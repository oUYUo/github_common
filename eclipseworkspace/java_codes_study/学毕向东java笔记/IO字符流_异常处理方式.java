//IO�쳣����ʽ
import java.io.*;
class java
{
	public static void main(String args[])
	{
		FileWriter fw = null; //Ϊʲô��������try���Ϊ������try���ôfw����ֻ����try�ֲ�ʹ�á�

		try
		{
			fw = new FileWriter("E:\\ѧϰ��\\java\\demo.txt");
			fw.write( "asdfg");
		}
		catch( IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			if( fw != null)	//���new�����쳣���� fw����Ϊnull��ֻ�е���Ϊnullʱ���ſ�ִ��close
			{
				try
				{
					fw.close();
				}
				catch( IOException e)
				{
					System.out.println(e.toString());
				}
			}
		}
	}
}