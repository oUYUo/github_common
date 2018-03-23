#include "head.h"
template <typename Type>
void Print_array( Type *const array, int const n ) {
	for (int i=1;i<=n;i++)
	{
		cout<<array[i]<<" ";
	}
	cout<<endl;
}

template <typename Type>
void merge(Type *array,int start,int end)			//钱程 
{
	Type* result=new Type[end+1];
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
// Function of Insert Sort
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




// Function of Heap Sort
template <typename Type>
void Heap_sort( Type *const array, int first, int last  ) {			//孙卓 
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
//		Print_array(array,last);
//		for (int i=1;i<=last;i++)
//		{
//			cout<<array[i]<<" ";
//		}
//		cout<<endl;
		
		Type tmp;
		tmp=array[first];
		array[first]=array[last];
		array[last]=tmp;
		last--;
		Heap_sort(array,first,last);
	}
		Print_array(array,last);
}


// Function of Merge Sort
template <typename Type>
void Merge_sort( Type *const array, int first, int last) {		//刘永杰 
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
       	Print_array(array,last);
	}
}


// Function of Quick Sort











template <typename Type>
void Quick_sort(Type *array, int l, int r)  		//沈琦凡 
{  
	int end=r;
    if (l< r)  
    {        
        int i = l, j = r, x = array[l];  
        while (i < j)  
        {  
            while(i < j && array[j]>= x)  
                j--;   
            if(i < j)  
                array[i++] = array[j];  
            while(i < j && array[i]< x)
                i++;   
            if(i < j)  
                array[j--] = array[i];  
        }  
        array[i] = x;  
        
        
        Quick_sort(array, l, i - 1); 
        Quick_sort(array, i + 1, r);  
        Print_array(array,end);	
		
    }  
}  






template <typename Type>
void Copy_array( Type *const array_x, Type *const array_y, int const n ) {
	for (int i=1;i<=n;i++)
	{
		array_y[i]=array_x[i];
	}
}
