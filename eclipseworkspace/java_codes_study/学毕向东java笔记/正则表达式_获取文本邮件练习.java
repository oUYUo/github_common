//ȡ�ı��ʼ���ַ��

import java.io.*;
import java.util.regex.*;

class  
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader( new FileReader( "E:\\ѧϰ��\\java\\������\\mail.txt"));

		String str = null;
		String reg = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile( reg);	//�������װ�ɶ���

		while( ( str = br.readLine()) != null)
		{
			Matcher m = p.matcher( str);	//������������ַ���������

			while( m.find())	//������� ��������١�
			{
				System.out.println( m.group());	//������ȡ�ַ�����
			}
		}
	}
}
