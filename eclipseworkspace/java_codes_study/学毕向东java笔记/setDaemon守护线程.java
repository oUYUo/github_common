/*
守护线程：void setDaemon(boolean on) 
1，在 Thread 类中，有个方法void setDaemon(boolean on) 
2，使用格式：线程对象.setDaemon(true);
3，该方法必须在启动线程前调用。 
4，作用：将该线程标记为守护线程或用户线程。当正在运行的线程都是守护线程时，Java 虚拟机退出。
		 也就是说：当主线程结束，守护线程也跟着结束。
*/

class StopThread implements Runnable
{
	private boolean flag =true;
	public  void run()
	{
		while(flag)
		{		
			System.out.println(Thread.currentThread().getName()+"....run");
		}
	}
}

class  StopThreadDemo
{
	public static void main(String[] args) 
	{
		StopThread st = new StopThread();
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.setDaemon(true);
		t2.setDaemon(true);
		t1.start();
		t2.start();

		int num = 0;

		while(true)
		{
			if(num++ == 60)
			{
				break;
			}
			System.out.println(Thread.currentThread().getName()+"......."+num);
		}
		System.out.println("over");
	}
}
