/*
基本数据类型对象包装类。

byte	Byte
short	Short
int		Integer
long	Long
boolean Boolean
float	Float
double	Double
char	Character



基本数据类型对象包装类的最常见作用，
就是用于基本数据类型和字符串类型之间做转换

基本数据类型转成字符串。

	基本数据类型+""

	基本数据类型.toString(基本数据类型值);

	如： Integer.toString(34);//将34整数变成"34";


字符串转成基本数据类型。

	xxx a = Xxx.parseXxx(String);

	int a = Integer.parseInt("123");

	double b = Double.parseDouble("12.23");

	boolean b = Boolean.parseBoolean("true");

	Integer i = new Integer("123");

	int num = i.intValue();

	


十进制转成其他进制。
	toBinaryString();
	toHexString();
	toOctalString();


其他进制转成十进制。
	parseInt(string,radix);


*/
class IntegerDemo 
{
	public static void sop(String str)
	{
		System.out.println(str);
	}
	
	public static void main(String[] args) 
	{
		//整数类型的最大值。
		//sop("int max :"+Integer.MAX_VALUE);

//		将一个字符串转成整数。

		int num = Integer.parseInt("123");//必须传入数字格式的字符串。
		//long x = Long.parseLong("123");

//		sop("num="+(num+4));

//		sop(Integer.toBinaryString(-6));
//		sop(Integer.toHexString(60));

		int x = Integer.parseInt("3c",16);

		sop("x="+x);
	}


	//JDK1.5版本以后出现的新特性。
	public static void IntegerDemo1()
	{
		Integer x = 4;//自动装箱，相当于new Integer(4);是说这4的值

		x = x + 2;//等于：x = x.intValue() + 2; x 进行自动拆箱。变成成了int类型。和2进行加法运算，再将和进行装箱赋给x。

		Integer m = 128;
		Integer n = 128;

		sop("m==n:"+(m==n));//结果为false，因为m和n超出了byte范围。

		Integer a = 127;
		Integer b = 127;

		sop("a==b:"+(a==b));//结果为true。因为a和b指向了同一个Integer对象。
						//因为当数值在byte范围内容，对于新特性，如果该数值已经存在，则不会在开辟新的空间。该理论是对于直接赋值而言。
	}

//---------------------------------------------------------------------------------------------------------------------------------
	public static void method()
	{
		Integer x = new Integer("123");
		Integer y = new Integer(123); 

		System.out.println("x==y:"+(x==y)); // false，比较对象是否相同，X和Y不是指向同一个地址。
		System.out.println("x.equals(y):"+x.equals(y)); //true，比较数值是否相同，自动转成int类型。
	}
}