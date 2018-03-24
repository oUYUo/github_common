package ÒøÐÐ;

public class SyncThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Bank bank =new Bank();
		Thread tadd =new Thread(new Runnable(){
			public void run()
			{
				while(true)
				{
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					bank.subMoney(100);
					bank.lookMoney();
					System.out.println("\n");
					tr
				}
			}
		}
	}

}
