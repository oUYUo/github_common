package ¼¯ºÏ;

import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class HashSetTest {
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hs = new HashSet();
		hs.add(new Person("a1",11));
		hs.add(new Person("a2",12));
		hs.add(new Person("a3",13));
		Iterator it =(Iterator) hs.iterator();
		
		while(it.next())
		{
			Person p = (Person)it.next();
			sop(p.getName()+"::"+p.getAge());
		}
		
	}

}
class Person
{
	public int hasCode()
	{
		return name.hasCode()+age*37;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person))
		{
			return false;
		}
		Person p =(Person)obj;
		return this.name.equals(p.name)&&this.age ==p.age;
	}
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
		
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	
}
