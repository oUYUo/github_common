/*
���ϣ�java.util�������ϴ洢�Ķ��Ƕ���ĵ�ֵַ��
���Ͽ��_TreeSet�ࡣ
1��TreeSet��Ȼ����ͨ��ʵ�� Comparable�ӿڵ� compareTo()������������
   compareTo()ͬ���߱���֤Ԫ�ص�Ψһ�ԡ�
2��TreeSet�洢��ʽ���������洢��
		��Ԫ��С�ڵ�һ��Ԫ�أ����ŵ�һ��Ԫ�����±ߡ�
		��Ԫ�ش��ڵ�һ��Ԫ�أ����ŵ�һ��Ԫ�����±ߡ�
		��Ԫ��С�ڵڶ���Ԫ�أ����ŵڶ���Ԫ�����±ߡ�

3��TreeSetȡ����ʽ���Ǵ�С����ȡ����Ҳ���ǴӶ�������������һ��Ԫ�ؿ�ʼȡ����
4���� compareTo()��������ȷ���򷽷�ʱ���ᷢ���쳣��
5���Զ�����ȷ���򷽷���ʵ�� Comparable�ӿڵ� compareTo()�������ɡ�


6��Comparable�ӿڷ�����
	1���Ƚϴ˶�����ָ�������˳��int compareTo(T o)
	   ����ֵ������������������������ݴ˶�����С�ڡ����ڻ��Ǵ���ָ������
	   �쳣��ClassCastException - ���ָ����������Ͳ���������˶�����бȽϡ�
	   ���÷�ʽ���ڶ������и�д�˷�����TreeSet ���Զ����á�
	   ���÷�ʽ��Ĭ�����򷽷���

7�����ɷ�ʽ����compareTo����ֵȫ������Ϊ-1��1���򰴴洢��˳��ȡ����

--------------------------------------------------------------------------------------------------------------------

8��TreeSet�๹�췽����
	1������TreeSet���ϣ�Ԫ�ذ���Ȼ˳������TreeSet();
	   ���÷�ʽ��TreeSet ts = new TreeSet();

	2������TreeSet���ϣ�Ԫ�ذ�ָ���Ƚ�������TreeSet(Comparator<? super E> comparator);
	   ����������Comparator�ӿڡ�
	   ���÷�ʽ��TreeSet( new Comparatorʵ����);

9��Comparator�ӿڷ�����
	1���Ƚ����������������int compare(T o1, T o2);
	   ������
	   ʵ�ַ�ʽ��ʵ�ָ��෽����new������󴫵� TreeSet(Comparator);

	2���Ƚ϶����Ƿ���ȣ�boolean equals(Object obj);
	   ʵ�ַ�ʽ����Object��������̳У���Object���д˷��������Կɲ�����д�÷�����

-------------------------------------------------------------------------------------------------------------------

10��Comparable�ӿ����� �� Comparator�ӿ����� ����
	Comparable�ӿڣ���һ��Ĭ�Ϸ�ʽ����ģ��� TreeSet �Զ����á�
	Comparator�ӿڣ���һ����չ�������� Comparable�����޸�����£����ṩ���������ʽ������˳������չ�ԡ�
*/

import java.util.*;
class java
{
	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		//TreeSet ts = new TreeSet( new Comp); �ڶ��ַ�ʽ���򣬶��Ƕ�������

		ts.add( new Student( "����", 18));
		ts.add( new Student( "����", 23));
		ts.add( new Student( "����", 20));
	  //ts.add( new Student( "����", 18));

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
			throw new RuntimeException("�������");

		Student s = (Student)obj;

		if( this.age > s.age)
			return 1;

		if( this.age == s.age)
		{
			return this.name.compareTo(s.name);	//String����Ҳ��д��compareTo�������ַ�������
		}

		return -1;
	}
}

//---------------------�ڶ�������ʽ--------------------------------------

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