package cmd;

import java.io.IOException;

public class Demo_cmd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime rt = Runtime.getRuntime();
		Process p;
		try {
			System.out.println("try");
//			Runtime.getRuntime().exec("cmd /k start time");
//			Runtime.getRuntime().exec("cmd /?");
//			p = rt.exec("cmd.exe /k time");
//			System.out.println(p.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
