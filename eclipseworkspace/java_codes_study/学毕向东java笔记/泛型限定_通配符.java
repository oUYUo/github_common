/*
泛型限定（通配符）
1，泛型通配符 <?>：用于接受未知类型。
   实例：public void print(ArrayList<?> a1)

2，泛型通配符与定义变量泛型的区别：
	2.1 泛型变量：可以使用未知类型特有方法。
	2.2 泛型通配符：不可使用通配符所传递类型的特有方法。
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