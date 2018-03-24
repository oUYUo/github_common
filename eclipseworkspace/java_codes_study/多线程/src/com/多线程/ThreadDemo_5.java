package com.多线程;

public class ThreadDemo_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread t = new TestThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}

}
class TestThread implements Runnable
{
	private int tickets=200;
	public void run()
	{
		while(true)
		{
			synchronized(this)
			{
				if(tickets>0)
				{
					try{
						Thread.sleep(100);
					}
					catch(Exception e)
					{
						
					}
					System.out.println(Thread.currentThread().getName()+"出售票"+tickets--);
				}
			}
		}
	}
}