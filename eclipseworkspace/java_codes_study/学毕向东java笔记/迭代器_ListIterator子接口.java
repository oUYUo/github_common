/*
java.util��
1��ListIterator��List�������еĵ�������
2��ListIterator��Iterator���ӽӿڡ�
3��ListIterator���Զ�Ԫ�أ���ӣ��޸ĵȲ�����


�ӿ� ListIterator<E> List���е�����
	1�����Ԫ�أ�void add(E e);
	   ���÷�ʽ��ͨ��List�ӿڵ�listIterator();��������ListIterator<E>���� ����.add( Ԫ��);
	
	2�������ж��Ƿ���Ԫ�أ�boolean hasNext();
	   ���÷�ʽ������.hasNext();

	3�������ж��Ƿ���Ԫ�أ�boolean hasPrevious();
	   ���⣺�б�ָ��Ĭ��ָ���һ��Ԫ�ص�ǰ�棬Ҫ��ʹ������ָ��ǰ�������Ԫ�ء�
	   ���÷�ʽ������.hasPrevious();

	4�������б��е���һ��Ԫ�أ�E next();
	   ���÷�ʽ������.next();

	5�������б��е�ǰһ��Ԫ�أ�E previous();
	   ��ϵ��ͨ��hasPrevious();�����жϣ�����previous();����Ԫ�ء�
	   ���÷�ʽ������.previous();

	6��ɾ��Ԫ�أ�void remove(); �� next �� previous ���ص����һ��Ԫ�ء�
	   ���÷�ʽ������.remove();

	7���޸�Ԫ�أ�void set(E e);  next �� previous ���ص����һ��Ԫ�ء�
	   ���÷�ʽ������.set( �滻Ԫ��);
*/