#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define OVERFLOW -2
#define MAX_NUM 20

typedef int Status;
typedef int QElemType;
typedef char VexType;

/*
 * �ڽӱ�洢�ṹ
 */
typedef struct EdgeNode
{
    int adjvex;    //�����λ��
    struct EdgeNode *next; //ָ����һ���ߵ�ָ��
}EdgeNode, *EdgeLink;

typedef struct VexNode
{
    VexType data;    //��������
    EdgeNode *firstEdge;    //ָ���һ�������ö���ıߵ�ָ��
}VexNode, AdjList[MAX_NUM];

typedef struct
{
    AdjList adjList;
    int vexNum, edgeNum;    //�������ͱ���
}ALGraph;

/*
 * ���д洢�ṹ(����ͼ�ı���)
 */
typedef struct QNode
{
    QElemType data;    //�������
    struct QNode *next;    //ָ����һ�����
}QNode, *QueuePtr;

typedef struct
{
    QueuePtr front;    //��ͷָ��
    QueuePtr rear;    //��βָ��
}LinkQueue;

/*
 * ��ʼ������
 */
Status InitQueue(LinkQueue *Q)
{
    Q->front = Q->rear = (QueuePtr) malloc(sizeof(QNode));
    if (!Q->front)
    {
        exit(OVERFLOW);
    }
    Q->front->next = NULL;
    return OK;
}

/*
 * �ж϶����Ƿ�Ϊ��
 */
Status IsEmpty(LinkQueue Q)
{
    if (Q.front->next == NULL)
    {
        return TRUE;
    }
    else
    {
        return FALSE;
    }
}

/*
 * ���
 */
Status EnQueue(LinkQueue *Q, QElemType e)
{
    QueuePtr p = (QueuePtr) malloc(sizeof(QNode));
    if (!p)
    {
        exit(OVERFLOW);
    }
    p->data = e;
    p->next = NULL;
    Q->rear->next = p;
    Q->rear = p;
    return OK;
}

/*
 * ����
 */
Status DeQueue(LinkQueue *Q, QElemType *e)
{
    QueuePtr p;
    if (Q->front == Q->rear)
    {
        return ERROR;
    }
    p = Q->front->next;
    *e = p->data;
    Q->front->next = p->next;
    if (Q->rear == p)
    {
        Q->rear = Q->front;
    }
    free(p);
    return OK;
}

/*
 * ����ͼ
 */
Status CreateGraph(ALGraph *G)
{
    int i, j, k;
    EdgeLink e;
    printf("�����붥����Ŀ�ͱ���:\n");
    scanf("%d", &G->vexNum);
    scanf("%d", &G->edgeNum);
    getchar();
    printf("����������������:\n");
    for (i = 0; i < G->vexNum; i++)
    {
        scanf("%c",&G->adjList[i].data);
        if (G->adjList[i].data == '\n')
        {
            i--;
            continue;
        }
        G->adjList[i].firstEdge = NULL;
    }

    printf("�����������(Vi,Vj)�Ķ������:\n");
    for (k = 0; k < G->edgeNum; k++)
    {
        scanf("%d", &i);
        scanf("%d", &j);
        e = (EdgeLink) malloc(sizeof(EdgeNode));
        e->adjvex = j;
        e->next = G->adjList[i].firstEdge;
        G->adjList[i].firstEdge = e;
        e = (EdgeLink) malloc(sizeof(EdgeNode));
        e->adjvex = i;
        e->next = G->adjList[j].firstEdge;
        G->adjList[j].firstEdge = e;
    }
    return OK;
}

int visited[MAX_NUM];    //���ڼ�¼����״̬

/*
 * �ݹ�ӵ�i�����������ȱ���ͼ
 */
void DFS(ALGraph G, int i)
{
    EdgeLink p;
    visited[i] = TRUE;
    printf("%c ", G.adjList[i].data);
    p = G.adjList[i].firstEdge;
    while (p)
    {
        if (!visited[p->adjvex])
        {
            DFS(G, p->adjvex);
        }
        p = p->next;
    }
}

/*
 * ������ȱ���
 */
Status DFSTraverse(ALGraph G)
{
    int i;
    for (i = 0; i < MAX_NUM; i++)
    {
        visited[i] = FALSE;
    }
    for (i = 0; i < G.vexNum; i++)
    {
        if (!visited[i])
        {
            DFS(G, i);
        }
    }
    return OK;
}

/*
 * ������ȱ���
 */
Status BFSTraverse(ALGraph G)
{
    int i;
    EdgeLink p;
    LinkQueue Q;
    InitQueue(&Q);
    for (i = 0; i < MAX_NUM; i++)
    {
        visited[i] = FALSE;
    }
    for (i = 0; i < G.vexNum; i++)
    {
        if (!visited[i])
        {
            visited[i] = TRUE;
            printf("%c ", G.adjList[i].data);
            EnQueue(&Q, i);
            while (!IsEmpty(Q))
            {
                DeQueue(&Q, &i);
                p = G.adjList[i].firstEdge;
                while (p)
                {
                    if (!visited[p->adjvex])
                    {
                        visited[p->adjvex] = TRUE;
                        printf("%c ", G.adjList[p->adjvex].data);
                        EnQueue(&Q, p->adjvex);
                    }
                    p = p->next;
                }
            }
        }
    }
    return OK;
}

int main()
{
    ALGraph G;
    CreateGraph(&G);
    printf("������ȱ���:");
    DFSTraverse(G);
    printf("\n������ȱ���:");
    BFSTraverse(G);
    printf("\n");
}
