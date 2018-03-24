/*
�ͻ��ˣ��ϴ�ͼƬ
1������˵㡣
2����ȡ�ͻ������е�ͼƬ���ݡ�
3��ͨ��socket ����������ݷ�������ˡ�
4����ȡ����˷�����Ϣ��
5���رա�

------------------------------------------------------

����ˣ�
1������˽�ÿ���ͻ��˷�װ��һ���������̣߳�ͬʱ�������ͻ���������ȷÿһ���ͻ���Ҫ�ڷ����ִ�еĴ��룬���ô������run�����С�
2��Ϊ�˱�֤����˲�ֹͣ����Ҫ�� accept()��������ѭ������Ϊ���������������
3����ȡ�ͻ���IP����IP��Ϊ�ļ�����
4��ͨ��File����ͬ���ļ���������IP + ��������
5�����ܿͻ���ͼƬ���ݣ���������д�뱾�ء�
6���ر��ļ���Դ���رտͻ��ˡ�
7�������ͻ��˸��Ƴɹ���Ϣ��
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

			out.write( "����ɹ�".getBytes());

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