/*
���ͽӿڣ������Ͷ����ڽӿ��ϡ�
1,ʵ�ַ�ʽ��
	1.1 ��ȷ�����������ͣ�class InterImpl implements Inter<String> 
		���÷�ʽ��InterImpl it = new InterImpl();

	1.2 ����ȷ�����ķ��ͣ�class InterImpl<T> implements Inter<T>
		���÷�ʽ��InterImpl<String> it = new InterImpl<String>();
*/

interface Inter<T>
{
	void show(T t);
}

class InterImpl implements Inter<String> 
{
	public void show(String s)
	{
		System.out.println(s);
	}
}

class InterIp<T> implements Inter<T> 
{
	public void show(T t)
	{
		System.out.println(t);
	}
}

class main
{
	public static void main(String[] args) 
	{
		InterImpl it = new InterImpl().show("haha");
		InterIp<String> ip = new InterIp<String>().show("hhh"); 
	}
}
