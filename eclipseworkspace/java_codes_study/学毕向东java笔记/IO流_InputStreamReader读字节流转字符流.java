/*
1��InputStreamReader�����ֽ�����ת���ַ����ࡣ
2��InputStreamReader �̳��� Reader ��ȡ�ַ�����
3��InputStreamReader �����÷���
	1�����췽�����ֽ���ת���ַ�����InputStreamReader(InputStream in)
	   ������InputStream ���������ĳ��ࡣ
	   ���÷�ʽ��InputStream in = System.in;
				 InputStreamReader isr = new InputStreamReader( in);
	
*/

class  
{
	public static void main(String[] args) 
	{
		//��ȡ����¼�����
		InputStream in = System.in;
		//���ֽ���ת���ַ�������
		InputStreamReader isr = new InputStreamReader( in);
		//Ϊ�����Ч�ʣ����ַ������л���������������
		BufferedReader bufr = new BufferedReader( isr);
		String s = null;

		while(true)
		{
			s = bufr.readLine();

			if( "over".equals(s))
			{
				break;
			}

			System.out.println(s);
		}

		bufr.close();
	}
}