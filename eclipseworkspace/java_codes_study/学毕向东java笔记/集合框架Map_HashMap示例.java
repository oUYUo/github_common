/*
注意：底层为哈希表数据结构，排序去除重复元素只能实现 Comparable 接口，复写hashCode()、equals()、compareTo();

代码作用：将学生属性：姓名，年龄作为键；将学生归属地作为值 ，存储Map集合中。
注意：姓名和年龄相同，视为同一个学生。
分析：
	1，描述学生。
	2，定义map容器。将学生作为键，地址作为值，存入map中。
	   原因：键不可重复，值可重复，所以将学生作为键。
	3，获取map集合中的元素。
*/
import java.util.*;
class java
{
	public static void main(String[] args) 
	{
		Map< students, String> map = new HashMap< students, String>();
		map.put( new students( "张三01", 18), "湖北");
		map.put( new students( "张三02", 19), "江苏");
		map.put( new students( "张三03", 12), "辽宁");
		map.put( new students( "张三04", 17), "浙江");

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