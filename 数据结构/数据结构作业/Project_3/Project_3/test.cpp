#include "AVL.h"
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
	AVL<float> mybst;
	int N=10;
	float * inputdata=new float[N+1];
	float * action=new float [N+1];
	srand((unsigned)time( NULL )); 
	Rand(inputdata, N+1);
	Rand(action, N+1);
	int i=0;
	int j=0;

	cout<<"Test for AVL"<<endl;
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

	cout<<"Print the AVL"<<endl;
	mybst.DrawAVL();
	cout<<"The size of the tree: "<<mybst.size()<<endl;
	cout<<"The height of the tree: "<<mybst.height()<<endl;
	cout<<"======================================="<<endl;
	
	for (i=0;i<N;i++)
	{
		cout<<"After erasing "<<mybst.at(0)<<" in AVL: "<<endl;
		mybst.erase(mybst.at(0));
		mybst.DrawAVL();
		cout<<"++++++++++++++++++++++++++++++++++++"<<endl;
	}
	cout<<"======================================="<<endl;

	return 0;
}
