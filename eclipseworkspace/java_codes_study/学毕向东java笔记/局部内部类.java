/*
局部内部类：
1，不可以被成员修饰符修饰。
2，可以直接访问外部类中的成员。
3，局部类部类只能访问它所在的局部中被final修饰的局部变量。
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