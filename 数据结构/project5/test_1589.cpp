#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <typeinfo>
#include <stdio.h>
#include <queue>
#include<windows.h>

#define length 4																										//		-------------------------------------------

using namespace std;

struct Graph{
 	int *head=new int[length];   //���㼯 
 	float  *edge=new float[(length*length-length)/2];		//�߼��� 
};

	//��θ����к�����һά�����ж�Ӧֵ
float getElement(int hang,int lie,float *arr){			//��������ȡ��Ԫ�أ��������Խ���򷵻�0   ���е�������һ��ʼ 
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

void putElement(float *arr){											//��txt�е�ͼ����Graph�������� 
	ifstream infile;	
	for(int i=0;i<(length*length-length)/2;i++)
	{
		arr[i]=0;
	}
// 	infile.open("NetScience.txt");					
	 	infile.open("test2.txt");																									//		------------------------------
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
	table[(raw-1)*3+col-1]=value;
	return (table[(raw-1)*3+col-1]);
}

float getTableElement(float* table,int raw,int col){
	return (table[(raw-1)*3+col-1]);
}


void CreateTable(float* table,int Node){				//��ά�б�����0�Ǹ��ڵ�����1�ǽڵ�֮��ľ��룬2���Ƿ񱻷��ʹ� 
	setTableElement(table,Node,1,-1);
	setTableElement(table,Node,2,0);
	setTableElement(table,Node,3,1);

}


void printTable(float *table) 
{
	for(int i=1;i<=length;i++){
		printf("%5d    ",i);
		for(int j=1;j<=3;j++)
		{
			if(j==2){//�ڶ����Ǿ��룬��С�� 
				printf("%10.7f  ",getTableElement(table,i,j));
			}
			else{
				printf("%10.7f  ",getTableElement(table,i,j));
			}
		}
		cout<<endl;
	}
}

float* Search_Min_Node(queue<int> QNode,float*arr,float* table){//arr ��G.edges 
	queue<int> QNodeCopy;
	float* result=new float[3];

	QNodeCopy=QNode;
	float Min=100000;//��ʼ����Сֵ 
	int Node;
	int Parent;
	for(;QNodeCopy.size()!=0;){
		for(int j=1;j<length+1;j++){
			float value=getElement(j,QNodeCopy.front(),arr);
			int visited=getTableElement(table,j,3);
			
			if((value<Min&&value!=0)&&(visited==0)){
					Min=value;
					Node=j;
					Parent=QNodeCopy.front();
			}
			
		
		}
		QNodeCopy.pop();
	}
	result[0]=Min;
	result[1]=Node;
	result[2]=Parent;
	return result;
}



void sendValue(float* table,float* Node){
	setTableElement(table,Node[1],2,Node[0]);
	setTableElement(table,Node[1],3,1);
	setTableElement(table,Node[1],1,Node[2]);
}

bool isAllVisited(float* table){
	int index=2;
	while(index<length*3){
		if(table[index]==0)
		{
			return 0;
		}
		else{
			index=index+3;
		}
	}
	return 1;
}

void CreateTree(float* table,queue<int> QNode,float* arr)
{
	
	float *NodeValue;
	float sum=0;
	while(!isAllVisited(table)){
		printTable(table);
		cout<<endl<<endl;
		NodeValue=Search_Min_Node(QNode,arr,table);
		sendValue(table,NodeValue);
		QNode.push(NodeValue[1]);	
		sum=sum+NodeValue[0];
	}
	printTable(table);
	cout<<endl<<sum;
	
}
void CreateTree_F(float* table,queue<int> QNode,float* arr)
{
	
	float *NodeValue;
	float sum=0;
	int time=1;
	while(time!=(length-1)){
		printTable(table);
		cout<<time<<endl;
		cout<<endl<<endl;
		NodeValue=Search_Min_Node(QNode,arr,table);
		sendValue(table,NodeValue);
		QNode.push(NodeValue[1]);	
		sum=sum+NodeValue[0];
		time++;
	}
	printTable(table);
	cout<<endl<<sum;
	
}

 int main(){
 	Graph G;
 	putElement(G.edge);

	float table[length*3]={0};
	CreateTable(table,4);																							//----------------------------------------


	queue<int> QNode;

	QNode.push(4);																								//	----------------------------------------------
	CreateTree_F(table,QNode,G.edge);

	
 } 

