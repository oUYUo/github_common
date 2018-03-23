package com.collection;

import java.util.ArrayList;
import java.util.Collection;

import com.bean.Student;
//添加集合
public class Demo4_collectionAll {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		Collection c2 = new ArrayList();//alt+shift+r  改名
		c2.add("a");
		c2.add("b");
		c2.add("c");
		c2.add("d");
		c1.addAll(c2);				//将c2添加到c1中
//		c1.add(c1);			//添加一个集合到另一个集合中
		c1.removeAll(c2);		//删除交集  返回布尔类型
		c1.containsAll(c2);	//判断是否包含，调用的集合是否包含传入的集合
		c1.retainAll(c2);//去交集  ，如果调用的集合改变，就返回true，如果调用的集合不变就返回false
		System.out.println(c1);
	}
	
}
