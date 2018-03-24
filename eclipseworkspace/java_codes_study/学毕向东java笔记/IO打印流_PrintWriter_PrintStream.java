/*
打印流：该流提供了打印方法，可以将各种数据类型的数据都原样打印。

1，字节打印流：PrintStream
2，构造函数可以接收的参数类型：
	1，file对象。File
	2，字符串路径。String
	3，字节输出流。OutputStream

---------------------------------------------------------------------

1，字符打印流：PrintWriter
2，构造函数可以接收的参数类型：
	1，file对象。File
	2，字符串路径。String
	3，字节输出流。OutputStream
	4，字符输出流，Writer。
3，PrintWriter类基本方法：
	1，文件创建：PrintWriter(File file) 
	   调用方法：PrintWriter pw = PrintWriter( new File( "文件"));

	2，文件创建：PrintWriter(Writer out)
	   调用方法：PrintWriter pw = PrintWriter( new FileWriter( "文件"));

	3，文件创建，是否自动刷新流：PrintWriter(Writer out, boolean autoFlush)
	   参数：autoFlush - boolean 变量；如果为 true，则 println、printf 或 format 方法将刷新输出缓冲区
	   调用方法：PrintWriter pw = PrintWriter( new FileWriter( "文件"), true);
	   
	4，文件创建，PrintWriter(String fileName) 
	   调用方法：PrintWriter pw = PrintWriter(  "文件");
*/

import java.io.*;

class  PrintStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		//autoFlush - boolean 变量；如果为 true，则 println、printf 或 format 方法将刷新输出缓冲区
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