/*
1��import java.io.SequenceInputStream;
2��SequenceInputStream��ƴ�����̳��� InputStream .
3�����ǽ�������ϲ�һ����������������ļ����ݴ���һ���ļ��С�
4��SequenceInputStream ����������
	1��SequenceInputStream(Enumeration<? extends InputStream> e)
	   ������Enumeration �Ǹ����Ͻӿڹ��ߡ�Vector.elements()��������ӿ�
	   ���÷�ʽ��Enumeration<FileInputStream> en =  new Vector<FileInputStream>().elements();
				 ����.SequenceInputStream( en);

	2��SequenceInputStream(InputStream s1, InputStream s2)
	   ���������ֽڶ�ȡ�����󣬽��к�ƴ��
	   ���÷�ʽ��SequenceInputStream( new FileInputStream( "1.txt"), new FileInputStream( "2.txt"))

5���������������������������ͬ

*/
import java.io.*;
import java.util.*;
class  
{
	public static void main(String[] args) throws IOException
	{
		Sequenc();
	}

	public static void Sequenc() throws IOException
	{
		Vector<FileInputStream> v = new Vector<FileInputStream>();

		v.add( new FileInputStream( "1.txt"));
		v.add( new FileInputStream( "2.txt"));
		v.add( new FileInputStream( "3.txt"));

		Enumeration<FileInputStream> en =  v.elements();

		SequenceInputStream sis = new SequenceInputStream( en);
		FileOutputStream fos = new FileOutputStream( "4.txt");
		
		int k = 0;

		while( ( k = sis.read()) != -1)
		{
			fos.write( k);
		}

		fos.close();
		sis.close();
	}
}