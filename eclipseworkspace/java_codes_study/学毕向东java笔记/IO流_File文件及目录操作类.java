/*
1，File是IO包中文件或文件夹操作类，弥补了IO流对文件或文件夹操作不足。
2，File类常见方法：
	1，构造方法：
		A）根据路径文件名创建对象：File(String pathname)
		   调用方式：File f1 = new File( "c:\\dome.txt");

		B）根据路径文件名创建对象：File(String parent, String child)
		   参数：parent 路径名、 child 文件名。
		   调用方式：File f1 = new File( "c:\\", "dome.txt");

		C）根据路径文件名创建对象：File(File parent, String child)
		   参数：parent File对象获取的路径、 child 文件名。
		   调用方式：File f1 = new File( "c:\\dome.txt");
					 File f2 = new File( f1, "do.txt");

	2，字段：
		A）跨平台目录分隔符：static String separator  
		   调用方式：File f1 = new File("c:" + File.separator + "Test.java");

	3，创建：
		A）指定位置创建文件，如果该文件已经存在，返回false：boolean createNewFile()
		   调用方式：对象.createNewFile();

		B）在系统默认临时文件目录中创建文件:static File createTempFile(String prefix, String suffix)	【作为了解】
		   参数：prefix - 文件名、suffix - 文件后缀名。suffix为 null，将使用后缀 ".tmp"
		   调用方式：File.createTempFile( "dome",".txt");

		C）在指定目录中创建文件：static File createTempFile(String prefix, String suffix, File directory)
		   参数：prefix - 文件名、suffix - 文件后缀名、directory - 文件路径。
		   调用方式：File f = new File( "c:\\dome.txt");
					 File.createTempFile( "dome", ".txt", f);

		D）创建一级文件夹：boolean mkdir()
		   调用方式：File dir = new File("abc");
		             dir.mkdir();

		E）创建多级文件夹：boolean mkdirs()
		   调用方式：File dir = new File("abc\\kkk\\a\\a\\dd\\ee\\qq\\aaa");
		             dir.mkdirs();

	4，删除：当文件夹为空时，才会删除，否则删除失败。
		A）删除文件：boolean delete()
		   返回值：如果文件正在被使用，则删除失败，返回false。
		   调用方式：对象.delete();

		B）在程序退出时删除指定文件：void deleteOnExit()
		   调用方式：对象.deleteOnExit()

	5，判断：
		A）文件是否存在：boolean exists()
		   调用方式： boolean b = 对象.exists();

		B）是否是文件：boolean isFile()
		   调用方式：boolean b = 对象.isFile();

		C）是否是文件夹：boolean isDirectory()
		   调用方式：boolean b = 对象.isDirectory();

		D）是否是隐藏文件：boolean isHidden()
		   调用方式：boolean b = 对象.isHidden();

		E）是否是绝对路径：boolean isAbsolute()
		   特殊：在 Windows 系统上，路径名前缀是后跟 "\\" 的盘符；在 UNIX 系统上，如果路径名的前缀是 "/"，都是绝对路径。
		   调用方式：boolean b = 对象.isAbsolute();

		F）文件是否能执行：boolean canExecute()
		   调用方式：boolean b = 对象.canExecute();

	6，获取信息：

		A）取文件名或文件夹名：	String getName()
		   调用方式：String s = 对象.getName();

		B）取构造函数String内容：String getPath()
		   返回值：它返回的是 对象在构造中所返回的内容。
		   调用方式：String s = 对象.getPath();   

		C）取文件相对路径：String getParent()
		   特殊：如果未指定文件路径，则返回null。
		   调用方式：String s = 对象.getParent();

		D）取文件路径：String getAbsolutePath() 
		   返回值：文件路径+文件名+后缀名。
		   调用方式：String s = 对象.getAbsolutePath();

		E）取最后一次修改时间：long lastModified() 
		   调用方式：long l = 对象.lastModified();

		F）返回文件大小：long length() 
		   调用方式：long l = 对象.length();

	7，修改：

		A）重命名并移动此文件：boolean renameTo(File dest) 
		   调用方式：File f1 = new File( "d:\\dome1");
					 File f2 = new File( "c:\\dome2");
					 f1.renameTo( f2);
			代码讲解：将 dome1 文件改名 dome2，并移动到c盘。

	8，文件列表：
		A）取所有盘符：static File[] listRoots()
		   调用方式：File[] files = File.listRoots();

		B）取目录所有文件：String[] list()
		   返回值：如是文件，则空指针异常。
		   调用方式：String[] s = new File( "abc").list();

		C）取指定后缀文件：String[] list(FilenameFilter filter)
		   参数：FilenameFilter 是一个接口，通过匿名内部类复写此接口 accept() 方法。
		   调用方式：String[] s = files.list( new FilenameFilter()
		   {
				public boolean accept( File dir, String name)
				{
				    // dir 表示目录， name是文件。	
				   //endsWith() 是String类中方法。测试此字符串是否以指定的后缀结束。
				  //思想： File 将遍历的所有文件 一个个 放入 accept中，然后根据accept返回值。
					return name.endsWith( ".java");
				}			
		   });

		D）将目录所有文件封装：File[] listFiles()
		   返回值：将目录所有文件对其一一封装成对象。具体示例参考“dome_8_listFiles”
		   调用方式：File[] f = file.listFiles();
*/

import java.io.*;
class FileDemo 
{
	public static void main(String[] args) throws IOException
	{
		
	}

	public static void dome_1() throws IOException
	{
		File f1 = new File( "c:\\dome.txt");
	  //File f1 = new File( "c:\\", "dome.txt");
		File f2 = new File( f1, "do.txt");
	}

	public static void dome_2() throws IOException
	{
		File f1 = new File("c:" + File.separator + "Test.java");
	}

	public static void dome_3() throws IOException
	{
		File f1 = new File( "c:\\dome.txt");
		f1.createNewFile();

		File.createTempFile( "dome", ".txt", "c:\\")

		File dir1 = new File("abc");
		dir1.mkdir();

		File dir2 = new File("abc\\kkk\\a\\a\\dd\\ee\\qq\\aaa");
		dir2.mkdirs();
	}

	public static void dome_4()throws IOException
	{
		File f1 = new File( "c:\\dome.txt");
		sop( f1.delete());

		File f2 = new File( "c:\\dome.txt");
		f2.deleteOnExit();
	}

	public static void dome_5()throws IOException
	{
		File f1 = new File( "c:\\dome.txt");

		//文件是否存在
		sop( f1.exists());

		//是否是文件：
		sop( f1.isFile());

		//是否是文件夹：
		sop( f1.isDirectory());

		//是否是隐藏文件：
		sop( f1.isHidden());

		//是否是绝对路径
		 sop( f1.isAbsolute());

		//文件是否能执行：
		sop( f1.canExecute());
	}

	public static void dome_6()throws IOException
	{
		File f1 = new File( "dome.txt");

		//取文件名或文件夹名：	String getName()
		sop( f1.getName());

		//取构造函数String内容：
		sop( f1.getPath());		//结果：dome.txt

		//取文件相对路径：
		sop( f1.getParent());	//结果：null

		//取文件路径：
		sop( f1.getAbsolutePath());

		//取最后一次修改时间：
		sop( f1.lastModified());

		//返回文件大小： 
		sop( f1.length());
	}

	public static void dome_7()throws IOException
	{
		//重命名并移动此文件：将 dome1 文件改名 dome2，并移动到c盘。
		File f1 = new File( "d:\\dome1");
		File f2 = new File( "c:\\dome2");
		f1.renameTo( f2);
	}

	public static void dome_8_list1()
	{
		//取所有盘符：
		File[] files = File.listRoots();

		for( File f : files)
		{
			String str = f.toString();	//将盘符放入 str 中
			System.out.println( " ----------------" + str + "-----------------");

			//取目录所有文件：
			String[] st = files.list();

			for( String s :st)
			{
				System.out.println(s);
			}
		}
	}

	public static void dome_8_list2()
	{
	/*
		FilenameFilter 是一个接口，里面方法只有 accept
		accept( File dir, String name)
		dir  --- 目录
		name --- 文件名
		endsWith 是String类中方法，判断是否以指定后缀名结束。

		解：list()方法将遍历到所有文件，放入 accept中，对其一一判断。
			如果返回真，则保留该文件信息，否则删除文件信息。
			我们通过endsWith()方法判断该文件是否以指定后缀名结束。
	*/
		File filete = new File( "c:\\");
		String[] name = filete.list( new FilenameFilter()
		{
			public boolean accept( File dir,  String name)
			{
				return name.endsWith( ".bmp");
			}	
		});

		for(String s : name)
		{
			System.out.println(s);
		}
	}

	public static void dome_8_listFiles()
	{
		File file = new File( "c:\\");
		//获取C盘目录下的文件或文件夹，并对其一一封装对象。
		File[] f = file.listFiles();

		for(File fi : f)
		{
			//getName 获取文件名。
			System.out.println( fi.getName());
		}
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

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
