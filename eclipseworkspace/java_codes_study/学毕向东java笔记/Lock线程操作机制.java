/*
JDK1.5 ���ṩ�˶��߳��������������
��ͬ��Synchronized�滻����ʵLock������
��Object�е�wait��notify notifyAll���滻��Condition����
�ö������Lock�� ���л�ȡ��
һ������ӵ�ж������
��ʾ���У�ʵ���˱���ֻ���ѶԷ�������

Lock:�����Synchronized
	lock 
	unlock
	newCondition()

Condition�������Object wait notify notifyAll
	await();
	signal();
	signalAll();
*/

import java.util.concurrent.locks.*;	//����jdk�ṩ�İ�������ʹ��Lock��Condition

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
	private Lock lock = new ReentrantLock();	//JDK�� ReentrantLock�� ʵ����Lock�ӿڡ�

	private Condition condition_pro = lock.newCondition();//JDK�� Condition�Ǹ��ӿڣ�Lock�ӿ���newCondition()�����ṩ�˴���Condition���󣬶�ʵ��Lock��ReentrantLock��
	private Condition condition_con = lock.newCondition();//Condition�������Ķ���
	//������룺һ������ӵ�ж������



	public  void set(String name)throws InterruptedException
	{
		lock.lock();
		try
		{
			while(flag)
				condition_pro.await();//t1,t2  ��condition_pro������߳̽��еȴ�
			this.name = name+"--"+count++;

			System.out.println(Thread.currentThread().getName()+"...������.."+this.name);
			flag = true;
			condition_con.signal();  //�������̳߳���condition_con���̡߳�
		}
		finally
		{
			lock.unlock();//�ͷ����Ķ���һ��Ҫִ�С��ͷ���  
		}
	}


	//  t3   t4  
	public  void out()throws InterruptedException
	{
		lock.lock();
		try
		{
			while(!flag)
				condition_con.await(); // ��condition_con������߳̽��еȴ�
			System.out.println(Thread.currentThread().getName()+"...������........."+this.name);
			flag = false;
			condition_pro.signal(); // �������̳߳���condition_pro���̡߳�
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
				res.set("+��Ʒ+");
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