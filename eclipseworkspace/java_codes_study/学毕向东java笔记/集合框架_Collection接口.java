/*
java.util包
打印集合内容：直接调用对象打印。

Collection<E>接口共性方法： 
	1，添加元素：void add( E e);
   	   调用方式：对象.add( 添加元素);
	  
	2，获取集合成员数：int size();
	   调用方式：对象.size();

	3，删除元素：boolean remove( Object o);
	   调用方式：对象.remove( 对象元素);

	4，清空集合：void clear();
	   调用方式：对象.clear();

	5，判断元素是否存在：boolean contains( Object o);
	   调用方式：对象.contains( 对象元素);

	6，判断集合是否为空：boolean isEmpty();
	   调用方式：对象.isEmpty();

	7，取交集，保留两个集合相同元素：void retainAll( Collection<?> c);
	   调用方式：对象1.retainAll( 对象2);

	8，去交集，去除两个集合相同元素：void removeAll( Collection<?> c);
	   调用方式：对象1.removeAll( 对象2);

    9，获取迭代器，用于取出集合元素：Iterator iterator();
       特殊：用到了 Iterator 接口。
	   调用方式：Iterator it = 对象.iterator();

   10，将集合转成数组：Object[] toArray();
       调用方式：元素类型 变量名 = 对象.toArray();

   11,指定泛型集合转成数组：<T> T[] toArray(T[] a);
      参数：泛型T作为元素类型即数组类型，new一个新T类型，并指定数组长度。数组长度最好与集合一致，所以用size()方法。
      调用方式：String[] arr = 对象.toArray( new String[对象.size()]);
*/