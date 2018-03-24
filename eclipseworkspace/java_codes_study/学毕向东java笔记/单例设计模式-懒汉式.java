/*
懒汉式存在安全隐患，通过加锁方式解决问题
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
	private Single(){};
	private static Single s = null;

	public static Single getInstance()
	{
		if( s == null)
			s == new Single();

/* 解决安全隐患，但是问题解决了，代码增多了，所以通常在实际开发时使用饿汉式。
		if(s==null) 
        { 
            synchronized(Single.class) 
            { 
                if(s==null) 
                    s = new Single(); 
            } 
        } 
*/
		return s;
	}
}