/*
泛型类：在定义类的后面加上参数，该参数就是泛型参数<>
1，当类中操作的引用数据类型不确定时，用泛型类完成。
2，早期定义OBject来完成扩展，但运行时可能会出现异常。
3，现在定义泛型来完成扩展，把运行时异常转移到编译时异常。
4，泛型类的对象明确操作具体类型后，所有要操作类型就已经固定了。
5，调用方式：Utils<String> u = new Utils<String>;
6，泛型类不可被静态方法使用。
*/

class Utils<QQ>	
{
	private QQ q;
	public void setObject(QQ q)
	{
		this.q = q;
	}

	public QQ getObject()
	{
		return q;
	}
}

class main
{
	public static void main(String[] agrs)
	{
		Utils<String> u = new Utils<String>();
		u.setObject("张三");
		String s = u.getObject();
	}
}