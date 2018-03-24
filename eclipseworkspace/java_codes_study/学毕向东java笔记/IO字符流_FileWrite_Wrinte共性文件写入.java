/*
import java.io.Write抽象类：操作写入字符。
1，因Write是抽象类，需找子类。
2，以写入文件为实例，发现Write子类OutputStreamWriter的子类FileWriter类。
3，IO操作大部分方法都要抛出 或 捕捉异常 。 IOExeption异常。
4，在win系统中，写入换行符：\r\n

5，FileWriter类基本方法：
	1，构造方法创建并覆盖文件：FileWriter(String fileName);
	   参数：文件目录+文件名。如只传文件名。默认产生文件路径和class文件同目录。
	   特殊：如该文件已存在，将会覆盖该文件。
	   调用方式：FileWriter fw = new FileWriter( "文件路径+文件名带后缀");
	
	2，构造函数创建不覆盖文件：FileWriter(String fileName, boolean append) 
	   参数：append（为true，写入数据到文件的末尾处。false写入数据到开始处）。
	   调用方式：FileWriter fw = new FileWriter( "文件路径+文件名带后缀", true);


----------------------------------------------------------------------------------------

6，Write共性方法：
	1，将字符串写入流中：void write(String str)
	   调用方式：fw.write( “字符内容”)
	   
	2，刷新流，将数据刷入本地：abstract void flush()  
	   调用方式：fw.flush();

	3，刷新关闭流：abstract  void close()
	   特殊：关闭流后，再用write()方法，会出异常。
	   调用方式：fw.close();

	4，写入单个字符：void write(int c)
	   调用方式：fw.write( int);  //写到文件里会自动转换ASCII字符。
*/

import java.io.*;
class  
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw = new FileWriter( "dmoe");	//该文件存在将会覆盖。
		fw.write( "asddsjs");	//写入流
		fw.flush(); //刷新流，将数据刷新到本地
		fw.close(); //刷新流，将数据刷新到本地，然后关闭流。
		//fw.write( "asddsjs"); 错误，关闭流后，将不能写入流。
	}
}
