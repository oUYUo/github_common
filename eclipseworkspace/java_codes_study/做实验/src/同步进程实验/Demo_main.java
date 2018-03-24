package 同步进程实验;
class MyThreadDemo implements Runnable{
	private int ticket=5;
	

	public void run(){
		for(int i=0;i<10;i++)
		{
			tell();
		}
	}
	public synchronized void tell(){
		if(ticket>0)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("车票"+ticket--+"\n"+Thread.currentThread().getName());
		}
	}
}
class Thread2 implements Runnable
{
	private int num=100;
	public void run()
	{
		for(int i =0;i<1000;i++)
		{
			tell();
		}
		
	}
	public synchronized void tell()
	{
		if(num>0)
		{
			System.out.println("ticket"+"="+num+"\tname: "+Thread.currentThread().getName());
			num=num-1;
		}
	}
	
}

public class Demo_main {

	public static void main(String[] args)  {
//		// TODO Auto-generated method stub
//		Demo_Thread[] T= new Demo_Thread[6];
//		for(int i=0;i<6;i++)
//		{
//			T[i] = new Demo_Thread();
//			T[i].start();
//			
////			System.out.println(T[i].getName());
//			T[i].setName(i+"hhh");
//			System.out.println(T[i].getName());
//		}
//		for(int i=0;i<10;i++)
//		{
//			
//			if(i>5)
//			{
//				T[0].join();
//				System.out.println("T[0].join");
//			}
//			System.out.println(i);
//		}
//		T[0].setPriority(Thread.MAX_PRIORITY);
//		T[1].setPriority(Thread.MIN_PRIORITY);
//		T[3].setPriority(Thread.NORM_PRIORITY);;
//		T[0].start();
//		T[1].start();
//		T[2].start();
//		MyThreadDemo m = new MyThreadDemo();
//		Thread  t1 = new Thread(m);
//		Thread  t2 = new Thread(m);
//		Thread  t3 = new Thread(m);
//		t1.start();
//		t2.start();
//		t3.start();
		Thread2 m = new Thread2();
		Thread t1=new Thread(m);
		Thread t2=new Thread(m);
		Thread t3=new Thread(m);
		Thread t4=new Thread(m);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t4.setName("t4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
	}

}
