/*
instanceof ��ʽ�� ���� instanceof ����������
1���ж�ʵ�����������Ƿ���ͬ��
2���ж��Ӷ��������Ƿ���ͬ��
ʵ�����ж����ã�a instanceof Cat �ж�a�������Ƿ�ΪCat�����ͣ�����boolean���͡�
*/

class java
{
	public static void main(String[] args)
	{
		mak k = new mak();
		mab b = new mab();

		Object obj = new mak();

	/* �ж�k���������Ƿ���mak���͡�
		System.out.println( k instanceof mak); ��� true�����ϵ�һ��������

------------------------------------------------------------------------------------

		�ж�k���������Ƿ���mab���͡�
		System.out.println( k instanceof mab); ��� true�����ϵڶ���������

-------------------------------------------------------------------------------------
		
		�ж�objָ������������Ƿ�Ϊmab��
		System.out.println( obj instanceof mab); ��� true�����ϵڶ���������
		�ر�˵����obj����mak���Ӷ�objָ��mak����mak�̳���mab�� 

		�ж� b���������Ƿ�Ϊmak
		System.out.println( b instanceof mak); ���false��
		�ر�˵����mab(b)�����߱�����������
	*/
	}
}

class mak extends mab
{
}

class mab
{
}