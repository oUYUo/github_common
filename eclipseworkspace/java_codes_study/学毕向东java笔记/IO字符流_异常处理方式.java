//IO异常处理方式
import java.io.*;
class java
{
	public static void main(String args[])
	{
		FileWriter fw = null; //为什么不定义在try里：因为定义在try里，那么fw变量只能在try局部使用。

		try
		{
			fw = new FileWriter("E:\\学习区\\java\\demo.txt");
			fw.write( "asdfg");
		}
		catch( IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			if( fw != null)	//如果new发生异常，则 fw依旧为null，只有当不为null时，才可执行close
			{
				try
				{
					fw.close();
				}
				catch( IOException e)
				{
					System.out.println(e.toString());
				}
			}
		}
	}
}