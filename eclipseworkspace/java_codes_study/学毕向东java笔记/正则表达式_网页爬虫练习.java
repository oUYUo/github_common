//��ҳ���棬ȡ��ҳ�����ʼ���ַ��

import java.io.*;
import java.net.*;
import java.util.regex.*;

class  
{
	public static void main(String[] args) throws Exception
	{
		//��ҳ���棬ȡ��ҳ�����ʼ���ַ��

		URL url = new URL( "http://127.0.0.1:8080/myweb/mail.html");

		URLConnection urlc = url.openConnection();

		InputStream is = urlc.getInputStream();

		BufferedReader bur = new BufferedReader( new InputStreamReader( is));



		String str = null;
		String reg = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile( reg);	//�������װ�ɶ���

		while( ( str = bur.readLine()) != null)
		{
			Matcher m = p.matcher( str);	//������������ַ���������

			while( m.find())	//������� ��������١�
			{
				System.out.println( m.group());	//������ȡ�ַ�����
			}
		}
	}
}
