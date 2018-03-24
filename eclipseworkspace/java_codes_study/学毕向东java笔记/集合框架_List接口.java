/*
java.util包
1，List<E>集合特有迭代器：ListIterator
2，ListIterator是Iterator的子接口。
3，只能通过List集合的listIterator方法获取该接口。


List<E>接口：凡是可以操作角标的方法都是该体系特有方法。
	1，添加元素：void add(int index, E element);
	   调用方式：对象.add( 角标, 添加元素);

	2，删除元素：void remove( int index);
	   调用方式：对象.remove( 角标);

	3，修改元素：void set( int index, E element);
	   调用方式：对象.set( 角标, 元素替换);

	4，查找元素：E get(int index);
	   调用方式：对象.get( 角标);

	5，通过对象内容获取位置：int indexOf( object o);
	   调用方式：对象.intdexOf( 对象内容);

	6，通过位置获取对象内容： List subList(int fromIndex, int toIndex);
       参数：fromIndex起始值，toIndex结尾值。包含头，不包含尾。
	   调用方式：List L = subList( 角标头, 角标尾);

	7，List特有迭代器：ListIterator<E> listIterator();
	   返回值：返回一个 ListIterator<E> 接口。
	   调用方式：ListIterator li = 对象.listIterator();
*/