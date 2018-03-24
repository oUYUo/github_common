//对邮件地址进行效验。
class  
{
	public static void main(String[] args) 
	{
		String sre = "sjsj@sina.com.cn";

		String reg = "[a-zA-Z0-9_]+[@][a-zA-Z0-9]+(\\.[comn]+)+";

		reg = "\\w+[@]\\w+(\\.\\w+)+";

		System.out.println( sre.matches( reg));
	}
}
