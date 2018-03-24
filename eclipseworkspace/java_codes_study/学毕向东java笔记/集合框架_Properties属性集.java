/*
1��java.util.Properties��һ�����Լ��ϣ��̳���  Hashtable �ɲ�������
2�����Ǽ����к�IO�������ϵļ���������
3���ü����ص㣺�������ڼ�ֵ����ʽ�������ļ���
4��Properties���л���������
	1�����أ��������б������ָ�����������void list(PrintStream out)
	   ���÷�ʽ��Properties prop = System.getProperties();
				 prop.list( new PrintStream( "sysinfo.txt"));

	2�����Ԫ�أ�Object setProperty(String key, String value)  
	   ����ֵ�������ؽ��ܡ�����ָ�����ľ�ֵ�����û��ֵ���򷵻� null��
	   ���������� Hashtable �ķ��� put��
	   ������key -- ���� value -- ֵ
	   ���÷�ʽ������.setProperty( "��", "ֵ");

	3��ָ������ȡֵ��String getProperty( String key)
	   ���÷�ʽ������.getProperty( "��");

	4����ȡ���м���Set<String> stringPropertyNames()
	   ���÷�ʽ��Set<String> namers = ����.stringPropertyNames();
				 for( String s : names)
				 {
					System.out.print( s + "=");	//ͨ��ѭ����ȡÿ������
					System.out.println( ����.getProperty( s));	//ͨ��ָ������ȡ��Ӧ��ֵ��
				 }

	5������ȡ�����ݴ��뼯�ϣ�void load(InputStream inStream)
	   ���⣺�ı���ʽ����=ֵ��
	   ������InputStream���ֽڶ�ȡ����ͨ��FileInputStream��ȡ�ļ���ŵ������С�
	   ���÷�ʽ������.load( new FileInputStream( "�ļ�"));
 
	6��ָ���ֽ�����������void list(PrintStream out)
	   ���÷�ʽ������.list( System.out);

	7��ָ���ַ�����������void list(PrintWriter out)
	   ���÷�ʽ������.list( System.out);

	8��ͨ���ֽ���д���ļ���void store(OutputStream out, String comments)
	   ������OutputStream --- �ֽ���д��comments --- ע�� // ע���ǲ��ᱻ��ȡ��
	   ���÷�ʽ������.store( new FileOutputStream( "�ļ�"), "ע����Ϣ");

	9��ͨ���ַ���д���ļ���void store(Writer writer, String comments)
	   ������writer --- �ַ���д��comments --- ע�� // ע���ǲ��ᱻ��ȡ��
	   ���÷�ʽ������.store( new FileWriter( "�ļ�"), "ע����Ϣ");
*/

import java.util.*;
import java.io.*;

class  
{
	public static void main(String[] args) throws IOException
	{
	}

	public static void getwin()throws IOException	//��ȡϵͳ��Ϣ��
	{
		/*
		getProperties()��ȡϵͳ��Ϣ�������ص��� Properties ���͡�
		new PrintStream( "sysinfo.txt");�ֽ���չ������������һ�� "sysinfo.txt" �ļ���
		list();����һ����������� ϵͳ��Ϣ �洢�� "sysinfo.txt"�ļ��С�

		*/
		Properties prop = System.getProperties();

		prop.list( new PrintStream( "sysinfo.txt"));

		/*
		System.setOut( new PrintStream( "sysinfo.txt"));		
		prop.list( System.out);
		*/
	}

	public static void Run_number()throws IOException	//�������д���
	{
		/*
		1����ȡ�����ļ������û���򴴽���
		2����¼����
		3��д�������ļ�
		4���ж��Ƿ�����Ѿ���
		*/
		Properties prop = new Properties();
		File file = new File( "PropertiesDome.ini");

		if( !(file.exists()))
			file.createNewFile();

		FileInputStream fis = new FileInputStream( file);

		prop.load( fis);	//��fis����ȡ�����ݴ��� prop �С�
		
		int count = 0;	
		String value = prop.getProperty( "time");	

		if( value != null)	//ֵ�Ƿ�Ϊ�ա�
		{
			count = Integer.parseInt( value);

			if( count >= 3)
			{
				System.out.println( "���ã�ʹ�ô����ѵ���");
				return;
			}
		}

		count++;

		prop.setProperty( "time", String.valueOf( count));

		FileOutputStream fos = new FileOutputStream( file);

		prop.store( fos,"");	//�� propд�뱾�ء�

		fos.close();
		fos.close();
		
		System.out.println( prop);
	}
}