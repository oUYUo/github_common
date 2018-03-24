/*
import java.io.OutputStream;
1，OutputStream 写字节流抽象类。
2，FileOutputStream操作写文件类继承了OutputStream。
3，在操作字节流中，不需要刷新流。因为字符流是由多个字节组成，而字节流是单个字节。
4，FileOutputStream字节流文件操作基本方法：
	1，构造方法创建文件：FileOutputStream(String name)
	   参数：文件路径 + 文件名 + 文件后缀名
	   调用方式：FileOutputStream fos = new FileOutputStream( "dome.java");

	2，关闭流资源：void close()
	   调用方式：fos.close()

	3，将字节数组写入流：void write(byte[] b)
	   关联：getBytes() 是String中方法，它是将字符串转成字节数组。
	   调用方式：fos.write( "abcde".getBytes());

*/
class  
{
	public static void main(String[] args) throws IOException
	{
		FileOutputStream fos = new FileOutputStream( "dome.txt");
		
		fos.write( "abcde".getBytes());	//getBytes() 是String中方法，它是将字符串转成字节数组。
		fos.close();
	}
}