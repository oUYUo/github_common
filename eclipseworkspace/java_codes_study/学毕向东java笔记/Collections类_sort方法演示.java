//��ʾ��sort����2�������� ���ã���List���򣬵�����ȥ���ظ�Ԫ�ء�
////����ʵ��������String����Stringʵ���� Comparable �ȽϽӿڣ����Գ���Ա��������ʵ��Comparable�ȽϽӿڡ�
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

	//	Collections.sort(list); ����1

	//	Collections.sort(list, new StringComp()); ����2

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