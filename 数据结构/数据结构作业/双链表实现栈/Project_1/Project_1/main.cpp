#include<iostream>
#include "Stack.h"
#include<stdlib.h>
using namespace std;
int main(){
	Stack<int> b;
	b.push(1);
	b.push(2);
	b.push(3);
	b.pop();
//	b.push(5);
	b.pop();
	b.pop();
	b.pop();
//	b.pop();
	b.print();
//	b.pop();
//	cout<<b.full();

//	b.pop();
//	b.pop();
//	b.pop();
//	cout<<b.top();
//	b.print();
//	cout<<b.top();
//	cout<<b.top()<<endl;
//	cout<<b.empty()<<endl;
//	cout<<b.full()<<endl;
//	b.push(1);
//	b.print();
//	b.push(343);
//	b.push(3);
//	b.push(6);
////	b.pop();
////	cout<<b.top();
//	b.pop();
//	b.pop();
//	b.pop();
//	b.pop();
//	b.pop();
////	b.pop();
//
////	b.print_h_e();
//	b.print();
////	b.rprint();
//	cout<<b.top();
}
