#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define OVERFLOW -2
#define INIT_SIZE 20
#define INCREMENT_SIZE 5

typedef int SElemType;
typedef int Status;

typedef struct 
{
	SElemType *base;
	SElemType *top;
	int size;
 } SqStack;
 
 Status InitStack(SqStack* S)
 {
 	S->base =(SElemType*) malloc(INIT_SIZE * sizeof(SElemType));
 	if(!S->base)
 	{
 		exit(OVERFLOW);
	 }
	 S->top=S->base;
	 S->size=INIT_SIZE;
	 return OK;
 }
 
 Status DestroyStack(SqStack* S)
 {
 	free(S->base);
 	S->base=NULL;
 	S->top=NULL;
 	S->size=0;
 	return OK;
 }
 
 Status ClearStack(SqStack* S)
 {
 	
 	S->base=S->top;
 	return OK;
 }
 
 Status IsEmpty(SqStack S)
 {
 	if(S.base==S.top)
 	{
 		return TRUE;
	 }
	 else
		return FALSE;
 }
 
 int GetLength(SqStack S)
 {
 	return S.top - S.base;
 }
 
 Status GetTop(SqStack S,SElemType *e)
 {
 	if(S.top>S.base)
 	{
 		*e=*(--S.top);
 		return 0K;
	 }
 }
 
