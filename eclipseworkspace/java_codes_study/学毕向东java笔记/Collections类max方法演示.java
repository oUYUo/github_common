/*
1��Collections�Ǽ��Ϲ����࣬�ɶԼ��Ͻ��в�����
2��Collections����������
	1����תָ���б���Ԫ�ص�˳��static void reverse(List<?> list)
	   ���÷�ʽ��Collections.reverse( list)

	2��ǿ����ת��Ȼ����static <T> Comparator<T> reverseOrder()
	   ���÷�ʽ��Comparator<Students> comp = Collections.reverseOrder();
				 TreeSet ts = new TreeSet<Students>( comp);

	3��������Ȼ˳��ȡ���Ԫ�أ�static <T extends Object & Comparable<? super T>> T  max( Collection<? extends T> coll)
	   ���÷�ʽ��Collections.max(list);

	4������ָ���Ƚ���ȡ���Ԫ�أ�static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) 
	   ���÷�ʽ��Collections.max(list, new StringComp());
*/
//���´������ã���ȡlist���������Ԫ�ء�
import java.util.*;
class java 
{
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();

		list.add( "qwe");
		list.add( "q");
		list.add( "qwert");
		list.add( "qw");
		list.add( "qwte");

	//	Collections.max(list); ����1

	//	Collections.max(list, new StringComp()); ����2

		System.out.println(list);
	}
}

class StringComp implements Comparator<String>
{
	public int compare(String o1, String o2)
	{
		if( o1.length() == o2.length())
			return o1.compareTo( o2);
		if( o1.length() > o2.length())
			return 1;
		return - 1;
	}
}