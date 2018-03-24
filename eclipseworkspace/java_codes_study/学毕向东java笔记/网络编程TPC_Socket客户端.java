/*
import java.net.Socket;
1��Socket����TCPЭ���еĿͻ��ˡ�
2�������˷�����Ϣ������Ҫ��ȡ���������
3��Socket�����������
	1����������ָ��IP�˿ڣ�Socket(InetAddress address, int port)

	2����ȡ���������OutputStream getOutputStream()

	3����ȡ����������InputStream getInputStream()  

	4����ȡ����IP��InetAddress getInetAddress()

	5����ȡԶ�̶˿ڣ�int getPort()

	6����ȡ����IP��InetAddress getLocalAddress()

	7����ȡ���ض˿ڣ�int getLocalPort()

	8���رտͻ��ˣ�void close()

	9���ر���������void shutdownInput() 

   10���ر��������void shutdownOutput() 
*/

import java.net.*;
import java.io.*;

class SocketDome
{
	public static void main(String[] args) throws Exception
	{
		Socket sock = new Socket( InetAddress.getLocalHost(), 10000);

		OutputStream out = sock.getOutputStream();

		out.write( "������Ϣ".getBytes());

		InputStream is = sock.getInputStream();

		byte[] buf = new byte[1024];

		int len = is.read( buf);

		System.out.println( new String( buf, 0, len));

		sock.close();
	}
}