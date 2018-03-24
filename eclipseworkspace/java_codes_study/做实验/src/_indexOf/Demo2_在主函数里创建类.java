package _indexOf;
class SayHello{
	String Talk()
	{
		return "hello";
	}
}
public class Demo2_在主函数里创建类 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SayHello c = new SayHello();
		String a=c.Talk();
		System.out.println(a);
		 
	}

}
