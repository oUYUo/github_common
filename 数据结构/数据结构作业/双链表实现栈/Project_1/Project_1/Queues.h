#include "head.h"
template <typename Type>
class Queue{
    private:
         struct Node{
        	Type data;
        	Node* next;
        	Node* prev;
		};
		int length; 
		int size;
		Node* bottom;
		Node* head;
    public:
    	   Queue(){
	    	bottom=new Node;
			head=new Node;
			head=bottom;
			head->prev=NULL;
			head->next=NULL;
			length=0; 
			size=1000;
		}
        bool empty() const;
		bool full() const;
        Type top() const;
        void push(Type);
        Type pop();
		void print();
};

template <typename Type>
bool Queue<Type>::empty() const {
	if(length==0){
		return 1;
	}
	else{
		return 0;
	}
	
}

template <typename Type> 
bool Queue<Type>::full() const { 
	if(size==length){
		return 1;
	}
	if(size!=length){
		return 0;
	}

}

template <typename Type>
Type Queue<Type>::top() const {
	if(bottom!=head)
	{
		return head->next->data;
	}
	else
	{
		return -1; 
	}
}

template <typename Type>
void Queue<Type>::push(Type data)  {
	if(!full()){
		Node* temp=new Node;
		temp->data=data;
		temp->prev=bottom;
		temp->next=NULL;
		bottom->next=temp;
		bottom=temp;
		length++;

	}
}

template <typename Type>
Type Queue<Type>::pop()  {
	if(length>0)
	{Type data=head->next->data;
		head=head->next;
		length--;
		return  data;
	}
	else{
	return -1;
}

}

template <typename Type>
void Queue<Type>::print()  {
	if(length>0)
	{
		Node* temp= new Node;
		temp=head->next;
		for(;temp->next;temp=temp->next){
			cout<<temp->data<<endl;
		}
		cout<<temp->data<<endl;
	}
}
