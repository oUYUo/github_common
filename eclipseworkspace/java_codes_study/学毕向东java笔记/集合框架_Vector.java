/*
java.util包
1，枚举就是Vector特有取出方式，和迭代是一样的。
2，因为枚举方法名称过长，被迭代器取代了。

Vector类中常见方法：
	1，添加元素：boolean add(E e);
	   调用方式：Vector v = new Vector(); v.add(添加元素);
	
	2，创建Vector枚举迭代器：Enumeration<E> elements();
	   调用方式：Enumeration en = v.elements();
*/

class  
{
	public static void main(String[] args) 
	{
		Vector v = new Vector();

		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");

		Enumeration en = v.elements();
	}
}
