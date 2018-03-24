/*
import java.io.Reader抽象类：操作读入字符。
1，因Reader是抽象类，需找子类。
2，以读入文件为实例，发现Reader子类InputStreamReader的子类FileReader类。
3，IO操作大部分方法都要抛出 或 捕捉异常 。 IOExeption异常。

4，FileReader类基本方法：
	1，创建文件读取流对象：FileReader(String fileName)
	   异常：该文件不存在 或 不是个文件，会发生 FileNotFoundException 异常。
	   调用方式：FileReader fr = new FileReader( "文件路径+文件名+后缀");

--------------------------------------------------------------------------------------

5，Reader共性操作方法：
	1，读取单个字符：int read()  
	   返回值：read一次读一个字符，而且会自动往下读，返回对应字符的数值。当读到没有字符时，返回 -1。
	   调用方式：char ch = (char)fr.read();
	   
	2，将字符读入数组：int read(char[] cbuf)
	   返回值：返回的是读入数组的个数，当读入超出内容时，返回 -1.
	   特殊：当存储数组小于字符数时，会循环覆盖掉数组内容。
	   调用方式：char[] buf = new char[1024];
	             int num = 0;
				 while( ( num = fr.read(buf)) != -1)
				 {
					System.out.println(new String( buf, 0, num));
				 }
				 fr.close();
*/

class  
{
	public static void main(String[] args)throws IOException
	{
		FileReader fr = new FileReader( "dome.txt");

		//char ch = (char)fr.read();  读取单个字符。

		char[] buf = new char[1024];	
		int num = fr.read( buf);	//将读取的字符存入 buf 中，返回所读取的字符个数。

		System.out.println( new String(buf,0,num)); 
		/*将字符数组转换字符串。 参数二：起始位置；参数三：结尾位置（不包含）。 
		因数组是从0开始，而返回的是数组数，所以不需要加+1或-1
		*/
	}
}
