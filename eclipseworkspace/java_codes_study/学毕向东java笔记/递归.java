/*
递归：函数自身调用自身，这种表现形式，或者编程手法，称为递归。
递归要注意：
1，限定条件，避免死循环。
2，要注意递归的次数。尽量避免内存溢出。
*/
class  
{
	public static void main(String[] args) 
	{
		//list( new File( "E:\\学习区\\java\\java笔记"));
	}

	public static void list( File file)	//列出目录下的所有文件
	{
		/*
		列出指定目录下文件或者文件夹，包含子目录中的内容。
		也就是列出指定目录下所有内容。

		因为目录中还有目录，只要使用同一个列出目录功能的函数完成即可。
		在列出过程中出现的还是目录的话，还可以再次调用本功能。
		也就是函数自身调用自身。
		这种表现形式，或者编程手法，称为递归。
		*/
		File[] f = file.listFiles();
		System.out.println("--------------" + file + "-----------" + f.length);

		for( File fi : f)
		{
			System.out.println( fi.getName());
		}

		for( int x =  f.length-1; x >= 0; x--)
		{
			if( f[x].isDirectory())
			{
				file_5( f[x]);
			}
		}	
	}

	public static void toBin( int num)	//十进制转二进制
	{
		if( num > 0)
		{
			toBin( num / 2);
			System.out.println( num % 2);
		}
	}

	public static int getSum( int sum)	//求和
	{
		if( sum == 1)
			return 1;

		return sum + getSum(sum-1);
	}

	public static void delete( File f)	// 演示删除带有内容的文件夹。
	{
		File[] fi = f.listFiles();

		for( int x = 0; x < fi.length; x++)
		{
			if( fi[x].isDirectory())
				delete( fi[x]);
			else
				fi[x].delete();
		}
		f.delete();
	}
}