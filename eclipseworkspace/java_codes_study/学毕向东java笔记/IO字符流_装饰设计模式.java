/*
装饰设计模式：
当想要对已有的对象进行功能增强时，
可以定义类，将已有对象传入，基于已有的功能，并提供加强功能。
那么自定义的该类称为装饰类。

装饰类通常会通过构造方法接收被装饰的对象。
并基于被装饰的对象的功能，提供更强的功能。

--------------------------------------------------------------------------------

继承设计思想：
	MyReader//专门用于读取数据的类。
		|--MyTextReader		//数据操作类型：播放
			|--MyBufferTextReader	//缓冲区
		|--MyMediaReader	//文件
			|--MyBufferMediaReader
		|--MyDataReader
			|--MyBufferDataReader

	class MyBufferReader
	{
		MyBufferReader(MyTextReader text)
		{}
		MyBufferReader(MyMediaReader media)
		{}
	}

上面这个类扩展性很差。

装饰设计模式：发现找到其参数的共同类型。通过多态的形式。可以提高扩展性。

	MyReader//专门用于读取数据的类。
		|--MyTextReader
		|--MyMediaReader
		|--MyDataReader
		|--MyBufferReader

	class MyBufferReader extends MyReader
	{
		private MyReader r;
		MyBufferReader(MyReader r)
		{}
	}	

以前是通过继承将每一个子类都具备缓冲功能。
那么继承体系会复杂，并不利于扩展。

现在优化思想。单独描述一下缓冲内容。
将需要被缓冲的对象。传递进来。也就是，谁需要被缓冲，谁就作为参数传递给缓冲区。
这样继承体系就变得很简单。优化了体系结构。


装饰模式比继承要灵活，避免了继承体系臃肿，而且降低了类于类之间的关系。

装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能。
所以装饰类和被装饰类通常是都属于一个体系中的。
*/

class Person
{
	public void chifan()
	{
		System.out.println("吃饭");
	}
}

class SuperPerson
{
	private Person p;
	SuperPerson( Person p)
	{
		this.p = p;
	}

	public void superChifan()
	{
		System.out.println( "开胃酒");
		p.chifan();
		System.out.println( "甜点");
		System.out.println( "来一根");
	}
}

class java
{
	public static void main(String args[])
	{
		SuperPerson sp = new SuperPerson( new Person());
		sp.superChifan();
	}
}