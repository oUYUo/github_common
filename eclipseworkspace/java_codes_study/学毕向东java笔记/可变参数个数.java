/*
1�������ʽ����������... ��������
2���ɱ������������б������档
*/

class java
{
	public static void main(String[] args) 
	{
		System.out.println( show( 3,5,6,8,9,6,3)); //���ݶ��ͬ���Ͳ�����
	}

	public static int show( int... add)  //��ʵ������������顣
	{
		int k = 0;
		for( int i = 0; i < add.length; i++)
		{
			k = k + add[i];
		}
		return k;
	}
}