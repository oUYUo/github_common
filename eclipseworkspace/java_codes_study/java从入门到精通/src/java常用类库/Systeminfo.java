package java≥£”√¿‡ø‚;
import java.util.*;
public class Systeminfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties sp =System.getProperties();
		Enumeration e =sp.propertyNames();
		while(e.hasMoreElements())
		{
			String key = (String)e.nextElement();
			System.out.println(key+"="+sp.getProperty(key));
		}
	}

}
