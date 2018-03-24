/*
1��TPC������������������Ϣ��
	1�����������IP/�˿ڡ�
	2����ͻ��˷�����Ϣ��
	3�������������������IP/�˿ڣ����磺http://192.168.1.254:11000

----------------------------------------------------------------------------

2��ͨ��Tomcat���������ͻ��˷��������
	1������Tomcat������
	2�������ͻ��ˡ� ���ʣ� thhp://·��+ ����html��ҳ:8080

3���ͻ��˷���Tomcat��������
	1������Tomcat��ִ��binĿ¼��startup.bat���������������˿ڣ�8080
	2��������������룺http://127.0.0.1:11000
	3�����ܷ�����������Ϣ��
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
