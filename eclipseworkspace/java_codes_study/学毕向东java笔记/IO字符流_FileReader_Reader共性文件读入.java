/*
import java.io.Reader�����ࣺ���������ַ���
1����Reader�ǳ����࣬�������ࡣ
2���Զ����ļ�Ϊʵ��������Reader����InputStreamReader������FileReader�ࡣ
3��IO�����󲿷ַ�����Ҫ�׳� �� ��׽�쳣 �� IOExeption�쳣��

4��FileReader�����������
	1�������ļ���ȡ������FileReader(String fileName)
	   �쳣�����ļ������� �� ���Ǹ��ļ����ᷢ�� FileNotFoundException �쳣��
	   ���÷�ʽ��FileReader fr = new FileReader( "�ļ�·��+�ļ���+��׺");

--------------------------------------------------------------------------------------

5��Reader���Բ���������
	1����ȡ�����ַ���int read()  
	   ����ֵ��readһ�ζ�һ���ַ������һ��Զ����¶������ض�Ӧ�ַ�����ֵ��������û���ַ�ʱ������ -1��
	   ���÷�ʽ��char ch = (char)fr.read();
	   
	2�����ַ��������飺int read(char[] cbuf)
	   ����ֵ�����ص��Ƕ�������ĸ����������볬������ʱ������ -1.
	   ���⣺���洢����С���ַ���ʱ����ѭ�����ǵ��������ݡ�
	   ���÷�ʽ��char[] buf = new char[1024];
	             int num = 0;
				 while( ( num = fr.read(buf)) != -1)
				 {
					System.out.println(new String( buf, 0, num));
				 }
				 fr.close();
*/

class  
{
	public static void main(String[] args)throws IOException
	{
		FileReader fr = new FileReader( "dome.txt");

		//char ch = (char)fr.read();  ��ȡ�����ַ���

		char[] buf = new char[1024];	
		int num = fr.read( buf);	//����ȡ���ַ����� buf �У���������ȡ���ַ�������

		System.out.println( new String(buf,0,num)); 
		/*���ַ�����ת���ַ����� ����������ʼλ�ã�����������βλ�ã����������� 
		�������Ǵ�0��ʼ�������ص��������������Բ���Ҫ��+1��-1
		*/
	}
}
