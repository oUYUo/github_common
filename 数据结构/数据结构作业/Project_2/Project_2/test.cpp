#include "BST.h"
#include <time.h>


void Rand(float* dRands, int nCount)
{
	for(int i = 0; i < nCount; i++)
	{
		int nRand = rand();//随机生成0 - 0x7FFF(即0 -- RAND_MAX)的随机数
		float dRand = (float)nRand / RAND_MAX;//将随机数映射到0 -- 1区间内
		
		dRands[i] = dRand;
	}
}


int main()
{
	BST<float> mybst;
	int N=16;
	float * inputdata=new float[N+1];
	float * action=new float [N+1];
	srand((unsigned)time( NULL )); 
	Rand(inputdata, N+1);
	Rand(action, N+1);
	int i=0;
	int j=0;

	cout<<"Test for binary search tree"<<endl;
	cout<<"======================================="<<endl;
	i=1;
	j=1;
	while(1)
	{
		mybst.insert(inputdata[i++]);
		if (i>N||j>N)
		{
			break;
		}

	}

	cout<<"Print the binary search tree"<<endl;
	cout<<"======================================="<<endl;	
	cout<<"Pre-order Traversal:"<<endl;
	mybst.Print_First();
	cout<<endl;
	cout<<"======================================="<<endl;
	cout<<"In-order Traversal:"<<endl;
	mybst.Print_Middle();
	cout<<endl;
	cout<<"======================================="<<endl;
	cout<<"Post-order Traversal:"<<endl;
	mybst.Print_Back();
	cout<<endl;
	cout<<"======================================="<<endl;
	cout<<"The size of the tree: "<<mybst.size()<<endl;
	cout<<"======================================="<<endl;
	cout<<"The height of the tree: "<<mybst.height()<<endl;
	cout<<"======================================="<<endl;
	cout<<"The minimum element in the tree: "<<mybst.front()<<endl;
	cout<<"======================================="<<endl;
	cout<<"The maximum element in the tree: "<<mybst.back()<<endl;
	cout<<"======================================="<<endl;

	int k=(int) (sqrt(N)); 
	cout<<"The "<<k+1<<"-th element in the tree: "<<mybst.at(k)<<endl;
	cout<<"======================================="<<endl;
	cout<<"The next element of "<<mybst.at(k)<<" in the tree: "<<mybst.next(mybst.at(k))<<endl;
	cout<<"======================================="<<endl;
	cout<<"The previous element of "<<mybst.at(k)<<" in the tree: "<<mybst.previous(mybst.at(k))<<endl;
	cout<<"======================================="<<endl;
	cout<<"After erasing "<<mybst.at(k)<<" in the tree: "<<endl;
	mybst.erase(mybst.at(k));
	mybst.Print_Middle();
	cout<<endl;
	cout<<"======================================="<<endl;
	return 0;
}