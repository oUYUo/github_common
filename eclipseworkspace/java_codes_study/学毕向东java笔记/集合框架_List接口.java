/*
java.util��
1��List<E>�������е�������ListIterator
2��ListIterator��Iterator���ӽӿڡ�
3��ֻ��ͨ��List���ϵ�listIterator������ȡ�ýӿڡ�


List<E>�ӿڣ����ǿ��Բ����Ǳ�ķ������Ǹ���ϵ���з�����
	1�����Ԫ�أ�void add(int index, E element);
	   ���÷�ʽ������.add( �Ǳ�, ���Ԫ��);

	2��ɾ��Ԫ�أ�void remove( int index);
	   ���÷�ʽ������.remove( �Ǳ�);

	3���޸�Ԫ�أ�void set( int index, E element);
	   ���÷�ʽ������.set( �Ǳ�, Ԫ���滻);

	4������Ԫ�أ�E get(int index);
	   ���÷�ʽ������.get( �Ǳ�);

	5��ͨ���������ݻ�ȡλ�ã�int indexOf( object o);
	   ���÷�ʽ������.intdexOf( ��������);

	6��ͨ��λ�û�ȡ�������ݣ� List subList(int fromIndex, int toIndex);
       ������fromIndex��ʼֵ��toIndex��βֵ������ͷ��������β��
	   ���÷�ʽ��List L = subList( �Ǳ�ͷ, �Ǳ�β);

	7��List���е�������ListIterator<E> listIterator();
	   ����ֵ������һ�� ListIterator<E> �ӿڡ�
	   ���÷�ʽ��ListIterator li = ����.listIterator();
*/