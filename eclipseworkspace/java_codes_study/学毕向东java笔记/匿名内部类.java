/*
匿名内部类：
1，匿名内部类其实就是内部类的简写格式。
2，定义匿名内部类的前提：
		内部类必须是继承一个类或实现接口。
3，匿名内部类的格式： new 父类 或者接口(){ 方法体 }.调用方法();
4，当匿名内部类为父类类或接口型时，只能调用父类或接口方法，如下：
			父类或接口名.对象名 = new 父类或接口名();     ------->这属于向上转型。
*/

class main
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}

interface face_test
{
	void tes();
}

class test
{
	//匿名内部类调用1。
	new face_test()
	{
		void tes(){}
		void tek(){}
	
	}.tes();

	//匿名内部类调用方法2
	face_test in = new face_test()
	{
		void tes(){}
		//这里就不能定义tek了，因为这是向上转型。
	}
	in.tes();
}