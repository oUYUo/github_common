package 类的封装继承多态;
class Person{
	String name;
	int age;
	public Person(){
		
	}
	public String talk()
	{
		return "我是"+this.name+"，今年："+this.age+"岁";
	}
}

class Student extends Person
{
	String school;
	public Student(String name,int age,String school)
	{
		super.name=name;
		super.age=age;
		System.out.print(super.talk());
		this.school=school;
	}
}

public class t通过super调用父类的属性和方法 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("张三",25,"北京");
		System.out.println("， 学校："+s.school);
	}

}
