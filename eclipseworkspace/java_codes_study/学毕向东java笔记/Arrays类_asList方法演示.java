/*
1，将数组变成集合。但是不能增删，因为数组中元素是固定的。
2，如果数组中元素都是对象。那么变成集合时，数组中的元素就直接转换成集合中的元素。
3，如果数组中元素都是基本数据类型，那么会将该数组地址值作为集合中元素存在。

包：java.util.*;
Arrays类方法：
	将数组变成list集合：static <T> List<T> asList(T... a) 

*/
import java.util.*;
class  java
{
	public static void main(String[] args) 
	{
		//String数据类型拥有自动装箱机制，所以是作为对象的存在。
		String[] s = { "01", "02", "03", "04"};
		List<String> list = Arrays.asList(s);
		System.out.println(list);




		/*演示基本数据类型转集合。
		int[] i = { 0, 3, 4, 8, 2};
		List<int> list = Arrays.asList(i);
		将会把数组地址存储到集合中。


		下面代码是把数组中的元素地址存储到集合中。
		
		Integer[] i = { 0, 3, 4, 8, 2};
		List<Integer> list = Arrays.asList(i);
		System.out.println(list);
		*/
	}
}