/*
super泛型：
1，定义格式：public int compare(<? super 类名> a1)
   参数说明：al接受 固定的子类，接受父类 或 子类。

2，固定的子类，父类可变的，只要父类被子类继承。子类被限定，称下限
*/
import java.util.*;
class GenericDemo7 
{
	public static void main(String[] args) 
	{
	/*
		TreeSet(Comparator<? super E> comparator);
		将E定为：Student、Worker， 根据super泛型规定：
		固定的子类，接受父类 或 子类。
		那么 Student只可接受 Student 或 Person。
			 Worker只可接受 Student 或 Person。
		Comparator<Person> 定义为Person，那么 compare 参数是 Person 供这两类共同接受。

		最初设计：如果 Comparator<Worker>，那么 compare 参数也是 Worker。 Student无法传递。
	*/
		
		TreeSet<Student> ts = new TreeSet<Student>(new Comp());

		ts.add(new Student("abc03"));
		ts.add(new Student("abc02"));
		ts.add(new Student("abc06"));
		ts.add(new Student("abc01"));
		
		Iterator<Student> it = ts.iterator();

		while(it.hasNext())
		{
			System.out.println(it.next().getName());
		}


		TreeSet<Worker> ts1 = new TreeSet<Worker>(new Comp());	

		ts1.add(new Worker("wabc--03"));
		ts1.add(new Worker("wabc--02"));
		ts1.add(new Worker("wabc--06"));
		ts1.add(new Worker("wabc--01"));


		Iterator<Worker> it1 = ts1.iterator();

		while(it1.hasNext())
		{
			System.out.println(it1.next().getName());
		}
	}
}
//Comparator<? super E> comparator)固定的子类，父类可变的，只要父类被子类继承。子类被限定，称下限

class Comp implements Comparator<Person>
{
	public int compare(Person p1,Person p2)
	{
		return p2.getName().compareTo(p1.getName());
	}
}


class Person
{
	private String name;
	Person(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return "person :"+name;
	}
}

class Student extends Person
{
	Student(String name)
	{
		super(name);
	}

}

class Worker extends Person
{
	Worker(String name)
	{
		super(name);
	}
}