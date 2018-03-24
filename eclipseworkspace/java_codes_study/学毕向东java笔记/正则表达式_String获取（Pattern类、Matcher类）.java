/*
1，将规则封装成 Pattern 对象。
2，将规则对象与字符串关联 ---> Matcher
3，建立循环，判断字符串中子串是否符合规则 ---> m.fina()
4，获取匹配后字符串结果 ---> m.group()
5，获取字符串牵扯到两个类，都在 java.util.regex 包中：
	Pattern类：将规则封装成对象。
	Matcher类：将规则对象与字符串关联。
6，获取必须先匹配。

---------------------------------------------------------------------------------------

7，Pattern类，它没有构造函数，基本方法：
	1，封装正则表达式：static Pattern compile(String regex) 
	   调用方式：Pattern p = Pattern.compile( "\\b[a-z]{4}\\b");
	
	2，返回匹配器：Matcher matcher(CharSequence input) 
	   调用方式：Matcher m = p.matcher( str);	//将规则对象与字符串关联。

	3，获取正则表达式：String pattern()

	4，分割：String[] split(CharSequence input)
	   参数：CharSequence类是字符超类。
	   调用方式：String[] s = p.split( "78aq4");

-------------------------------------------------------------------------------------

8，Matcher类，它没有构造函数，基本方法：
	1，由 Pattern类 matcher()方法返回 Matcher对象。

	2，匹配：boolean find() 

	3，返回匹配成功字符串：String group()

	4，获取匹配字符串初始索引：int start() -->(从0开始)
 
	5，获取匹配字符串之后的偏移量：int end()

	6，重置匹配器：Matcher reset(CharSequence input)

*/

import java.util.regex.*;
class  
{
	public static void main(String[] args) 
	{
		String str = "ming tian jiu yao fang jia le ,da jia";
		String reg = "\\b[a-z]{4}\\b";

		Pattern p = Pattern.compile( reg);	//将规则封装成对象。
		Matcher m = p.matcher( str);	//将规则对象与字符串关联。

		while( m.find())	//如迭代器 ，返回真假。
		{
			System.out.println( m.group());	//按规则取字符串。
			System.out.println( m.start() + "...." + m.end());	//	取字符串所在的首尾位置，从0开始，结尾字符位置+1
		}
	}
}
