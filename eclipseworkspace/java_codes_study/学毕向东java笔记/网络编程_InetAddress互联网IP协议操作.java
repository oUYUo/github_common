/*
1��InetAddress���ǻ����� IPЭ�������
2��InetAddress���ࣺInet4Address -- �Ķ�IP, Inet6Address -- ����IP��
3��InetAddress�������������û�й��캯��
	1�����ر�������static InetAddress getLocalHost()
	   ���÷�ʽ��InetAddress ia = InetAddress.getLocalHost();

	2��ȡ��������String getHostName()

	3��ȡ����IP��String getHostAddress()

	4��ָ��IP/��������ȡ����static InetAddress getByName(String host)
	   ���÷�ʽ��InetAddress ia1 = InetAddress.getByName( "www.baidu.com");

	5��ָ��IP/��������ȡ�������static InetAddress[] getAllByName(String host) 
	   ���⣺����֪��������վ������ֻ��һ��IP
	   ���÷�ʽ��InetAddress[] ia2 = InetAddress.getAllByName( "www.baidu.com");
*/
import java.net.*;
class IPDome 
{
	public static void main(String[] args) throws Exception
	{
		//���ر�������
		InetAddress ia = InetAddress.getLocalHost();

		//��ȡ�������������ȡ�ⲿ���������ʧ�ܣ����ص���IP��
		String name = ia.getHostName();

		//��ȡIP��ַ��
		String ip = ia.getHostAddress();

		//ͨ��ĳ��IP����������ȡ����������
		InetAddress ia1 = InetAddress.getByName( "www.baidu.com");

		//����֪��������վ������ֻ��һ��IP��
		InetAddress[] ia2 = InetAddress.getAllByName( "www.baidu.com");

		for( InetAddress i : ia2)
		{
			System.out.println( i.getHostAddress());
		}
	}
}
