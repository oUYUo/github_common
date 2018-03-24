/*
import java.net.*
1，DatagramPacket类用于发送或封装数据。
2，DatagramPacket类基本方法：
	1，构造方法：
		A）接受字节数组数据包：DatagramPacket(byte[] buf, int length) 
		B）发送指定IP端口数据包：DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
		C）接受指定偏移量字节数组数据包：DatagramPacket(byte[] buf, int offset, int length) 

	2，取IP地址：InetAddress getAddress()
	3，取缓冲区数据：byte[] getData() 
	4，取数据长度：int getLength() 
	5，取发往主机或从主机接收到的端口：int getPort() 
*/

import java.net.*;
class UdpRece
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(4000);//定义本机端口，用于接受信息。

		while( true)
		{
			byte[] b = new byte[1024];

			DatagramPacket dp = new DatagramPacket( b, b.length);

			ds.receive( dp);

			System.out.println( new String( dp.getData(), 0, dp.getLength()));
		}

	//	ds.close();
	}
}