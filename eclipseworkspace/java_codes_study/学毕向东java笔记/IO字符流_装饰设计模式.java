/*
װ�����ģʽ��
����Ҫ�����еĶ�����й�����ǿʱ��
���Զ����࣬�����ж����룬�������еĹ��ܣ����ṩ��ǿ���ܡ�
��ô�Զ���ĸ����Ϊװ���ࡣ

װ����ͨ����ͨ�����췽�����ձ�װ�εĶ���
�����ڱ�װ�εĶ���Ĺ��ܣ��ṩ��ǿ�Ĺ��ܡ�

--------------------------------------------------------------------------------

�̳����˼�룺
	MyReader//ר�����ڶ�ȡ���ݵ��ࡣ
		|--MyTextReader		//���ݲ������ͣ�����
			|--MyBufferTextReader	//������
		|--MyMediaReader	//�ļ�
			|--MyBufferMediaReader
		|--MyDataReader
			|--MyBufferDataReader

	class MyBufferReader
	{
		MyBufferReader(MyTextReader text)
		{}
		MyBufferReader(MyMediaReader media)
		{}
	}

�����������չ�Ժܲ

װ�����ģʽ�������ҵ�������Ĺ�ͬ���͡�ͨ����̬����ʽ�����������չ�ԡ�

	MyReader//ר�����ڶ�ȡ���ݵ��ࡣ
		|--MyTextReader
		|--MyMediaReader
		|--MyDataReader
		|--MyBufferReader

	class MyBufferReader extends MyReader
	{
		private MyReader r;
		MyBufferReader(MyReader r)
		{}
	}	

��ǰ��ͨ���̳н�ÿһ�����඼�߱����幦�ܡ�
��ô�̳���ϵ�Ḵ�ӣ�����������չ��

�����Ż�˼�롣��������һ�»������ݡ�
����Ҫ������Ķ��󡣴��ݽ�����Ҳ���ǣ�˭��Ҫ�����壬˭����Ϊ�������ݸ���������
�����̳���ϵ�ͱ�úܼ򵥡��Ż�����ϵ�ṹ��


װ��ģʽ�ȼ̳�Ҫ�������˼̳���ϵӷ�ף����ҽ�����������֮��Ĺ�ϵ��

װ������Ϊ��ǿ���ж��󣬾߱��Ĺ��ܺ����е�����ͬ�ģ�ֻ�����ṩ�˸�ǿ���ܡ�
����װ����ͱ�װ����ͨ���Ƕ�����һ����ϵ�еġ�
*/

class Person
{
	public void chifan()
	{
		System.out.println("�Է�");
	}
}

class SuperPerson
{
	private Person p;
	SuperPerson( Person p)
	{
		this.p = p;
	}

	public void superChifan()
	{
		System.out.println( "��θ��");
		p.chifan();
		System.out.println( "���");
		System.out.println( "��һ��");
	}
}

class java
{
	public static void main(String args[])
	{
		SuperPerson sp = new SuperPerson( new Person());
		sp.superChifan();
	}
}