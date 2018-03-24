
class MyThreadDemo implements Runnable{
	private int ticket =5;
	
	public void run(){
		for(int i =0;i<10;i++)
		{
			tell();
		}
	}
	public synchronized void tell()
	{
		Thread.sleep(500);
		System.out.println("³µÆ±"+ticket--+"\n"+Thread.currentThread().getName());
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

	public class Demo_Thread{
		public static void main(String[] args)
		{
			Thread2 T2=new Thread2();
			Thread t1=new Thread(T2);
			t1.start();
	}
}