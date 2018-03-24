/*
1，import java.io.SequenceInputStream;
2，SequenceInputStream合拼流，继承了 InputStream .
3，它是将多个流合并一个流。例：将多个文件数据存入一个文件中。
4，SequenceInputStream 基本方法：
	1，SequenceInputStream(Enumeration<? extends InputStream> e)
	   参数：Enumeration 是个集合接口工具。Vector.elements()返回这个接口
	   调用方式：Enumeration<FileInputStream> en =  new Vector<FileInputStream>().elements();
				 对象.SequenceInputStream( en);

	2，SequenceInputStream(InputStream s1, InputStream s2)
	   参数：两字节读取流对象，进行合拼。
	   调用方式：SequenceInputStream( new FileInputStream( "1.txt"), new FileInputStream( "2.txt"))

5，其他方法与基本流方法操作相同

*/
import java.io.*;
import java.util.*;
class  
{
	public static void main(String[] args) throws IOException
	{
		Sequenc();
	}

	public static void Sequenc() throws IOException
	{
		Vector<FileInputStream> v = new Vector<FileInputStream>();

		v.add( new FileInputStream( "1.txt"));
		v.add( new FileInputStream( "2.txt"));
		v.add( new FileInputStream( "3.txt"));

		Enumeration<FileInputStream> en =  v.elements();

		SequenceInputStream sis = new SequenceInputStream( en);
		FileOutputStream fos = new FileOutputStream( "4.txt");
		
		int k = 0;

		while( ( k = sis.read()) != -1)
		{
			fos.write( k);
		}

		fos.close();
		sis.close();
	}
}