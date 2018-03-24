/*
案例：服务端反馈大写信息。
问题：客户端和服务端都在莫名的等待。
原因：因为客户端和服务端都有阻塞方法，这些方法没有独到结束标记，就一直等。而导致两端都在等待。
解决：缓冲区需要刷新。刷新后，客户端和服务端才能读到数据。
第二种解决方案：PrintWriter ---		传入任意输出流
				PeintStream ---		传入任意输入流

细节：在客户端sock.close(),将会告诉服务端结束了，返回 -1 给服务端 read()方法，而readLine()的底层调用是read()
*/
import java.io.*;
import java.net.*;

class TPCSocket 
{
	public static void main(String[] args) throws Exception	//客户端
	{
		Socket sock = new Socket( InetAddress.getLocalHost(), 10000);

		//BufferedWriter outbuf = new BufferedWriter( new OutputStreamWriter( sock.getOutputStream()));
		PrintWriter outbuf = new PrintWriter( sock.getOutputStream(), true);

		BufferedReader isbur = new BufferedReader( new InputStreamReader( sock.getInputStream()));

		BufferedReader inbur = new BufferedReader( new InputStreamReader( System.in));

		String buf = null;

		while( ( buf = inbur.readLine()) != null)
		{
			if( "over".equals( buf))
				break;

			//outbuf.write( buf);
			//outbuf.newLine();
			//outbuf.flush();
			outbuf.println( buf);

			System.out.println( isbur.readLine());
		}

		sock.close();
		System.out.println( "结束");
	}
}


class TPCServerSocket
{
	public static void main( String[] args) throws Exception	//服务端
	{
		ServerSocket ss = new ServerSocket( 10000);

		Socket sock = ss.accept();

		//BufferedWriter outbuf = new BufferedWriter( new OutputStreamWriter( sock.getOutputStream()));
		PrintWriter outbuf = new PrintWriter( sock.getOutputStream(), true);

		BufferedReader isbur = new BufferedReader( new InputStreamReader( sock.getInputStream()));

		String buf = null;

		while( ( buf = isbur.readLine()) != null )
		{
			//outbuf.write( buf.toUpperCase());
			//outbuf.newLine();
			//outbuf.flush();
			outbuf.println( buf.toUpperCase());
		}

		sock.close();
		ss.close();
		System.out.println( "结束");
	}
}