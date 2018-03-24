/*
1，缓冲区提高了流的操作效率。所以创建缓冲区之前，必须先有流对象。
2，BufferedWriter继承Writer。
3，BufferedWriter部分方法：
	1，创建默认大小缓冲区对象：BufferedWriter(Writer out)
	   参数：将所要在缓冲区操作的对象放入。
	   调用格式：BufferedWriter bufw = new BufferedWriter( new FileWriter( "buf.txt"));

	2，父类实现写入字符串：void write(String str)
	   调用格式；bufw.write( "abbcde");	//将数据写入到缓冲区。
	
	3，写入一个跨平台行分隔符：void newLine() 
	   关联：手动换行不能跨平台。此方法可跨平台。
	   调用方式：bufw.newLine();	//换行

	4，将缓冲区的数据刷新到本地：void flush()
	   调用方式：bufw.flush();

	5，刷新流，并关闭此流：void close()
	   详解：关闭缓冲区，就是在关闭缓冲区中的流对象。
	   调用方式：bufw.close();
*/

class  
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw = new FileWriter( "buf.txt");	//指定要写入文件的目的地和文件名。
		
		BufferedWriter bufw = new BufferedWriter(fw);	//将该对象放入缓冲区。

		bufw.write( "abbcde");	//将数据写入到缓冲区。
		bufw.newLine();	//换行，可以跨平台。  手动换行不能跨平台。
		bufw.flush();//将缓冲区的数据刷新到本地。
		bufw.close(); //关闭缓冲区，就是在关闭缓冲区中的流对象。
	}
}
