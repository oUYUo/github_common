/*
import java.net.*;
1��InetSocketAddress���ǲ���IP/�˿ڡ�
2��InetSocketAddressʵ����SocketAddress��
3��InetSocketAddress�����������
	1������IP/�˿ڣ�InetSocketAddress(InetAddress addr, int port)

	2������������/�˿ڣ�InetSocketAddress(String hostname, int port)

	3������˿ڣ�InetSocketAddress(int port)

	4����ȡIP����InetAddress getAddress()

	5����ȡ��������String getHostName()

	6����ȡ�˿ڣ�int getPort() 

*/
class  
{
	public static void main(String[] args) 
	{
		Socket sock = new Socket();

		// connect(SocketAddress endpoint) ---> InetSocketAddressʵ����SocketAddress��
		InetSocketAddress isa = new InetSocketAddress( "192.168.2.164",10000);
		sock.connect( isa);
	}
}