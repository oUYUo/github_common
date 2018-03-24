/*
import java.net.URL;
1��URL ������Դ��λ������ָ����������Դ����ָ�롣��Դ�����Ǽ򵥵��ļ���Ŀ¼��Ҳ�����ǶԸ�Ϊ���ӵĶ�������á�
2��URL����������
	1���������URL��URL(String spec)
	   ���÷�ʽ��URL url = new URL( "http://192.168.1.254/myweb/demo.html?name=haha&age=30");

	2����ȡURL�ļ�����String getFile()
	   �����/myweb/demo.html?name=haha&age=30

	3����ȡURL��������String getHost()
	   �����192.168.1.254

	4����ȡURL·�����֣�String getPath()
	   �����/myweb/demo.html

	5����ȡURL�˿ںţ�int getPort()
	   �����-1

	6����ȡURLЭ�����ƣ�String getProtocol()
	   �����http

	7����ȡURL��ѯ����String getQuery()
	   �����name=haha&age=30

	8����ȡURL���Ӷ���URLConnection openConnection()

	9�������Ӳ�������������InputStream openStream()
	   ��ϸ��openConnection().getInputStream()

3���������ࣺ
	1��URLConnection --- Ӧ�ó���� URL ֮���ͨ������
	2��InputStream   --- ��ȡ����������ݣ���ȡ��������
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
		����˿�Ϊ-1�����Ǹ���Ĭ�϶˿�80
		int port = getPort();
		if(port==-1)
			port = 80;
		*/
	}
}


//Ӧ�ò���ȥ�����������¡�
