/*
1，import java.io.BufferedInputStream;
2，BufferedInputStream类 继承了 FilterInputStream类。
3，BufferedInputStream读缓冲区类方法：
	1，构造方法，创建缓冲区：BufferedInputStream(InputStream in)
	   调用方式：BufferedInputStream bis = new BufferedInputStream( new FileInputStream( "1.mp3"));
	 
	2，读单个字节：int read()
	   返回值：如果数据为空，返回 -1，否则返回数据。
	   调用方式：int by = bis.read();
	  
	3，关闭流资源：void.close()
	   调用方式：bis.close();

--------------------------------------------------------------------------------------------------

3，import java.io.BufferedOutputStream;
4，BufferedOutputStream类 继承了 FilterOutputStream类。
5，BufferedOutputStream写缓冲区类方法：
	1，构造方法，创建缓冲区：BufferedOutputStream(OutputStream out)
	   调用方式：BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( "2.mp3"));

	2，将指定字节写入缓冲区：void write(int b);
	   调用方式：bos.write(by);

	3，关闭流资源：void.close()
	   调用方式：bos.close();
*/

//MP3复制示例
import java.io.*;

class java
{
	public static void main(String[] args) throws IOException
	{
		BufferedInputStream bis = new BufferedInputStream( new FileInputStream( "1.mp3")); //读
		BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( "2.mp3")); //写

		int by = 0;

		while( (by = bis.read()) != -1)
		{
			bos.write(by);
		}

		 bis.close();
		 bos.close();
	}
}