#include<stdio.h>
int main()
{
	int a[10];
	printf("%p,%p\n",&a[3],&a[1]);
	printf("%d",&a[3]-&a[1]);
}
