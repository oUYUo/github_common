#ifndef _STACK_H_
#define _STACK_H_
#include "Double_list.h"
using namespace std;



template <class T>
class Stack{
	private: 
		Double_list<T> Db;
	public:
		bool empty() const;
		T top() const;
		void push(T const &);
		T pop();
};
template <class T>
void Stack<T>::push(T const & num)
{
	Db->head=num;
}
#endif
