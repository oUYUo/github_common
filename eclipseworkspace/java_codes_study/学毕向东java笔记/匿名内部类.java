/*
�����ڲ��ࣺ
1�������ڲ�����ʵ�����ڲ���ļ�д��ʽ��
2�����������ڲ����ǰ�᣺
		�ڲ�������Ǽ̳�һ�����ʵ�ֽӿڡ�
3�������ڲ���ĸ�ʽ�� new ���� ���߽ӿ�(){ ������ }.���÷���();
4���������ڲ���Ϊ�������ӿ���ʱ��ֻ�ܵ��ø����ӿڷ��������£�
			�����ӿ���.������ = new �����ӿ���();     ------->����������ת�͡�
*/

class main
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}

interface face_test
{
	void tes();
}

class test
{
	//�����ڲ������1��
	new face_test()
	{
		void tes(){}
		void tek(){}
	
	}.tes();

	//�����ڲ�����÷���2
	face_test in = new face_test()
	{
		void tes(){}
		//����Ͳ��ܶ���tek�ˣ���Ϊ��������ת�͡�
	}
	in.tes();
}