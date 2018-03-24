/*
1，TPC服务端向浏览器发送信息：
	1，建立服务端IP/端口。
	2，向客户端发送消息。
	3，打开浏览器，输入服务端IP/端口，例如：http://192.168.1.254:11000

----------------------------------------------------------------------------

2，通过Tomcat服务器，客户端访问浏览器
	1，启动Tomcat服务器
	2，启动客户端。 访问： thhp://路径+ 本地html网页:8080

3，客户端访问Tomcat服务器：
	1，下载Tomcat，执行bin目录：startup.bat，服务器启动，端口：8080
	2，打开浏览器，输入：http://127.0.0.1:11000
	3，接受服务器反馈信息。
*/

import java.io.*;
import java.net.*;

class MyIE 
{
	public static void main(String[] args)throws Exception 
	{
		Socket s = new Socket( InetAddress.getLocalHost(),8080);
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		out.println("GET /myweb/demo.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Accept-Language: zh-cn");
		out.println("Host: 192.168.1.254:11000");
		out.println("Connection: closed");

		out.println();
		out.println();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}

		s.close();
	}
}
/*
http://192.168.1.254:11000/myweb/demo.html

GET /myweb/demo.html HTTP/1.1
Accept: application/x-shockwave-flash, image/gif, image/x-xbitmap, image/jpeg, i
mage/pjpeg, application/vnd.ms-excel, application/vnd.ms-powerpoint, application
/msword, application/QVOD, application/QVOD,
Accept-Language: zh-cn
Accept-Encoding: gzip, deflate
User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0
.50727)
Host: 192.168.1.254:11000
Connection: Keep-Alive


*/
