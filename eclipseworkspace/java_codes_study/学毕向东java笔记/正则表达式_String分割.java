/*
String��ָ�������ʽ��
1���ָString[] split(String regex);
2���ָ�ʵ����"(.)\\1"			--->	. ��ʾ�����ַ����� .  �ַ���������1�Ρ��ж�ֱ�����һ���ַ���(.)\1+;��ʾ����2�����ϡ�
*/

class  
{
	public static void main(String[] args) 
	{
		//   . ��ʾ�����ַ��� \.��ʾ�����壻 \\.��ʾ������ʽ\.
		splitemo( "zhangsan.lisi.wangwu", "\\.");

		//	�ָ��������б��\\����\\ ת���ʾһ�������� \\\\
		splitDemo( "C:\\Program Files\\Intel", "\\\\");

		/* ���ʷָ��ĸ������ɱ�����ʹ�ã�С����()
				  1����ʾ��ͨ�ַ�
				 \1��ת��1��������
				\\1����ʾ������ʽ\n

			������1���ַ���(.)��ͬʱ��
			������ֶ���ַ���ͬʱ�� "(.)\\1+"	(\n)

		*/
		splitDemo( "arkktyqquizzo", "(.)\\1");
	}

	public static void splitD( String str, String reg) //�и���ó���
	{
		String[] arr = str.split( reg);
		for( String s : arr)
		{
			System.out.println( s);
		}
	}
}
