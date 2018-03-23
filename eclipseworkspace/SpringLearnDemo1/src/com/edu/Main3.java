package com.edu;

public class Main3 {
	public static void main(String[] args) {
		ClassB  classB = new ClassB();
		ClassA  classA = new ClassA();
		classA.setClassB(classB);
		classA.a();
	}
}
// 对象之间存在弱耦合关系（“setter方法注入依赖”关系）