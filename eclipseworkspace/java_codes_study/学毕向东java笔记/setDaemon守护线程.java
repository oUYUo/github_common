/*
�ػ��̣߳�void setDaemon(boolean on) 
1���� Thread ���У��и�����void setDaemon(boolean on) 
2��ʹ�ø�ʽ���̶߳���.setDaemon(true);
3���÷��������������߳�ǰ���á� 
4�����ã������̱߳��Ϊ�ػ��̻߳��û��̡߳����������е��̶߳����ػ��߳�ʱ��Java ������˳���
		 Ҳ����˵�������߳̽������ػ��߳�Ҳ���Ž�����
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
