/*
案例：复制txt文件
问题：服务端与客户端结束不了
原因：服务端因读数据死循环
解决：在客户端输完数据后，搞个结束标记，告诉服务端数据结束。sock.shutdownOutput();
*/
import java.net.*;
import java.io.*;

class TextServer
{
	public static void main(String[] args) throws Exception
	{
		Socket sock = new Socket( InetAddress.getLocalHost(), 10000);

		BufferedReader txtbuf = 
			new BufferedReader( new InputStreamReader( new FileInputStream( "TextServer.txt")));

		PrintWriter pwout = new PrintWriter( sock.getOutputStream(), true);

		BufferedReader bufin = new BufferedReader( new InputStreamReader( sock.getInputStream()));

		String buf = null;

		while( ( buf = txtbuf.readLine()) != null)
		{
			pwout.println( buf);
		}

		sock.shutdownOutput();

		System.out.println( bufin.readLine());

		sock.close();
	}
}

class TextServerSocket
{
	public static void main(String[] args)
	{
		ServerSocket ss = new ServerSocket( 10000);

		Socket sock = ss.accept();

		System.out.println( sock.getInetAddress().getHostAddress());

		BufferedReader txtbuf = new BufferedReader( new InputStreamReader( sock.getInputStream()));

		PrintWriter pwout = new PrintWriter( new FileOutputStream( "TextServerSocket.txt"), true);

		String buf = null;

		while( ( buf = txtbuf.readLine()) != null)
		{
			pwout.println( buf);
		}

		OutputStream out = new OutputStream ( sock.getOutputStream());

		out.read( "上传成功".getbytes());
	}
}