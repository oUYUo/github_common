/*
1，操作字节数组流：
	1，ByteArrayInputStream类是读字节数组流。
	2，ByteArrayInputStream类方法：
		1，构造方法：ByteArrayInputStream(byte[] buf) 
		   参数：buf --- 数组源
		   调用方式：ByteArrayInputStream bis = new ByteArrayInputStream( "qwer".getBytes());

		2，取单个字节：int read()
		   调用方式：bis.read();

	----------------------------------------------------------------------------------------

	3，ByteArrayOutputStream是写字节数组流。
	4，ByteArrayOutputStream类方法：
		1，构造函数：ByteArrayOutputStream()
		   调用方式：ByteArrayOutputStream bao = new ByteArrayOutputStream();

		2，输出字节：void write( byte[] b)
		   调用方式：bao.write( "qwe".getBytes());

		3，输出指定流：writeTO( OutputStream out)
		   调用方式：bao.writeTo( new FileOutputStream( "1.txt"));

		4，取当前缓冲区大小：int size()
		   调用方式：int len = bao.size();

		5，取字符串：String toString()
		   调用方式：String s = bao.toString();

2，操作字符数组流：方法和操作字节数组流基本一致。
	1，CharArrayReader			读字符数组流
	2，CharArrayWriter			写字符数组流

3，操作字符串流：方法和操作字节数组流基本一致。
	1，StringReader			读字符串数组流
	2，StringWrite			写字符串数组流

4，共性：无异常，不需关资源。

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
		//读：数据源
		ByteArrayInputStream bis = new ByteArrayInputStream( "qwe".getBytes());
		//写：数据目的
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
