#include<stdio.h>
#include<stdlib.h>
typedef struct HNode *Heap;
typedef int Type;
struct HNode{
	Type *Data;
	int Size;
	int Capacity;
};

typedef Heap MaxHeap;
typedef Heap MinHeap; 

#define MAXDATA 1000

MaxHeap CreateHeap(int MaxSize)
{
	MaxHeap H =(MaxHeap)malloc(sizeof(struct HNode));
	H->Data=(Type*)malloc((MaxSize+1)*sizeof(Type));
	H->Size=0;
	H->Capacity=MaxSize;
	H->Data[0]=MAXDATA;
	
	return H;
	
}

bool IsFull(MaxHeap H){
	return (H->Size==H->Capacity);
}

bool Insert(MaxHeap H,Type X){
	int i;
	
	if(IsFull(H)){
		printf("最大堆已满");
		return false;
	}
	i=++H->Size;
	for(;H->Data[i/2]<X;i/=2)
		H->Data[i]=H->Data[i/2];
	H->Data[i]=X;
	return true;
}

bool IsEmpty(MaxHeap H){
	return (H->Size==0);
}

Type DeleteMax(MaxHeap H){
	int Parent,Child;
	Type MaxItem,X;
	
	if(IsEmpty(H))
	{
		printf("最大堆已为空");
		return -1;
	}
	MaxItem=H->Data[1];
	X=H->Data[H->Size--];
	for(Parent=1;Parent*2<=H->Size;Parent=Child){
		Child=Parent*2;
		if((Child!=H->Size)&&(H->Data[Child]<H->Data[Child+1]))
			Child++;
		if(X>=H->Data[Child]) break;
		else
			H->Data[Parent]=H->Data[Child];
	}
	H->Data[Parent]=X;
	
	return MaxItem;
}
int main(){
	MaxHeap test=CreateHeap(100);
	Insert(test,1);
	Insert(test,1123);
	Insert(test,1312);
	Insert(test,5);
	Insert(test,3);
	
	printf("%d",DeleteMax(test));
}





