class Template	//ģ����Ʒ�ʽ��
{
	public static void main(String[] agrs)
	{
		new Subclasses().time();
	}
}

abstract class GetTime
{
	public final void time()	//���ø��Ǹ÷�����
	{
		long start = System.currentTimeMillis();//��ȡ��ǰ�������к��롣

		test();

		long and = System.currentTimeMillis();//��ȡ��ǰ�������к��롣

		System.out.println(and - start);//����������͵��ڳ�������ʱ�䡣
	}
	abstract void test();
}

class Subclasses extends GetTime
{
	public void test()	//��дtest��ʵ���˳��󷽷������á�
	{
		for (int i = 0; i<1000; i++)
		{
			System.out.print(i);
		}
		System.out.println();
	}
}
