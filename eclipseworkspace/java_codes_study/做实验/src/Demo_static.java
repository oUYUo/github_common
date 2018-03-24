class Person{
	static{
		System.out.println("static");
	}
}
class Student extends Person implements Do{
	
	public void talk()
	{
		System.out.println("studen is talk");
	}
	
	@Override
	public String Smile() {
		// TODO Auto-generated method stub
		return "hhh";
	}
	
}
interface Do{
	public static final String name = "sunzhuo";
	public void talk();
	public String Smile();
}

public class Demo_static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		Person p2 = new Person();
		Student s1 = new Student();
		s1.talk();
		String student_Simle=s1.Smile();
		System.out.println(student_Simle);
	}

}
