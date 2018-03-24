
public class delete_blank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String blank=new String("    he llo   ");
		System.out.println(blank);
		String no_blank=blank.trim();
		System.out.println(no_blank);
		System.out.println(blank);
		String shortstr=blank.replaceAll("\\s","");
		System.out.println(shortstr);
		String Replace= blank.replace(" ","1");
		System.out.println(Replace);
	}

}
