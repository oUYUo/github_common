/*
正则练习：
192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30
要求：按ip地址字段排序
*/

import java.util.*;
class  
{
	public static void main(String[] args) 
	{
		String sre = "192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30";

		sre = sre.replaceAll( "(\\d+)", "00$1");

		sre = sre.replaceAll( "0*(\\d{3})", "$1");

		String[] sra = sre.split( " ");

		TreeSet<String> t = new TreeSet<String>();

		for( String s : sra)
			t.add(s);

		for(String s : t)
			System.out.println( s.replaceAll( "0*(\\d)", "$1"));
	}
}
