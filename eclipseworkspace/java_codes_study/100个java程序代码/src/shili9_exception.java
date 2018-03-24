class MyException extends Exception{
	public MyException(){}
	public MyException(String msg){
		super(msg);
	}
	public MyException(String msg,int x){
		super(msg);
		i=x;
	}
	public int val(){return i;}
	private int i;
	
}


public class shili9_exception {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Throwing MyException from b()");
	}
	public static void c() throws MyException{
		System.out.println("Throwing MyException from c()");
		throw new MyException("Priginated in c()",47);
	}
	public static 
}
