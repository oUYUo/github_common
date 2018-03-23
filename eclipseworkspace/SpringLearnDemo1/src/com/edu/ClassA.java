package com.edu;

public class ClassA {
	private ClassB classB;//类A将依赖于类B，因为类A使用类B的一个实例化classB
	public ClassA(){
		classB = new ClassB();// 修改要添加的一行语句
		System.out.println("A类默认构造方法被执行");
	}
	public ClassA( ClassB classB)
	{
		System.out.println("A类带参构造方法开始被执行！");
		this.classB=classB;
		System.out.println("A类带参构造方法结束被执行！");
	}
	public void a(){
		System.out.println("exec ClassA.a()!");
		classB.b();
	}
	public ClassB getClassB() {
		return classB;
	}
	public void setClassB(ClassB classB) {
		this.classB = classB;
	}
	
	
	
}
