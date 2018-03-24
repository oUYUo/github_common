/*
1，InputStreamReader类是字节流类转换字符流类。
2，InputStreamReader 继承了 Reader 读取字符流。
3，InputStreamReader 具体用法：
	1，构造方法，字节流转换字符流：InputStreamReader(InputStream in)
	   参数：InputStream 是输入流的超类。
	   调用方式：InputStream in = System.in;
				 InputStreamReader isr = new InputStreamReader( in);
	
*/

class  
{
	public static void main(String[] args) 
	{
		//获取键盘录入对象。
		InputStream in = System.in;
		//将字节流转成字符流对象。
		InputStreamReader isr = new InputStreamReader( in);
		//为了提高效率，将字符串进行缓冲区技术操作。
		BufferedReader bufr = new BufferedReader( isr);
		String s = null;

		while(true)
		{
			s = bufr.readLine();

			if( "over".equals(s))
			{
				break;
			}

			System.out.println(s);
		}

		bufr.close();
	}
}