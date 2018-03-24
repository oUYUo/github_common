/*
泛型接口：将泛型定义在接口上。
1,实现方式：
	1.1 明确操作泛型类型：class InterImpl implements Inter<String> 
		调用方式：InterImpl it = new InterImpl();

	1.2 不明确操作的泛型：class InterImpl<T> implements Inter<T>
		调用方式：InterImpl<String> it = new InterImpl<String>();
*/

interface Inter<T>
{
	void show(T t);
}

class InterImpl implements Inter<String> 
{
	public void show(String s)
	{
		System.out.println(s);
	}
}

class InterIp<T> implements Inter<T> 
{
	public void show(T t)
	{
		System.out.println(t);
	}
}

class main
{
	public static void main(String[] args) 
	{
		InterImpl it = new InterImpl().show("haha");
		InterIp<String> ip = new InterIp<String>().show("hhh"); 
	}
}
