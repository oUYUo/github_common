/*
ע�⣺�ײ�Ϊ��ϣ�����ݽṹ������ȥ���ظ�Ԫ��ֻ��ʵ�� Comparable �ӿڣ���дhashCode()��equals()��compareTo();

�������ã���ѧ�����ԣ�������������Ϊ������ѧ����������Ϊֵ ���洢Map�����С�
ע�⣺������������ͬ����Ϊͬһ��ѧ����
������
	1������ѧ����
	2������map��������ѧ����Ϊ������ַ��Ϊֵ������map�С�
	   ԭ�򣺼������ظ���ֵ���ظ������Խ�ѧ����Ϊ����
	3����ȡmap�����е�Ԫ�ء�
*/
import java.util.*;
class java
{
	public static void main(String[] args) 
	{
		Map< students, String> map = new HashMap< students, String>();
		map.put( new students( "����01", 18), "����");
		map.put( new students( "����02", 19), "����");
		map.put( new students( "����03", 12), "����");
		map.put( new students( "����04", 17), "�㽭");

		Set<Map.Entry< students, String>> set = map.entrySet();

		Iterator< Map.Entry< students, String>> it = set.iterator();

		while( it.hasNext())
		{
			Map.Entry me = it.next();
			students s = (students)me.getKey();

			System.out.println( "name = " + s.getname() + "		age = " + s.getage() + "	Value = " + me.getValue());
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
		return name.hashCode() + age * 37;
	}

	public boolean equals( Object obj) //**
	{
		if( ! ( obj instanceof students))
			return false;

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