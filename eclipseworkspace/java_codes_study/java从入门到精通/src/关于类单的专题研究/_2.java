package 关于类单的专题研究;
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
			System.out.println("成绩：score="+score);
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
