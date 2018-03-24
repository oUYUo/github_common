import java.util.Arrays;

public class shuzu {

	public static void main(String[] args) {

		char poem[][]=new char[4][];
		poem[0] = new char[]{'春','眠','不','觉','晓'};
		poem[1] = new char[]{'处','处','闻','啼','鸟'};
		poem[2] = new char[]{'夜','来','风','雨','声'};
		poem[3]	= new char[]{'花','落','知','多','少'};
//		System.out.println(poem[1].length);
//		for( int i =0;i<poem.length;i++)
//		{
//			
//			for(int j=0;j<poem[i].length;j++)
//			{
//				System.out.print(poem[i][j]);
//			}
//			if(i%2==0){
//				System.out.println(",");
//			}
//			else{
//				System.out.println("。");
//			}
//			System.out.println("");
//		}
		for(char a[]:poem)
		{
			for(char b:a){
				System.out.println(b);
			}
		}
		
		int arr[]={1,2,3,4,5};
		int bc[]=arr;
		for(int tmp:bc){
			System.out.println(tmp);
		}
		int bb[] =Arrays.copyOf(arr, 5);
		for(int tmp:bb){
			System.out.println(tmp);
		}
		
	}

}
