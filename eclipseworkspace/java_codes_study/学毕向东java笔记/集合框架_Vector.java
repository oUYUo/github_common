/*
java.util��
1��ö�پ���Vector����ȡ����ʽ���͵�����һ���ġ�
2����Ϊö�ٷ������ƹ�������������ȡ���ˡ�

Vector���г���������
	1�����Ԫ�أ�boolean add(E e);
	   ���÷�ʽ��Vector v = new Vector(); v.add(���Ԫ��);
	
	2������Vectorö�ٵ�������Enumeration<E> elements();
	   ���÷�ʽ��Enumeration en = v.elements();
*/

class  
{
	public static void main(String[] args) 
	{
		Vector v = new Vector();

		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");

		Enumeration en = v.elements();
	}
}
