
public class compare_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = new String("tom");
		String dbValue = new String("tom");
		String dbValue2 = new String("TOM");
		System.out.println(name==dbValue);
		String name_ = "tom";
		String dbValue_ = "tom";
		System.out.println(name_==dbValue_);
//		����ȣ�˫�����жϵĶ����ַ
		boolean bool = name.equals(dbValue);
		System.out.println(bool);
		boolean bool3 = name.equalsIgnoreCase(dbValue);
		boolean bool2 = name.equalsIgnoreCase(dbValue2);
		System.out.println(bool2);
	}	

}
