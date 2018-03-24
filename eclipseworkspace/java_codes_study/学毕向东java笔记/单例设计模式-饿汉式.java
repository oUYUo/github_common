/*	开发用饿汉式
设计模式：解决某一类问题最行之有效的方法。
java中23种设计模式：
单例设计模式：解决一个类在内存只存在一个对象。
2、
想要保证对象唯一
1）为了避免其它程序过多地建立该类对象，先禁止其他程序建立该类对象。
2）还为了让其他程序可以访问到该类对象，只好在本类中，自定义一个对象。
3）为了方便其他程序对自定义对象的访问，可以对外提供一些访问方式。
这三部怎么用代码体现呢？
1）将构造函数私有话。
2）在类中创建一个本类对象
3）提供一个方法可以获取到该类对象
对于事物该怎么描述，还怎么描述
当需要将该事物的对象保证在内存中唯一时，就将以上的三步加上即可。
*/

class  
{
	public static void main(String[] args) 
	{
		Single s = Single.getInstance();
	}
}

class Single
{
	private Single(){}	//将构造函数私有化，防止外界创建对象。
	private static Single s = new Single();	//S静态引用，指向对象，这句话是随着类的加载而创建对象的。

	public static Single getInstance()
	{
		return s;
	}
}