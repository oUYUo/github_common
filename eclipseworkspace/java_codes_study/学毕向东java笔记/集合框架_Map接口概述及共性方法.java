/*
Map<K,V>接口：
	K - 此映射所维护的键的类型。
	V - 映射值的类型。
	解：张三（V值）在北京（K键）。

1，Map在java.util包里。
2，将键映射到值的对象。一个映射不能包含重复的键；每个键最多只能映射到一个值。
3，键不可重复，因为键相当于标识符，值可重复。
4，当遇到重复元素时，新元素会覆盖旧元素。
5，底层为哈希表数据结构，排序去除重复元素只能实现 Comparable 接口，复写hashCode()、equals()、compareTo();
6，底层为二叉树数据结构，排序去除重复元素，可以实现 Comparable 接口中 compareTo()，也可以单独实现 Comparator 接口中 compare()。
7，注意：实现Comparator接口，只排序 键。键是什么类型，Comparator泛型就是什么类型。

Map接口共性方法： HasMap类演示Map接口方法。
	1，创建实例对象：Map< String, String> map = new HashMap< String, String>();
	   泛型：添加String类型键与值到map集合。
	   对象：Map是接口，HashMap实现了Map集合方法。

	2，添加元素：V put(K key, V value);
	   返回值：【可不接受】返回 key 是否有映射关系。 如果key有映射关系，则返回所映射的值，并替换新值。如果key映射value是null，则返回null。
	   调用方式：对象名.put( 键名, 值);

	3，判断键是否存在：boolean containsKey(Object key);
	   调用方式：对象名.containsKey( 键名);

	4，判断值是否存在：boolean containsValue(Object value);
	   调用方式：对象名.containsValue( 值);

	5，删除元素：V remove(Object key);
	   返回值：【可不接受】返回键名所映射的值，如果该值 或 键名不存在，则返回 null。
	   调用方式：对象名.remove( 键名);

	6，获取元素：V get(Object key);
	   返回值：返回指定键所映射的值，如果该值或键不存在，则返回null。
	   调用方式：对象名.get( 键名);
	  
	7，获取集合中所有值：Collection<V> values();
	   返回值：返回是Collection接口，泛型是该对象名对应的泛型，所以必须创建Collection变量进行接受。
	   调用方式：Collection< 值泛型> c =  对象名.values();  取出打引：c

	8，获取集合中所有键：Set<K> keySet();
	   返回值：返回是Set集合，是将所有键返回到Set 中，然后通过Set迭代器进行取出。
	   调用方式：Set< 键泛型> s = 对象名.keySet();
				 Iterator< 键泛型> it = s.iterator();
				 while( it.hasNext())
				{
					System.out.println( it.next());
				}
	   原理：将map集合转成set集合，再通过迭代器取出。

	9，获取集合中所有键或值：Set<Map.Entry<K,V>> entrySet();
	   返回值：返回Set集合，Map.Entry<K,V>类型。
		   	   Map.Entry<K,V>：是Map内部的Entry接口，是键和值映射类型，如同结婚证。被HashMap内部类所实现。
	   调用方式：Set<Map.Entry< 键泛型, 值泛型>> entrySet = 对象名.entrySet();
				 Iterator<Map.Entry< 键泛型, 值泛型>> it = entrySet.iterator();
				 while( it.hasNext())
				 {
					Map.Entry< 键泛型, 值泛型> me = it.next();	//键和值映射关系，这种关系是个 Map.Entry 类型。所以需要Map.Entry接受。
					String key = me.getKet();	//Map接口的Enntry内部接口特有方法。
					String value = me.getValue();	//Map接口的Enntry内部接口特有方法。
				 }

------------------------------------------------------------------------------------------------------------------------------------------------

Map.Entry< K, V> 接口方法： 是Map的内部接口：Enntry
	1，获取对应的键：K getKey();
	   返回值：是Set集合中所设定键的类型。
	   关系：Map接口的Set<Map.Entry<K,V>> entrySet()方法。
	   调用方式：对象名.getKey();	（另参考Map接口共性方法第八项）。

	2，获取对应的值：V getValue();
	   返回值：是Set集合中所设定值的类型。
	   关系：Map接口的Set<Map.Entry<K,V>> entrySet()方法。
	   调用方式：对象名.getValue();	（另参考Map接口共性方法第八项）。
*/

import java.util.*;
class java
{
	//获取集合中所有键或值：Set<Map.Entry<K,V>> entrySet();实例
	public static void main(String[] args) 
	{
		Map< Integer, String> map = new HashMap< Integer, String>();

		map.put( 1, "01");
		map.put( 2, "02");
		map.put( 2, "02");
		Set<Map.Entry< Integer, String>> entrySet = map.entrySet();

		Iterator<Map.Entry< Integer, String>> it = entrySet.iterator();

		while( it.hasNext())
		{
			Map.Entry< Integer, String> me = it.next();	//键和值映射关系，这种关系是个 Map.Enntry 类型。所以需要Map.Enntry接受。
			Integer key = me.getKey();	//Map接口的Enntry内部接口特有方法。
			String value = me.getValue();	//Map接口的Enntry内部接口特有方法。
			System.out.println("key = " + key + " ------ value = " + value);
		}
	}
}