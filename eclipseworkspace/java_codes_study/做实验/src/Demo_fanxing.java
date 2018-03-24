
public class Demo_fanxing {
	static {
		System.out.println("super static blook");
	}
	StaticSuper{
		System.out.println("super constructor");
	}
	public static String name;
	static void talk()
	{
		System.out.print("hhh");
	}
	static
	{
		System.out.println("helloworld");
		name="sunzhuo";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(name);
		talk();
	}

}
