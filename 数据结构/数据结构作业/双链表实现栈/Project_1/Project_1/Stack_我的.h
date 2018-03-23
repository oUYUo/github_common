#include "head.h"
#define FALSE 0
#define TRUE 1
template <typename Type>
class Stack {//program by Ëï×¿ 
    private: 
        /*input your code here*/
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
		void print_h_e();
};
template <typename Type>//programm by Éòçù·² 
bool Stack<Type>::empty() const {
	if(length==0){
		return 1;
	}
	else{
		return 0;
	}
	/*input your code here*/
}

template <typename Type>//programm by Éòçù·² 
bool Stack<Type>::full() const { 
	if(size==length){
		return 1;
	}
	if(size!=length){
		return 0;
	}
	/*input your code here*/
}

template <typename Type>
Type Stack<Type>::top() const {//program by Ç®³Ì 
	/*input your code here*/
	if(bottom!=head)
	{
		return head->data;
	}
	else
	{
		cout<<"Õ»¶¥Ã»ÓÐÔªËØ";
		return -1; 
	}
}

template <typename Type>//program by Ëï×¿ 
void Stack<Type>::push(Type data)  {
	/*input your code here*/
	if(!full())
	{
		Node* temp = new Node;
		temp->data=data;
		head->next=temp;
		temp->prev=head;
		temp->next=NULL;
		head=temp;
		length++;
		}
	else{
		cout<<"Õ»ÒÑÂú"<<endl;
	}
}

template <typename Type>//program by Ëï×¿ 
Type Stack<Type>::pop()  {
	if(length!=0)
	{
		Node* temp=new Node;
		temp=head;
		head->prev->next=NULL;
		head=head->prev;
		free(temp);
		length--;
	}
	else{
		return -1;
	}
}

template <typename Type>//program by ÁõÓÀ½Ü 
void Stack<Type>::print()  {
	/*input your code here*/
	Node* temp_h=new Node;
	Node* temp_b=new Node;
	temp_h=head;
	temp_b=bottom;
	while(temp_b!=temp_h)
	{
		cout<<temp_b->next->data<<"  ";
		temp_b=temp_b->next;
	}
	cout<<endl;
} 

