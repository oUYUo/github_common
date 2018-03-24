/*
import java.net.Socket;
1，Socket类是TCP协议中的客户端。
2，向服务端发送信息，首先要获取输出流对象。
3，Socket类基本方法：
	1，创建连接指定IP端口：Socket(InetAddress address, int port)

	2，获取输出流对象：OutputStream getOutputStream()

	3，获取输入流对象：InputStream getInputStream()  

	4，获取连接IP：InetAddress getInetAddress()

	5，获取远程端口：int getPort()

	6，获取本地IP：InetAddress getLocalAddress()

	7，获取本地端口：int getLocalPort()

	8，关闭客户端：void close()

	9，关闭输入流：void shutdownInput() 

   10，关闭输出流：void shutdownOutput() 
*/

import java.net.*;
import java.io.*;

class SocketDome
{
	public static void main(String[] args) throws Exception
	{
		Socket sock = new Socket( InetAddress.getLocalHost(), 10000);

		OutputStream out = sock.getOutputStream();

		out.write( "接受信息".getBytes());

		InputStream is = sock.getInputStream();

		byte[] buf = new byte[1024];

		int len = is.read( buf);

		System.out.println( new String( buf, 0, len));

		sock.close();
	}
}