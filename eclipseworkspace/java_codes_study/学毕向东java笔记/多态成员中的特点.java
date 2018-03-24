/*
在多态中成员函数的特点：
在编译时期：参阅引用型变量所属的类中是否有调用方法。如果有，编译通过，否则编译失败。
在运行时期：残月对象所属的类中是否有调用方法。

在多态中，成员变量的特点：无论编译和运行，都参考引用型变量所属的类。

在多态中，静态成员函数特点：无论编译和运行，都参考引用型变量所属的类。


-------------------------------------以下是自己结果----------------------------------------------------------------

1，多态中，非静态存在函数覆盖特征。（指向子类的引用）
2，多态中，静态函数指向父类的引用。
3，多态中，非静态变量和静态变量结果都是指向父类的引用。
*/

class 多态成员中的特点
{

	public static void main(String[] args) 
	{
		fu c = new zi();
		c.a(); //zi_a
		c.b(); //fu_b
		System.out.println(c.name); //非静态和静态结果都是10
	}
}

class fu
{
	 int name = 10;
	void a()
	{
		System.out.println("fu_a");
	}

	static void b()
	{
		System.out.println("fu_b");
	}

}

class zi extends fu
{
	 int name = 11;
	void a()
	{
		System.out.println("zi_a");
	}
	
	static void b()
	{
		System.out.println("zi_b");
	}
}