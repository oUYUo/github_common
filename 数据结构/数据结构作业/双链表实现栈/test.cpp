#include<iostream>
using namespace std;
template <class T>
class Base{
	public:
		
		Base(T b);
//		{
//			a=b;
//		}
		T getA(){return a;
		}
		void setA(T c);
		void sayHello();
	private:
		T a;
};
template <class T>
Base<T>::Base(T b){
	a=b;
}
template <class T>
void Base<T>::setA(T c)
{
	a=c;
}
template <class T>
void Base<T>::sayHello(){
	cout<<"hello";
} 
int main(){
	Base <int>b(4);
	cout<<b.getA();
}
