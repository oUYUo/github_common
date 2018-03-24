package 第六章;

public class 运算符_表达式_与语句 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 猜猜我写了什么
		 */
		int a = 0;//赋值运算符
		//+ - ! ~取补码 一元运算符
		if(true)
		{
			System.out.println("hhh");
		}
		if(2!=1)
		{
			System.out.println("yiyiyi");
		}
		System.out.println(a++);
		System.out.println(++a);
		//逻辑运算符
		if(false&&false)
		{
			System.out.println("iii");
		}
		int c=(1>0)?2:3;
		boolean t1= 1==2;
		System.out.println(t1);
		System.out.println(c);
		c=c+c;
		System.out.println(c);
	}
	

}
