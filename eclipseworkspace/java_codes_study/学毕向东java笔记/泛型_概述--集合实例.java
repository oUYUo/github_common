/*
泛型：JDK1.5版本以后出现新特性。用于解决安全问题，是一个安全机制。
1，当在集合中存储不同数据类型，取出时，会出现 ClassCastException 异常（也就是运行异常）。使用泛型后，将运行异常转移到了编译异常。
2，泛型集合使用方式：ArrayList<String> a1 = new ArrayList<String>();
   泛型迭代器使用方式：Iterator<String> it = a1.iterator();
   说明：将集合与迭代器存储数据固定为 String， 当存储其它类型，编译时会出错。
3，给出固定集合数据类型后，避免了强制转换的麻烦。
4，泛型格式：通过<>来定义要操作的引用数据类型。定义在返回值前面，修饰符后面。
5，在JDK API文档中，经常见到 类名<E> 与 参数<T> 其实这些都是泛型，通过<E>这个变量，给出我们自定义引用类型。
	例如：Comparator<E> ---> 实现接口：class Comp implements Comparator<String>
		  public int compare( T o1, T o2); --->实现方法：public int compare(String o1, String o2)
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