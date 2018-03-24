/*
1�������ֽ���������
	1��ByteArrayInputStream���Ƕ��ֽ���������
	2��ByteArrayInputStream�෽����
		1�����췽����ByteArrayInputStream(byte[] buf) 
		   ������buf --- ����Դ
		   ���÷�ʽ��ByteArrayInputStream bis = new ByteArrayInputStream( "qwer".getBytes());

		2��ȡ�����ֽڣ�int read()
		   ���÷�ʽ��bis.read();

	----------------------------------------------------------------------------------------

	3��ByteArrayOutputStream��д�ֽ���������
	4��ByteArrayOutputStream�෽����
		1�����캯����ByteArrayOutputStream()
		   ���÷�ʽ��ByteArrayOutputStream bao = new ByteArrayOutputStream();

		2������ֽڣ�void write( byte[] b)
		   ���÷�ʽ��bao.write( "qwe".getBytes());

		3�����ָ������writeTO( OutputStream out)
		   ���÷�ʽ��bao.writeTo( new FileOutputStream( "1.txt"));

		4��ȡ��ǰ��������С��int size()
		   ���÷�ʽ��int len = bao.size();

		5��ȡ�ַ�����String toString()
		   ���÷�ʽ��String s = bao.toString();

2�������ַ��������������Ͳ����ֽ�����������һ�¡�
	1��CharArrayReader			���ַ�������
	2��CharArrayWriter			д�ַ�������

3�������ַ������������Ͳ����ֽ�����������һ�¡�
	1��StringReader			���ַ���������
	2��StringWrite			д�ַ���������

4�����ԣ����쳣���������Դ��

*/

import java.io.*;
class  
{
	public static void main(String[] args) 
	{
		ByteArrayIO();
	}

	public static void ByteArrayIO()
	{
		//��������Դ
		ByteArrayInputStream bis = new ByteArrayInputStream( "qwe".getBytes());
		//д������Ŀ��
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		int by = 0;

		while( ( by = bis.read()) != -1)
		{
			bos.write( by);
		
		}

		System.out.println( bos.size());
		System.out.println( bos.toString());
	}
}
