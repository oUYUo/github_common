class Template	//模板设计方式。
{
	public static void main(String[] agrs)
	{
		new Subclasses().time();
	}
}

abstract class GetTime
{
	public final void time()	//不让覆盖该方法。
	{
		long start = System.currentTimeMillis();//获取当前程序运行毫秒。

		test();

		long and = System.currentTimeMillis();//获取当前程序运行毫秒。

		System.out.println(and - start);//两数相减，就等于程序运行时间。
	}
	abstract void test();
}

class Subclasses extends GetTime
{
	public void test()	//复写test，实现了抽象方法的作用。
	{
		for (int i = 0; i<1000; i++)
		{
			System.out.print(i);
		}
		System.out.println();
	}
}
