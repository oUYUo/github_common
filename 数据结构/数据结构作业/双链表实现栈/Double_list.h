
#ifndef _DOUBLE_ARRAY_H_
#define _DOUBLE_ARRAY_H_
#define NULL 0
#include<iostream>
using namespace std;
template <class T>
class Double_list{
	private: 
		struct Node{
			T data;
			Node* next;
			Node* prev;
		};
		Node* head;
		Node* tail;
		int length;
		int size;
	public:
		
		Double_list();
		void Double_list_insert(T const& num);
		void traverse_Double_list();
};
template <class T>
void Double_list<T>::Double_list_insert(T const& num){
	Node* temp = new Node();
	temp->data=num;
	temp->next=NULL;
	temp->prev=tail;
	tail->next=temp;
	tail=temp;	
	
}
template <class T>
Double_list<T>::Double_list(){
	head = new Node;
	head->prev=tail;
	head->next=NULL;
	tail=head;
}
template <class T>
void Double_list<T>::traverse_Double_list()
{
	cout<<"traverse";
	Node* p =tail->next;
	if(p!=NULL)
	{
		cout<<p->data<<endl;
		p=p->next;
	}
	else{
		cout<<"end";
	}
}
#endif

