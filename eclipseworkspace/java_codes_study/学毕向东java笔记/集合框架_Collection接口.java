/*
java.util��
��ӡ�������ݣ�ֱ�ӵ��ö����ӡ��

Collection<E>�ӿڹ��Է����� 
	1�����Ԫ�أ�void add( E e);
   	   ���÷�ʽ������.add( ���Ԫ��);
	  
	2����ȡ���ϳ�Ա����int size();
	   ���÷�ʽ������.size();

	3��ɾ��Ԫ�أ�boolean remove( Object o);
	   ���÷�ʽ������.remove( ����Ԫ��);

	4����ռ��ϣ�void clear();
	   ���÷�ʽ������.clear();

	5���ж�Ԫ���Ƿ���ڣ�boolean contains( Object o);
	   ���÷�ʽ������.contains( ����Ԫ��);

	6���жϼ����Ƿ�Ϊ�գ�boolean isEmpty();
	   ���÷�ʽ������.isEmpty();

	7��ȡ��������������������ͬԪ�أ�void retainAll( Collection<?> c);
	   ���÷�ʽ������1.retainAll( ����2);

	8��ȥ������ȥ������������ͬԪ�أ�void removeAll( Collection<?> c);
	   ���÷�ʽ������1.removeAll( ����2);

    9����ȡ������������ȡ������Ԫ�أ�Iterator iterator();
       ���⣺�õ��� Iterator �ӿڡ�
	   ���÷�ʽ��Iterator it = ����.iterator();

   10��������ת�����飺Object[] toArray();
       ���÷�ʽ��Ԫ������ ������ = ����.toArray();

   11,ָ�����ͼ���ת�����飺<T> T[] toArray(T[] a);
      ����������T��ΪԪ�����ͼ��������ͣ�newһ����T���ͣ���ָ�����鳤�ȡ����鳤������뼯��һ�£�������size()������
      ���÷�ʽ��String[] arr = ����.toArray( new String[����.size()]);
*/