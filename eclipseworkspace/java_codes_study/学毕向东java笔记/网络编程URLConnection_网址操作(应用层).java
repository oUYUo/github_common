/*
import java.net.*;
1，URLConnection抽象类是所有类的超类，它代表应用程序和 URL 之间的通信链接。此类的实例可用于读取和写入此 URL 引用的资源。
2，URLConnection抽象类基本方法：
	1，返回打开连接读取的输入流：InputStream getInputStream()
*/
import java.net.*;
import java.io.*;

class  
{
	public static void main(String[] args) throws IOException
	{
		String ip = InetAddress.getLocalHost().getHostAddress();
		URL url = new URL( "file:///E:/学习区/java/编译区/360.htm");

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