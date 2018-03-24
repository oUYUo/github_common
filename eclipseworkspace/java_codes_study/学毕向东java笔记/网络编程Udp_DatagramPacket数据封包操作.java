/*
import java.net.*
1��DatagramPacket�����ڷ��ͻ��װ���ݡ�
2��DatagramPacket�����������
	1�����췽����
		A�������ֽ��������ݰ���DatagramPacket(byte[] buf, int length) 
		B������ָ��IP�˿����ݰ���DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
		C������ָ��ƫ�����ֽ��������ݰ���DatagramPacket(byte[] buf, int offset, int length) 

	2��ȡIP��ַ��InetAddress getAddress()
	3��ȡ���������ݣ�byte[] getData() 
	4��ȡ���ݳ��ȣ�int getLength() 
	5��ȡ������������������յ��Ķ˿ڣ�int getPort() 
*/

import java.net.*;
class UdpRece
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(4000);//���屾���˿ڣ����ڽ�����Ϣ��

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