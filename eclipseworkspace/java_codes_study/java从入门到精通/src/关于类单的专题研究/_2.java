package �����൥��ר���о�;
class Outer
{
	int score =56;
	void inst()
	{
		inner in =new inner();
		in.display();
	}
	class inner
	{
		void display()
		{
			System.out.println("�ɼ���score="+score);
		}
	}
}

public class _2 {
	public static void main(String[] args)
	{
		Outer outer =new Outer();
		outer.inst();
	}

}
