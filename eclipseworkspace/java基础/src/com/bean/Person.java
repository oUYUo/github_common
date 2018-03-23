package com.bean;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	public Person() {
		
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)					//调用的对象和传入的对象是同一个对象
			return true;					//直接返回true
		if (obj == null)					
			return false;
		if (getClass() != obj.getClass())		//判断两个对象对应的字节码文件是一个字节码
			return false;
		Person other = (Person) obj;			//向下转型
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	//按照年龄排序
//	@Override
//	public int compareTo(Person o) {
//		// TODO Auto-generated method stub
//		int num =this.age-o.age;
//		return num==0?this.name.compareTo(o.name):num;
//	}
	@Override
//	//按照姓名排序
//	public int compareTo(Person o) {
//		// TODO Auto-generated method stub
//		int num =this.name.compareTo(o.name); 
//		return num==0?this.age-o.age:num;
//	}
	//按照姓名长度排序
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		int length = this.name.length() - o.name.length();
		int num = length ==0 ?this.name.compareTo(o.name):length;
		return num==0?this.age-o.age:num;
	}
	
}
