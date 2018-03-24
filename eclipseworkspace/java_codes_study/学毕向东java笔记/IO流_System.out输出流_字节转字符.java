/*
1，在System类中，常用字段：
	System.out：打印流 ----> static PrintStream out
	System.in： 输入流 ----> static InputStream in

2，static PrintStream out 打印流：
	A，被static修饰静态方法。
	B，返回类型：PrintStream 类。
	C，调用方式：PrintStream ps = System.out;

3，PrintStream 继承了 FilterOutputStream。
4，通过 System.out 返回的 PrintStream，可以在控制台输入输出操作。
5，键盘输入输出操作方法：
	1，“标准”输出流：static PrintStream out
	   说明：用于创建输出对象。
	   调用方式：OutputStream out = System.out;

6，键盘输入输出操作不用关闭资源。

-----------------------------------------------------------------------------------------------

7，OutputStreamWriter将输出字节流转换字符流：
	1，构造方法，使用默认编码将字节流转换字符流：OutputStreamWriter(OutputStream out)
	   编码：默认编码采用的是：GBK
	   调用方式：OutputStreamWriter otw = new OutputStreamWriter( System.out);

	2，构造方法，使用指定编码将字节流转换字符流：OutputStreamWriter(OutputStream out, String charsetName) 
	   编码：默认编码采用的是：GBK
	   参数：charsetName指定编码表
       调用方式：OutputStreamWriter otw = new OutputStreamWriter( FilterOutputStream, "UTF-8");

8，转换流是字符和字节之间的桥梁。通常涉及到字符编码转换时，需要用到转换流。
*/

class  
{
	public static void main(String[] args) 
	{
	/*
		OutputStream out = System.out; 创建输出字节流
		OutputStreamWriter osw = new OutputStreamWriter( out); 将输出字节流转换字符流。
		BufferedWriter bufw = new BufferedWriter(osw); 创建字符流缓冲区
	*/
		BufferedReader bufr = new BufferedReader( new InputStreamReader( System.in)); //输入流\读
		BufferedWriter bufw = new BufferedWriter( new OutputStreamWriter( System.out)); //输出流\写

	/*
		字节流转换字符流：例：将本地文件显示到控制台。
			解释：文件都是字节二进制所存放的，将它读取我们能看的懂的，就要转换字符。

		输入流，是将本地文件读取。
			System.in ---> 输入，然后通过字节转字符获取数据。


		字符流转换字节流：例：将文件存储到本地。
			解释：文件都是以二进制存储的，所以我们要转换字节存储。

		输出流，是将文件写到本地。
			System.out ---> 输出， 将字符转字节存储。
	*/

		String s = null;

		while( ( s = bufr.readLine()) != null)
		{
			if( "over".equals( s))
			{
				break;
			}

			bufw.write( s);	//输出到缓存。
			bufw.newLine();	//换行
			bufw.flush();	//刷新流，显示到控制台。
		}

		bufw.close();
	}
}