#include<stdio.h>
#include "BST.h"
struct TNode{
	int data;
	TNode* L;
	TNode* R;
};
int main(){
	BST<int> K;
	K.insert(4);
	K.insert(1);
	K.insert(100);
	K.insert(12);

//	K.erase(1);
	K.Print_Middle();
	cout<<K.find(12);

////	K.insert(1);
//	K.insert(100);
//	K.insert(1000);
//	K.insert(12312);
//	K.Print_Middle();
//	cout<<endl;
//	K.erase(2);
//	K.Print_Middle();
//	K.Print_Middle();
//	float arr[10];
//	for(int i=0;i<10;i++){
//		arr[i]=(float) rand()/9;
//		K.insert(arr[i]);
//	}
//	K.Print_Middle();
//	K.erase(K.at(4));
//	cout<<endl;
//	K.Print_Middle();
//	cout<<K.next(K.at(3));
//////	K.clear();
//	K.Print_Middle();
//	cout<<endl<<K.previous(6);
//	cout<<endl;
//	cout<<K.front();
//	cout<<endl<<K.back(); 
//	cout<<endl<<K.size();
//	cout<<endl<<K.at(0);
//	cout<<K.height();
//	K.Print_Middle();
//	cout<<endl<<endl;
//	K.Print_First();
//	cout<<endl<<endl;
//	K.Print_Back();

} 
