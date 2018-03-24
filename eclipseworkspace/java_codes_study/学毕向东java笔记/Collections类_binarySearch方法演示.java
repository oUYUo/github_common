//返回值：返回搜索键的索引；否则返回 (-(插入点) - 1)。插入点 被定义为将键插入列表的那一点。此键被找到时，返回的值将 >= 0。 不存在返回负数，存在返回正数。
//下面实例泛型是String，而String实现了 Comparable 比较接口，所以程序员不必另起实现Comparable比较接口。
import java.util.*;
class  CollectionsDemo
{
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();

		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		list.add("qq");
		list.add("z");

		int index = Collections.binarySearch(list,"aaaa");
		System.out.println(index);
	}

/*	实现 binarySearch 原理，就是折半查找。
	public static int halfSearch(List<String> list,String key)
	{
		int max,min,mid;
		max = list.size()-1;
		min = 0;

		while(min<=max)
		{
			mid = (max+min)>>1;//  /2;

			String str = list.get(mid);

			int num = str.compareTo(key);
			if(num>0)
				max = mid -1;
			else if(num<0)
				min = mid + 1;
			else
				return mid;
		}
		return -min-1;
	}
*/
}