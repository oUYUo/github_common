package com.test;

import java.util.HashSet;
import java.util.Random;

public class test1 {
	/*
	 * 分析：
	 * 1.有random创建随机数对象
	 * 2.需要存储十个随机数，而且不能重复，所以我们用hashset
	 * 3.如果hashset的size是小于10就可以不断存储，若果大于就停止存储
	 * 4.通过random中的nextint（n）方法，来获取1到20之间的随机数并将这些随机数存储在hashset集合中
	 * 5.遍历hashset
	 */
	public static void main(String[] args) {
		Random random = new Random();
		HashSet<Integer> hashSet = new HashSet<>();
		while (hashSet.size()<10) {
			hashSet.add(random.nextInt(21));
		}
		for(Integer integer:hashSet)
			System.out.println(integer);
	}
}
