package ��ķ�װ�̳ж�̬;
class Person{
	String name;
	int age;
	public Person(){
		
	}
	public String talk()
	{
		return "����"+this.name+"�����꣺"+this.age+"��";
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

public class tͨ��super���ø�������Ժͷ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("����",25,"����");
		System.out.println("�� ѧУ��"+s.school);
	}

}
