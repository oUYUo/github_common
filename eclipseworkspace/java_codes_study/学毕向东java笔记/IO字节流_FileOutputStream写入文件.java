/*
import java.io.OutputStream;
1��OutputStream д�ֽ��������ࡣ
2��FileOutputStream����д�ļ���̳���OutputStream��
3���ڲ����ֽ����У�����Ҫˢ��������Ϊ�ַ������ɶ���ֽ���ɣ����ֽ����ǵ����ֽڡ�
4��FileOutputStream�ֽ����ļ���������������
	1�����췽�������ļ���FileOutputStream(String name)
	   �������ļ�·�� + �ļ��� + �ļ���׺��
	   ���÷�ʽ��FileOutputStream fos = new FileOutputStream( "dome.java");

	2���ر�����Դ��void close()
	   ���÷�ʽ��fos.close()

	3�����ֽ�����д������void write(byte[] b)
	   ������getBytes() ��String�з��������ǽ��ַ���ת���ֽ����顣
	   ���÷�ʽ��fos.write( "abcde".getBytes());

*/
class  
{
	public static void main(String[] args) throws IOException
	{
		FileOutputStream fos = new FileOutputStream( "dome.txt");
		
		fos.write( "abcde".getBytes());	//getBytes() ��String�з��������ǽ��ַ���ת���ֽ����顣
		fos.close();
	}
}