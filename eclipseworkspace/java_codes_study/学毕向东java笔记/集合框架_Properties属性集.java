/*
1，java.util.Properties是一个属性集合，继承了  Hashtable 可操作流。
2，它是集合中和IO技术相结合的集合容器。
3，该集合特点：可以用于键值对形式的配置文件。
4，Properties类中基本方法：
	1，重载，将属性列表输出到指定的输出流：void list(PrintStream out)
	   调用方式：Properties prop = System.getProperties();
				 prop.list( new PrintStream( "sysinfo.txt"));

	2，添加元素：Object setProperty(String key, String value)  
	   返回值：【不必接受】返回指定键的旧值，如果没有值，则返回 null。
	   关联：调用 Hashtable 的方法 put。
	   参数：key -- 键、 value -- 值
	   调用方式：对象.setProperty( "键", "值");

	3，指定键获取值：String getProperty( String key)
	   调用方式：对象.getProperty( "键");

	4，获取所有键：Set<String> stringPropertyNames()
	   调用方式：Set<String> namers = 对象.stringPropertyNames();
				 for( String s : names)
				 {
					System.out.print( s + "=");	//通过循环获取每个键。
					System.out.println( 对象.getProperty( s));	//通过指定键获取对应的值。
				 }

	5，将读取流内容存入集合：void load(InputStream inStream)
	   特殊：文本格式：键=值。
	   参数：InputStream是字节读取流，通过FileInputStream读取文件存放到集合中。
	   调用方式：对象.load( new FileInputStream( "文件"));
 
	6，指定字节输出流输出：void list(PrintStream out)
	   调用方式：对象.list( System.out);

	7，指定字符输出流输出：void list(PrintWriter out)
	   调用方式：对象.list( System.out);

	8，通过字节流写入文件：void store(OutputStream out, String comments)
	   参数：OutputStream --- 字节流写、comments --- 注释 // 注释是不会被读取。
	   调用方式：对象.store( new FileOutputStream( "文件"), "注释信息");

	9，通过字符流写入文件：void store(Writer writer, String comments)
	   参数：writer --- 字符流写、comments --- 注释 // 注释是不会被读取。
	   调用方式：对象.store( new FileWriter( "文件"), "注释信息");
*/

import java.util.*;
import java.io.*;

class  
{
	public static void main(String[] args) throws IOException
	{
	}

	public static void getwin()throws IOException	//获取系统信息。
	{
		/*
		getProperties()获取系统信息，它返回的是 Properties 类型。
		new PrintStream( "sysinfo.txt");字节扩展功能流，创建一个 "sysinfo.txt" 文件。
		list();接受一个输出流，将 系统信息 存储到 "sysinfo.txt"文件中。

		*/
		Properties prop = System.getProperties();

		prop.list( new PrintStream( "sysinfo.txt"));

		/*
		System.setOut( new PrintStream( "sysinfo.txt"));		
		prop.list( System.out);
		*/
	}

	public static void Run_number()throws IOException	//程序运行次数
	{
		/*
		1，读取配置文件。如果没有则创建。
		2，记录次数
		3，写入配置文件
		4，判断是否次数已尽。
		*/
		Properties prop = new Properties();
		File file = new File( "PropertiesDome.ini");

		if( !(file.exists()))
			file.createNewFile();

		FileInputStream fis = new FileInputStream( file);

		prop.load( fis);	//将fis所读取的内容存入 prop 中。
		
		int count = 0;	
		String value = prop.getProperty( "time");	

		if( value != null)	//值是否为空。
		{
			count = Integer.parseInt( value);

			if( count >= 3)
			{
				System.out.println( "您好，使用次数已到。");
				return;
			}
		}

		count++;

		prop.setProperty( "time", String.valueOf( count));

		FileOutputStream fos = new FileOutputStream( file);

		prop.store( fos,"");	//将 prop写入本地。

		fos.close();
		fos.close();
		
		System.out.println( prop);
	}
}