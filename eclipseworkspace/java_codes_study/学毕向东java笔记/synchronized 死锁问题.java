/*
synchronized ����������
ͬ����Ƕ��ͬ��, ����ȴ��ͬ,��ӵ��2����2�����ϵ��̲߳Żᷢ�������⡣
���ͣ���2���̣߳�ÿ���߳��õ���ͬ������A�߳��õ�A��ִ��A����Ȼ��ִ��B����B�߳��õ�B��ִ��B����Ȼ�� ִ��A����
      ��A������ȷ����A�̣߳�B�߳�Ҳ����B��A������B������B�߳�û��B������A�߳̿����õ�B��
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
	//д�ɾ�̬�Ƿ���ֱ�ӵ��á�
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