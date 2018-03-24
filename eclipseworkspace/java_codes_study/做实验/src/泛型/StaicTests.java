package ·ºÐÍ;

public class StaicTests extends StaticSuper {
	static int rand;
	static {
		rand = (int)(Math.random()*6);
		System.out.println("static block"+rand);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("int main");
		StaicTests st = new StaicTests();
			}

}
