#include "head.h"
#include<stdlib.h> 
using namespace std;
template <typename Type>
class Stack {
private:
	int size;
	int length;
	Type* head;
	Type* bottom;  
    public:
    	Stack(){
    		size=1000;
    		length=0;
    		bottom=(Type*) malloc(size*sizeof(Type));
    		head=bottom;

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
return  length == 0;  
	}
template <typename Type> 
bool Stack<Type>::full() const {
return  length==size ;  
}

template <typename Type>
Type Stack<Type>::top() const {
return bottom[length-1];
}

template <typename Type>
void Stack<Type>::push(Type data)  {
	if(!full())
	{
		bottom[length]=data;
		length=length+1;
	
	}	

}

template <typename Type>
Type Stack<Type>::pop()  {
	if(!empty()) 
	{
		length=length-1;
		
	}
}
template <typename Type>
void Stack<Type>::print()  {
	if(!empty())
	{ 
		for(int i=0;i<=length-1;i++)
		{
		    cout<<bottom[i]<<" ";
		}
		cout<<endl;
	}
}

