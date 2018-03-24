/*
客户端：上传图片
1，服务端点。
2，读取客户端已有的图片数据。
3，通过socket 输出流将数据发给服务端。
4，读取服务端反馈信息。
5，关闭。

------------------------------------------------------

服务端：
1，服务端将每个客户端封装到一个单独的线程，同时处理多个客户端请求。明确每一个客户端要在服务端执行的代码，将该代码存入run方法中。
2，为了保证服务端不停止，需要在 accept()方法加上循环，因为这个方法有阻塞。
3，获取客户端IP，将IP作为文件名。
4，通过File避免同名文件，例：带IP + （次数）
5，接受客户端图片数据，并将数据写入本地。
6，关闭文件资源，关闭客户端。
7，反馈客户端复制成功信息。
*/
import java.net.*;
import java.io.*;

class PictureServer
{
	public static void main(String[] args) throws Exception
	{
		Socket sock = new Socket( InetAddress.getLocalHost(), 10000);

		BufferedOutputStream bos = new BufferedOutputStream(  sock.getOutputStream());

		BufferedInputStream bis = new BufferedInputStream( new FileInputStream("1.jpg"));

		BufferedReader br = new BufferedReader( new InputStreamReader( sock.getInputStream()));

		byte[] buf = new byte[1024*1024];
		int len = 0;

		while( ( len = bis.read( buf)) != -1)
		{
			bos.write( buf, 0, len);
			bos.flush();
		}

		sock.shutdownOutput();
		
		System.out.println( br.readLine());

		sock.close();
	}
}

class PictureServerSocket
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket( 10000);

		while( true)
		{
			Socket sock = ss.accept();

			new Thread( new ThreadServerSocket( sock)).start();
		}
	}
}

class ThreadServerSocket implements Runnable
{
	private Socket sock;

	ThreadServerSocket( Socket sock)
	{
		this.sock = sock;
	}

	public void run()
	{
		try
		{
			File name = FileDome( sock.getInetAddress().getHostAddress());

			BufferedInputStream bis = new BufferedInputStream( sock.getInputStream());

			BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( name));

			byte[] buf = new byte[1024*1024];
			int len = 0;

			while( ( len = bis.read( buf)) != -1)
			{
				bos.write( buf, 0, len);
				bos.flush();
			}

			OutputStream out = sock.getOutputStream();

			out.write( "传输成功".getBytes());

			bos.close();
			sock.close();
		}
		catch( Exception es)
		{
		}
	}

	public File FileDome( String name)
	{
		File file= new File( name + ".jpg");

		int len = 1;

		while( file.exists())
		{
			file= new File( name + "(" + len++ + ")" + ".jpg");
		}

		return file;
	}
}