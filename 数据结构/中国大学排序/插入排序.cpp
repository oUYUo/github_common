//插入排序
void Insertion_Sort(ElementType A[] ,int N){
	for(P= 1,P<N;P++){
		Tmp=A[p];//摸下一张牌 
		for(i=P;i>0&&A[i-1]>Tmp;i--)
			A[i]=A[i-1];//移出空位 
		A[i]=Tmp;//新牌落位 
	}
} 
