package com.List;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

public class Demo1_list {
	public static void main(String[] args) {
//		demo1();
//		
//		demo4();
		List list = new ArrayList();		//不能访问子类特有方法
		list.add(111);
		list.add(222);
		list.set(1, "a");
		System.out.println(list);
	}

	private static void demo4() {
		List list = new ArrayList();		//不能访问子类特有方法
		list.add(111);
		list.add(222);
		Object object = list.get(0);
		System.out.println(object);
		
		//通过索引遍历list集合
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			
		}
	}

	private static void dmeo2() {
		List list = new ArrayList();		//不能访问子类特有方法
		list.add(111);
		list.add(222);
		list.add(333);
		//list.remove(111);
		list.remove(new Integer(111)); 			//删除的时候不会自动装箱，把111当做索引
		System.out.println(list);
	}

	private static void demo1() {
		List list = new ArrayList();		//不能访问子类特有方法
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
//		list.add(1, "e");				//在指定位置添加元素
//		list.add(10, "z"); 				//出现索引越界异常
		list.add(4,"z"); 				//index<=size并且index>=0都不会报异常
		System.out.println(list);
		Object object = list.remove(1);
		System.out.println(object);
		System.out.println(list);
	}
}
