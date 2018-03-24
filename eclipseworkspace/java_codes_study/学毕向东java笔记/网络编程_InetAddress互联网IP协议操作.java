/*
1，InetAddress类是互联网 IP协议操作。
2，InetAddress子类：Inet4Address -- 四段IP, Inet6Address -- 六段IP。
3，InetAddress类基本方法：它没有构造函数
	1，返回本机对象：static InetAddress getLocalHost()
	   调用方式：InetAddress ia = InetAddress.getLocalHost();

	2，取主机名：String getHostName()

	3，取主机IP：String getHostAddress()

	4，指定IP/主机名获取对象：static InetAddress getByName(String host)
	   调用方式：InetAddress ia1 = InetAddress.getByName( "www.baidu.com");

	5，指定IP/主机名获取多个对象：static InetAddress[] getAllByName(String host) 
	   特殊：我们知道大型网站不可能只有一个IP
	   调用方式：InetAddress[] ia2 = InetAddress.getAllByName( "www.baidu.com");
*/
import java.net.*;
class IPDome 
{
	public static void main(String[] args) throws Exception
	{
		//返回本机对象。
		InetAddress ia = InetAddress.getLocalHost();

		//获取主机名：如果获取外部主机名则会失败，返回的是IP。
		String name = ia.getHostName();

		//获取IP地址：
		String ip = ia.getHostAddress();

		//通过某个IP或主机名获取该主机对象。
		InetAddress ia1 = InetAddress.getByName( "www.baidu.com");

		//我们知道大型网站不可能只有一个IP：
		InetAddress[] ia2 = InetAddress.getAllByName( "www.baidu.com");

		for( InetAddress i : ia2)
		{
			System.out.println( i.getHostAddress());
		}
	}
}
