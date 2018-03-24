/*
1��java.io.RandomAccessFile;
2��RandomAccessFile����һ���������ֱ࣬�Ӽ̳�Object����ֻ�ܶ��ļ���д������
3��RandomAccessFile����ļ����ݴ��������У�ͨ��ָ��λ�û�ȡ���ݡ�
4��ģʽ���ܣ�
	1��"r"   ��ֻ����ʽ�򿪡����ý��������κ� write �������������׳� IOException��  
	2��"rw"  ���Ա��ȡ��д�롣������ļ��в����ڣ����Դ������ļ���  
	3��"rws" ���Ա��ȡ��д�룬���� "rw"����Ҫ����ļ������ݻ�Ԫ���ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸��  
	4��"rwd" ���Ա��ȡ��д�룬���� "rw"����Ҫ����ļ����ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸�� 

5��RandomAccessFile�����������
	д�ķ�����
		1���ӵ�ǰָ��д�����ݣ�void write(byte[] b) 
		   ���⣺�ᰴ�ֽ���ʽ�����ļ���ԭ�����ݡ�����ԭ"����" -- д"��" ---> ���ᰴ�ֽ���ʽ��"��"�滻"��"
		   ���÷�ʽ��raf.write( "785".getBytes());

		2�����ַ���д�����ݣ�void writeBytes(String s) 

		3����int��д�����ݣ�void writeInt(int v)

	���ķ�����
		1���ӵ�ǰָ����ȡ���ݣ�int read(byte[] b)
		   ���÷�ʽ��int k = raf.reat( new bte[1024]);

		2���ӵ�ǰָ����ȡ32λ������int readInt()
		   ���÷�ʽ��int a = raf.readInt();

	���Է�����
		1�����캯���������ļ���RandomAccessFile(String name, String mode)
		   ������name --- �ļ�����mode --- ģʽ��
		   ���⣺���ļ�����ʱ�����Ḳ�Ǿ��ļ���
		   ���÷�ʽ��RandomAccessFile raf = new RandomAccessFile( "raf.txt", "rw");

		2������ָ�����ֽ�Ϊ��λ����ƫ�ƣ�void seek(long pos)
		   ���÷�ʽ��raf.seek( 8);

		3������ָ�����ֽ�Ϊ��λ���ƫ�ƣ�int skipBytes(int n)
		   ���⣺ֻ�����ƫ�ơ�
		   ���÷�ʽ��raf.skipBytes( 16);

		4���ر���Դ��void close()

---------------------------------------------------------------------------------------------------

6��ע�����
	1����дͬһ���������ͬһ���ļ���
			д��д�����ݵ��ļ��ɹ���
			����read����-1��

	2����д�����������ͬһ���ļ���
			д��д�����ݵ��ļ��ɹ���
			������ȡ���ݳɹ���

	3����һ������ռ����ֽڣ����������д�����ݵĻ������ᶪʧ���ݡ�
*/

import java.io.*;
class RandomAccessFile_dome
{
	public static void main(String[] args) throws Exception
	{
	    Output();
		Input();
	}

	public static void Output() throws IOException//д
	{
		RandomAccessFile raf = new RandomAccessFile( "raf.txt", "rw");
		raf.write( "785".getBytes());
		raf.close();		
	}
	
	public static void Input() throws IOException//��
	{
		RandomAccessFile raf = new RandomAccessFile( "raf.txt", "r");
		
		byte[] b = new byte[1024];
		int len = raf.read(b);

		System.out.println( new String( b, 0, len));
		raf.close();
	}
}