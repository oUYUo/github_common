/*
����java.util.*;
Collections ���Ϲ����ࡣ
1��Collections���Ǿ�̬������

Collections������
	1����List����Ԫ�ؽ�����Ȼ����static <T extends Comparable<? super T>> void sort(List<T> list) 
	   ������String�౾��ʵ����Comparable�ӿڡ�
	   ���÷�ʽ��List<String> list = new ArrayList<String>();
				 Collections.sort(list);

	2��List����ָ���Ƚ�������static <T> void sort(List<T> list, Comparator<? super T> c)
	   ������List<T>���ͣ�����List�����͵ļ��ϣ� �ٴ���ʵ��Comparator<List���ͻ��͵ĸ���>���ࡣ
	   ���÷�ʽ��List<String> list = new ArrayList<String>();
				 Collections.sort(list, ʵ��Comp�ıȽ���<String ��String�ĸ���>);

	3���۰����Ԫ�أ�static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) 
	   ����һ��List< ʵ��Comparable < ��T�������T��>>��Ҫ�������б�
	   ��������Ҫ���ҵ�Ԫ�ء�Ҫ�����ļ��� 
	   ����ֵ�����������������������򷵻� (-(�����) - 1)������� ������Ϊ���������б����һ�㡣�˼����ҵ�ʱ�����ص�ֵ�� >= 0�� �����ڷ��ظ��������ڷ���������
	   ���÷�ʽ��Collections.binarySearch( list<String>, String "����Ԫ��");	//����Ҫʵ�� Comparable�� ����Ԫ������ΪString��

	4������Ȼ˳��ȡԪ�����ֵ��static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll);
	   ���ͣ�T����̳�Object������ʵ�� Comparable< T �� T�ĸ���>
	   ������������ Collection���� ʵ�� Collection�����࣬���ķ����� T �� T �����ࡣ
	   ���÷�ʽ��List<String> list = new ArrayList<String>();
				 Collections.max( list);
	   ��⣺String����̳���Objecct,����ʵ����Comparable�ӿ� ; List��Collection�ӽӿڡ�

	5����ָ��˳��ȡԪ�����ֵ��static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp)
	   ���÷�ʽ����ڶ�����ͬ���������ϣ���һ���Ƚ�����

	6����ָ��Ԫ���滻List��������Ԫ�أ�static <T> void fill(List<? super T> list, T obj) 
	   ���÷�ʽ��Collections.fill( List���ϣ� �滻Ԫ��);

	7��ָ��Ԫ���滻�µ�Ԫ�أ�static <T> boolean replaceAll(List<T> list, T oldVal, T newVal)
	   ���÷�ʽ��Collections.replaceAll(List���ϣ� ��Ԫ�أ���Ԫ��);

	8����תList�б���Ԫ�ص�˳��static void reverse(List<?> list)
	   ���÷�ʽ��Collections.reverse(List����);

	9����תָ���б���Ԫ�أ�static <T> Comparator<T> reverseOrder() 
	   ���÷�ʽ��TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder())

   10����ָ���Ƚ�����תԪ�أ�static <T> Comparator<T> reverseOrder(Comparator<T> cmp)
       ����������һ��Comparator�ӿڱȽ�����
	   ���÷�ʽ��TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder( new Comp));

   11��List�б��ָ��λ�ô�����Ԫ�أ�static void swap(List<?> list, int i, int j)
       ���÷�ʽ��Collections.swap( list����, �Ǳ�A, �Ǳ�B);	//���Ǳ�AԪ���û��Ǳ�BԪ�ء��Ǳ�BԪ���û��Ǳ�AԪ�ء�

   12�������ָ���б���Ԫ�ؽ����û���static void shuffle(List<?> list) 
       ���÷�ʽ��Collections.shuffle( list);
*/