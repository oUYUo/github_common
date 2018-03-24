/*
泛型方法：将泛型定义在方法上。
1，调用方式：new Demo().show( 传递任意类型);
2，静态方法不可访问类泛型，因为静态先加载，对象后加载。但可以定义静态泛型方法。
3，该方式使用集合需要强转。 不安全。
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
		d.show("哈哈");
		d.show(4);

		Demo.getlish("hh");
	}
}