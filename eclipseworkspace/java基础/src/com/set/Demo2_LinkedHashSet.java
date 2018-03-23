package com.set;

import java.util.LinkedHashSet;

public class Demo2_LinkedHashSet {
	/*
	 * LinkedHashSet
	 * 底层链表实现，是set集合中唯一一位能保证怎么存怎么取的集合对象
	 * 因为是hashset的子类，所以也是保证元素唯一的，与hashset的原理一样
	 */
	public static void main(String[] args) {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("a");
		linkedHashSet.add("z");
		linkedHashSet.add("c");
		System.out.println(linkedHashSet);
	}
}
