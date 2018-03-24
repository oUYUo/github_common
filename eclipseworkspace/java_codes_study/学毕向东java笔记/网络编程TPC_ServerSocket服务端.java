/*
import java.net.ServerSocket;
1，ServerSocket类是TPC协议中的服务端。
2，接受或反馈客户端信息，首先获取客户端流对象。
3，ServerSocket类基本方法：
	1，创建服务器指定端口：ServerSocket(int port)

	2，创建服务器指定端口队列数：ServerSocket(int port, int backlog)

	3，创建服务器指定IP端口队列数ServerSocket(int port, int backlog, InetAddress bindAddr) 
	
	4，侦听连接并获取客户端对象：Socket accept()

	5，关闭客户端或服务端：void close()
*/

import java.net.*;
import java.io.*;

class ServerSocketDome 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket( 10000);

		Socket sock = ss.accept();

		InputStream is = sock.getInputStream();

		byte[] buf = new byte[1024];

		int len = is.read( buf);

		System.out.println( new String( buf, 0, len));

		OutputStream out = sock.getOutputStream();

		out.write( "反馈信息".getBytes());

		s.close();//关闭客户端.

		ss.close();
	}
}
