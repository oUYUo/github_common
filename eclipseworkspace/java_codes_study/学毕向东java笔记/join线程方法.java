/*
join��������Thread���С�
���ã���A�߳�ִ�е�B�̵߳�.join()����ʱ��A�ͻ�ȴ�����B�̶߳�ִ���꣬A�Ż�ִ�С�
join����������ʱ�����߳�ִ�У�д�ڸ��߳��������һ�д��룬Ч�����ԡ�

��ʽ���̱߳���.join();
�쳣��InterruptedException - ����κ��߳��ж��˵�ǰ�̡߳����׳����쳣ʱ����ǰ�̵߳��ж�״̬ �������
*/

class java
{
	public static void main(String[] args)throws InterruptedException
	{
		Thread t1 = new Thread( new Run("a====================="));
		Thread t2 = new Thread( new Run("b+++"));
		t1.start();
		t1.join();	//��ִ�е�joinʱ�����̺߳�t2�̶߳�Ҫ�ȴ�t1�߳�ִ����󣬲�ִ�С�
		t2.start();		
		
	}
}

class Run implements Runnable
{
	private String s;
	Run(String s)
	{
		this.s = s;
	}
	private int k = 0;
	public  void run()
	{
		while ( k < 100)
		{
			System.out.println(this.s + k);
			k++;
		}
	}
}