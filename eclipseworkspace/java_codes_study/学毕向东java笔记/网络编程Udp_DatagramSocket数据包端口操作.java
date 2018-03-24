/*
import java.net.*
1，DatagramSocket类用于发送和接受数据包的插座（套接字）。
2，DatagramSocket类基本方法：
	1，构造方法：
		A）绑定本机指定端口：DatagramSocket(int port)
		B）绑定本机指定IP/端口：DatagramSocket(int port, InetAddress laddr)
		C）无参构造方法：DatagramSocket()

	2，获取本机绑定端口：int getLocalPort()

	3，获取本机绑定IP：InetAddress getLocalAddress()

	4，从端口接受数据包：void receive(DatagramPacket p)

	5，从端口发送数据包：void send(DatagramPacket p)

*/
import java.net.*;
import java.io.*;
class UdpSend
{
	public static void main(String[] args) throws Exception
	{
		InetAddress ia = InetAddress.getLocalHost();

		DatagramSocket ds = new DatagramSocket( 8888);//定义本机端口

		BufferedReader bur = new BufferedReader( new InputStreamReader( System.in));
		
		String s = null;
		byte[] b = null;

		while( ( s = bur.readLine()) != null)
		{
			b = s.getBytes();

			DatagramPacket dp = new DatagramPacket( b, b.length, ia, 4000);//发送IP和对应的端口

			ds.send( dp);
		}

		ds.close();
	}
}