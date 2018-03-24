/*
线程间通讯：
其实就是多个线程在操作同一个资源，
但是操作的动作不同。

wait();		 线程等待 ----- 锁.wait();  等待线程池中的第一个线程（处于运行排位的第一位线程）
		异常：InterruptedException - 如果在当前线程等待通知之前或者正在等待通知时，任何线程中断了当前线程。在抛出此异常时，当前线程的中断状态 被清除。
		异常：IllegalMonitorStateException - 如果当前线程不是此对象监视器的所有者。

notify();    线程唤醒 ----- 锁.notify();  唤醒线程池中第一个线程（处于唤醒排位的第一位线程）
		异常：IllegalMonitorStateException - 如果当前线程不是此对象监视器的所有者。

notifyAll(); 唤醒所有线程  ----- 锁.notifyAll();  唤醒在此对象监视器上等待的所有线程。
		异常：异常：IllegalMonitorStateException - 如果当前线程不是此对象监视器的所有者。

以上方法在 Object 类中。

都使用在同步中，因为要对持有监视器(锁)的线程操作。
所以要使用在同步中，因为只有同步才具有锁。

为什么这些操作线程的方法要定义Object类中呢？
因为这些方法在操作同步中线程时，都必须要标识它们所操作线程只有的锁，
只有同一个锁上的被等待线程，可以被同一个锁上notify唤醒。
不可以对不同锁中的线程进行唤醒。

也就是说，等待和唤醒必须是同一个锁。

而锁可以是任意对象，所以可以被任意对象调用的方法定义Object类中。

*/
class Res
{
	String name;
	String sex;
	boolean flag = false;
}

class Input implements Runnable
{
	private Res r ;
	Input(Res r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			synchronized(r)
			{

				if(r.flag)

					try
					{
						r.wait();
					}
					catch ( Exception e){   }

				if(x==0)
				{
					r.name="mike";
					r.sex="man";
				}
				else
				{
					r.name="丽丽";
					r.sex = "女女女女女";
				}
				x = (x+1)%2;
				r.flag = true;
				r.notify();
			}
		}
	}
}

class Output implements Runnable
{
	private Res r ;
	
	Output(Res r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			synchronized(r)
			{
				if(!r.flag)
			    {
					try
					{
						r.wait();
					}
					catch (Exception e){     }
				}
				System.out.println(r.name+"...."+r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}


class  InputOutputDemo
{
	public static void main(String[] args) 
	{
		Res r = new Res();

		Input in = new Input(r);
		Output out = new Output(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);

		t1.start();
		t2.start();
	}
}