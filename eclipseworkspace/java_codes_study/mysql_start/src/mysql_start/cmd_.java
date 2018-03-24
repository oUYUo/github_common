package mysql_start;

import java.io.IOException;

public class cmd_ {
	private int time_close;
	public void settime(int time){
		this.time_close=time;
		
	}
	public void SHUTDOWN(){
		Runtime rt =Runtime.getRuntime();
		
		try {
			rt.exec("cmd /c shutdown -s -t "+time_close);
			System.out.println("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CANCEL(){
		Runtime rt =Runtime.getRuntime();
		
		try {
			rt.exec("cmd /c shutdown -a ");
			System.out.println("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

}
