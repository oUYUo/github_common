package java�������;
import java.util.*;
public class CalendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c1=Calendar.getInstance();
		System.out.println(c1.get(c1.YEAR)+"��"+(c1.get(c1.MONTH)+1)+"��"+c1.get(c1.DAY_OF_MONTH)+"��"+c1.get(c1.HOUR));
		c1.add(c1.DATE_OF_YEAR,230);
		
	
	
	}
	
	

}
