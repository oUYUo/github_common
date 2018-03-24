/*
管道流是将写 读连在一起，成为一个管道。
共性问题：由于管道流牵扯到线程，如果先读后写。读的没数据时，线程将会等待写入后再读取。所以管道流必须要由两个线程来完成，否则会产生死锁。
1，java.io.PipedOutputStream;
2，PipedOutputStream类是管道写入流。
3，PipedOutputStream类基本方法：
	1，构造方法，构造管道流：PipedOutputStream()
	   调用方式：PipedOutputStream pos = new PipedOutputStream();

	2，写入数据： void write(byte[] b)  
	   调用方式：pos.write( "asd".getBytes);	//getBytes()方法是将字符串转成byte字节数组。

	3，关闭资源：void close()
	   调用方式：pos.close();

------------------------------------------------------

1，java.io.PipedInputStream;
2，PipedInputStream类是管道读入流。
3，PipedInputStream类基本方法：
	1，构造方法，构造管道流：PipedInputStream()
	   调用方式：PipedInputStream pis = new PipedInputStream();

	2，构造方法，构造管道流并关联写入流：PipedInputStream( PipedOutputStream src)
	   调用方式：PipedInputStream pis = new PipedInputStream( new PipedOutputStream());

	3，关联写入流：void connect( PipedOutputStream src)
	   调用方式：pis.( new PipedOutputStream());

	4，读取数据，返回数据长度：int read( byte[] b)
	   调用方式：byte[] b = new byte[1024];
				 int len = pis.read( b);
				 String s = new String( b, 0, len).toString();

	5，关闭资源：void close()
	   调用方式：pos.close();
*/

import java.io.*;

class Piped
{
	public static void main(String[] args) throws IOException
	{
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream( pos);

		//pis.connect( pos);

		Thread	T1 = new Thread( new PipedOutput( pos));
		Thread	T2 = new Thread( new PipedInput( pis));
		T1.start();
		T2.start();		
	}
}

class PipedInput implements Runnable	//读
{
	private PipedInputStream pis;
	PipedInput( PipedInputStream pis)
	{
		this.pis = pis;
	}

	public void run()
	{
		try
		{
			byte[] b = new byte[1024];
			int len = pis.read( b);

			System.out.println( new String( b, 0, len).toString());
			
			pis.close();
		}
		catch( IOException e)
		{
			throw new RuntimeException( "管道读入流失败");	
		}
	}
}

class PipedOutput implements Runnable	//写
{
	private PipedOutputStream pos;
	PipedOutput( PipedOutputStream pos)
	{
		this.pos = pos;
	}

	public void run()
	{
		try
		{
			pos.write( "PipedOutputStream".getBytes());
			pos.close();
		}
		catch( IOException e)
		{
			throw new RuntimeException( "管道写入流失败");
		}			
	}
}