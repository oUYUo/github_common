/*
1����������������Ĳ���Ч�ʡ����Դ���������֮ǰ����������������
2��BufferedWriter�̳�Writer��
3��BufferedWriter���ַ�����
	1������Ĭ�ϴ�С����������BufferedWriter(Writer out)
	   ����������Ҫ�ڻ����������Ķ�����롣
	   ���ø�ʽ��BufferedWriter bufw = new BufferedWriter( new FileWriter( "buf.txt"));

	2������ʵ��д���ַ�����void write(String str)
	   ���ø�ʽ��bufw.write( "abbcde");	//������д�뵽��������
	
	3��д��һ����ƽ̨�зָ�����void newLine() 
	   �������ֶ����в��ܿ�ƽ̨���˷����ɿ�ƽ̨��
	   ���÷�ʽ��bufw.newLine();	//����

	4����������������ˢ�µ����أ�void flush()
	   ���÷�ʽ��bufw.flush();

	5��ˢ���������رմ�����void close()
	   ��⣺�رջ������������ڹرջ������е�������
	   ���÷�ʽ��bufw.close();
*/

class  
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw = new FileWriter( "buf.txt");	//ָ��Ҫд���ļ���Ŀ�ĵغ��ļ�����
		
		BufferedWriter bufw = new BufferedWriter(fw);	//���ö�����뻺������

		bufw.write( "abbcde");	//������д�뵽��������
		bufw.newLine();	//���У����Կ�ƽ̨��  �ֶ����в��ܿ�ƽ̨��
		bufw.flush();//��������������ˢ�µ����ء�
		bufw.close(); //�رջ������������ڹرջ������е�������
	}
}
