/*
import java.io.InputStream;
1，InputStream 读取字节流抽象类。
2，FileInputStream操作读文件类继承了InputStream。
3，在操作字节流中，不需要刷新流。因为字符流是由多个字节组成，而字节流是单个字节。
4，FileInputStream字节流文件操作基本方法：
	1，构造方法，创建打开文件：FileInputStream(String name)
	   调用方式：FileInputStream fis = new FileInputStream( 文件路径+文件名+后缀名);

	2，读取文件到数组：int read(byte[] b);
	   返回值：【可不必接受】读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。 
	   调用方式：byte[] b = new byte[fis.available()];
				 fis.read(b);

	3，获取文件数据个数：int available()
	   返回值：返回文件数据中个数，包括回车符；回车符占2个字节 \R\N
	   调用方式：int mun = fis.available();

	4，关闭流资源：void close()
	   调用方式：fis.close();
*/

class  
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream( "dome.txt");
		
		byte[] b = new byte[ fis.available()];
		/*
			byte[] b = new byte[ fis.available()]; 
			此句代码不建议使用。
			原因：当拷贝数据超过内存时，那么就会产生内存溢出。
			如果给定数组的个数后，无论怎么缓存，都不会溢出。
		*/

		fis.read(b);
		System.out.println( new String(b));

		fis.close();
	}
}