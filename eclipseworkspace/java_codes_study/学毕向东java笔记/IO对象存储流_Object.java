/*
1，java.io.ObjInputStream;
2，ObjectOutputStream 是对象的序列化类，也就是存入对象文件的。
3，存储的对象必须要实现 Serializable 接口。 《该接口介绍请看下面笔记》
4，ObjInputStream类基本方法：
	1，构造方法，创建写入指定文件：ObjectOutputStream(OutputStream out)
	   调用方式：ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( "Person.Object"));

	2，存入对象到文件中：Object writeObject( Object obj);
	   特殊：存入多个对象时，反复调用此方法即可。
	   调用方式：oos.writeObject( new Person( "lisi", 20));

	3，关闭资源：void close()
	   调用方式：oos.close()

-------------------------- ObjectInputStream --------------------------

1，java.io.ObjectInputStream;
2,ObjectInputStream 是读取对象文件的。
3，对象读取要验证UID序列号是否正确，如果Person类修改了，再次读取，UID不一样，将会报错。
4，通过 Serializable 接口，可以自定义UID序列号，这样再读取时，将不会报错。
5，ObjectInputStream类基本方法：
	1，构造方法，创建读入指定文件：ObjectInputStream(InputStream in)
	   调用方式：ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.Object"));

	2，获取对象：Object readObject();
	   特殊：取出多个对象时，反复调用此方法可依次取出。
	   调用方式：Person p = (Person)ois.readObject();

	3，关闭资源：void close()
	   调用方式：oos.close()
	
------------------ Serializable ---------------------------------------------

1，Serializable是标记接口，被存储的对象需要实现它。
2，Serializable接口没有任何方法。
3，序列化常量：static final long serialVersionUID = 42L; 42L是long型的，可赋任何值。
4，uid随着类的改变而改变，保持uid唯一性就是 《选项3》。

--------------------- 序列化类共同要点 --------------------------------------

1，当Person类成员被 static、transient 修饰时，将不会被序列化。
   static：被它所修饰成员的不在推内存。
		现象：除了在定义时赋值，内部都无法进行赋值。
			  可在外部调用特有方法对其赋值。

   teansient：被它所修饰的成员在推内存中，但不会被序列化。
		现象：构造函数、内部都无法进行赋值。
			  可在外部调用特有方法对其赋值。

2，【注意事项】当一次性调用写读方法：country静态变量未被释放，所以结果是kr

						分两次运行：第一次运行写方法，kr被释放了，第二次运行是 cn

						原因：country 是静态的，不会被序列化。
*/

import java.io.*;
class ObjectIOS
{
	public static void main(String[] args) throws Exception
	{
		//ObjOutputStream();	
		ObjInputStream();

		/*
			当这两种方法同时运行，会出现数据异常 static
		*/
	}

	public static void ObjInputStream()throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.Object"));

		Person p = (Person)ois.readObject();

		System.out.println(p);
		ois.close();
	}

	public static void ObjOutputStream()throws IOException
	{
		ObjectOutputStream oos = 
			new ObjectOutputStream(new FileOutputStream("Person.Object"));

		oos.writeObject(new Person("lisi0",399,"kr"));

		oos.close();
	}
}

//-----------------------------------------------------------------------------------

class Person implements Serializable
{
	
	public static final long serialVersionUID = 42L;

	private String name;
	transient int age;
	static String country = "cn";
	Person(String name,int age,String country)
	{
		this.name = name;
		this.age = age;
		this.country = country;
	}
	public String toString()
	{
		return name+":"+age+":"+country;
	}
}