/*
1��java.io.DataOutputStream��
2��DataOutputStream���ǻ������������д�룩��������
3��DataOutputStream�������ʽ��
	1�����췽�������������������DataOutputStream(OutputStream out)
	   ���÷�ʽ��DataOutputStream dos = new DataOutputStream( new FileOutputStream( "data.txt"));

	2�����Int��void writeInt();
	   ���÷�ʽ��dos.writeInt( 234);

	3�����Boolean��void writeBoolean();
	   ���÷�ʽ��dos.writeBoolean( true);

	4�����Double��void writeDouble();
	   ���÷�ʽ��dos.writeDouble( 9887.543);

	5�����UTF-8�޸İ棺void writeUTF();
	   ���⣺UTF-8�� �޸İ�Ĳ�ͬ��ʹ�ø��෽��д������ô�ͱ����ö�Ӧ�Ķ�ȡ��
	   ���÷�ʽ��dos.writeUTF( "���");

------------------------------------------------------------------------------------------------------

4��java.io.DataInputStream��
5��DataInputStream���ǻ����������루��ȡ��������
6��DataInputStream�������ʽ��
	1�����췽���������������������������DataInputStream(InputStream in)
	   ���÷�ʽ��DataInputStream dis = new DataInputStream( new FileInputStream( "data.txt"));

	2��ȡint���ݣ�int readInt()
	   ���÷�ʽ��int i = dis.readInt();

	3��ȡboolean���ݣ�boolean readBoolean()
	   ���÷�ʽ��boolean b = dis.readBoolean();

	4��ȡdouble���ݣ�double readdouble()
	   ���÷�ʽ��double d = dis.readDouble();

	5��ȡString���ݣ�String readUTF()
	   ���÷�ʽ��String s = dis.readUTF();

7��������붼�ǰ�˳���д�ģ�����
   д��1����asd����true��15.5
   ����1����asd����true��15.5
*/
import java.io.*;
class Data_Dome
{
	public static void main(String[] args) throws IOException
	{
		DataOutputs();
		DataInputS();
	}

	public static void DataOutputs() throws IOException
	{
		DataOutputStream dos = new DataOutputStream( new FileOutputStream( "data.txt"));

		dos.writeInt( 234);
		dos.writeBoolean( true);
		dos.writeDouble( 9887.543);
		dos.writeUTF( "���");	//����UTF-8�޸İ棬����ͨ����������ġ�

		dos.close();
	}

	public static void DataInputS() throws IOException
	{
		DataInputStream dis = new DataInputStream( new FileInputStream( "data.txt"));

		int i = dis.readInt();
		boolean b = dis.readBoolean();
		double d = dis.readDouble();
		String s = dis.readUTF();

		dis.close();

		System.out.println( i);
		System.out.println( b);
		System.out.println( d);
		System.out.println( s);
	}
}
