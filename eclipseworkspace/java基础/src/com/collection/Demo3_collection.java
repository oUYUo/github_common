package com.collection;

import java.util.ArrayList;
import java.util.Collection;

import com.bean.Student;

//toArray 转换成数组

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Demo3_collection {
	public static void main(String[] args) {
//		demo1();
		Collection  c = new ArrayList();
		c.add(new Student("张三", 23));
		c.add(new Student("李四", 234));
		Object[] student = c.toArray();
		for(Object stu:student)
		{
			Student s =(Student) stu;
			System.out.println(s.getAge());
		}
	}

	private static void demo1() {
		Collection  c = new ArrayList();
		c.add("a");
		c.add("b");
		Object[] arr = c.toArray();
		for(Object arrs: arr)
		{
			System.out.println(arrs);
		}
	}
}
