#include<iostream> 
#include<stdlib.h>
#include "double_list.h"
using namespace std;
template <class T>
class Stack{
	private: 
		Double_list<T> list;
	public:
		bool empty() const;
		T top() const;
		void push(T const &);
		T pop();
};

