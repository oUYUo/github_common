/*
�ܵ����ǽ�д ������һ�𣬳�Ϊһ���ܵ���
�������⣺���ڹܵ���ǣ�����̣߳�����ȶ���д������û����ʱ���߳̽���ȴ�д����ٶ�ȡ�����Թܵ�������Ҫ�������߳�����ɣ���������������
1��java.io.PipedOutputStream;
2��PipedOutputStream���ǹܵ�д������
3��PipedOutputStream�����������
	1�����췽��������ܵ�����PipedOutputStream()
	   ���÷�ʽ��PipedOutputStream pos = new PipedOutputStream();

	2��д�����ݣ� void write(byte[] b)  
	   ���÷�ʽ��pos.write( "asd".getBytes);	//getBytes()�����ǽ��ַ���ת��byte�ֽ����顣

	3���ر���Դ��void close()
	   ���÷�ʽ��pos.close();

------------------------------------------------------

1��java.io.PipedInputStream;
2��PipedInputStream���ǹܵ���������
3��PipedInputStream�����������
	1�����췽��������ܵ�����PipedInputStream()
	   ���÷�ʽ��PipedInputStream pis = new PipedInputStream();

	2�����췽��������ܵ���������д������PipedInputStream( PipedOutputStream src)
	   ���÷�ʽ��PipedInputStream pis = new PipedInputStream( new PipedOutputStream());

	3������д������void connect( PipedOutputStream src)
	   ���÷�ʽ��pis.( new PipedOutputStream());

	4����ȡ���ݣ��������ݳ��ȣ�int read( byte[] b)
	   ���÷�ʽ��byte[] b = new byte[1024];
				 int len = pis.read( b);
				 String s = new String( b, 0, len).toString();

	5���ر���Դ��void close()
	   ���÷�ʽ��pos.close();
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

class PipedInput implements Runnable	//��
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
			throw new RuntimeException( "�ܵ�������ʧ��");	
		}
	}
}

class PipedOutput implements Runnable	//д
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
			throw new RuntimeException( "�ܵ�д����ʧ��");
		}			
	}
}