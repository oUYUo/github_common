/*
extends���ͣ�
1�������ʽ��public static void  print(ArrayList< ? extends ����> a1)
   ����˵��������ArrayList���� ���� �� ���ࡣ

2���̶��ĸ��࣬����ɱ�ģ�ֻҪ����̳����ࡣ���౻�޶���������
3��������ʲô���͵����þͿɵ��ø��������з�����
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

class Student extends Person	//ѧ���̳���
{
	void stun()
	{
		System.out.println("Student");
	}
}

/*
�����
Person
Student
*/