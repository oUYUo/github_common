package com.edu;

public class Main2 {
	public static void main(String[] args) {
		ClassB  classB = new ClassB();
		ClassA  classA = new ClassA(classB);
		classA.a();
	}
}
//对象之间存在弱耦合关系（“构造器注入依赖”关系）