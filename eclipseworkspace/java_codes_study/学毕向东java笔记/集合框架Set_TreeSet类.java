/*
集合：java.util包。集合存储的都是对象的地址值。
集合框架_TreeSet类。
1，TreeSet自然排序：通过实现 Comparable接口的 compareTo()方法进行排序。
   compareTo()同样具备保证元素的唯一性。
2，TreeSet存储方式：二叉树存储：
		当元素小于第一个元素，则存放第一个元素左下边。
		当元素大于第一个元素，则存放第一个元素右下边。
		当元素小于第二个元素，则存放第二个元素左下边。

3，TreeSet取出方式：是从小到大取出，也就是从二叉树的左边最后一个元素开始取出。
4，当 compareTo()方法不明确排序方法时，会发生异常。
5，自定义明确排序方法，实现 Comparable接口的 compareTo()方法即可。


6，Comparable接口方法：
	1，比较此对象与指定对象的顺序：int compareTo(T o)
	   返回值：负整数、零或正整数，根据此对象是小于、等于还是大于指定对象。
	   异常：ClassCastException - 如果指定对象的类型不允许它与此对象进行比较。
	   调用方式：在对象类中复写此方法，TreeSet 会自动调用。
	   调用方式：默认排序方法。

7，技巧方式：将compareTo返回值全部设置为-1或1，则按存储的顺序取出。

--------------------------------------------------------------------------------------------------------------------

8，TreeSet类构造方法：
	1，构造TreeSet集合，元素按自然顺序排序：TreeSet();
	   调用方式：TreeSet ts = new TreeSet();

	2，构造TreeSet集合，元素按指定比较器排序：TreeSet(Comparator<? super E> comparator);
	   参数：传递Comparator接口。
	   调用方式：TreeSet( new Comparator实现类);

9，Comparator接口方法：
	1，比较排序的两个参数：int compare(T o1, T o2);
	   参数：
	   实现方式：实现该类方法，new子类对象传递 TreeSet(Comparator);

	2，比较对象是否相等：boolean equals(Object obj);
	   实现方式：因Object被所有类继承，而Object类有此方法，所以可不必另复写该方法。

-------------------------------------------------------------------------------------------------------------------

10，Comparable接口排序 与 Comparator接口排序 区别：
	Comparable接口：是一种默认方式排序的，由 TreeSet 自动调用。
	Comparator接口：是一种扩展性排序。在 Comparable排序不修改情况下，能提供额外的排序方式。提高了程序的扩展性。
*/

import java.util.*;
class java
{
	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		//TreeSet ts = new TreeSet( new Comp); 第二种方式排序，都是二叉树。

		ts.add( new Student( "张三", 18));
		ts.add( new Student( "李四", 23));
		ts.add( new Student( "李武", 20));
	  //ts.add( new Student( "张三", 18));

		Iterator it = ts.iterator();

		while( it.hasNext())
		{
			Student s = (Student)it.next();
			System.out.println( "name = " + s.getname() + "   age = " + s.getage());
		}
	}
}

class Student implements Comparable
{
	private String name;
	private int age;
	
	Student( String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	String getname()
	{
		return this.name;
	}

	int getage()
	{
		return this.age;
	}

	public int compareTo( Object obj)
	{
		if( !(obj instanceof Student))
			throw new RuntimeException("对象错误");

		Student s = (Student)obj;

		if( this.age > s.age)
			return 1;

		if( this.age == s.age)
		{
			return this.name.compareTo(s.name);	//String类中也复写了compareTo方法，字符串排序。
		}

		return -1;
	}
}

//---------------------第二种排序方式--------------------------------------

class Comp implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;

		int num = s1.getname().compareTo( s2.getname());

		if( num == 0)
		{
			return new Integer( s1.getage()).compareTo( new Integer( s2.getage()));
		}

		return num;
	}
}