package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.bean.Student;

public class Demo5_Iterator {
	public static void main(String[] args) {
//		demo1();
		Collection c = new ArrayList();
		c.add(new Student("张三",23));			//object obj = new Student("张三",23);
		c.add(new Student("张sd三",23));
		c.add(new Student("sd张三",23));
		c.add(new Student("张三sd",23));
		//获取迭代器
		 
		Iterator iterator=c.iterator();
		while(iterator.hasNext())
		{
			Student student=(Student)iterator.next();	//向下转型
//			System.out.println(iterator.next());
			System.out.println(student.getName());

		}
	}

	private static void demo1() {
		Collection c = new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		//对集合中的元素迭代（遍历）
		Iterator  it =c.iterator();//获取迭代器
//		boolean b1 = it.hasNext();
//		Object obj1 = it.next();
//		System.out.println(b1);
//		System.out.println(obj1);
//		
//		boolean b2 = it.hasNext();
//		Object obj2 = it.next();
//		System.out.println(b2);
//		System.out.println(obj2);
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
