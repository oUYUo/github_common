/*
java.util��
���Ͽ��_LinedList�����з�����
    1�����Ԫ�ص���β����
		1.1 boolean add(E e);
			���÷�ʽ��LinedList link = new LinedList();  link.add( ���Ԫ��);

		1.2 boolean offer(E e)
			���÷�ʽ������.offer( ���Ԫ��);

	2������Ԫ�ص��б�ͷ����
		2.1 void addFirst(E e);
			���÷�ʽ������.addFirst( ���Ԫ��);

		2.2 boolean offerFirst(E e);
		    ���÷�ʽ������.offerFirst( ���Ԫ��);

	3�����Ԫ�ص���β����
		3.1 void addLast(E e);
			���÷�ʽ������.addLast( ���Ԫ��);

		3.2 boolean offerLast(E e);
			���÷�ʽ������.offerLast( ���Ԫ��);

	4��ȡ�б�ĵ�һ��Ԫ�أ�
		4.1 E getFirst();
			�쳣��������б�Ϊ�գ��׳� NoSuchElementException �쳣��
			���÷�ʽ������.getFirst();

		4.2 E peekFirst();
			����ֵ��������б�Ϊ�գ��򷵻� null��
			���÷�ʽ������.peekFirst();

	5��ȡ�б�����һ��Ԫ�أ�
		5.1 E getLast();
			�쳣��������б�Ϊ�գ��׳� NoSuchElementException �쳣��
			���÷�ʽ������.getLast();

		5.2 E peekLast();
			����ֵ��������б�Ϊ�գ��򷵻� null��
			���÷�ʽ������.peekLast();

	6��ȡ�б�Ԫ������int size();
	   ���÷�ʽ������.size();

	7��ɾ����ȡ�б��һ��Ԫ�أ�
		7.1 E removeFirst();
		    �쳣��������б�Ϊ�գ��׳� NoSuchElementException �쳣��
			���÷�ʽ������.removeFirst();

		7.2 E pollFirst();
		    ����ֵ��������б�Ϊ�գ��򷵻� null��
			���÷�ʽ������.removeFirst();

	8��ɾ����ȡ�б����һ��Ԫ�أ�
		8.1 E reomveLast();
			�쳣��������б�Ϊ�գ��׳� NoSuchElementException �쳣��
			���÷�ʽ������.reomveLast();

		8.2 E pollLast();
			����ֵ��������б�Ϊ�գ��򷵻� null��
			���÷�ʽ������.pollLast();

	9��������Ԫ�أ��򷵻� true��boolean isEmpty();
	   ��ϵ���˷����Ǽ̳й����ġ�
	   ���÷�ʽ������.isEmpty();
*/