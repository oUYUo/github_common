//ц╟ещеепР
#include<iostream>
using namespace std;
void Bubble_Sort(ElementType A[] ,int N){
	for(P=N-1;P>=0;P--){
		flag=0;
		for(i=0;i<P;i++){
			if(A[i]>A[i+1]){
				Swap(A[i],A[i+1]);
				flag=1;
			}
		}
		if(flag==0) break;
	}
} 
