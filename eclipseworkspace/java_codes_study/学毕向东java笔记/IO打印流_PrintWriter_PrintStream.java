/*
��ӡ���������ṩ�˴�ӡ���������Խ������������͵����ݶ�ԭ����ӡ��

1���ֽڴ�ӡ����PrintStream
2�����캯�����Խ��յĲ������ͣ�
	1��file����File
	2���ַ���·����String
	3���ֽ��������OutputStream

---------------------------------------------------------------------

1���ַ���ӡ����PrintWriter
2�����캯�����Խ��յĲ������ͣ�
	1��file����File
	2���ַ���·����String
	3���ֽ��������OutputStream
	4���ַ��������Writer��
3��PrintWriter�����������
	1���ļ�������PrintWriter(File file) 
	   ���÷�����PrintWriter pw = PrintWriter( new File( "�ļ�"));

	2���ļ�������PrintWriter(Writer out)
	   ���÷�����PrintWriter pw = PrintWriter( new FileWriter( "�ļ�"));

	3���ļ��������Ƿ��Զ�ˢ������PrintWriter(Writer out, boolean autoFlush)
	   ������autoFlush - boolean ���������Ϊ true���� println��printf �� format ������ˢ�����������
	   ���÷�����PrintWriter pw = PrintWriter( new FileWriter( "�ļ�"), true);
	   
	4���ļ�������PrintWriter(String fileName) 
	   ���÷�����PrintWriter pw = PrintWriter(  "�ļ�");
*/

import java.io.*;

class  PrintStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		//autoFlush - boolean ���������Ϊ true���� println��printf �� format ������ˢ�����������
		PrintWriter out = new PrintWriter(new FileWriter("a.txt"),true);

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			out.println(line.toUpperCase());
			//out.flush();
		}

		out.close();
		bufr.close();

	}	
}