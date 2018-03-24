/*
String类分割正则表达式：
1，分割：String[] split(String regex);
2，分割实例："(.)\\1"			--->	. 表示任意字符，当 .  字符连续出现1次。判断直至最后一个字符。(.)\1+;表示出现2次以上。
*/

class  
{
	public static void main(String[] args) 
	{
		//   . 表示任意字符； \.表示无意义； \\.表示正则表达式\.
		splitemo( "zhangsan.lisi.wangwu", "\\.");

		//	分割符是两个斜杠\\，而\\ 转义表示一个，所有 \\\\
		splitDemo( "C:\\Program Files\\Intel", "\\\\");

		/* 叠词分割，组的概念：结果可被重新使用，小括号()
				  1：表示普通字符
				 \1：转移1，无意义
				\\1：表示正则表达式\n

			当出现1个字符与(.)相同时，
			如果出现多个字符相同时： "(.)\\1+"	(\n)

		*/
		splitDemo( "arkktyqquizzo", "(.)\\1");
	}

	public static void splitD( String str, String reg) //切割调用程序。
	{
		String[] arr = str.split( reg);
		for( String s : arr)
		{
			System.out.println( s);
		}
	}
}
