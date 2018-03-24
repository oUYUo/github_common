package 第五章_数据类型;

public class 整数类型 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*数据类型-基本数据类型-数值型
		 * 
		 */
		byte a=Byte.MAX_VALUE;
		System.out.println(a);
		short b=3;//一个变量名貌似不可以试用两次
		System.out.println(b);
		float num=3.0f;
		System.out.println(num);
		double hhh=44e10;
		System.out.println(hhh);
		float h=(float)hhh;
		System.out.println(h);
		String[] zhuanyi =new String[4];
		zhuanyi[0]="woaini\n"+"hhh";
		System.out.println(zhuanyi[0]);
		boolean status = true;
		System.out.println(status);
		num=(float)a/b;
		System.out.println(num);
		long g = Long.MIN_VALUE;
		System.out.println(g);
	}

}
