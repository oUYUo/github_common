/*
�ֲ��ڲ��ࣺ
1�������Ա���Ա���η����Ρ�
2������ֱ�ӷ����ⲿ���еĳ�Ա��
3���ֲ��ಿ��ֻ�ܷ��������ڵľֲ��б�final���εľֲ�������
*/

class A
{
	A()
	{
		class B
		{

			public void C()
			{
				System.out.println("C");
			}
		}

		new B().C();

		System.out.println( "A");
	}

	public static void main( String[] ager)
	{
		new A();
	}
}