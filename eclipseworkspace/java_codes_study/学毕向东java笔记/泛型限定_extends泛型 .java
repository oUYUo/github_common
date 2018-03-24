/*
extends泛型：
1，定义格式：public static void  print(ArrayList< ? extends 类名> a1)
   参数说明：接受ArrayList集合 父类 或 子类。

2，固定的父类，子类可变的，只要父类继承子类。父类被限定，称上限
3，泛型是什么类型的引用就可调用该类型特有方法。
*/
import java.util.*;
class java
{
	public static void main(String[] args) 
	{
		ArrayList<Person> s1 = new ArrayList<Person>();
		ArrayList<Student> s2 = new ArrayList<Student>();
		s1.add( new Person());
		s2.add( new Student());

		print( s1);
	    print( s2); 
	}

	public static void  print(ArrayList< ? extends Person> al)
	{
		Iterator< ? extends Person> it = al.iterator();

		while( it.hasNext())
		{
			it.next().stun();
		}
	}
}

class Person
{
	void stun()
	{
		System.out.println("Person");
	}
}

class Student extends Person	//学生继承人
{
	void stun()
	{
		System.out.println("Student");
	}
}

/*
结果：
Person
Student
*/