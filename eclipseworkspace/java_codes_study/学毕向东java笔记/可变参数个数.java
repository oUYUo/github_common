/*
1，定义格式：参数类型... 变量名。
2，可变参数定义参数列表的最后面。
*/

class java
{
	public static void main(String[] args) 
	{
		System.out.println( show( 3,5,6,8,9,6,3)); //传递多个同类型参数。
	}

	public static int show( int... add)  //其实这参数就是数组。
	{
		int k = 0;
		for( int i = 0; i < add.length; i++)
		{
			k = k + add[i];
		}
		return k;
	}
}