package com.collection;

import java.util.ArrayList;
import java.util.Collection;

import com.bean.Student;
//add方法如果是list集合一直返回true，因为list集合中可以存储重复元素
//如果是set集合当存储重复元素，返回false
//arraylist的父类的父类，重写登录tostring方法,所以打印对象引用是，不是object的tostring
@SuppressWarnings({ "rawtypes", "unchecked" })//保持原始类型，不检查
public class Demo2_collection {
	public static void main(String[] args) {
//		demo1();
		Collection c  = new ArrayList();//父类引用指向子类对象
		c.add("a");
		c.add("a");

		c.add("b");
		c.remove("a");
		c.remove("a");
		System.out.println(c.size());
		System.out.println(c.contains("b"));
		System.out.println(c.isEmpty());
//		c.clear();
		System.out.println(c);  //删除指定元素
		
	}

	private static void demo1() {
		Collection c  = new ArrayList();//父类引用指向子类对象
		boolean b1 = c.add("abc");
		boolean b2 = c.add(true);  //自动装箱 new Boolean(true);
		boolean b3 = c.add(100);	
		boolean b4 = c.add(new Student("张三", 15));			
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(c.toString());
	}
}
