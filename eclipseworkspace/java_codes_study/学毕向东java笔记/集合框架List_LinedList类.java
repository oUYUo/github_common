/*
java.util包
集合框架_LinedList类特有方法：
    1，添加元素到结尾处：
		1.1 boolean add(E e);
			调用方式：LinedList link = new LinedList();  link.add( 添加元素);

		1.2 boolean offer(E e)
			调用方式：对象.offer( 添加元素);

	2，插入元素到列表开头处：
		2.1 void addFirst(E e);
			调用方式：对象.addFirst( 添加元素);

		2.2 boolean offerFirst(E e);
		    调用方式：对象.offerFirst( 添加元素);

	3，添加元素到结尾处：
		3.1 void addLast(E e);
			调用方式：对象.addLast( 添加元素);

		3.2 boolean offerLast(E e);
			调用方式：对象.offerLast( 添加元素);

	4，取列表的第一个元素：
		4.1 E getFirst();
			异常：如果此列表为空，抛出 NoSuchElementException 异常。
			调用方式：对象.getFirst();

		4.2 E peekFirst();
			返回值：如果此列表为空，则返回 null。
			调用方式：对象.peekFirst();

	5，取列表的最后一个元素：
		5.1 E getLast();
			异常：如果此列表为空，抛出 NoSuchElementException 异常。
			调用方式：对象.getLast();

		5.2 E peekLast();
			返回值：如果此列表为空，则返回 null。
			调用方式：对象.peekLast();

	6，取列表元素数：int size();
	   调用方式：对象.size();

	7，删除并取列表第一个元素：
		7.1 E removeFirst();
		    异常：如果此列表为空，抛出 NoSuchElementException 异常。
			调用方式：对象.removeFirst();

		7.2 E pollFirst();
		    返回值：如果此列表为空，则返回 null。
			调用方式：对象.removeFirst();

	8，删除并取列表最后一个元素：
		8.1 E reomveLast();
			异常：如果此列表为空，抛出 NoSuchElementException 异常。
			调用方式：对象.reomveLast();

		8.2 E pollLast();
			返回值：如果此列表为空，则返回 null。
			调用方式：对象.pollLast();

	9，不包含元素，则返回 true：boolean isEmpty();
	   关系：此方法是继承过来的。
	   调用方式：对象.isEmpty();
*/