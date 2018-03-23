#include "AVL.h"
#include <time.h>
int main(){
		AVL<float> mybst;
		mybst.insert(10);
		mybst.insert(5);
		mybst.insert(20);
		mybst.insert(30);
		mybst.insert(4);
		mybst.insert(8);
		mybst.insert(9);
		mybst.erase(30);
//		mybst.erase(2);
//		mybst.insert(21);
//		mybst.insert(23);
//		mybst.insert(12);
//		mybst.insert(3234);		
//		mybst.Print_Middle();
//		mybst.Print_First();
//		mybst.Print_Back();
		mybst.DrawAVL();
		mybst.Print_First();
//		cout<<mybst.root()->size();
//		cout<<endl<<mybst.size();
}
