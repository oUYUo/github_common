/*
正则练习：
"我我...我我...我要..要要...要要...学学学...学学学....学学...编编编...编程..程.程程...程...程"
结果：我要学编程
*/
class 
{
	public static void main(String[] args) 
	{
		String sre = "我我...我我...我要..要要...要要...学学学...学学学....学学...编编编...编程..程.程程...程...程";

		sre = sre.replaceAll( "\\.", "");

		sre = sre.replaceAll( "(.)\\1+", "$1");

		System.out.println( sre);
	}
}
