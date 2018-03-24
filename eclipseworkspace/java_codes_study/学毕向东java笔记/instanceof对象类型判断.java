/*
instanceof 格式： 对象 instanceof 类类型名。
1，判断实例对象类型是否相同。
2，判断子对象类型是否相同。
实例：判断引用，a instanceof Cat 判断a的引用是否为Cat类类型，返回boolean类型。
*/

class java
{
	public static void main(String[] args)
	{
		mak k = new mak();
		mab b = new mab();

		Object obj = new mak();

	/* 判断k引用类型是否是mak类型。
		System.out.println( k instanceof mak); 结果 true，符合第一项条件。

------------------------------------------------------------------------------------

		判断k引用类型是否是mab类型。
		System.out.println( k instanceof mab); 结果 true，符合第二项条件。

-------------------------------------------------------------------------------------
		
		判断obj指向的引用类型是否为mab。
		System.out.println( obj instanceof mab); 结果 true，符合第二项条件。
		特别说明：obj接受mak，从而obj指向mak。而mak继承了mab。 

		判断 b引用类型是否为mak
		System.out.println( b instanceof mak); 结果false。
		特别说明：mab(b)并不具备子类特征。
	*/
	}
}

class mak extends mab
{
}

class mab
{
}