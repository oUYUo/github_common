/*
�����޶���ͨ�����
1������ͨ��� <?>�����ڽ���δ֪���͡�
   ʵ����public void print(ArrayList<?> a1)

2������ͨ����붨��������͵�����
	2.1 ���ͱ���������ʹ��δ֪�������з�����
	2.2 ����ͨ���������ʹ��ͨ������������͵����з�����
*/

import java.util.*;
class java
{
	public static void main(String[] aers)
	{
		ArrayList<String> al = new ArrayList<String>();
		al.add("001");
		al.add("002");
		al.add("003");

		ArrayList<Integer> in = new ArrayList<Integer>();
		in.add(4);
		in.add(7);
		in.add(3);

		print(al);
		print(in);
	}

	public static void print(ArrayList<?> al)
	{
		Iterator<?> it = al.iterator();

		while(it.hasNext())
		{
			System.out.println( it.next());
		}
	}
}