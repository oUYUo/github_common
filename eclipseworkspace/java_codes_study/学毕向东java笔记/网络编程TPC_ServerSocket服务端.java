/*
import java.net.ServerSocket;
1��ServerSocket����TPCЭ���еķ���ˡ�
2�����ܻ����ͻ�����Ϣ�����Ȼ�ȡ�ͻ���������
3��ServerSocket�����������
	1������������ָ���˿ڣ�ServerSocket(int port)

	2������������ָ���˿ڶ�������ServerSocket(int port, int backlog)

	3������������ָ��IP�˿ڶ�����ServerSocket(int port, int backlog, InetAddress bindAddr) 
	
	4���������Ӳ���ȡ�ͻ��˶���Socket accept()

	5���رտͻ��˻����ˣ�void close()
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

		out.write( "������Ϣ".getBytes());

		s.close();//�رտͻ���.

		ss.close();
	}
}
