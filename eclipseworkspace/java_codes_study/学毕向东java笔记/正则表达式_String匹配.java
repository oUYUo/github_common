/*
String类匹配正则表达式：
1，匹配：boolean matches(String regex);用规则匹配整个字符串，只要有一处不符合规则，就匹配结束，返回false。
2，匹配实例："[1-9]\\d{4,14}"  --->	第一位字符[1-9]，第二位字符[0-9]，且从第二位字符开始，至少出现四次，最多14次。（整个长度至少是5位数）。
*/

class  
{
	public static void main(String[] args) 
	{
		//Summary();
		//CharacterLimit()
		
	}

	public static void Summary()//匹配
	{
		String qq = "23858";
		String reagex = "[1-9][0-9]{4,14}";
		boolean flag = qq.matches( reagex);

		/*
		String reagex = "[1-9][0-9]{4,14}";
		[1-9]:第一位出现的范围。
		[0-9]:第二位出现的范围。
		{4,14}:第4位到14位满足[0-9]。
		*/
	}

	public static void CharacterLimit()//匹配
	{
		String str = "by";
		String reg = "[bcd][a-z]";//或者把a-z的字符都写出来
		boolean b = reg.matches( str);	
		/*
		条件满足为真
		[bcd]：判断 str 第一个字符是否是 b、c、d
		[a-z]：判断 str 第二个字符是否是 a到z的范围。

		如果在正则表达式加 ^ 则结果为取反，例：[^bcd]，条件满足为假。

		规定大小写范围：[a-zA-Z]
		取并集：[a-d[m-p]]
		取交集：[a-z&&[def]]
		范围内舍去：[a-z&&[^bc]]	a到z，除了b和c
		范围内舍去：[a-z&&[^m-p]]	a到z，除了m到p
		*/
	}
}
