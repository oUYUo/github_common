#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <typeinfo>
#include <stdio.h>
#include <queue>

#define length 1589

using namespace std;

struct Graph{
 	int *head=new int[length];   //���㼯 
 	float  *edge=new float[(length*length-length)/2];		//�߼��� 
};

	//��θ����к�����һά�����ж�Ӧֵ
float getElement(int hang,int lie,float *arr){			//��������ȡ��Ԫ�أ��������Խ���򷵻�0   ���е�������һ��ʼ 
	if(((hang>1589)||(hang<1))||((lie>1589)||(lie<1))) 
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
 	infile.open("NetScience.txt");
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

float* getTable(int Node,float* table){
//	return table[Node];
		return table;
}

void printTable(float *table) 
{
	for(int i=1;i<=1589;i++){
		for(int j=1;j<=3;j++)
		{
			if(j==2){
				printf("    %5f  ",getTableElement(table,i,j));
			}
			else{
				printf("%5d  ",getTableElement(table,i,j));
			}
		
		}
		cout<<endl;
	}
}

Search_Min_Node(queue<int> QNode){
	
}


 int main(){
// 	Graph G;
// 	putElement(G.edge);
////	cout<<getElement(-1573,1512312371,G.edge); 
//	float table[length][3];	
//	int Node=15;							
//	Node=Node-1;//��Ϊ�����д���Ľڵ���1 
//	 
//	table[Node][0]=-1;
//	table[Node][1]=0;
//	table[Node][2]=1; 
//	
//	cout<<table[14][0];

//	float table[length*3]={0};
//	CreateTable(table,15);
//	printTable(table);

//	cout<<setTableElement(table,15,1,-1);

	queue<int> QNode;
	

	
 } 

