package com.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Demo4_listiterator {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("world");
		list.add("d");
		ListIterator listIterator=list.listIterator();//获取迭代器
		while(listIterator.hasNext())
		{
			System.out.println(listIterator.next());//获取元素冰箱指针向后移动
		}
		
		System.out.println("-----------");
		
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());//获取元素并将指针向前移动
		}
	}
}
