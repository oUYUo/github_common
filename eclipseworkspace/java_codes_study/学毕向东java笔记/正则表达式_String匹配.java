/*
String��ƥ��������ʽ��
1��ƥ�䣺boolean matches(String regex);�ù���ƥ�������ַ�����ֻҪ��һ�������Ϲ��򣬾�ƥ�����������false��
2��ƥ��ʵ����"[1-9]\\d{4,14}"  --->	��һλ�ַ�[1-9]���ڶ�λ�ַ�[0-9]���Ҵӵڶ�λ�ַ���ʼ�����ٳ����ĴΣ����14�Ρ�����������������5λ������
*/

class  
{
	public static void main(String[] args) 
	{
		//Summary();
		//CharacterLimit()
		
	}

	public static void Summary()//ƥ��
	{
		String qq = "23858";
		String reagex = "[1-9][0-9]{4,14}";
		boolean flag = qq.matches( reagex);

		/*
		String reagex = "[1-9][0-9]{4,14}";
		[1-9]:��һλ���ֵķ�Χ��
		[0-9]:�ڶ�λ���ֵķ�Χ��
		{4,14}:��4λ��14λ����[0-9]��
		*/
	}

	public static void CharacterLimit()//ƥ��
	{
		String str = "by";
		String reg = "[bcd][a-z]";//���߰�a-z���ַ���д����
		boolean b = reg.matches( str);	
		/*
		��������Ϊ��
		[bcd]���ж� str ��һ���ַ��Ƿ��� b��c��d
		[a-z]���ж� str �ڶ����ַ��Ƿ��� a��z�ķ�Χ��

		�����������ʽ�� ^ ����Ϊȡ��������[^bcd]����������Ϊ�١�

		�涨��Сд��Χ��[a-zA-Z]
		ȡ������[a-d[m-p]]
		ȡ������[a-z&&[def]]
		��Χ����ȥ��[a-z&&[^bc]]	a��z������b��c
		��Χ����ȥ��[a-z&&[^m-p]]	a��z������m��p
		*/
	}
}
