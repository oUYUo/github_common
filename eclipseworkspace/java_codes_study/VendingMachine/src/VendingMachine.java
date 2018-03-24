
public class VendingMachine {
	int price =80;
	int balance;
	int total;
	
	void showPrompt(){
		System.out.println("Weclome");
		
	}
	void insertMoney(int amount){
		balance =balance+amount;
	}
	void showBalance(){
		System.out.println(balance);
	}
	void getFood(){
		if (balance>=price){
			System.out.println("here you are");
			balance = balance-price;
			total = total-price;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine vm = new VendingMachine();
		vm.showPrompt();
		vm.showBalance();
		vm.insertMoney(100);
		vm.getFood();
		vm.showBalance();
	}

}
