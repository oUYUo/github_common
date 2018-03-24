/*
import java.net.URL;
1，URL 代表资源定位符，它指向互联网“资源”的指针。资源可以是简单的文件或目录，也可以是对更为复杂的对象的引用。
2，URL基本方法：
	1，构造解析URL：URL(String spec)
	   调用方式：URL url = new URL( "http://192.168.1.254/myweb/demo.html?name=haha&age=30");

	2，获取URL文件名：String getFile()
	   结果：/myweb/demo.html?name=haha&age=30

	3，获取URL主机名：String getHost()
	   结果：192.168.1.254

	4，获取URL路径部分：String getPath()
	   结果：/myweb/demo.html

	5，获取URL端口号：int getPort()
	   结果：-1

	6，获取URL协议名称：String getProtocol()
	   结果：http

	7，获取URL查询部：String getQuery()
	   结果：name=haha&age=30

	8，获取URL连接对象：URLConnection openConnection()

	9，打开连接并返回输入流：InputStream openStream()
	   明细：openConnection().getInputStream()

3，关联的类：
	1，URLConnection --- 应用程序和 URL 之间的通信链接
	2，InputStream   --- 读取浏览器中内容（获取输入流）
*/
import java.net.*;
class URLDemo 
{
	public static void main(String[] args) throws MalformedURLException
	{
		URL url = new URL("http://192.168.1.254/myweb/demo.html?name=haha&age=30");


		System.out.println("getProtocol() :"+url.getProtocol());
		System.out.println("getHost() :"+url.getHost());
		System.out.println("getPort() :"+url.getPort());
		System.out.println("getPath() :"+url.getPath());
		System.out.println("getFile() :"+url.getFile());
		System.out.println("getQuery() :"+url.getQuery());
		System.out.println("openConnection() :"+url.openConnection());

		/*
		如果端口为-1，我们给个默认端口80
		int port = getPort();
		if(port==-1)
			port = 80;
		*/
	}
}


//应用层拆包去掉，正文留下。
