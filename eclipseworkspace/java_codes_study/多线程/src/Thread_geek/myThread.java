package Thread_geek;

public class myThread extends Thread {
	private String name;
	public myThread(String name){
		this.name = name;
		
	}
	public void run(){
		super.run();
		for(int i=0;i<1000;i++)
		{
			System.out.println(name+":"+i);
		}
	}

}
