
public class �쳣���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=4,b=0;
		try
		{
			if(b==0)
			{
				throw new ArithmeticException("һ�������쳣");
			}
			else
			{
				System.out.println(a+"/"+b+"="+a/b);	
			}
		}
			catch(ArithmeticException e)
			{
				System.out.println("�׳��쳣Ϊ��"+e);
				
			}
	}

}
