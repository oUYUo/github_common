/*
java.util包
1，ListIterator是List集合特有的迭代器。
2，ListIterator是Iterator的子接口。
3，ListIterator可以对元素：添加，修改等操作。


接口 ListIterator<E> List特有迭代器
	1，添加元素：void add(E e);
	   调用方式：通过List接口的listIterator();方法创建ListIterator<E>对象。 对象.add( 元素);
	
	2，正向判断是否有元素：boolean hasNext();
	   调用方式：对象.hasNext();

	3，逆向判断是否有元素：boolean hasPrevious();
	   特殊：列表指针默认指向第一个元素的前面，要想使用逆向，指针前面必须有元素。
	   调用方式：对象.hasPrevious();

	4，返回列表中的下一个元素：E next();
	   调用方式：对象.next();

	5，返回列表中的前一个元素：E previous();
	   关系：通过hasPrevious();逆向判断，利用previous();返回元素。
	   调用方式：对象.previous();

	6，删除元素：void remove(); 由 next 或 previous 返回的最后一个元素。
	   调用方式：对象.remove();

	7，修改元素：void set(E e);  next 或 previous 返回的最后一个元素。
	   调用方式：对象.set( 替换元素);
*/