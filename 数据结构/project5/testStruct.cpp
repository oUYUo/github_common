#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <typeinfo>

#define length 1589

using namespace std;

struct Graph{
 	int head[length];   //���㼯 
 	float  edge[(length*length-length)/2];		//�߼��� 
};


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
	return 0;
} 


void main(){
 	 Graph G;
 	//���ļ���ʧ�ܷ���error 
	 G.edge[111111]=11;
	cout<<G.edge[111111];
	cout<<"hhh";
	 

 } 
