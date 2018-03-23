
#ifndef _SINGLE_ARRAY_H_
#define _SINGLE_ARRAY_H_

template <class T>
class Single_list{
	private: 
		struct Node{
			T data;
			Node* next;
			Node* prev;
		};
		Node* head;
		int length;
		int size;
	public:
		T Double_list_insert()
		Single_list();
		
};
template <class T>
Single_list<T>::Single_list(){
	head = new Node;
	head->prev=NULL;
	head->next=NULL;
	length=0;
	size=0;
	
}
#endif _SINGLE_ARRAY_H_

