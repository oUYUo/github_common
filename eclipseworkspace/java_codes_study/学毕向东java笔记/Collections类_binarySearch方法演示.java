//����ֵ�����������������������򷵻� (-(�����) - 1)������� ������Ϊ���������б����һ�㡣�˼����ҵ�ʱ�����ص�ֵ�� >= 0�� �����ڷ��ظ��������ڷ���������
//����ʵ��������String����Stringʵ���� Comparable �ȽϽӿڣ����Գ���Ա��������ʵ��Comparable�ȽϽӿڡ�
import java.util.*;
class  CollectionsDemo
{
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();

		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		list.add("qq");
		list.add("z");

		int index = Collections.binarySearch(list,"aaaa");
		System.out.println(index);
	}

/*	ʵ�� binarySearch ԭ�������۰���ҡ�
	public static int halfSearch(List<String> list,String key)
	{
		int max,min,mid;
		max = list.size()-1;
		min = 0;

		while(min<=max)
		{
			mid = (max+min)>>1;//  /2;

			String str = list.get(mid);

			int num = str.compareTo(key);
			if(num>0)
				max = mid -1;
			else if(num<0)
				min = mid + 1;
			else
				return mid;
		}
		return -min-1;
	}
*/
}