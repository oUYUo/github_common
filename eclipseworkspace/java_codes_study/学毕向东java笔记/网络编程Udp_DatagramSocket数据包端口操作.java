/*
import java.net.*
1��DatagramSocket�����ڷ��ͺͽ������ݰ��Ĳ������׽��֣���
2��DatagramSocket�����������
	1�����췽����
		A���󶨱���ָ���˿ڣ�DatagramSocket(int port)
		B���󶨱���ָ��IP/�˿ڣ�DatagramSocket(int port, InetAddress laddr)
		C���޲ι��췽����DatagramSocket()

	2����ȡ�����󶨶˿ڣ�int getLocalPort()

	3����ȡ������IP��InetAddress getLocalAddress()

	4���Ӷ˿ڽ������ݰ���void receive(DatagramPacket p)

	5���Ӷ˿ڷ������ݰ���void send(DatagramPacket p)

*/
import java.net.*;
import java.io.*;
class UdpSend
{
	public static void main(String[] args) throws Exception
	{
		InetAddress ia = InetAddress.getLocalHost();

		DatagramSocket ds = new DatagramSocket( 8888);//���屾���˿�

		BufferedReader bur = new BufferedReader( new InputStreamReader( System.in));
		
		String s = null;
		byte[] b = null;

		while( ( s = bur.readLine()) != null)
		{
			b = s.getBytes();

			DatagramPacket dp = new DatagramPacket( b, b.length, ia, 4000);//����IP�Ͷ�Ӧ�Ķ˿�

			ds.send( dp);
		}

		ds.close();
	}
}