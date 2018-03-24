//网页爬虫，取网页所有邮件地址。

import java.io.*;
import java.net.*;
import java.util.regex.*;

class  
{
	public static void main(String[] args) throws Exception
	{
		//网页爬虫，取网页所有邮件地址。

		URL url = new URL( "http://127.0.0.1:8080/myweb/mail.html");

		URLConnection urlc = url.openConnection();

		InputStream is = urlc.getInputStream();

		BufferedReader bur = new BufferedReader( new InputStreamReader( is));



		String str = null;
		String reg = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile( reg);	//将规则封装成对象。

		while( ( str = bur.readLine()) != null)
		{
			Matcher m = p.matcher( str);	//将规则对象与字符串关联。

			while( m.find())	//如迭代器 ，返回真假。
			{
				System.out.println( m.group());	//按规则取字符串。
			}
		}
	}
}
