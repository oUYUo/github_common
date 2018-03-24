/*
String类替换正则表达式：
1，替换：String replaceAll(regex,str);如果regex中有定义组，可以在第二参数中通过$符号获取正则表达式中的已有的组。
2，组的概念：当规则结果被重用，就把它用小括号封装组，这个组可被重新使用。组的编号从1开始（\n组编号）。格式请看“16项”
3，获取组值：( "(.)\\1+", "$1");	--->	$1获取第一组的值。注意：是在组的外面获取。
4，替换实例：( "(.)\\1+", "$1")   --->		将出现叠词替换叠词的单字符。如：zzzzz 替换 z。$1取编号1组的值。
*/

class  
{
	public static void main(String[] args) 
	{
		//将数字替换成#号
		String str = "ajshu1588waaa5852as7S5assa8fr756";
		str = str.replaceAll( "\\d+", "#");

		//将叠词替换 叠词的第一个字符，如：zzzzz 替换 z。$1取编号1组的值。
		String str1 = "arkktyqquizzzzo";
		str1 = str1.replaceAll( "(.)\\1+", "$1");
	}
}