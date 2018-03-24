/*
JDK1.5 中提供了多线程升级解决方案。
将同步Synchronized替换成现实Lock操作。
将Object中的wait，notify notifyAll，替换了Condition对象。
该对象可以Lock锁 进行获取。
一个锁可拥有多个对象。
该示例中，实现了本方只唤醒对方操作。

Lock:替代了Synchronized
	lock 
	unlock
	newCondition()

Condition：替代了Object wait notify notifyAll
	await();
	signal();
	signalAll();
*/

import java.util.concurrent.locks.*;	//导入jdk提供的包，可以使用Lock、Condition

class ProducerConsumerDemo2 
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();

		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}

class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;
			//  t1    t2
	private Lock lock = new ReentrantLock();	//JDK中 ReentrantLock类 实现了Lock接口。

	private Condition condition_pro = lock.newCondition();//JDK中 Condition是个接口，Lock接口中newCondition()方法提供了创建Condition对象，而实现Lock是ReentrantLock类
	private Condition condition_con = lock.newCondition();//Condition创建锁的对象。
	//上面代码：一个锁可拥有多个对象。



	public  void set(String name)throws InterruptedException
	{
		lock.lock();
		try
		{
			while(flag)
				condition_pro.await();//t1,t2  对condition_pro对象的线程进行等待
			this.name = name+"--"+count++;

			System.out.println(Thread.currentThread().getName()+"...生产者.."+this.name);
			flag = true;
			condition_con.signal();  //唤醒在线程池中condition_con的线程。
		}
		finally
		{
			lock.unlock();//释放锁的动作一定要执行。释放锁  
		}
	}


	//  t3   t4  
	public  void out()throws InterruptedException
	{
		lock.lock();
		try
		{
			while(!flag)
				condition_con.await(); // 对condition_con对象的线程进行等待
			System.out.println(Thread.currentThread().getName()+"...消费者........."+this.name);
			flag = false;
			condition_pro.signal(); // 唤醒在线程池中condition_pro的线程。
		}
		finally
		{
			lock.unlock();
		}
		
	}
}

class Producer implements Runnable
{
	private Resource res;

	Producer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				res.set("+商品+");
			}
			catch (InterruptedException e)
			{
			}
			
		}
	}
}

class Consumer implements Runnable
{
	private Resource res;

	Consumer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				res.out();
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}