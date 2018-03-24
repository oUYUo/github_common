/*
join方法：在Thread类中。
作用：当A线程执行到B线程的.join()方法时，A就会等待。等B线程都执行完，A才会执行。
join可以用来临时加入线程执行，写在该线程启动后的一行代码，效果明显。

格式：线程变量.join();
异常：InterruptedException - 如果任何线程中断了当前线程。当抛出该异常时，当前线程的中断状态 被清除。
*/

class java
{
	public static void main(String[] args)throws InterruptedException
	{
		Thread t1 = new Thread( new Run("a====================="));
		Thread t2 = new Thread( new Run("b+++"));
		t1.start();
		t1.join();	//当执行到join时，主线程和t2线程都要等待t1线程执行完后，才执行。
		t2.start();		
		
	}
}

class Run implements Runnable
{
	private String s;
	Run(String s)
	{
		this.s = s;
	}
	private int k = 0;
	public  void run()
	{
		while ( k < 100)
		{
			System.out.println(this.s + k);
			k++;
		}
	}
}