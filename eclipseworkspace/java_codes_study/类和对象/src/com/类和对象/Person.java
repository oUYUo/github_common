package com.类和对象;

public class Person {
	private String name;
	private int age;
	public Person(String n ,int a)
	{
		name=n;
		age=a;
		System.out.println("public Person(String n,int a)");
		
	}
	public String talk()
	{
		return "i am"+name+"i am "+age+"year's old";
	}
}
