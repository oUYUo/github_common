#include "Queues.h"
#include "Stack.h"
#include <math.h>
#include <time.h>
#include <stdlib.h>


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
//	Queue<float> my_queue;
	Stack<float> my_stack;
	int N=100;
	float * inputdata=new float[N+1];
	float * action=new float [N+1];
	srand((unsigned)time( NULL )); 
	Rand(inputdata, N+1);
	Rand(action, N+1);
	int i=0;
	int j=0;

//	 //test for Queue;
//	i=1;
//	j=1;
//	while(1)
//	{
//		if (action[j++]>=0.5)
//		{
//			my_queue.push(inputdata[i++]);
//		}
//		else
//		{
//			my_queue.pop();
//		}
//		my_queue.print();
//		if (i>N||j>N)
//		{
//			break;
//		}
//
//}
//}

	 //test for Stack;
	i=1;
	j=1;
	while(1)
	{
		if (action[j++]>=0.5)
		{
			my_stack.push(inputdata[i++]);

		}
		else
		{
			my_stack.pop();
		}
		my_stack.print();
		if (i>N||j>N)
		{
			break;
		}
		
	}

	return 0;
}
