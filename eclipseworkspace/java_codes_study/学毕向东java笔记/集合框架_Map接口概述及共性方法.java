/*
Map<K,V>�ӿڣ�
	K - ��ӳ����ά���ļ������͡�
	V - ӳ��ֵ�����͡�
	�⣺������Vֵ���ڱ�����K������

1��Map��java.util���
2������ӳ�䵽ֵ�Ķ���һ��ӳ�䲻�ܰ����ظ��ļ���ÿ�������ֻ��ӳ�䵽һ��ֵ��
3���������ظ�����Ϊ���൱�ڱ�ʶ����ֵ���ظ���
4���������ظ�Ԫ��ʱ����Ԫ�ػḲ�Ǿ�Ԫ�ء�
5���ײ�Ϊ��ϣ�����ݽṹ������ȥ���ظ�Ԫ��ֻ��ʵ�� Comparable �ӿڣ���дhashCode()��equals()��compareTo();
6���ײ�Ϊ���������ݽṹ������ȥ���ظ�Ԫ�أ�����ʵ�� Comparable �ӿ��� compareTo()��Ҳ���Ե���ʵ�� Comparator �ӿ��� compare()��
7��ע�⣺ʵ��Comparator�ӿڣ�ֻ���� ��������ʲô���ͣ�Comparator���;���ʲô���͡�

Map�ӿڹ��Է����� HasMap����ʾMap�ӿڷ�����
	1������ʵ������Map< String, String> map = new HashMap< String, String>();
	   ���ͣ����String���ͼ���ֵ��map���ϡ�
	   ����Map�ǽӿڣ�HashMapʵ����Map���Ϸ�����

	2�����Ԫ�أ�V put(K key, V value);
	   ����ֵ�����ɲ����ܡ����� key �Ƿ���ӳ���ϵ�� ���key��ӳ���ϵ���򷵻���ӳ���ֵ�����滻��ֵ�����keyӳ��value��null���򷵻�null��
	   ���÷�ʽ��������.put( ����, ֵ);

	3���жϼ��Ƿ���ڣ�boolean containsKey(Object key);
	   ���÷�ʽ��������.containsKey( ����);

	4���ж�ֵ�Ƿ���ڣ�boolean containsValue(Object value);
	   ���÷�ʽ��������.containsValue( ֵ);

	5��ɾ��Ԫ�أ�V remove(Object key);
	   ����ֵ�����ɲ����ܡ����ؼ�����ӳ���ֵ�������ֵ �� ���������ڣ��򷵻� null��
	   ���÷�ʽ��������.remove( ����);

	6����ȡԪ�أ�V get(Object key);
	   ����ֵ������ָ������ӳ���ֵ�������ֵ��������ڣ��򷵻�null��
	   ���÷�ʽ��������.get( ����);
	  
	7����ȡ����������ֵ��Collection<V> values();
	   ����ֵ��������Collection�ӿڣ������Ǹö�������Ӧ�ķ��ͣ����Ա��봴��Collection�������н��ܡ�
	   ���÷�ʽ��Collection< ֵ����> c =  ������.values();  ȡ��������c

	8����ȡ���������м���Set<K> keySet();
	   ����ֵ��������Set���ϣ��ǽ����м����ص�Set �У�Ȼ��ͨ��Set����������ȡ����
	   ���÷�ʽ��Set< ������> s = ������.keySet();
				 Iterator< ������> it = s.iterator();
				 while( it.hasNext())
				{
					System.out.println( it.next());
				}
	   ԭ����map����ת��set���ϣ���ͨ��������ȡ����

	9����ȡ���������м���ֵ��Set<Map.Entry<K,V>> entrySet();
	   ����ֵ������Set���ϣ�Map.Entry<K,V>���͡�
		   	   Map.Entry<K,V>����Map�ڲ���Entry�ӿڣ��Ǽ���ֵӳ�����ͣ���ͬ���֤����HashMap�ڲ�����ʵ�֡�
	   ���÷�ʽ��Set<Map.Entry< ������, ֵ����>> entrySet = ������.entrySet();
				 Iterator<Map.Entry< ������, ֵ����>> it = entrySet.iterator();
				 while( it.hasNext())
				 {
					Map.Entry< ������, ֵ����> me = it.next();	//����ֵӳ���ϵ�����ֹ�ϵ�Ǹ� Map.Entry ���͡�������ҪMap.Entry���ܡ�
					String key = me.getKet();	//Map�ӿڵ�Enntry�ڲ��ӿ����з�����
					String value = me.getValue();	//Map�ӿڵ�Enntry�ڲ��ӿ����з�����
				 }

------------------------------------------------------------------------------------------------------------------------------------------------

Map.Entry< K, V> �ӿڷ����� ��Map���ڲ��ӿڣ�Enntry
	1����ȡ��Ӧ�ļ���K getKey();
	   ����ֵ����Set���������趨�������͡�
	   ��ϵ��Map�ӿڵ�Set<Map.Entry<K,V>> entrySet()������
	   ���÷�ʽ��������.getKey();	����ο�Map�ӿڹ��Է����ڰ����

	2����ȡ��Ӧ��ֵ��V getValue();
	   ����ֵ����Set���������趨ֵ�����͡�
	   ��ϵ��Map�ӿڵ�Set<Map.Entry<K,V>> entrySet()������
	   ���÷�ʽ��������.getValue();	����ο�Map�ӿڹ��Է����ڰ����
*/

import java.util.*;
class java
{
	//��ȡ���������м���ֵ��Set<Map.Entry<K,V>> entrySet();ʵ��
	public static void main(String[] args) 
	{
		Map< Integer, String> map = new HashMap< Integer, String>();

		map.put( 1, "01");
		map.put( 2, "02");
		map.put( 2, "02");
		Set<Map.Entry< Integer, String>> entrySet = map.entrySet();

		Iterator<Map.Entry< Integer, String>> it = entrySet.iterator();

		while( it.hasNext())
		{
			Map.Entry< Integer, String> me = it.next();	//����ֵӳ���ϵ�����ֹ�ϵ�Ǹ� Map.Enntry ���͡�������ҪMap.Enntry���ܡ�
			Integer key = me.getKey();	//Map�ӿڵ�Enntry�ڲ��ӿ����з�����
			String value = me.getValue();	//Map�ӿڵ�Enntry�ڲ��ӿ����з�����
			System.out.println("key = " + key + " ------ value = " + value);
		}
	}
}