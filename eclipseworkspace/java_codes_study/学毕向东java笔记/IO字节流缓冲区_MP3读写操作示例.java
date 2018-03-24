/*
1��import java.io.BufferedInputStream;
2��BufferedInputStream�� �̳��� FilterInputStream�ࡣ
3��BufferedInputStream���������෽����
	1�����췽����������������BufferedInputStream(InputStream in)
	   ���÷�ʽ��BufferedInputStream bis = new BufferedInputStream( new FileInputStream( "1.mp3"));
	 
	2���������ֽڣ�int read()
	   ����ֵ���������Ϊ�գ����� -1�����򷵻����ݡ�
	   ���÷�ʽ��int by = bis.read();
	  
	3���ر�����Դ��void.close()
	   ���÷�ʽ��bis.close();

--------------------------------------------------------------------------------------------------

3��import java.io.BufferedOutputStream;
4��BufferedOutputStream�� �̳��� FilterOutputStream�ࡣ
5��BufferedOutputStreamд�������෽����
	1�����췽����������������BufferedOutputStream(OutputStream out)
	   ���÷�ʽ��BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( "2.mp3"));

	2����ָ���ֽ�д�뻺������void write(int b);
	   ���÷�ʽ��bos.write(by);

	3���ر�����Դ��void.close()
	   ���÷�ʽ��bos.close();
*/

//MP3����ʾ��
import java.io.*;

class java
{
	public static void main(String[] args) throws IOException
	{
		BufferedInputStream bis = new BufferedInputStream( new FileInputStream( "1.mp3")); //��
		BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( "2.mp3")); //д

		int by = 0;

		while( (by = bis.read()) != -1)
		{
			bos.write(by);
		}

		 bis.close();
		 bos.close();
	}
}