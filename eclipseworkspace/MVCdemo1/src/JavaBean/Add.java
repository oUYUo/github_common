package JavaBean;

public class Add {
	private int a;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	private int b;
	public Add(){};
	public Add(int a ,int b)
	{
		this.a=a;
		this.b=b;
	}
	public int sum(){
		int c,s=0;
		if(a>b){c=a;a=b;b=c;}
		for(int i=a;i<=b;i++){
				s+=i;
		}
		return s;
	}
	
	
}
