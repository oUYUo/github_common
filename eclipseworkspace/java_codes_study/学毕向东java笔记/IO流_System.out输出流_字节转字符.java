/*
1����System���У������ֶΣ�
	System.out����ӡ�� ----> static PrintStream out
	System.in�� ������ ----> static InputStream in

2��static PrintStream out ��ӡ����
	A����static���ξ�̬������
	B���������ͣ�PrintStream �ࡣ
	C�����÷�ʽ��PrintStream ps = System.out;

3��PrintStream �̳��� FilterOutputStream��
4��ͨ�� System.out ���ص� PrintStream�������ڿ���̨�������������
5�����������������������
	1������׼���������static PrintStream out
	   ˵�������ڴ����������
	   ���÷�ʽ��OutputStream out = System.out;

6��������������������ùر���Դ��

-----------------------------------------------------------------------------------------------

7��OutputStreamWriter������ֽ���ת���ַ�����
	1�����췽����ʹ��Ĭ�ϱ��뽫�ֽ���ת���ַ�����OutputStreamWriter(OutputStream out)
	   ���룺Ĭ�ϱ�����õ��ǣ�GBK
	   ���÷�ʽ��OutputStreamWriter otw = new OutputStreamWriter( System.out);

	2�����췽����ʹ��ָ�����뽫�ֽ���ת���ַ�����OutputStreamWriter(OutputStream out, String charsetName) 
	   ���룺Ĭ�ϱ�����õ��ǣ�GBK
	   ������charsetNameָ�������
       ���÷�ʽ��OutputStreamWriter otw = new OutputStreamWriter( FilterOutputStream, "UTF-8");

8��ת�������ַ����ֽ�֮���������ͨ���漰���ַ�����ת��ʱ����Ҫ�õ�ת������
*/

class  
{
	public static void main(String[] args) 
	{
	/*
		OutputStream out = System.out; ��������ֽ���
		OutputStreamWriter osw = new OutputStreamWriter( out); ������ֽ���ת���ַ�����
		BufferedWriter bufw = new BufferedWriter(osw); �����ַ���������
	*/
		BufferedReader bufr = new BufferedReader( new InputStreamReader( System.in)); //������\��
		BufferedWriter bufw = new BufferedWriter( new OutputStreamWriter( System.out)); //�����\д

	/*
		�ֽ���ת���ַ����������������ļ���ʾ������̨��
			���ͣ��ļ������ֽڶ���������ŵģ�������ȡ�����ܿ��Ķ��ģ���Ҫת���ַ���

		���������ǽ������ļ���ȡ��
			System.in ---> ���룬Ȼ��ͨ���ֽ�ת�ַ���ȡ���ݡ�


		�ַ���ת���ֽ������������ļ��洢�����ء�
			���ͣ��ļ������Զ����ƴ洢�ģ���������Ҫת���ֽڴ洢��

		��������ǽ��ļ�д�����ء�
			System.out ---> ����� ���ַ�ת�ֽڴ洢��
	*/

		String s = null;

		while( ( s = bufr.readLine()) != null)
		{
			if( "over".equals( s))
			{
				break;
			}

			bufw.write( s);	//��������档
			bufw.newLine();	//����
			bufw.flush();	//ˢ��������ʾ������̨��
		}

		bufw.close();
	}
}