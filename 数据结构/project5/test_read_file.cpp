#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <typeinfo>

#define length 1589

using namespace std;

struct Graph{
 	int *head=new int[length];   //顶点集 
 	float  *edge=new float[(length*length-length)/2];		//边集合 
};

	//如何根据行和列在一维数组中对应值
float getElement(int hang,int lie,float *arr){
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

void putElement(float *arr){
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

 int main(){
 	Graph G;

	putElement(G.edge);

	cout<<getElement(59,60,G.edge);
	


 } 

