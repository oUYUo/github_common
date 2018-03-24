package _indexOf;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mail="1548314601@qq.com";
		int i=3;
		String a=String.valueOf(i);
		System.out.println(a);//将int类型转为String类型
		int b= Integer.parseInt(a);
		System.out.println(b);//将String转为int类型
		int c=mail.indexOf('1');
		System.out.println(c);
		
		System.out.println(mail);
	}

}
