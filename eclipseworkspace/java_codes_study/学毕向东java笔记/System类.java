/*
import java.util.*;
1，System类都是静态方法。
System类中方法：
	1，获取当前系统属性：static Properties getProperties()
	   返回值：Properties 是Hashtable子类，也就是Map集合子类对象。可以通过prop.keySey()取出
	   调用方式：Properties prop = System.getProperties();

	2，设置指定键指示的系统属性：static String setProperty(String key, String value)
	   返回值：【不必接受】返回系统属性以前的值，如果没有以前的值，则返回 null。
	   调用方式：System.setProperty( 键, 值)

    3，根据键获取系统信息：static String getProperty(String key)
	   调用方式：System.getProperty( 键);  如："os.name"  此键获取操作系统。
	
	4，重新分配“标准”输入流：static void setIn(InputStream in)
	   实例：参考 dome_2(); 代码。
	   调用方式：System.setIn( new FileInputStream( "dome.txt"));


	5，重新分配“标准”输出流：static void setOut(PrintStream out) 
	   实例：参考 dome_2(); 代码。
	   调用方式：System.setOut( new PrintStream( "zzz.txt"));

-----------------------------------------------------------------------------------------------------------

2，System类中字段：
	1，“标准”输入流：static InputStream in 
	   说明：用于创建键盘输入对象。
	   调用方式：InputStream in = System.in;

	2，“标准”输出流：static PrintStream out 
	   说明：用于创建键盘输出对象。
	   调用方式：OutputStream out = System.out;
           


----------------------------------------------------------------------------------------------------------

System知识点：
1，外部设置系统属性：cmd --> java -D键=值 文件名。	// 给键赋值。
*/
class  
{
	public static void main(String[] args)throws IOException
	{
		/*
		dome_1();
		dome_2();
		*/
	}

	public static void dome_1()
	{
		Properties prop = System.getProperties(); //返回当前系统属性。
		//Properties 是Hashtable子类，也就是Map集合子类对象。可以通过prop.keySey()取出.
		//获取系统所有信息、
		for(Object obj : prop.keySey()) 
	    }
			String valus = (String)prop.get(obj);
			System.out.println(obj+"::"+value);
		}


		//设置指定键指示系统属性
		System.setProperty( "01", "qwe");


		//获取指定键系统信息
		System.getProperty( "01");  //返回 “qwe”。
	}

	public static void dome_2()throws IOException
	{
		System.setIn( new FileInputStream( "dome.txt")); //改变输入流。
		System.setOut( new PrintStream( "zzz.txt"));	//改变输出流。
		/*
			System.in  ---> 默认是控制台输入流。
			System.out  ----> 默认是 打印流。

			可以通过 SetIn、setOut  这两方法改变默认的流对象。
		*/

		BufferedReader bufr = new BufferedReader( new InputStreamReader( System.in));
		BufferedWriter bufw = new BufferedWriter( new OutputStreamWriter( System.out));

		String line = null;

		while( ( line = bufr.readLine()) != null)
		{
			if( "over".equals(line))
				break;

			bufw.write( line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		
		bufr.close();
	}
}