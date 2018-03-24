/*
1���������װ�� Pattern ����
2��������������ַ������� ---> Matcher
3������ѭ�����ж��ַ������Ӵ��Ƿ���Ϲ��� ---> m.fina()
4����ȡƥ����ַ������ ---> m.group()
5����ȡ�ַ���ǣ���������࣬���� java.util.regex ���У�
	Pattern�ࣺ�������װ�ɶ���
	Matcher�ࣺ������������ַ���������
6����ȡ������ƥ�䡣

---------------------------------------------------------------------------------------

7��Pattern�࣬��û�й��캯��������������
	1����װ������ʽ��static Pattern compile(String regex) 
	   ���÷�ʽ��Pattern p = Pattern.compile( "\\b[a-z]{4}\\b");
	
	2������ƥ������Matcher matcher(CharSequence input) 
	   ���÷�ʽ��Matcher m = p.matcher( str);	//������������ַ���������

	3����ȡ������ʽ��String pattern()

	4���ָString[] split(CharSequence input)
	   ������CharSequence�����ַ����ࡣ
	   ���÷�ʽ��String[] s = p.split( "78aq4");

-------------------------------------------------------------------------------------

8��Matcher�࣬��û�й��캯��������������
	1���� Pattern�� matcher()�������� Matcher����

	2��ƥ�䣺boolean find() 

	3������ƥ��ɹ��ַ�����String group()

	4����ȡƥ���ַ�����ʼ������int start() -->(��0��ʼ)
 
	5����ȡƥ���ַ���֮���ƫ������int end()

	6������ƥ������Matcher reset(CharSequence input)

*/

import java.util.regex.*;
class  
{
	public static void main(String[] args) 
	{
		String str = "ming tian jiu yao fang jia le ,da jia";
		String reg = "\\b[a-z]{4}\\b";

		Pattern p = Pattern.compile( reg);	//�������װ�ɶ���
		Matcher m = p.matcher( str);	//������������ַ���������

		while( m.find())	//������� ��������١�
		{
			System.out.println( m.group());	//������ȡ�ַ�����
			System.out.println( m.start() + "...." + m.end());	//	ȡ�ַ������ڵ���βλ�ã���0��ʼ����β�ַ�λ��+1
		}
	}
}
