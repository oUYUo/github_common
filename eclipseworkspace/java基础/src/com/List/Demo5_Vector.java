package com.List;

import java.util.Enumeration;
import java.util.Vector;

public class Demo5_Vector {
	public static void main(String[] args) {
		Vector vector = new Vector();
		vector.addElement("a");
		vector.addElement("b");
		vector.addElement("c");
		vector.addElement("d");
		
		Enumeration enumeration = vector.elements();//获取枚举
		while (enumeration.hasMoreElements()) {			//判断集合中是否有元素
			System.out.println(enumeration.nextElement());  //获取集合中的元素
		}
	}
}
