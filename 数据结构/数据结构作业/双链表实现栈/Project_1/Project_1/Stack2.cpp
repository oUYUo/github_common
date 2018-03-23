
#define FALSE 0
#define TRUE 1
template <typename Type>
class Stack {
    private:
        /*input your code here*/
        struct Node{
        	Type data;
        	Node* next;
        	Node* prev;
		};
		int length;
		int size;
		Node* head;
	
	
    public:
	    Stack(int size){
			head=new Node;
			head->prev=NULL;
			head->next=NULL;
			length=0;
			this->size=size;
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
	if(length==0){
		return 1;
	}
	else{
		return 0;
	}
	/*input your code here*/
}

template <typename Type>
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
Type Stack<Type>::top() const {
	/*input your code here*/
	
}

template <typename Type>
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
		cout<<"栈已满";
	}
}

template <typename Type>
Type Stack<Type>::pop()  {
	/*input your code here*/
	if(length!=0){
		Node* temp=new Node();
		head=temp->prev;
		head->next=NULL;
		head->prev=temp->prev->prev;
		
	}
	else{
		cout<<"栈为空";
	}
	return 0.0; // 根据实际return
}
#include "head.h"
#define FALSE 0
#define TRUE 1
template <typename Type>
class Stack {
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
	    Stack(int size){
	    	bottom=new Node;
			head=new Node;
			bottom=head;
			head->prev=NULL;
			head->next=NULL;
			length=0;
			this->size=size;
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
	if(length==0){
		return 1;
	}
	else{
		return 0;
	}
	/*input your code here*/
}

template <typename Type>
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
Type Stack<Type>::top() const {
	/*input your code here*/
	
}

template <typename Type>
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
		cout<<"栈已满";
	}
}

template <typename Type>
Type Stack<Type>::pop()  {
	/*input your code here*/
	if(length!=0){
		Node* temp=new Node();
		head=temp->prev;
		head->next=NULL;
		head->prev=temp->prev->prev;
		
	}
	else{
		cout<<"栈为空";
	}
	return 0.0; // 根据实际return
}


template <typename Type>
void Stack<Type>::print()  {
	/*input your code here*/
	if(size!=0){
		for(int i=0;i<size;i++){
			cout<<
		}
	}
	else{
		cout<<"没有元素";
	}

template <typename Type>
void Stack<Type>::print()  {
	/*input your code here*/
	if(size!=0){
		for(int i=0;i<size;i++){
			cout<<
		}
	}
	else{
		cout<<"没有元素";
	}
