/*
1，java.io.RandomAccessFile;
2，RandomAccessFile类是一个独立的类，直接继承Object。它只能对文件读写操作。
3，RandomAccessFile类把文件数据存入数组中，通过指针位置获取数据。
4，模式介绍：
	1，"r"   以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。  
	2，"rw"  打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。  
	3，"rws" 打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。  
	4，"rwd" 打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。 

5，RandomAccessFile类基本方法：
	写的方法：
		1，从当前指针写入数据：void write(byte[] b) 
		   特殊：会按字节形式覆盖文件中原有数据。例：原"张三" -- 写"李" ---> 将会按字节形式把"张"替换"李"
		   调用方式：raf.write( "785".getBytes());

		2，按字符串写入数据：void writeBytes(String s) 

		3，按int型写入数据：void writeInt(int v)

	读的方法：
		1，从当前指定读取数据：int read(byte[] b)
		   调用方式：int k = raf.reat( new bte[1024]);

		2，从当前指定读取32位整数：int readInt()
		   调用方式：int a = raf.readInt();

	共性方法：
		1，构造函数：创建文件：RandomAccessFile(String name, String mode)
		   参数：name --- 文件名、mode --- 模式。
		   特殊：当文件存在时，不会覆盖旧文件。
		   调用方式：RandomAccessFile raf = new RandomAccessFile( "raf.txt", "rw");

		2，设置指针以字节为单位任意偏移：void seek(long pos)
		   调用方式：raf.seek( 8);

		3，设置指针以字节为单位向后偏移：int skipBytes(int n)
		   特殊：只能向后偏移。
		   调用方式：raf.skipBytes( 16);

		4，关闭资源：void close()

---------------------------------------------------------------------------------------------------

6，注意事项：
	1，读写同一个对象操作同一个文件：
			写：写入数据到文件成功。
			读：read返回-1。

	2，读写两个对象操作同一个文件：
			写：写入数据到文件成功。
			读：读取数据成功。

	3，当一个数据占多个字节，如果按正常写入数据的话，将会丢失数据。
*/

import java.io.*;
class RandomAccessFile_dome
{
	public static void main(String[] args) throws Exception
	{
	    Output();
		Input();
	}

	public static void Output() throws IOException//写
	{
		RandomAccessFile raf = new RandomAccessFile( "raf.txt", "rw");
		raf.write( "785".getBytes());
		raf.close();		
	}
	
	public static void Input() throws IOException//读
	{
		RandomAccessFile raf = new RandomAccessFile( "raf.txt", "r");
		
		byte[] b = new byte[1024];
		int len = raf.read(b);

		System.out.println( new String( b, 0, len));
		raf.close();
	}
}