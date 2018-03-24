package shapes;

public class MyPic2 {
	static int i=40;
	static int k=320;
	static int j=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Picture pic = new Picture(420,300);
		for(int I=1;I<1000;I++)
		{
//			String c = String.valueOf(I);
			Circle c = new Circle(k,i,80);
			k=k+j;
			i=i+j;
			pic.add(c);
		}
		pic.draw();
	}

}
