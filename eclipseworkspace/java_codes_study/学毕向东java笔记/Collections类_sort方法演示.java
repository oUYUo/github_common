//演示：sort重载2个方法， 作用：将List排序，但不会去除重复元素。
////下面实例泛型是String，而String实现了 Comparable 比较接口，所以程序员不必另起实现Comparable比较接口。
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

	//	Collections.sort(list); 方法1

	//	Collections.sort(list, new StringComp()); 方法2

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