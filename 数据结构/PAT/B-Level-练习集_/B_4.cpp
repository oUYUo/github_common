#include<iostream>
using namespace std;
typedef struct{
	char name[10];
	char sno[20];
	int grade; 
}  Student;

int main(){
	int num,big=0,small=100,big_index,small_index;
	cout<<"请输入人数："<<endl;
	cin>>num;
	cout<<"请输入姓名 学号 分数:"<<endl; 
	Student T[num];
	for(int i=0;i<num;i++)
	{
		cin>>T[i].name>>T[i].sno>>T[i].grade;
	}
	
	for(int i=0;i<num;i++)
	{
		if(T[i].grade>big) big=T[i].grade ,big_index=i;
		if(T[i].grade<small) small=T[i].grade ,small_index=i;
	}
	cout<<endl;
	cout<<T[big_index].name<<" "<<T[big_index].sno<<" "<<T[big_index].grade<<endl;
	cout<<T[small_index].name<<" "<<T[small_index].sno<<" "<<T[small_index].grade<<endl;
	 
	
}
