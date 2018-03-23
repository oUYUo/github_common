#include<stdio.h>
#include<queue> 
using namespace std;
void Arr(int len,int num[]){
	queue<int> T;	
	for(int i=0;i<len;i++)
	{
		T.push(num[i]);
	}
	for(int i=0;i<len;i++){
		while(num[i]!=1){
			if(num[i]%2==0) 
			{
				num[i]=num[i]/2; T.push(num[i]);
			}
			else
			{
				num[i]=(3*num[i]+1)/2; T.push(num[i]);
			}
		}
	}
	int len_T=T.size();
	int arr[len_T];
	for(int i=0;i<len_T;i++){
		arr[i]=T.front();
		T.pop();
	}
//	for(int i=0;i<len_T;i++){
//		printf("%d ",arr[i]);
//	}
	queue<int> one;
	int time;
	for(int i=0;i<len_T;i++){
		time=0;
		for(int j=0;j<len_T;j++){
			if(arr[i]!=arr[j]) time++;
		}
		if(time==(len_T-1)){
			one.push(arr[i]);
		}
	}
	
	while(!one.empty()){
		printf("%d ",one.front());
		one.pop();
	}
}

int main()
{
	queue<int> T;
	int len;
	printf("请输入样例长度：");
	scanf("%d",&len);
	printf("请输入数字:");
	int num[len];
	for(int i=0;i<len;i++){
		scanf("%d",&num[i]);
	}
	
	Arr(len,num);


}


//	int arr[1000]={NULL};
//	for(int i=0;i<len;i++){
//		arr[i]=num[i];
//	}
//	int index=len;
//	for(int i=0;i<len;i++){
//		while(num[i]!=1){
//			if(num[i]%2==0) 
//			{
//				num[i]=num[i]/2; arr[index]=num[i];index++;
//			}
//			else
//			{
//				num[i]=3*num[i]+1; arr[index]=num[i];index++;
//			}
//		}
//		int arr2[10]={0};
//		int index2=0;
//		int time=0;
//		for(int i=0;i<100;i++){
//			time=0;
//			for(int j=0;j<100;j++){
//				if(arr[i]!=0)
//				{
//					if(arr[i]!=arr[j])
//					{
//						time++;					
//					}
//					if(time==99){
//						arr2[index]=arr[i];
//						index2++;
//					}
//				 } 
//			}
//		}
//		for(int i=0;i<10;i++){
//			if(arr2[i]!=0){
//				printf("%d",arr2[i]);
//			}
//		}
//	}
