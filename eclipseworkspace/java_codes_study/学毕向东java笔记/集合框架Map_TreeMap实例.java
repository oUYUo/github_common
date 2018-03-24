/*
ע�⣺ʵ��Comparator�ӿڣ�ֻ���� ��������ʲô���ͣ�Comparator���;���ʲô���͡�
*/
import java.util.*;
class java
{
	public static void main(String[] args)
	{
		TreeMap< students, String> map = new TreeMap< students, String>( new Comp());

		map.put( new students( "����01", 18), "����");
		map.put( new students( "����02", 19), "����");
		map.put( new students( "����03", 12), "����");
		map.put( new students( "����04", 17), "�㽭");
		Set<Map.Entry< students, String>> set = map.entrySet();

		Iterator<Map.Entry< students, String>> it = set.iterator();

		while( it.hasNext())
		{
			Map.Entry me = it.next();
			students s = (students)me.getKey();
			System.out.println( "name = " + s.getname() + "		age = " + s.getage() + "	��ַ��" + me.getValue());
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
			throw new ClassCastException("���Ͳ�ƥ��");

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