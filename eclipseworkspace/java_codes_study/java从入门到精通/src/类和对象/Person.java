package 类和对象;

public class Person {
	private String name;
	private int  age;
	public Person(String name,int age)
	{
		this.name = name;
		this.age= age;
	}
	
	void talk()
	{
		System.out.println("我是"+name+" ，我今年"+age+"岁了");
	}
}
