/*
1，PrintStream类是字节输出流扩展功能。
2，PrintStream继承了FilterOutputStream。
3，PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。 
4，PrintStream类基本方法：
	1，构造方法，创建文件打印流：PrintStream(String fileName) 
	   参数：fileName ---> 文件路径+文件名+文件后缀名。
	   调用方式：PrintStream ps = new PrintStream( "exeception.log");

	2，重载方法，打印String：void println(String x)
	   说明：在构造方法中指定文件后，调用此方法，可将 x 打印在文件上。
	   调用方式：ps.println( "需要打印的内容");

5，示例：异常日志存储
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
			//创建异常日期时间
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss");
			String sb = sdf.format( d);

			try
			{
				//创建异常存储文件
				PrintStream ps = new PrintStream( "exeception.log");

				ps.println( sb);	//将日期打印 "exeception.log" 文件中
				System.setOut( ps);	//改变输出流
			}
			catch( IOException ioe)
			{
				throw new RuntimeException( "日志文件创建失败");
			}

			//将异常信息存储到文件中。
			e.printStackTrace(System.out);
	}
}
//log4j