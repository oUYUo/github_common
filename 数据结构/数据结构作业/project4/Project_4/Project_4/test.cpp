#include "SortAlgorithm.h"
#include <time.h>


void Rand(float* dRands, int nCount)
{
	for(int i = 0; i < nCount; i++)
	{
		int nRand = rand();//随机生成0 - 0x7FFF(即0 -- RAND_MAX)的随机数
		float dRand = (float)nRand / RAND_MAX;//将随机数映射到0 -- 1区间内
		
		dRands[i] = (int)(dRand*1000);
	}
}


int main()
{
	
	int N=32;
	float * inputdata=new float[N+1];
	float * testdata=new float[N+1];
	srand((unsigned)time( NULL )); 
	Rand(inputdata, N+1);
	cout<<"The original unsorted sequence:"<<endl;
	Print_array(inputdata,N);


	cout<<"The process of Insert Sort:"<<endl;
	Copy_array( inputdata, testdata, N );
	Insert_sort(testdata,1,N);
	Print_array(testdata,N);


	cout<<"The process of Heap Sort:"<<endl;
	Copy_array( inputdata, testdata, N );
	Heap_sort(testdata,1,N);

		
	cout<<"The process of Merge Sort:"<<endl;
	Copy_array( inputdata, testdata, N );
	Merge_sort(testdata,1,N);


	cout<<"The process of Quick Sort:"<<endl;
	Copy_array( inputdata, testdata, N );
	Quick_sort(testdata,1,N);



	return 0;

}