/*
1，Collections是集合工具类，可对集合进行操作。
2，Collections基本方法：
	1，反转指定列表中元素的顺序：static void reverse(List<?> list)
	   调用方式：Collections.reverse( list)

	2，强行逆转自然排序：static <T> Comparator<T> reverseOrder()
	   调用方式：Comparator<Students> comp = Collections.reverseOrder();
				 TreeSet ts = new TreeSet<Students>( comp);

	3，根据自然顺序取最大元素：static <T extends Object & Comparable<? super T>> T  max( Collection<? extends T> coll)
	   调用方式：Collections.max(list);

	4，根据指定比较器取最大元素：static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) 
	   调用方式：Collections.max(list, new StringComp());
*/
//以下代码作用：获取list集合中最大元素。
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

	//	Collections.max(list); 方法1

	//	Collections.max(list, new StringComp()); 方法2

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