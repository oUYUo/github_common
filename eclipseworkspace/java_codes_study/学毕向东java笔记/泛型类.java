/*
�����ࣺ�ڶ�����ĺ�����ϲ������ò������Ƿ��Ͳ���<>
1�������в����������������Ͳ�ȷ��ʱ���÷�������ɡ�
2�����ڶ���OBject�������չ��������ʱ���ܻ�����쳣��
3�����ڶ��巺���������չ��������ʱ�쳣ת�Ƶ�����ʱ�쳣��
4��������Ķ�����ȷ�����������ͺ�����Ҫ�������;��Ѿ��̶��ˡ�
5�����÷�ʽ��Utils<String> u = new Utils<String>;
6�������಻�ɱ���̬����ʹ�á�
*/

class Utils<QQ>	
{
	private QQ q;
	public void setObject(QQ q)
	{
		this.q = q;
	}

	public QQ getObject()
	{
		return q;
	}
}

class main
{
	public static void main(String[] agrs)
	{
		Utils<String> u = new Utils<String>();
		u.setObject("����");
		String s = u.getObject();
	}
}