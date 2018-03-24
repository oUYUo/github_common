package Thread_geek;

public class myRunable implements Runnable {
	private String name;
	public myRunable(String name){
		this.name =name;
		public void run()    
		{
		
			for (int i=0;i<100;i++)
			{
				System.out.println(name+":"+i);
			}
		}
	}

}
