  #include <iostream>
#include <fstream>
#include <vector>
#include <utility>
#include <cassert>
#include <string>
using namespace std; 

const int M = 1000;		//两节点无边权值用M表示
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
	cout<<"普里姆算法:"<<endl;	
	cout<<"总路径长度："<<Prim(G, edge)<<endl;
	for(int i = 0; i != VNUM-1; ++i)
		cout<<"("<<edge[i].first<<", "<<edge[i].second<<")"<<endl;
}

float Prim(const float G[][VNUM], vector<pair<int, int> > &edge)
{
	float w = 0;						//权重
	vector<int> visited(VNUM, 0);	//已访问节点集合				
	//初始化
	visited[18] = 1;					//0号节点已访问			
	//循环VNUM-1次
	int u, v;
	for(int number = 1; number < VNUM; ++number)
	{	
		float min = M;
		for(int i = 0; i != VNUM; ++i) //一次循环有一个节点入栈
		{
			if(visited[i] == 1)
			{
				for(int j = 0; j != VNUM; ++j)			//判断边（i, j)的权值,i为已访问节点，j为未访问节点
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
