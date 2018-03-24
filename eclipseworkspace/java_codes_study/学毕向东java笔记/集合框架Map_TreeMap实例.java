/*
注意：实现Comparator接口，只排序 键。键是什么类型，Comparator泛型就是什么类型。
*/
import java.util.*;
class java
{
	public static void main(String[] args)
	{
		TreeMap< students, String> map = new TreeMap< students, String>( new Comp());

		map.put( new students( "张三01", 18), "湖北");
		map.put( new students( "张三02", 19), "江苏");
		map.put( new students( "张三03", 12), "辽宁");
		map.put( new students( "张三04", 17), "浙江");
		Set<Map.Entry< students, String>> set = map.entrySet();

		Iterator<Map.Entry< students, String>> it = set.iterator();

		while( it.hasNext())
		{
			Map.Entry me = it.next();
			students s = (students)me.getKey();
			System.out.println( "name = " + s.getname() + "		age = " + s.getage() + "	地址：" + me.getValue());
		}
	}
}

class students implements Comparable<students>
{
	private String name;
	private int age;

	students( String name, int age)
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

	public int hashCode() //**
	{
		return name.hashCode() + age * 34;
	}

	public boolean equals(Object obj) //**
	{
		if(!(obj instanceof students))
			throw new ClassCastException("类型不匹配");

		students s = (students)obj;

		return this.name.equals(s.name) && this.age == s.age;
	}

	public int compareTo( students s)//**
	{
		int num = new Integer(this.age).compareTo( new Integer(s.age));

		if(num == 0)
			return this.name.compareTo(s.name);
		return num;
	}
}

class Comp implements Comparator<students>
{
	public int compare( students o1, students o2)
	{
		int unm = o1.getname().compareTo(o2.getname());

		if( unm == 0)
		{
			return new Integer( o2.getage()).compareTo( new Integer( o1.getage()));
		}
		return unm;
	}
}