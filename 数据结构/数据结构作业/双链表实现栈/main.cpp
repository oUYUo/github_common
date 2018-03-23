#include "Double_list.h"
#include "Stack.h"
#include<stdlib.h>
using namespace std;
int main()
{
	Double_list<int> a;
//	Stack<int> b;
//	a.print();
	a.Double_list_insert(3);
	a.Double_list_insert(3);
	a.Double_list_insert(3);
	a.Double_list_insert(3);
//	cout<<a.tail->next->data;
	a.traverse_Double_list();
//	b.push(2);
 } 
