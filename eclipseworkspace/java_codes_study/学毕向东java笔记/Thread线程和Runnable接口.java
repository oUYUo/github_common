/*
线程概述：
1，进程：是一个正在执行中的程序。每个进行执行都有执行顺序，该顺序是应该执行路劲，或叫控制单元。
2，线程：进程中的一个独立控制单元。线程在控制进程的执行。一个进程中至少有一个线程。
3，java vm 启动会有java.exe进程。该进程中至少一个线程负责java程序执行。而这个线程运行的代码存在于main方法中。该程序称为 主线程。
4，线程组：是指开启线程所属的方法。例：在main方法开启线程，那么线程组名：main。
		查看方法：Thread.toString();返回该线程的字符串表示形式，包括线程名称、优先级和线程组。
----------------------------------------------------------------------------------------------

创建线程：
      方法A： 1，定义类继承Thread。
		      2，复写Thread类中的run方法。
				    目的：将自定义代码存储在run方法，让线程运行。
			  3，调用线程的start方法，该方法有两个作用：启动线程，调用run方法。

	  方法B： 1，定义类实现Runnable
			  3，通过Thread类建立线程对象。
			  4，将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数。
					目的：自定义的run方法所属的对象是Runnable接口的子类对象。
			  5，调用Thread类的start方法开启线程并调用Runnable接口子类的run方法。

------------------------------------------------------------------------------------------------
Runnable接口：
1，Runnable接口在API文档中java.lang包中。
2，它只有一个方法： void run();   使用实现接口 Runnable 的对象创建一个线程时，启动该线程将导致在独立执行的线程中调用对象的 run 方法
3，被Thread所实现（当然不止它一个）。

Thread多线程：
1，Thread构造函数实现了Runnable接口。 ----->  public Thread(Runnable target)

-------------------------------------------------------------------------------------------------

Runnable实现方式与Thread继承方式的区别：
实现方式：避免了单继承的局限性。在定义线程时，建议使用实现方式。

继承Thread：线程代码存放Thread子类run方法中。
实现Runnable：线程代码存在接口的子类run方法中。

-----------------------------------------------------------------------------------------------

创建获取对象名称：
1，Thread.currentThread(); 方法静态的，获取当前线程对象。
2，getName(); 获取线程名称。
3，setName();设置线程名称，或者构造函数函数进行设置。 super(name);
4，如果不自定义名称，将会自动生成名称，形式为 “Thread-”+n，其中的 n 为整数。

问题：
1，一个对象多次调用start，会出现异常。
*/

class Demo extends Thread
{
	public void run()
	{
		// 写需要被创建线程的代码
	}
}

class ThreadDemo
{
	public static void main(String[] args)
	{
		Deom d = new Demo;
		d.start();//调用父类方法开启线程，并运行需要线程的run方法。
/*
方法2：
		Thread	T = new Thread(new DemoRunnable());
		T.start();
	  */
	}
}

/*
class DemoRunnable implements Runnable
{
	public void run()
	{
		// 写需要被创建线程的代码	
	}
}

*/