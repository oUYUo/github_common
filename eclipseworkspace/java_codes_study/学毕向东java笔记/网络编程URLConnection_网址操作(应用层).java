/*
import java.net.*;
1��URLConnection��������������ĳ��࣬������Ӧ�ó���� URL ֮���ͨ�����ӡ������ʵ�������ڶ�ȡ��д��� URL ���õ���Դ��
2��URLConnection���������������
	1�����ش����Ӷ�ȡ����������InputStream getInputStream()
*/
import java.net.*;
import java.io.*;

class  
{
	public static void main(String[] args) throws IOException
	{
		String ip = InetAddress.getLocalHost().getHostAddress();
		URL url = new URL( "file:///E:/ѧϰ��/java/������/360.htm");

		URLConnection urlc = url.openConnection();
		
		InputStream is = urlc.getInputStream();

		byte[] b = new byte[1024];
		int len = 0;

		while( ( len = is.read( b)) != -1)
		{
			System.out.println( new String( b, 0, len));
		}

		is.close();
	}
}