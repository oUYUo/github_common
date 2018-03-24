abstract  class Animals
{
	String name;
	int L;
	int age;
	abstract void bark();
	abstract String getName();
}
class Cats extends Animals{
	Cats(String name)
	{
		this.name=name;
	}
	void bark()
	{
		System.out.println("mimi");
	}
	String getName()
	{
		return name;
	}
	
}
public class Demo_abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cats c = new Cats("cats");
		c.bark();
		String c_name=c.getName();
		System.out.println(c_name);
		
	}

}
