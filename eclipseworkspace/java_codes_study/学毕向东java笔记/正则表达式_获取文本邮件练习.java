//取文本邮件地址。

import java.io.*;
import java.util.regex.*;

class  
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader( new FileReader( "E:\\学习区\\java\\编译区\\mail.txt"));

		String str = null;
		String reg = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile( reg);	//将规则封装成对象。

		while( ( str = br.readLine()) != null)
		{
			Matcher m = p.matcher( str);	//将规则对象与字符串关联。

			while( m.find())	//如迭代器 ，返回真假。
			{
				System.out.println( m.group());	//按规则取字符串。
			}
		}
	}
}
