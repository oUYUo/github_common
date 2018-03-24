//import java.sql.Date;
import java.util.Date;

//import javax.xml.crypto.Data;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 =String.format("字母x大写：%c", 'X');
		System.out.println(str1);
		System.out.println(String.format("%d", 123+123));
		System.out.println(String.format("pai %.2f",Math.PI));
		System.out.println(String.format("%b", 2<3));
		System.out.println(String.format("%e", 1200000000000000.1));
		System.out.println(String.format("天才是由百分之%d%%的灵感和%d%%的汗水", 1,99));
		
		Date date = new Date();
		String str_date = String.format("%tF", date);
		System.out.println(str_date);
		System.out.println(date);
		
		String year = String.format("%tY", date);
		String date_ = String.format("%td", date);
		System.out.println(year);
		System.out.println(date_);

		String str_split="abc,abc,abc";
		String[] setArray=str_split.split(",");
		for (String tmp:setArray){
			System.out.println(tmp);
		}
		String ip ="193.123.34.56";
		String[] ipArray =ip.split("\\.",2);
		for (String tmp:ipArray){
			System.out.println(tmp);
		}
		String upper ="asdSDFSDF";
		System.out.println(upper.toLowerCase());
		System.out.println(upper.toUpperCase());
		
		}

}
