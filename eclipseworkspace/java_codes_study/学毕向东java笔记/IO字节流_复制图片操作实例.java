//复制图片案例。

import java.io.*;

class java
{
	public static void main(String[] args)
	{

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
			fis = new FileInputStream( "1.jpg"); //读
			fos = new FileOutputStream( "2.jpg"); //写
			byte[] b = new byte[1024];
			int mun = 0;

			while( ( mun = fis.read(b)) != -1)
			{
				fos.write(b);
			}		
		}
		catch( IOException e)
		{
			throw new RuntimeException( "文件不存在");
		}
		finally
		{
			try
			{
				if( fis != null)
				{
					fis.close();
				}
				if( fos != null)
				{
					fos.close();
				}
			}	
			catch( IOException e)
			{
				throw new RuntimeException( "关闭资源失败");
			}
		}
	}
}