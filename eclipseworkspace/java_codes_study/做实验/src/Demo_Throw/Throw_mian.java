package Demo_Throw;

public class Throw_mian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Throws T=new Throws();
		try{
			T.pop();
		}catch(NegativeArraySizeException e)
		{
			System.out.println("出异常NegativeArraySizeException");
		}
		catch(Exception e)
		{
			System.out.println("出异常Exception");
		}
		
		
	}

}
