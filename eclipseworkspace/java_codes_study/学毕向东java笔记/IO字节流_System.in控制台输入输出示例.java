/*
1，在System类中，常用字段：
	System.out：输出流 ----> static PrintStream out
	System.in： 输入流 ----> static InputStream in

2，static InputStream in 输入流：
	A，被static修饰静态方法。
	B，返回类型：InputStream 类。
	C，调用方式：InputStream is = System.in;

3，InputStream （抽象类）字节输入流的所有类的超类。
4，通过 System.in 返回的 InputStream，可以在控制台输入输出操作。
5，键盘输入输出操作方法：
	1，“标准”输入流：static InputStream in
	   说明：用于创建输入对象。
	   调用方式：InputStream is = System.in;
	
	2，读取键盘单个字节：abstract  int read()
	   说明：调用此方法可以在控制台输入，并获取输入的单个字节。
	   调用方式：int r = is.read();

	3，读取键盘字节数组：int read(byte[] b)
	   返回值：返回读取字节数组个数。
	   调用方式：byte[] b = new byte[1024];
				 int i = is.read( b);

6，键盘输入输出操作不用关闭资源。
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