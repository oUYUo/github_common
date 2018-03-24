
public class 异常处理 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=4,b=0;
		try
		{
			if(b==0)
			{
				throw new ArithmeticException("一个算术异常");
			}
			else
			{
				System.out.println(a+"/"+b+"="+a/b);	
			}
		}
			catch(ArithmeticException e)
			{
				System.out.println("抛出异常为："+e);
				
			}
	}

}
