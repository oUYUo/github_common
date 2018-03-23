#include<stdio.h>
#include "head.h"

template <typename Type>
void merge(Type *array,int start,int end)
{
	Type result[end+1];
	int left_length =(end-start+1)/2+1;
	int left_index=start;
	int right_index=start+left_length;
	int result_index=start;
	while(left_index<start+left_length&&right_index<end+1)
	{
		if(array[left_index]<=array[right_index])
		{
			result[result_index++]=array[left_index++];
		}
		else
		{
			result[result_index++]=array[right_index++];
		}
	}
	while(left_index<start+left_length)
		result[result_index++]=array[left_index++];
	while(right_index<end+1)
		result[result_index++]=array[right_index++]; 
	left_index=start;
	for(int i=left_index;i<end+1;i++)
	{
		array[i]=result[i];
	}

}

template <typename Type>
void Insert_sort( Type *const array, int first, int last  ) {
	for ( int k = first+1; k <= last; ++k ) {
        Type tmp = array[k];

        for ( int j = k; k > 0; --j ) {
            if ( array[j - 1] > tmp ) {
                array[j] = array[j - 1];
            } else {
                 array[j] = tmp;
                 break;
            }
        }

        if ( array[first] > tmp ) {
            array[first] = tmp;  
        }
    }
}

template <typename Type>
void Print_array( Type *const array, int const n ) {
	for (int i=1;i<=n;i++)
	{
		cout<<array[i]<<" ";
	}
	cout<<endl;
}

template <typename Type>
void Heap_sort( Type *const array, int first, int last  ) {
	if(first<=last)
	{
		for(int i=last/2;i>=first;i--){//从最后一个叶子节点的父节点往前 
			if(2*i+1<=last)//如果最后叶子节点是两个的话 
				if(array[2*i]<=array[2*i+1])
				{
					if(array[i]<array[2*i+1]){
						Type tmp;
						tmp=array[i];
						array[i]=array[2*i+1];
						array[2*i+1]=tmp;
					}
				}
				else{
					if(array[i]<array[2*i]){
						Type tmp;
						tmp=array[i];
						array[i]=array[2*i];
						array[2*i]=tmp;
					}
				}
			else						//如果最后叶子节点是一个的话 
				if(array[i]<array[2*i])
				{
					Type tmp;
					tmp=array[i];
					array[i]=array[2*i];
					array[2*i]=tmp;
				}
			
		}
		cout<<array[first]<<" ";
		Type tmp;
		tmp=array[first];
		array[first]=array[last];
		array[last]=tmp;
		last--;
		Heap_sort(array,first,last);
	}
}


template <typename Type>
void Merge_sort( Type *const array, int first, int last) {
	if ( last - first==1) {
		if(array[first]>array[last])
	    {
			int tmp=array[first];
	    	array[first]=array[last];
	    	array[last]=tmp;
    	}
		return ;
	}
	else if(0==last-first){
		return;
	} 
	else {
        Merge_sort( array, first, (last-first+1)/2+first );
        Merge_sort( array,(last-first+1)/2+first+1, last );
       	merge(array,first,last);
	}
}

void quickSort(int *array, int l, int r)  
{  
	int end=r;
    if (l< r)  
    {        
        int i = l, j = r, x = array[l];  
        while (i < j)  
        {  
            while(i < j && array[j]>= x) // 从右向左找第一个小于x的数  
                j--;   
            if(i < j)  
                array[i++] = array[j];  
            while(i < j && array[i]< x) // 从左向右找第一个大于等于x的数  
                i++;   
            if(i < j)  
                array[j--] = array[i];  
        }  
        array[i] = x;  
        
        Print_array(array,end);
        quickSort(array, l, i - 1); // 递归调用  
        quickSort(array, i + 1, r);  
        	
		
    }  
}  


int main(){
	int arr[12]={0,3,1,12,5,6,123,33,10,71,232,9};
//	int arr[7]={0,1,3,6,12,5,123};
//		Print_array(arr,11);
//	merge(arr,4,6);

//	printf("%d",9/2);
//	Heap_sort(arr,1,8);
	 Merge_sort(arr,1,11);
//	 merge(arr,1,6);
//	quickSort(arr,1,11);
	 Print_array(arr,11);
//	merge(arr,1,11,5); 
//	Print_array(arr,8);
//	printf("%d",arr[12]);
}
