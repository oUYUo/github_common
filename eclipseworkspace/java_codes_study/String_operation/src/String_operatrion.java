import java.util.Scanner;

public class String_operatrion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch1='a';
		char ch2='b';
		System.out.println(ch1);
		
		String a="time is money";
		String b="hhh",c="jjj";
		String str1,str2;
		str1="hhh";
		str2="hhh";
		System.out.println(str1);
		String aa= new String("i love u ");
		System.out.println(aa);
		String bb=new String(aa);
		System.out.println(bb);
		
		char[] charArray={'t','i','m','e'};
		String aaa = new String(charArray);
		System.out.println(aaa);
		
		String bbb = new String(charArray,1,2);
		System.out.println(bbb);
		
				
		byte[] byteArray={-60,-6,-70,-20};
		String byte_String = new String(byteArray);
		System.out.println(byte_String);
		
		String id="1234567890";
		String sub=id.substring(2);
		System.out.println(sub);
		String st1="8888";
		int index =st1.indexOf("8");
		System.out.println(index);
		System.out.println(st1.length());
		String pinjie=new String("a"+"123");
		System.out.println(pinjie);
		id="111";
		System.out.println(id);
		
		StringBuffer sbf=new StringBuffer(32);
		sbf.append(id);
		System.out.println(sbf);
		
		StringBuffer poem = new StringBuffer("��ʫ����");
		poem.delete(0, 2);
		poem.insert(1, "�߲���");
		poem.append(",����������");
		System.out.println(poem);
		String regex="\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
		String a1="1548314601@qq.com";
		if (a1.matches(regex)){
			System.out.println("�Ϸ�");
		}
		
		Scanner sc = new Scanner(System.in);
		String regex2="(13[0-9]|15[012356789]|18[056789)\\d{8}";
		while(true){
			String phone = sc.nextLine();
			if(phone.matches(regex2)){
				System.out.println(phone+"���ֻ���");
			}else{
				System.out.println("������Ĳ����ֻ���");
			}
		}
			
	}
}
		
	

