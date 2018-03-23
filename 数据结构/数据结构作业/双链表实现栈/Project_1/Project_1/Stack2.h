#include "head.h"
template <typename Type>
class Stack {
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
        /*input your code here*/
    public:
    	Stack(){
	    	bottom=new Node;
			head=new Node;
			bottom=head;
			head->prev=NULL;
			head->next=NULL;
			length=0;
			size=1000;	
		}
        bool empty() const;
		bool full() const;
        Type top() const;
        void push( Type);
        Type pop();
		void print();
};
template <typename Type>
bool Stack<Type>::empty() const {
	/*input your code here*/
	if(lenght==0){
		return 1;
	}
	else{
		return 0;
	}
}

template <typename Type>
bool Stack<Type>::full() const {
		if(size==length){
		return 1;
	}
	if(size!=length){
		return 0;
	}
}

template <typename Type>
Type Stack<Type>::top() const {
	/*input your code here*/
}

template <typename Type>
void Stack<Type>::push(Type data)  {
	if(!full())
	{
		Node* temp=new Node;
		temp->data=data;
		head->next=tem
	}
}

template <typename Type>
Type Stack<Type>::pop()  {
	/*input your code here*/
	return 0.0; // 根据实际return
}


template <typename Type>
void Stack<Type>::print()  {
	/*input your code here*/
}
