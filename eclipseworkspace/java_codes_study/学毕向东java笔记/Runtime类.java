/*
java.lang��
1��Runtime��û���ṩ���캯�����������о�̬�Ǿ�̬�������뵽�������ģʽ��
2��Runtime�෽����
	1����ȡRuntime����static Runtime getRuntime();
	   ���÷�ʽ��Runtime run = Runtime.getRuntime();

	2��cmd�����У�Process exec(String command);
	   �쳣��ʹ�ø÷�����Ҫ ��׽�쳣���� �׳��쳣
	   ��������Ҫ���򿪵��ļ�·��+�ļ���׺��
	   ���⣺�� \ Ϊת���ַ�������Ҫ˫ \ ;  Ĭ�ϴ򿪷�ʽ��exe�������������ʽ��exec( EditPlus dome.java);
	   ����ֵ�����ؽ��ܡ� Process ������ ���ɶ� exec ���򿪵��ļ����в������磺ɱ�����̡�
	   ���÷�ʽ������.exec( "D:\\AIDE\\aida64.exe");

----------------------------------------------------------------------------------------------

Process�����෽����
	1��ɱ��exec�������Ľ��̣�abstract void destroy()
	   ���÷�ʽ��Process p = run.exec( "D:\\AIDE\\aida64.exe");  // ���� aida64.exe
				 p.destroy();  //ɱ�� aida64.exe����
*/

class  
{
	public static void main(String[] args) throws Exception
	{
		Runtime run = Runtime.getRuntime();
		Process p = run.exec( "D:\\AIDE\\aida64.exe");  // ���� aida64.exe
		p.destroy();  //ɱ�� aida64.exe����

//-----------------------------------------------------------------------------

		run.exec( "notepad.exe F:\\1.txt"); //�������� ����·��
	}
}
