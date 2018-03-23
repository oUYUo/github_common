package com.collection;

import com.bean.Student;

public class Demo1_Array {
	public static void main(String[] args) {
		Student[] arr = new Student[5];//引用数据类型数组
		arr[0] = new Student("张三",23);
		arr[1] = new Student("李四", 24);
		arr[2] = new Student("王五", 22344);
		arr[3] = new Student("赵六", 2234);
//		arr[4] = new Student("路人甲", 54);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		for(Student std: arr)
		{
			System.out.println(std);
		}
	}
	
}
