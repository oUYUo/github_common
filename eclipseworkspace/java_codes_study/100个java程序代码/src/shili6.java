class tree
{
	public void root()
	{
		String sSite ="������";
		String sFunction="��������";
		print("λ��"+sSite);
		print("����"+sFunction);
	}
	public void bolo()
	{
		String sSite="����";
		String sFunction="��������";
		print("λ��"+sSite);
		print("����"+sFunction);
	}
	public void print(Object oPara)	
	{
		System.out.println(oPara);
	}
}
class grass extends tree{
	public void root(){
		super.root();
		String fire="�Ż���";
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
