/*
import java.net.*;
1，InetSocketAddress类是操作IP/端口。
2，InetSocketAddress实现了SocketAddress。
3，InetSocketAddress类基本方法：
	1，构造IP/端口：InetSocketAddress(InetAddress addr, int port)

	2，构造主机名/端口：InetSocketAddress(String hostname, int port)

	3，构造端口：InetSocketAddress(int port)

	4，获取IP对象：InetAddress getAddress()

	5，获取主机名：String getHostName()

	6，获取端口：int getPort() 

*/
class  
{
	public static void main(String[] args) 
	{
		Socket sock = new Socket();

		// connect(SocketAddress endpoint) ---> InetSocketAddress实现了SocketAddress。
		InetSocketAddress isa = new InetSocketAddress( "192.168.2.164",10000);
		sock.connect( isa);
	}
}