/*
import java.io.Write�����ࣺ����д���ַ���
1����Write�ǳ����࣬�������ࡣ
2����д���ļ�Ϊʵ��������Write����OutputStreamWriter������FileWriter�ࡣ
3��IO�����󲿷ַ�����Ҫ�׳� �� ��׽�쳣 �� IOExeption�쳣��
4����winϵͳ�У�д�뻻�з���\r\n

5��FileWriter�����������
	1�����췽�������������ļ���FileWriter(String fileName);
	   �������ļ�Ŀ¼+�ļ�������ֻ���ļ�����Ĭ�ϲ����ļ�·����class�ļ�ͬĿ¼��
	   ���⣺����ļ��Ѵ��ڣ����Ḳ�Ǹ��ļ���
	   ���÷�ʽ��FileWriter fw = new FileWriter( "�ļ�·��+�ļ�������׺");
	
	2�����캯�������������ļ���FileWriter(String fileName, boolean append) 
	   ������append��Ϊtrue��д�����ݵ��ļ���ĩβ����falseд�����ݵ���ʼ������
	   ���÷�ʽ��FileWriter fw = new FileWriter( "�ļ�·��+�ļ�������׺", true);


----------------------------------------------------------------------------------------

6��Write���Է�����
	1�����ַ���д�����У�void write(String str)
	   ���÷�ʽ��fw.write( ���ַ����ݡ�)
	   
	2��ˢ������������ˢ�뱾�أ�abstract void flush()  
	   ���÷�ʽ��fw.flush();

	3��ˢ�¹ر�����abstract  void close()
	   ���⣺�ر���������write()����������쳣��
	   ���÷�ʽ��fw.close();

	4��д�뵥���ַ���void write(int c)
	   ���÷�ʽ��fw.write( int);  //д���ļ�����Զ�ת��ASCII�ַ���
*/

import java.io.*;
class  
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw = new FileWriter( "dmoe");	//���ļ����ڽ��Ḳ�ǡ�
		fw.write( "asddsjs");	//д����
		fw.flush(); //ˢ������������ˢ�µ�����
		fw.close(); //ˢ������������ˢ�µ����أ�Ȼ��ر�����
		//fw.write( "asddsjs"); ���󣬹ر����󣬽�����д������
	}
}
