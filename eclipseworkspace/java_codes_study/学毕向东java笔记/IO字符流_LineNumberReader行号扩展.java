/*
1，LineNumberReader 继承了 BufferedReader
2，LineNumberReader 扩展功能类：
		1，构造方法，创建缓冲区行编号：LineNumberReader(Reader in) 
		   调用方式：LineNumberReader lnr = new LineNumberReader( new FileReader( "dome.java"));

		2，设置当前行号：void setLineNumber(int lineNumber) 
		   参数：行号初始值。例：100  打印从101开始。
		   调用方式：lnr.setLineNumber( 15);

		3，获取当前行号：int getLineNumber()
		   调用方式：lnr.getLineNumber();

		4，其它方法和父类都相同。
*/

import java.io.*;
class  
{
	public static void main(String[] args) throws IOException
	{
		LineNumberReader lnr = new LineNumberReader( new FileReader( "dome.java"));

		String line = null;
		lnr.setLineNumber(100);	//定义行号，从101开始。
		
		while( (line = lnr.readLine()) != null)
		{
			//打印文本行号，并打印文本行文本。
			System.out.println( lnr.getLineNumber() + ":" + line);
		}

		lnr.close();
	}
}