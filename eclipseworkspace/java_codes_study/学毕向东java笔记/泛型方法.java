/*
���ͷ����������Ͷ����ڷ����ϡ�
1�����÷�ʽ��new Demo().show( ������������);
2����̬�������ɷ����෺�ͣ���Ϊ��̬�ȼ��أ��������ء������Զ��徲̬���ͷ�����
3���÷�ʽʹ�ü�����Ҫǿת�� ����ȫ��
*/

class Demo
{
	public <T> void show( T t)
	{
		System.out.println(t);
	}

	public static <T> void getlish( T t)
	{
		System.out.println(t);
	}
}

class main
{
	public static void main(String[] agrs)
	{
		Demo d = new Demo();
		d.show("����");
		d.show(4);

		Demo.getlish("hh");
	}
}