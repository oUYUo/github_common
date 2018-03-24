package 银行;

public class Bank {
	private int count=0;//账户余额
		
		
	public void addMoney(int money){
			count+=money;
			System.out.println(System.currentTimeMillis()+"存进"+money);
	}
		
	public void subMoney(int money){
		if(count-money <0){
			System.out.println("余额不足");
			return;
		}
		count-=money;
		System.out.println(System.currentTimeMillis()+"取出"+money);
			
	}
		
		
	public void lookMoney(){
		System.out.println("账户余额"+count);
			
	}
}
