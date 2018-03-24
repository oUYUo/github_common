/*
1��LineNumberReader �̳��� BufferedReader
2��LineNumberReader ��չ�����ࣺ
		1�����췽���������������б�ţ�LineNumberReader(Reader in) 
		   ���÷�ʽ��LineNumberReader lnr = new LineNumberReader( new FileReader( "dome.java"));

		2�����õ�ǰ�кţ�void setLineNumber(int lineNumber) 
		   �������кų�ʼֵ������100  ��ӡ��101��ʼ��
		   ���÷�ʽ��lnr.setLineNumber( 15);

		3����ȡ��ǰ�кţ�int getLineNumber()
		   ���÷�ʽ��lnr.getLineNumber();

		4�����������͸��඼��ͬ��
*/

import java.io.*;
class  
{
	public static void main(String[] args) throws IOException
	{
		LineNumberReader lnr = new LineNumberReader( new FileReader( "dome.java"));

		String line = null;
		lnr.setLineNumber(100);	//�����кţ���101��ʼ��
		
		while( (line = lnr.readLine()) != null)
		{
			//��ӡ�ı��кţ�����ӡ�ı����ı���
			System.out.println( lnr.getLineNumber() + ":" + line);
		}

		lnr.close();
	}
}