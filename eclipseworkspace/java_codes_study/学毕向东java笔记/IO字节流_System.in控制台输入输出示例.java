/*
1����System���У������ֶΣ�
	System.out������� ----> static PrintStream out
	System.in�� ������ ----> static InputStream in

2��static InputStream in ��������
	A����static���ξ�̬������
	B���������ͣ�InputStream �ࡣ
	C�����÷�ʽ��InputStream is = System.in;

3��InputStream �������ࣩ�ֽ���������������ĳ��ࡣ
4��ͨ�� System.in ���ص� InputStream�������ڿ���̨�������������
5�����������������������
	1������׼����������static InputStream in
	   ˵�������ڴ����������
	   ���÷�ʽ��InputStream is = System.in;
	
	2����ȡ���̵����ֽڣ�abstract  int read()
	   ˵�������ô˷��������ڿ���̨���룬����ȡ����ĵ����ֽڡ�
	   ���÷�ʽ��int r = is.read();

	3����ȡ�����ֽ����飺int read(byte[] b)
	   ����ֵ�����ض�ȡ�ֽ����������
	   ���÷�ʽ��byte[] b = new byte[1024];
				 int i = is.read( b);

6��������������������ùر���Դ��
*/

import java.io.*;

class java
{
	public static void main(String[] args)throws IOException
	{
		read_1();
	//	read_2();

	}

	public static void read_1() throws IOException
	{
		InputStream is = System.in;
		StringBuilder sb = new StringBuilder();

		while(true)
		{
			int r = is.read();

			if( r == '\r')
			{
				continue;
			}
			if( r == '\n')
			{
				String s = sb.toString();
				if( "over".equals(s))
				{
					break;
				}
				System.out.println(s);
				sb.delete(0,sb.length());
			}

			else if( r != -1)
			{
				sb.append((char)r);
			}
		}	
	}


	public static void read_2() throws IOException
	{
		InputStream is = System.in;

		byte[] b = new byte[1024];

		while(true)
		{
			int i = is.read( b);
			String s = new String(b, 0, i);
			if(  "over\r\n".equals(s))
			{
				break;
			}
			System.out.print( s);
		}
	}
}