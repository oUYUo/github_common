/*
stop�����Ѿ���ʱ��

���ֹͣ�̣߳�
ֻ��һ�֣�run����������
�������߳����У����д���ͨ����ѭ���ṹ��

ֻҪ����סѭ�����Ϳ�����run����������Ҳ�����߳̽�����


���������
���̴߳����˶���״̬��
�Ͳ����ȡ����ǡ���ô�߳̾Ͳ��������

��û��ָ���ķ�ʽ�ö�����ָ̻߳�������״̬ʱ����ʱ��Ҫ�Զ�����������
ǿ�����ָ̻߳�������״̬�����������Ϳ��Բ���������߳̽�����

Thread���ṩ�÷��� interrupt();  �������״̬�̣߳�ʹ�ָ̻߳�����״̬��  �߳�.interrupt
*/

class StopThread implements Runnable
{
	private boolean flag =true;
	public synchronized void run()
	{
		while(flag)
		{
			try
			{
			//����ڵ�ǰ�̵߳ȴ�֪֮ͨǰ�������ڵȴ�֪ͨʱ���κ��߳��ж��˵�ǰ�̡߳����׳����쳣ʱ����ǰ�̵߳��ж�״̬ �������
				wait();
	
			}
			catch (InterruptedException e)
			{
				System.out.println(Thread.currentThread().getName()+"....Exception");
				flag = false;
			}
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

		//t1.setDaemon(true);
		//t2.setDaemon(true);
		t1.start();
		t2.start();

		int num = 0;

		while(true)
		{
			if(num++ == 60)
			{
			//interrupt();��wait�ָ̻߳���wait���׳��쳣��Ȼ��catch���䴦��whileΪ�٣�����ѭ����������������
				t1.interrupt();// �������״̬�̣߳�ʹ�ָ̻߳�����״̬��
				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+"......."+num);
		}
		System.out.println("over");
	}
}