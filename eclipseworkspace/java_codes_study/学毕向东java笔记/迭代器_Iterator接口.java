/*
java.util包
1，迭代器：其实就是集合取出元素的方式。
2，在迭代时，不可以通过集合对象的方法操作集合中的元素，因为会发生ConcurrentModificationException异常。
3，Iterator迭代器只能对元素进行判断，取出，删除的操作。


Iterator接口：迭代器接口。一次性操作（被next取出后，元素则不存在Iterator）
	1，取出列表下一个元素：E next();
	   特殊：有多少个next();，那么就会依次取出多少个集合元素。
	   调用方式：对象.next();

	2，判断是否有元素：boolean hasNext();
	   调用方式：对象.hasNext();

	3，移除迭代器返回的最后一个元素：void.remove()
	   详解：next()返回的元素，利用remove删除该元素。
	   实例：对象.next(); 对象.remove(); --> 删除了next所返回的元素。
	   特殊：集合与迭代器同步。
	   调用方式：对象.remove();
*/

