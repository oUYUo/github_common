/*
多线程安全性：票100，4个线程在卖，当多个线程出现在打印语句时，会打印同一个票。
解决安全性：对多条操作共享数据语句，只能让一个线程执行完。在执行中，其它线程不可参与执行。
			 synchronized( 对象 ) 锁
             {
				 需要被同步的代码;
             }
对象如同锁。持有锁的线程可以在同步中执行。
没有持有锁的线程即使获取cpu的执行权，也进不去，因为没有获取锁。

例：火车上的卫生间，需要关门，要上卫生间，需要先判断里面有没有人。

同步中只能有一个线程在运行。
弊端：多线程需要判断锁，较为消耗资源。

-----------------------------------------------------------------------
同步函数：public synchronized void run( int i){     }
同步函数就是把 synchronized 作为修饰词，被它修饰的函数有同步性。

----------------------------------------------------------------------

共性：1，明确哪些代码是多线程运行代码。
	  2，明确共享数据。
	  3，明确多线程运行代码中哪些语句是操作共享数据的。

不同：synchronized代码块使用的是自定义对象。
	  synchronized函数使用的是this对象。

	  当代码块和函数使用同一个对象，由这2个所控制的线程，可一起同步。

-----------------------同步函数被静态修饰------------------------------

同步函数被静态修饰：它的锁不是this，因为静态方法中不可定义this。
1，静态进内存是没有本类对象，但是一定有该类对应的字节码文件对象。
	类名.class 该对象的类型是Class
2，静态同步函数使用的锁是该方法所在类的字节码文件对象。类名.class



*/

class main
{
	public static void main(String[] args)
	{
		Runnable t = new Ticket();
		Thread t1 new Thread(t);
		t1.start();
	}
}

class Ticket implements Runnable
{
	private int tick = 100;
	Object obj new = Object

	public void run()		//synchronized 同步代码块使用方式。
	{
		while( true)
		{
			synchronized( obj)	//可随便new一个对象。synchronized同步代码块。
			{
				if ( tick > 0)
				{
					
					System.out.println(Thread.currentThread().getName()+"....sale :" + tick --);
					// currentThread() 返回对当前正在执行的线程对象的引用。 
					//getName() 返回该线程的名称。
				}
			}
		}

//------------- synchronized 同步函数  --------------------------------------
	public void run()
	{
		while( true)
		{
			synch()
	    }
	}

	public synchronized void synch()
	{
		if ( tick > 0)
		{
					
			System.out.println(Thread.currentThread().getName()+"....sale :" + tick --);
			// currentThread() 返回对当前正在执行的线程对象的引用。 
			//getName() 返回该线程的名称。
		}
	}
}