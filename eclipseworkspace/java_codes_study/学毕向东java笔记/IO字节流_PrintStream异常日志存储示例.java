/*
1��PrintStream�����ֽ��������չ���ܡ�
2��PrintStream�̳���FilterOutputStream��
3��PrintStream ��ӡ�������ַ���ʹ��ƽ̨��Ĭ���ַ�����ת��Ϊ�ֽڡ�����Ҫд���ַ�������д���ֽڵ�����£�Ӧ��ʹ�� PrintWriter �ࡣ 
4��PrintStream�����������
	1�����췽���������ļ���ӡ����PrintStream(String fileName) 
	   ������fileName ---> �ļ�·��+�ļ���+�ļ���׺����
	   ���÷�ʽ��PrintStream ps = new PrintStream( "exeception.log");

	2�����ط�������ӡString��void println(String x)
	   ˵�����ڹ��췽����ָ���ļ��󣬵��ô˷������ɽ� x ��ӡ���ļ��ϡ�
	   ���÷�ʽ��ps.println( "��Ҫ��ӡ������");

5��ʾ�����쳣��־�洢
*/
import java.io.*;
import java.util.*;
import java.text.*;

class  
{
	public static void main(String[] args) 
	{
		try
		{
			int[] a = new int[2];
			System.out.println(a[2]);
		}
		catch( Exception e)
		{
			//�����쳣����ʱ��
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy��MM��dd�� HH:mm:ss");
			String sb = sdf.format( d);

			try
			{
				//�����쳣�洢�ļ�
				PrintStream ps = new PrintStream( "exeception.log");

				ps.println( sb);	//�����ڴ�ӡ "exeception.log" �ļ���
				System.setOut( ps);	//�ı������
			}
			catch( IOException ioe)
			{
				throw new RuntimeException( "��־�ļ�����ʧ��");
			}

			//���쳣��Ϣ�洢���ļ��С�
			e.printStackTrace(System.out);
	}
}
//log4j