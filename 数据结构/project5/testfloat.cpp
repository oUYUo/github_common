  #include <iostream>
#include <fstream>
#include <vector>
#include <utility>
#include <cassert>
#include <string>
using namespace std; 

const int M = 1000;		//���ڵ��ޱ�Ȩֵ��M��ʾ
const int VNUM = 34;

float Prim(const float G[][VNUM], vector<pair<int, int> > &edge);
int Kruskal(const float G[][VNUM], vector<pair<int, int> > &edge);

int main()
{
	float value;
	int lie,hang;
	float G[VNUM][VNUM]={1000};
	ifstream fin("Karate.txt");
	while(!fin.eof()){
		fin>>hang;
		fin>>lie;
		fin>>value;                     
		G[hang-1][lie-1]=value;
		G[lie-1][hang-1]=value; 
	}
	cout<<G[0][1]<<endl; 
//	cout<<hang<<" "<<lie<<" "<<value<<endl;
	vector<pair<int, int> > edge(VNUM-1);

	//Prim
	cout<<"����ķ�㷨:"<<endl;	
	cout<<"��·�����ȣ�"<<Prim(G, edge)<<endl;
	for(int i = 0; i != VNUM-1; ++i)
		cout<<"("<<edge[i].first<<", "<<edge[i].second<<")"<<endl;
}

float Prim(const float G[][VNUM], vector<pair<int, int> > &edge)
{
	float w = 0;						//Ȩ��
	vector<int> visited(VNUM, 0);	//�ѷ��ʽڵ㼯��				
	//��ʼ��
	visited[18] = 1;					//0�Žڵ��ѷ���			
	//ѭ��VNUM-1��
	int u, v;
	for(int number = 1; number < VNUM; ++number)
	{	
		float min = M;
		for(int i = 0; i != VNUM; ++i) //һ��ѭ����һ���ڵ���ջ
		{
			if(visited[i] == 1)
			{
				for(int j = 0; j != VNUM; ++j)			//�жϱߣ�i, j)��Ȩֵ,iΪ�ѷ��ʽڵ㣬jΪδ���ʽڵ�
				{
					
					if(visited[j] == 0 && G[i][j] < min&&G[i][j]!=0)
					{
						min = G[i][j];
						v = i;
						u = j;
					}
				}
			}
		}
		w += G[v][u];
		visited[u] = 1;
		edge[number-1].first = v;
		edge[number-1].second = u;
	}
	return w;
}
