/*
1���������ɼ��ϡ����ǲ�����ɾ����Ϊ������Ԫ���ǹ̶��ġ�
2�����������Ԫ�ض��Ƕ�����ô��ɼ���ʱ�������е�Ԫ�ؾ�ֱ��ת���ɼ����е�Ԫ�ء�
3�����������Ԫ�ض��ǻ����������ͣ���ô�Ὣ�������ֵַ��Ϊ������Ԫ�ش��ڡ�

����java.util.*;
Arrays�෽����
	��������list���ϣ�static <T> List<T> asList(T... a) 

*/
import java.util.*;
class  java
{
	public static void main(String[] args) 
	{
		//String��������ӵ���Զ�װ����ƣ���������Ϊ����Ĵ��ڡ�
		String[] s = { "01", "02", "03", "04"};
		List<String> list = Arrays.asList(s);
		System.out.println(list);




		/*��ʾ������������ת���ϡ�
		int[] i = { 0, 3, 4, 8, 2};
		List<int> list = Arrays.asList(i);
		����������ַ�洢�������С�


		��������ǰ������е�Ԫ�ص�ַ�洢�������С�
		
		Integer[] i = { 0, 3, 4, 8, 2};
		List<Integer> list = Arrays.asList(i);
		System.out.println(list);
		*/
	}
}