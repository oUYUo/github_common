/*
ģ�淽�����ģʽ���ڶ��幦��ʱ������һ������ȷ���ĵģ�����һ���ֲ�ȷ������ȷ���Ĳ�����ʹ�ò�ȷ���Ĳ��֣���ô��ʱ�ͽ���ȷ���Ĳ��ֱ�¶��ȥ���ɸ��������ȥ��ɡ�


���󣺻�ȡһ�γ�������ʱ�䡣
ԭ����ȡ����ʼ�ͽ�����ʱ�䲢������ɡ�
��ȡʱ�䣺System.currentTimeMillis();


*/
class TemplateDemo
{
	public static void main(String[] agrs)
	{	
		SubTime  = new SubTime().runcade();
	}
}

abstract class GetTime
{
	public final void  GetTime()
	{
		long start = System.currentTimeMillis();
		runcade();
		long end = System.currentTimeMillis();
		System.out.println("���룺 " + end - start);
	}

	public abstract void runcade();
}

class SubTime extends GetTime
{
	public void runcade()
	{
		for (int x = 0; x < 4000; x++)
		{
			System.out.print(x);
		}
	}
}