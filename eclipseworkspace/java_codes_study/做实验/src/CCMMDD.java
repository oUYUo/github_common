import java.io.IOException;

public class CCMMDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime rt =Runtime.getRuntime();
		
		try {
			rt.exec("cmd /k start mysql -uroot -psz869993410");
			System.out.println("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
