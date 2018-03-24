/*
1，java.io.DataOutputStream。
2，DataOutputStream类是基本数据输出（写入）操作流。
3，DataOutputStream类基本方式：
	1，构造方法，创建数据输出流：DataOutputStream(OutputStream out)
	   调用方式：DataOutputStream dos = new DataOutputStream( new FileOutputStream( "data.txt"));

	2，输出Int：void writeInt();
	   调用方式：dos.writeInt( 234);

	3，输出Boolean：void writeBoolean();
	   调用方式：dos.writeBoolean( true);

	4，输出Double：void writeDouble();
	   调用方式：dos.writeDouble( 9887.543);

	5，输出UTF-8修改版：void writeUTF();
	   特殊：UTF-8与 修改版的不同，使用该类方法写出，那么就必须用对应的读取。
	   调用方式：dos.writeUTF( "你好");

------------------------------------------------------------------------------------------------------

4，java.io.DataInputStream。
5，DataInputStream类是基本数据输入（读取）操作流
6，DataInputStream类基本方式：
	1，构造方法，创建基本数据输入操作流：DataInputStream(InputStream in)
	   调用方式：DataInputStream dis = new DataInputStream( new FileInputStream( "data.txt"));

	2，取int数据：int readInt()
	   调用方式：int i = dis.readInt();

	3，取boolean数据：boolean readBoolean()
	   调用方式：boolean b = dis.readBoolean();

	4，取double数据：double readdouble()
	   调用方式：double d = dis.readDouble();

	5，取String数据：String readUTF()
	   调用方式：String s = dis.readUTF();

7，输出输入都是按顺序读写的，例：
   写：1、”asd“、true、15.5
   读：1、”asd“、true、15.5
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
		dos.writeUTF( "你好");	//用了UTF-8修改版，和普通版是有区别的。

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
