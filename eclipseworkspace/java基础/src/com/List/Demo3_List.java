package com.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Demo3_List {
public static void main(String[] args) {
	List list = new ArrayList();
	list.add("a");
	list.add("b");
	list.add("world");
	list.add("d");
	ListIterator listIterator =list.listIterator();//list集合特有的
	while(listIterator.hasNext())
	{
		String string=(String)listIterator.next();
		if("world".equals(string))
		{
//			list.add("javaee");					//listiterator在遍历的时候还可以添加
			listIterator.add("javaee");
		}
	}
	System.out.println(list);
//	Iterator iterator = list.iterator();
//	while(iterator.hasNext())
//	{
//		String  string =(String) iterator.next();//向下转型
//		if("world".equals(string))
//		{
//			list.add("javaee");
//		}
//		
//	}
//	System.out.println(list);
}
}
