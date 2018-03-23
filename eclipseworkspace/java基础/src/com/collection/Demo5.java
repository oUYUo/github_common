package com.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo5 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		String[] arr = list.toArray(new String[10]);
		for(String string:arr)
		{
			System.out.println(string);
		}
		Integer[] aIntegers ={11,22,33,44,55};
		List<Integer> list2 = Arrays.asList(aIntegers);
		System.out.println(list2);
//		String[] arr=new String[2];
//		arr[0]= "string";
//		arr[1]= "abc";
//		print(2, arr);
//		System.out.println("--------------------------");
//		print(1,"a","b","c","d");
	}
	public static void print(int ar,String ... arr) {
		System.out.println(ar);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
	}
}
