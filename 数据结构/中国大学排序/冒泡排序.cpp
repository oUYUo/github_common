#include<stdio.h>
int main(){
	int t;
	int arr[6]={6,5,4,3,2,1 };
	printf("��ʼ���� ��");
	for(int i=0;i<6;i++)//�����ʼ���� 
	{
		printf("%d  ",arr[i]);	
	}
	printf("\n");
	 
	for(int i=0;i<6;i++)//��forѭ����ʼ 
	{
		
		for(int j=0;j<6-i-1;j++)
		{//��forѭ����ʼ 
			if(arr[j]>arr[j+1]) 
			{
				t=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=t;
			}
		}//��forѭ������ 
		
			printf("��%d������",i+1);	//�������ÿ���������������	
			for(int i=0;i<6;i++)
			{
				printf("%d  ",arr[i]);
			}
		printf("\n");
	
	}//��forѭ������ 
	printf("������� ��");//��������Ľ�� 
	for(int i=0;i<6;i++){
		printf("%d  ",arr[i]); 
	}
} 
