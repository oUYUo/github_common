package ����;

public class Bank {
	private int count=0;//�˻����
		
		
	public void addMoney(int money){
			count+=money;
			System.out.println(System.currentTimeMillis()+"���"+money);
	}
		
	public void subMoney(int money){
		if(count-money <0){
			System.out.println("����");
			return;
		}
		count-=money;
		System.out.println(System.currentTimeMillis()+"ȡ��"+money);
			
	}
		
		
	public void lookMoney(){
		System.out.println("�˻����"+count);
			
	}
}
