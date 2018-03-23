#include<stdio.h>
int main(){
	int t;
	int arr[6]={6,5,4,3,2,1 };
	printf("初始数组 ：");
	for(int i=0;i<6;i++)//输出初始数组 
	{
		printf("%d  ",arr[i]);	
	}
	printf("\n");
	 
	for(int i=0;i<6;i++)//外for循环开始 
	{
		
		for(int j=0;j<6-i-1;j++)
		{//内for循环开始 
			if(arr[j]>arr[j+1]) 
			{
				t=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=t;
			}
		}//内for循环结束 
		
			printf("第%d次排序：",i+1);	//用来输出每次排序后数组的情况	
			for(int i=0;i<6;i++)
			{
				printf("%d  ",arr[i]);
			}
		printf("\n");
	
	}//外for循环结束 
	printf("排序结束 ：");//输出排序后的结果 
	for(int i=0;i<6;i++){
		printf("%d  ",arr[i]); 
	}
} 
