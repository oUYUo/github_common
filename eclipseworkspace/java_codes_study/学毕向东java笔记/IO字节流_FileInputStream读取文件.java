/*
import java.io.InputStream;
1��InputStream ��ȡ�ֽ��������ࡣ
2��FileInputStream�������ļ���̳���InputStream��
3���ڲ����ֽ����У�����Ҫˢ��������Ϊ�ַ������ɶ���ֽ���ɣ����ֽ����ǵ����ֽڡ�
4��FileInputStream�ֽ����ļ���������������
	1�����췽�����������ļ���FileInputStream(String name)
	   ���÷�ʽ��FileInputStream fis = new FileInputStream( �ļ�·��+�ļ���+��׺��);

	2����ȡ�ļ������飺int read(byte[] b);
	   ����ֵ�����ɲ��ؽ��ܡ����뻺�������ֽ������������Ϊ�Ѿ������ļ�ĩβ��û�и�������ݣ��򷵻� -1�� 
	   ���÷�ʽ��byte[] b = new byte[fis.available()];
				 fis.read(b);

	3����ȡ�ļ����ݸ�����int available()
	   ����ֵ�������ļ������и����������س������س���ռ2���ֽ� \R\N
	   ���÷�ʽ��int mun = fis.available();

	4���ر�����Դ��void close()
	   ���÷�ʽ��fis.close();
*/

class  
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream( "dome.txt");
		
		byte[] b = new byte[ fis.available()];
		/*
			byte[] b = new byte[ fis.available()]; 
			�˾���벻����ʹ�á�
			ԭ�򣺵��������ݳ����ڴ�ʱ����ô�ͻ�����ڴ������
			�����������ĸ�����������ô���棬�����������
		*/

		fis.read(b);
		System.out.println( new String(b));

		fis.close();
	}
}