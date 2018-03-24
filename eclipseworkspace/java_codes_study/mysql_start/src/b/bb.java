package b;

import java.io.IOException;

public class bb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Runtime rt =Runtime.getRuntime();
			
			try {
				rt.exec("cmd /k shutdown -s -t 1800");
				System.out.println("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

}
