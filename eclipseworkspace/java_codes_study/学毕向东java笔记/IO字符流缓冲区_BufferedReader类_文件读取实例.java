/*
1��BufferedReader����һ����ȡ��������
2��BufferedReader��̳���Reader�ࡣ
3��BufferedReader�ಿ�ַ�����
	1������Ĭ�ϴ�С��ȡ��������BufferedReader(Reader in) 
	   ���÷�ʽ��BufferedReader buf = new BufferedReader( new FileReader( "buf.txt"););

	2����ȡһ���ı��У�String readLine();
	   ����ֵ�����Ϊ�գ��򷵻� null�� �Ҳ����� �س�����
	   ���÷�ʽ��buf.readLine();

	3���رո����뻺������Դ��void close()
	   ���÷�ʽ��buf.close();
*/

class 
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader( "buf.txt");

		BufferedReader buf = new BufferedReader( fr);

		String line = null;
	//readLine()��һ�У����Ϊ�գ��򷵻� null��
		while( (line = buf.readLine()) != null)
		{
			System.out.println( line);
		}

		buf.close();
	}
}
