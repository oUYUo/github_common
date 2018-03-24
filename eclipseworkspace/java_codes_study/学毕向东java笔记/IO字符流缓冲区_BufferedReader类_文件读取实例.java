/*
1，BufferedReader类是一个读取缓冲区。
2，BufferedReader类继承了Reader类。
3，BufferedReader类部分方法：
	1，创建默认大小读取缓冲区：BufferedReader(Reader in) 
	   调用方式：BufferedReader buf = new BufferedReader( new FileReader( "buf.txt"););

	2，读取一个文本行：String readLine();
	   返回值：如果为空，则返回 null。 且不返回 回车符。
	   调用方式：buf.readLine();

	3，关闭该流与缓冲区资源：void close()
	   调用方式：buf.close();
*/

class 
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader( "buf.txt");

		BufferedReader buf = new BufferedReader( fr);

		String line = null;
	//readLine()读一行，如果为空，则返回 null。
		while( (line = buf.readLine()) != null)
		{
			System.out.println( line);
		}

		buf.close();
	}
}
