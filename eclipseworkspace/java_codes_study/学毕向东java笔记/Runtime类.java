/*
java.lang包
1，Runtime类没有提供构造函数，该类中有静态非静态方法。想到单例设计模式。
2，Runtime类方法：
	1，获取Runtime对象：static Runtime getRuntime();
	   调用方式：Runtime run = Runtime.getRuntime();

	2，cmd运行行：Process exec(String command);
	   异常：使用该方法需要 捕捉异常，或 抛出异常
	   参数：需要被打开的文件路径+文件后缀名
	   特殊：因 \ 为转义字符，所以要双 \ ;  默认打开方式是exe，如需打开其他格式：exec( EditPlus dome.java);
	   返回值【不必接受】 Process 抽象类 ，可对 exec 所打开的文件进行操作。如：杀掉进程。
	   调用方式：对象.exec( "D:\\AIDE\\aida64.exe");

----------------------------------------------------------------------------------------------

Process抽象类方法：
	1，杀掉exec所开启的进程：abstract void destroy()
	   调用方式：Process p = run.exec( "D:\\AIDE\\aida64.exe");  // 运行 aida64.exe
				 p.destroy();  //杀掉 aida64.exe进程
*/

class  
{
	public static void main(String[] args) throws Exception
	{
		Runtime run = Runtime.getRuntime();
		Process p = run.exec( "D:\\AIDE\\aida64.exe");  // 运行 aida64.exe
		p.destroy();  //杀掉 aida64.exe进程

//-----------------------------------------------------------------------------

		run.exec( "notepad.exe F:\\1.txt"); //程序类型 程序路径
	}
}
