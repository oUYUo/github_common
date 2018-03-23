#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <typeinfo>
#include <stdio.h>
#include <queue>
#include<windows.h>

#define length 34																									//		-------------------------------------------

using namespace std;

struct Graph{
 	int *head=new int[length];   //顶点集 
 	float  *edge=new float[(length*length-length)/2];		//边集合 
};

	//如何根据行和列在一维数组中对应值
float getElement(int hang,int lie,float *arr){			//从数组中取出元素，如果数组越界则返回0   行列的索引从一开始 
	if(((hang>length)||(hang<1))||((lie>length)||(lie<1))) 
	{
		return 0;
	}
	else{
		if(hang==lie)
		{
			return 0;
		}
		if(hang>lie){
			int index=(hang*hang-3*hang)/2+lie;
			return arr[index];
		}
		if(hang<lie){
			int tmp;
			tmp=hang;
			hang=lie;
			lie=tmp;
			getElement(hang,lie,arr);
		}
	}
	
	
} 

void putElement(float *arr){											//将txt中的图放入Graph的数组中 
	ifstream infile;	
	for(int i=0;i<(length*length-length)/2;i++)
	{
		arr[i]=0;
	}
// 	infile.open("NetScience.txt");					
	 infile.open("Karate.txt");		
//	infile.open("test2.txt");																							//		------------------------------
 	if(!infile) cout<<"error"<<endl;

	float t1; 
	int hang,lie,index;
	float weight;
	while(infile)
	{
		infile>>hang;
		infile>>lie;
		infile>>weight;
		index=(hang*hang-3*hang)/2+lie;
		arr[index]=weight;
	}
} 

float setTableElement(float* table,int raw,int col,float value){
	table[(raw-1)*2+col-1]=value;
}

float getTableElement(float* table,int raw,int col){
	return (table[(raw-1)*2+col-1]);
}


void CreateTable(float* table){				//二维列表辅助，0是父节点名，1是节点之间的距离，2是是否被访问过 
	for(int i=1;i<=length;i++)
	{
		setTableElement(table,i,1,i);
		setTableElement(table,i,2,0);
	}

}

void printTable(float* table){
	for(int i=0;i<length*2;i=i+2)
	{
		cout<<table[i]<<"  "<<table[i+1];
		cout<<endl;
	}
}

bool isInColl(float* table,float Node1,float Node2){
	return ((getTableElement(table,Node1,2))&&(getTableElement(table,Node2,2)));
}

bool isAllVisited(float* table){
	for( int i=1;i<=length;i++)
	{
		 if(getTableElement(table,i,2)==0)
		 {
		 	return 0;
		 }
	}
	return 1;
} 

float* Search_Min_Side(float*arr,float* table){//arr 是G.edges 
	float Min=10000;
	float tmp;
	float* result=new float[3];
	result[0]=0;
	result[1]=0;
	result[2]=Min;
	for(int i=1;i<=length;i++)
	{
		for( int j=1;j<=length;j++)
		{
			tmp=getElement(i,j,arr);
			if((tmp<Min)&&(tmp!=0)&&(!isInColl(table,i,j)))//是否在集合中 
			{
				Min=tmp; 
//				cout<<tmp<<endl;
				result[0]=i;
				result[1]=j;
				result[2]=Min;
				
			}
		}
	 } 
	 return result;
}




void CreateTree(float* table,float* arr)
{
	float* result;
	float  sum=0;
	while(!isAllVisited(table)) 
	{
		result=Search_Min_Side(arr,table);
		setTableElement(table,result[0],2,1);
		setTableElement(table,result[1],2,1);
		printTable(table);
		cout<<"___________________________________________________________________"<<endl;
		sum=sum+result[2];
	}
	cout<<endl<<"sum = "<<sum<<endl;
	
}


 int main(){
 	Graph G;
	float table[length*2]={0};
	float Coll[length]={0};  //存放点在集合上的点， 
	
	putElement(G.edge);
	CreateTable(table);			//建立辅助二维表																		


	CreateTree(table,G.edge);
	
 } 

