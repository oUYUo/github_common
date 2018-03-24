/*
���ͣ�JDK1.5�汾�Ժ���������ԡ����ڽ����ȫ���⣬��һ����ȫ���ơ�
1�����ڼ����д洢��ͬ�������ͣ�ȡ��ʱ������� ClassCastException �쳣��Ҳ���������쳣����ʹ�÷��ͺ󣬽������쳣ת�Ƶ��˱����쳣��
2�����ͼ���ʹ�÷�ʽ��ArrayList<String> a1 = new ArrayList<String>();
   ���͵�����ʹ�÷�ʽ��Iterator<String> it = a1.iterator();
   ˵������������������洢���ݹ̶�Ϊ String�� ���洢�������ͣ�����ʱ�����
3�������̶������������ͺ󣬱�����ǿ��ת�����鷳��
4�����͸�ʽ��ͨ��<>������Ҫ�����������������͡������ڷ���ֵǰ�棬���η����档
5����JDK API�ĵ��У��������� ����<E> �� ����<T> ��ʵ��Щ���Ƿ��ͣ�ͨ��<E>������������������Զ����������͡�
	���磺Comparator<E> ---> ʵ�ֽӿڣ�class Comp implements Comparator<String>
		  public int compare( T o1, T o2); --->ʵ�ַ�����public int compare(String o1, String o2)
*/
import java.util.*;
class java
{
	public static void main(String[] args) 
	{
		TreeSet<String> ts = new TreeSet<String>(  new Comp());

		ts.add("0007");
		ts.add("8");
		ts.add("005");
		ts.add("06");

		Iterator<String> it = ts.iterator();

		while( it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}

class Comp implements Comparator<String>
{
	public int compare(String o1, String o2)
	{
		int num = new Integer(o1.length()).compareTo( new Integer( o2.length()));

		if( num == 0)
			return o1.compareTo(o2);

		return num;
	}
}