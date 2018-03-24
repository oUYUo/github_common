package juzheng;

import java.lang.Math;
public class square {
//	public int arr[][]=new int[0][0];
//	
//	public square(int arr[][]){
//		this.arr=arr;
//	}
	
	
	public float sqrt(int[] arr1){
		float sum=0;
		for(float tmp:arr1){
			sum=sum+tmp*tmp;
		}
		return (float)(Math.sqrt(sum));
		
	}
	
	public  int cheng(int arr1[],int arr2[]){
		int sum= 0;
		int lon = arr1.length;
		for(int i=0;i<arr1.length;i++)
		{
			sum=sum+arr1[i]*arr2[i];
			
		}
		return sum; 
	}
	
	public float cos(int arr1[],int arr2[]){
		int upper = cheng(arr1,arr2);
		float lower = sqrt(arr1)*sqrt(arr2);
		return (float) (upper/lower);
		
	}
	
	
	public int[][] zhuanzhi(int arr[][]){
		int row = arr.length;
		int col = arr[0].length;
		int[][] arr2=new int[col][row];
		for(int i =0;i<row;i++){
			for(int j=0;j<col;j++){
				arr2[j][i]=arr[i][j];
			}
		}
		
		return arr2;
	}
	
	public float[][] all_people(int[][] arr){
		int row = arr.length;
		float[][] arr2=new float[row][row];
		for(int i =0;i<row;i++){
			for(int j =0;j<row;j++){
				arr2[i][j]=cos(arr[i],arr[j]);
			}
		}
		
		return arr2;
		
	}
	
	public float[][] all_book(int[][] arr){
		int[][] arr_zhuanzhi=zhuanzhi(arr);
		int row = arr_zhuanzhi.length;
		float[][] arr2=new float[row][row];
		for(int i =0;i<row;i++){
			for(int j =0;j<row;j++){
				arr2[i][j]=cos(arr_zhuanzhi[i],arr_zhuanzhi[j]);
			}
		}
		
		return arr2;
		
	}
	
	public void visualation(int[][] b,String str)
	{
		if(str=="people")
		{
			float[][] c=this.all_people(b);
			for(float[] tmps:c){
				for(float tmp:tmps){
					System.out.printf("%10s",tmp);
					System.out.print("\t");
				}
				System.out.println("");
			}
		}
		if(str=="book")
		{
			float[][] c=this.all_book(b);
			for(float[] tmps:c){
				for(float tmp:tmps){
					System.out.printf("%10s",tmp);
					System.out.print("\t");
				}
				System.out.println("");
			}
		}
		else
		{
			System.out.println("请输入book,或者输入people");
		}
		
	}
}
