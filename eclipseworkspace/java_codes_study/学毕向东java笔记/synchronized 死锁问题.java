/*
synchronized 产生死锁。
同步中嵌套同步, 而锁却不同,且拥有2个或2个以上的线程才会发生此问题。
解释：有2个线程，每个线程拿到不同的锁，A线程拿到A锁执行A锁，然后执行B锁；B线程拿到B锁执行B锁，然后 执行A锁。
      当A锁有了确定的A线程，B线程也有锁B，A不能拿B锁；当B线程没有B锁，而A线程可以拿到B锁
*/

class Test implements Runnable
{
	private boolean flag;

	Test( boolean flag)
	{
		this.flag = flag;
	}

	public  void run()
	{
		if (flag)
		{
			synchronized(MyLock.locka)
			{
				System.out.println("if locka");
				synchronized(MyLock.lockb)
				{
					System.out.println("if lockb");
				}
			}
		}
		else
		{
			synchronized(MyLock.lockb)
			{
				System.out.println("else lockb");
				synchronized(MyLock.locka)
				{
					System.out.println("else locka");
				}
			}
		}
	}
}

class MyLock
{
	//写成静态是方便直接调用。
	static Object locka = new Object();
	static Object lockb = new Object();
}


class  DeadLockDemo
{
	public static void main(String[] args) 
	{
		Thread t1 = new Thread( new Test(true));
		Thread t2 = new Thread( new Test(false));
		t1.start();
		t2.start();
	}
}