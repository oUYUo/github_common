/*
包：java.util.*;
Collections 集合工具类。
1，Collections都是静态方法。

Collections方法：
	1，将List集合元素进行自然排序：static <T extends Comparable<? super T>> void sort(List<T> list) 
	   参数：String类本身实现了Comparable接口。
	   调用方式：List<String> list = new ArrayList<String>();
				 Collections.sort(list);

	2，List根据指定比较器排序：static <T> void sort(List<T> list, Comparator<? super T> c)
	   参数：List<T>泛型，传入List带泛型的集合； 再传入实现Comparator<List泛型或泛型的父类>的类。
	   调用方式：List<String> list = new ArrayList<String>();
				 Collections.sort(list, 实现Comp的比较器<String 或String的父类>);

	3，折半查找元素：static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) 
	   参数一：List< 实现Comparable < 是T的子类或T类>>；要搜索的列表。
	   参数二：要查找的元素。要搜索的键。 
	   返回值：返回搜索键的索引；否则返回 (-(插入点) - 1)。插入点 被定义为将键插入列表的那一点。此键被找到时，返回的值将 >= 0。 不存在返回负数，存在返回正数。
	   调用方式：Collections.binarySearch( list<String>, String "查找元素");	//首先要实现 Comparable。 查找元素类型为String。

	4，按自然顺序取元素最大值：static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll);
	   泛型：T必须继承Object，并且实现 Comparable< T 或 T的父类>
	   参数：必须是 Collection，或 实现 Collection的子类，它的泛型是 T 或 T 的子类。
	   调用方式：List<String> list = new ArrayList<String>();
				 Collections.max( list);
	   详解：String本身继承了Objecct,并且实现了Comparable接口 ; List是Collection子接口。

	5，按指定顺序取元素最大值：static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp)
	   调用方式：与第二项相同，传个集合，传一个比较器。

	6，将指定元素替换List集合所有元素：static <T> void fill(List<? super T> list, T obj) 
	   调用方式：Collections.fill( List集合， 替换元素);

	7，指定元素替换新的元素：static <T> boolean replaceAll(List<T> list, T oldVal, T newVal)
	   调用方式：Collections.replaceAll(List集合， 旧元素，新元素);

	8，反转List列表中元素的顺序：static void reverse(List<?> list)
	   调用方式：Collections.reverse(List集合);

	9，反转指定列表中元素：static <T> Comparator<T> reverseOrder() 
	   调用方式：TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder())

   10，按指定比较器反转元素：static <T> Comparator<T> reverseOrder(Comparator<T> cmp)
       参数：传入一个Comparator接口比较器。
	   调用方式：TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder( new Comp));

   11，List列表的指定位置处交换元素：static void swap(List<?> list, int i, int j)
       调用方式：Collections.swap( list集合, 角标A, 角标B);	//将角标A元素置换角标B元素。角标B元素置换角标A元素。

   12，随机对指定列表中元素进行置换：static void shuffle(List<?> list) 
       调用方式：Collections.shuffle( list);
*/