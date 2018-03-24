import java.util.ArrayList;

abstract class Person implements Play
{
	String name="sunzho";
	int age=12;
	String Super()
	{
		return "super father";
	}
	abstract String talk();
	abstract int _long();
}


interface Play
{
	void Football();
	void Basketball();
}


class Player extends Person implements Play
{
	int _long()
	{
		return 1;
	}
	String Super()
	{
		
		return "i am son"+super.Super();
	}
	public String talk()
	{
		return "i am a Palyer" ;
	}
	public void say(String name)
	{
		System.out.println("i am a Player,i am playing"+name);
	}
	@Override
	public
	void Football()
	{
		say("football");
	}
	@Override
	public void Basketball()
	{
		say("basketball");
	}
}



class Student extends Person implements Play
{
//	String name ="sunzhuo";
//	int age=12;
	int _long()
	{
		return 2;
	}
	int age;
	Student(int i)
	{
		this.age=i;
	}
	public void say(String name)
	{
		System.out.println("i am a studetn,i am playing "+name);
	}
	String talk()
	{
		return "i am a student";
	}
	@Override
	public
	void Football()
	{
		say("football");
//		System.out.println("i am playing football");
	}
	@Override
	public void Basketball()
	{
		say("basketball");
	}
}

class Interview 
{
	String Speak(Person a)
	{
		return a.talk();
	}
	void Play(Person a)
	{
		a.Football();
		a.Basketball();
	}
}



public class Demo_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Student S = new Student();
//		String a=S.talk();
//		S.Football();
//		S.Basketball();
//		System.out.println(a);
		long NowTime =System.currentTimeMillis();
		for(int i=0;i<100000;i++)
		{
			Interview AA = new Interview();
			String A = AA.Speak(new  Student(1));
			String B=AA.Speak(new Player());
			System.out.println(A);
			System.out.println(B);
			AA.Play(new Student(1));
			AA.Play(new Player());
			Player player = new Player();
			String II=player.Super();
			System.out.println(II);
			Object SS= new Student(1);
			System.out.println(SS.getClass());
			if(SS instanceof Student){
				boolean boo = SS instanceof Student;
				System.out.println("SS instanceof Student"+"\n"+boo);
			}
			ArrayList<Student> as = new ArrayList<Student>();
			as.add(new Student(1));
			as.add(new Student(2));
			as.add(new Student(2));
			System.out.println(as);
			as.get(1).Football();
			System.out.println("hhh");
		}
		
		long EndTime =System.currentTimeMillis();
		long Time =EndTime-NowTime;
		System.out.println(Time);
		
	}

}
