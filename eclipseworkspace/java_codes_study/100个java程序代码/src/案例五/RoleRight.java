package °¸ÀýÎå;
import java.util.*;
public class RoleRight {
private static Hashtable rightList= new Hashtable();

}

public void init()
{
	String[] accRoleList = {"admin","satrap","manager","user","guest"};
	String[] rightCodeList ={"10001","10011","10021","20011","24011"};
	for(int i =0;i<accRoleList.length;i++)
	{
		rightList.put(accRoleList[i],rightCodeList[i]);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
