/*
import java.util.Date��;
Date�෽��������ʱ����Calendar������ȡ�������ַ�����ʾ��
	1�����췽�������󷵻ؿ�����ʱ���ֶΣ�Date()
	   ���÷�ʽ��Date d = new Date();

----------------------------------------------------------

import java.text.SimpleDateFormat��;
y  ��				M  ���е��·�		w  ���е�����				W  �·��е�����				D  ���е�����						d  �·��е�����
F  �·��е�����		E  �����е�����		H  һ���е�Сʱ����0-23��	k  һ���е�Сʱ����1-24��	K  am/pm �е�Сʱ����0-11��			h  am/pm �е�Сʱ����1-12��		
m  Сʱ�еķ�����	s  �����е�����		S  ������

SimpleDateFormat����������
	1������ģʽ���캯����SimpleDateFormat(String pattern)
	   ������"yyyy��MM��dd��" ���������ṩ�ı����������ڸ�ʽ������Ҫȡʲô�����Ǿ�����ʲô������"yyyy��"����ô���ֻ�����ꡣ
	   ���÷�ʽ��SimpleDateFormat sf = new SimpleDateFormat( "yyyy��MM��dd��");
	
	2����ʽ������ʱ�䣺StringBuffer format(Date date) 
	   ������ʹ�ù��췽�����ú����ڸ�ʽ���ٴ��� Date�����ص�ʱ�䣬Date�����ݵ������
	   ���÷�ʽ��String sb = ����.format( data����);

--------------------------------------------------------------------------------------------------
import java.util.Calendar��
Calendar�����������ֶα�YEAR��   MONTH��   DAY_OF_MONTH��   DAY_OF_WEEK����   HOUR_OF_DAYСʱ   MINUTE����   MILLISECOND����
1��������·��Ǵ�0�·ݿ�ʼ�ģ�0��Ҳ����1�¡�
2������������ǣ�������������һ��
Calendar�������з�����
    1��ʹ��Ĭ��ʱ�������Ի������һ��������static Calendar getInstance()
	   ���ã��൱�ڴ������ڶ���
	   ���÷�ʽ��Calendar c = Calendar.getInstance();

	2����ȡ�������ֶε�ֵ��int get(int field)
	   ���÷�ʽ������.get( Calendar.YEAR);  //��ȡ���ꡣ
	   �������ֶ��Ǿ�̬�ģ�ͨ���������á�getInstance()��������һ��������ͨ������������ݡ�

	3�����������գ�void set(int year, int month, int date) 
	   ���÷�ʽ������.set( ��, ��, ��);

	4����ӻ��ȥָ����ʱ������abstract void add(int field, int amount)
	   ������field�������ֶΣ���amount��ƫ��������
	   ���÷�ʽ������.( Calendar.YEAR, -4); //����ǰ������ȥ4�ꡣ

-------------------------------------------------------------------------------------------------

С��ϰ��
1����ȡ�������2���ж����졣
2����ȡ���������ʱ�̡�

*/
import java.util.*;
class java
{
	public static void main(String args[])
	{
		Calendar c = Calendar.getInstance();
		//System.out.println(nian(c,2014));
		//System.out.println(shi(c));
	}

	static int nian(Calendar c, int n)
	{
		c.set( n, 2, 1); //ĳһ���3��1��   �������0�¿�ʼ�� 2��Ҳ����3��
		c.add( Calendar.DAY_OF_MONTH, -1);  //��3��1�ռ�1����ô����2�µ����һ�졣

		return c.get( Calendar.DAY_OF_MONTH);
	}

	static String shi(Calendar c)
	{
		c.add( Calendar.DAY_OF_MONTH, -1);
		return c.get( Calendar.DAY_OF_MONTH ) + "��" +
		c.get( Calendar.HOUR_OF_DAY ) + "ʱ" + 
		c.get( Calendar.MINUTE) + "��" +
		c.get( Calendar.MILLISECOND)+ "��";
	}
}