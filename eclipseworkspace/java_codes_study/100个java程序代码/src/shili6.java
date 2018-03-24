class tree
{
	public void root()
	{
		String sSite ="土壤中";
		String sFunction="吸收养分";
		print("位置"+sSite);
		print("功能"+sFunction);
	}
	public void bolo()
	{
		String sSite="地面";
		String sFunction="传递养分";
		print("位置"+sSite);
		print("功能"+sFunction);
	}
	public void print(Object oPara)	
	{
		System.out.println(oPara);
	}
}
class grass extends tree{
	public void root(){
		super.root();
		String fire="着火了";
		print("gongneng"+fire);
		
	}
}
public class shili6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tree t =  new tree();
	
		grass g = new grass();
		g.root();
		g.bolo();
		
	}

}
