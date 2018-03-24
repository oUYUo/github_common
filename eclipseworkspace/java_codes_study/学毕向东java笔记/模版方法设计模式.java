/*
模版方法设计模式：在定义功能时，功能一部分是确定的的，但有一部分不确定，而确定的部分在使用不确定的部分，那么这时就将不确定的部分暴露出去，由该类的子类去完成。


需求：获取一段程序运行时间。
原理：获取程序开始和结束的时间并相减即可。
获取时间：System.currentTimeMillis();


*/
class TemplateDemo
{
	public static void main(String[] agrs)
	{	
		SubTime  = new SubTime().runcade();
	}
}

abstract class GetTime
{
	public final void  GetTime()
	{
		long start = System.currentTimeMillis();
		runcade();
		long end = System.currentTimeMillis();
		System.out.println("毫秒： " + end - start);
	}

	public abstract void runcade();
}

class SubTime extends GetTime
{
	public void runcade()
	{
		for (int x = 0; x < 4000; x++)
		{
			System.out.print(x);
		}
	}
}