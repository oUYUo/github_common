

#include<sys/time.h>
#include <iostream>
#include <fstream>
#include <string>
#include <string.h>
#include <vector>
#include <cstdlib>
#include <time.h> 
#include<stdlib.h>
#include <math.h>
#include <map>
#include <algorithm> 
#include <vector>
#include <sstream>
#include <sys/types.h>
#include <iterator>
#include <set>
#include <unistd.h>
#include <pthread.h>
#include <assert.h>  
#define FALSE 0
typedef unsigned long DWORD;
typedef void *		LPVOID;
typedef void * HANDLE;

using namespace std;

long long int todiff(struct timeval *tod1, struct timeval *tod2)
{
    long long t1, t2;
    t1 = tod1->tv_sec * 1000000 + tod1->tv_usec;
    t2 = tod2->tv_sec * 1000000 + tod2->tv_usec;
    return t1 - t2;
}

//connect two char*
char* strcatre(char *s1,char*s2)
{
	int i,i1,i2;
	i1=strlen(s1);
	i2=strlen(s2);
	char *s3=new char[i1+i2+1];
	while(*s1!='\0')
		*(s3++)=*(s1++);
	while(*s2!='\0')
		*(s3++)=*(s2++);
	*(s3++)='\0';
	for(i=0;i<i1+i2+1;i++)
		s3--;
	return s3;
}

unsigned long GetTickCount()  
{  
    struct timespec ts;  
	
    clock_gettime(CLOCK_MONOTONIC, &ts);  
	
    return (ts.tv_sec * 1000 + ts.tv_nsec / 1000000);  
} 



void Rand(float* dRands, int nCount)
{
	for(int i = 0; i < nCount; i++)
	{
		int nRand = rand();//随机生成0 - 0x7FFF(即0 -- RAND_MAX)的随机数
		float dRand = (float)nRand / RAND_MAX;//将随机数映射到-1 -- 1区间内
		
		dRands[i] = dRand;
	}
}








struct Neighborhood{  
    int ID;  
    float lambda; 
	float varpi;
};  

typedef struct GKmeans
{
	char* head;
	int n;//number of node agents
	int m;//number of edges
	int d;//number of dimensions
	int K;//number of clusters
	Neighborhood** Neighbor; // neighbor set of each node
	float** Opinion; // opinion vector of each node
	float** FutureOpinion; // opinion vector of each node
	float* Reputation; // the reputation of each node
	float* varsigma; // the probability of each node being an opinion leader
	int * state; // the system state vector
	float * selfdistance;



	int** cluster; // the set of clusters
	float** centroid; // the set of opinion centroids
	float* theta; // the percentage of degree occupied by cluster



	int time_1; // the time index in phase 1
	int time_2; // the time index in phase 2
	set<int> * Feasible_Strategy;
	float * Local_Modularity;
	float * Local_K_means_Objective;
	float Believe_Threshold;
	int opinionupdateingnumber;

	//====================//
	//Parameters
	int type_of_graph;
	int type_of_Topology_similarity;
	int type_of_divergence;
	float beta; // the max value of opinion difference (phase_1)  
	float rho; // the decline parameter of opinion dynamics (phase_1)
	float varepsilon; // the relative decline threshold;
	//====================//


	int maxiteration;
	int typeofoutput;
}; 
 


GKmeans mygraph;



void OutputGraphgml(GKmeans mygraph)
{

	char s[10]; 
	sprintf(s, "%d", mygraph.time_2);
	char* head1=strcatre(mygraph.head,s);
	char* graphtail=".gml";
	char* graphfile=strcatre(head1,graphtail);
	ofstream ffout;
	ffout.open(graphfile);
	ffout<<"graph"<<endl;
	ffout<<"["<<endl;
	ffout<<"	directed 0"<<endl;
	int i=0;
	int j=0;
	for(i=1;i<=mygraph.n;i++)
	{
			
			ffout<<"	node"<<endl;
			ffout<<"	["<<endl;
			ffout<<"		id "<<i<<endl;
			ffout<<"		label "<<"\""<<i<<"\""<<endl;
			if (mygraph.Neighbor[i][0].ID==0)
			{
				ffout<<"		cluster "<<"\""<<0<<"\""<<endl;
			}
			else
			{
				ffout<<"		cluster "<<"\""<<mygraph.state[i]<<"\""<<endl;
			}
			ffout<<"		reputation "<<mygraph.Reputation[i]<<endl;
			ffout<<"		varsigma "<<mygraph.varsigma[i]<<endl;
			ffout<<"	]"<<endl;

	}
	
	for(i=1;i<=mygraph.n;i++)
	{
		if (mygraph.Neighbor[i][0].ID>0)
		{
		
			for(j=1;j<=mygraph.Neighbor[i][0].ID;j++)
			{
				if(i<mygraph.Neighbor[i][j].ID)
				{
					ffout<<"	edge"<<endl;
					ffout<<"	["<<endl;
					ffout<<"		source "<<i<<endl;
					ffout<<"		target "<<mygraph.Neighbor[i][j].ID<<endl;
					ffout<<"        weight "<<mygraph.Neighbor[i][j].lambda<<endl;
					ffout<<"	]"<<endl;
				}
			}
		}
	}
	
	ffout<<"]"<<endl;
	ffout.close();
}
















int finish=0;
int visited_ID=0;
pthread_mutex_t mutex,mutex1,mutex2;





void Initialization(char* head, int type_of_Topology_similarity, int type_of_divergence, int K)		
{
	ifstream fin1;
	ifstream fin2;
	int i=0;
	int j=0;
	int k=0;
	int n=0;
	int m=0;
	int p=0;
	string szLine;

	char* graphtail=".biggraph";
	char* graphfile=strcatre(head,graphtail);
	char* opiniontail=".feature";
	char* opinionfile=strcatre(head,opiniontail);

	if (access(opinionfile, R_OK|W_OK)==0)
	{
		cout<<"The input dataset is an opinion graph"<<endl;
		mygraph.type_of_graph=1;
	}
	else
	{
		cout<<"The input dataset is a plan graph"<<endl;
		mygraph.type_of_graph=0;

	}


	fin1.open(graphfile);
    i=0;
	while(getline (fin1,szLine))
	{
		i++;
	}
	fin1.close();
	fin1.clear();
	n=i;
	mygraph.head=head;
	mygraph.n=n;
	mygraph.K=K;
	mygraph.d=64;
	mygraph.maxiteration=30;
	mygraph.typeofoutput=1;
	mygraph.varepsilon=0.001;
	mygraph.Neighbor=new Neighborhood* [n+1];
	mygraph.Opinion=new float* [n+1];
	mygraph.FutureOpinion=new float* [n+1];
	mygraph.Reputation=new float[n+1];
	mygraph.varsigma=new float[n+1];
	mygraph.state=new int[n+1];
	mygraph.selfdistance= new float[n+1];
	mygraph.time_1=0;
	mygraph.time_2=0;
	mygraph.Feasible_Strategy=new set<int> [n+1];
	mygraph.Local_K_means_Objective=new float [n+1];
	mygraph.Local_Modularity=new float[n+1];
	
	mygraph.type_of_Topology_similarity=type_of_Topology_similarity;
	mygraph.type_of_divergence=type_of_divergence;
	mygraph.beta=mygraph.d;
	mygraph.rho=0.5;
	mygraph.m=0;

	i=1;
	fin1.open(graphfile);
	while(getline (fin1,szLine))
	{
		vector<string> tData;
		istringstream iss(szLine);
		copy(istream_iterator<string>(iss),istream_iterator<string>(), back_inserter<vector<string> >(tData));
		mygraph.Neighbor[i]=new Neighborhood [tData.size()+1];
		mygraph.Neighbor[i][0].ID=tData.size();
		mygraph.Neighbor[i][0].lambda=-1;
		mygraph.Neighbor[i][0].varpi=-1;
		j=1;
		for(vector<string>::iterator iter = tData.begin(); iter!=tData.end(); ++iter)
		{
			mygraph.m++;
			mygraph.Neighbor[i][j].ID=atoi((*iter).c_str());
			mygraph.Neighbor[i][j].lambda=-1;
			mygraph.Neighbor[i][j].varpi=-1;
			j++;
		}
		i++;	
	}
	fin1.close();
	fin1.clear();
	mygraph.m=mygraph.m/2;
	cout<<"Number of Nodes: "<<mygraph.n<<endl;
	cout<<"Number of Edges: "<<mygraph.m<<endl;



	if (mygraph.type_of_graph==1)
	{
		int maxddd=0;
		i=1;
		fin2.open(opinionfile);
		while(getline (fin2,szLine))
		{
			vector<string> tData;
			istringstream iss(szLine);
			copy(istream_iterator<string>(iss),istream_iterator<string>(), back_inserter<vector<string> >(tData));
			for(vector<string>::iterator iter = tData.begin(); iter!=tData.end(); ++iter)
			{
				int tempd=atoi((*iter).c_str());
				if (maxddd<=tempd)
				{
					maxddd=tempd;
				}
			}
			i++;	
		}
		fin2.close();
		fin2.clear();
		mygraph.d=maxddd;
		mygraph.beta=mygraph.d;
		for (i=1;i<=mygraph.n;i++)
		{
			mygraph.Opinion[i]=new float[mygraph.d+1];
			mygraph.Opinion[i][0]=mygraph.d;
			mygraph.FutureOpinion[i]=new float[mygraph.d+1];
			mygraph.FutureOpinion[i][0]=mygraph.d;
			for (j=1;j<=mygraph.d;j++)
			{
				mygraph.Opinion[i][j]=0;
				mygraph.FutureOpinion[i][j]=0;
			}
			mygraph.Reputation[i]=0;
			mygraph.varsigma[i]=0;
			mygraph.state[i]=0;
			mygraph.Local_K_means_Objective[i]=0;
			mygraph.Local_Modularity[i]=0;
		}
		i=1;
		fin2.open(opinionfile);
		while(getline (fin2,szLine))
		{
			vector<string> tData;
			istringstream iss(szLine);
			copy(istream_iterator<string>(iss),istream_iterator<string>(), back_inserter<vector<string> >(tData));
			for(vector<string>::iterator iter = tData.begin(); iter!=tData.end(); ++iter)
			{
				mygraph.Opinion[i][atoi((*iter).c_str())]=1;
			}
			i++;	
		}
		fin2.close();
		fin2.clear();
	}
	else
	{
		mygraph.d=64;
		mygraph.beta=mygraph.d;
		for (i=1;i<=mygraph.n;i++)
		{
			mygraph.Opinion[i]=new float[mygraph.d+1];
			mygraph.Opinion[i][0]=mygraph.d;
			mygraph.FutureOpinion[i]=new float[mygraph.d+1];
			mygraph.FutureOpinion[i][0]=mygraph.d;
			for (j=1;j<=mygraph.d;j++)
			{
				mygraph.Opinion[i][j]=0;
				mygraph.FutureOpinion[i][j]=0;
			}
			mygraph.Reputation[i]=0;
			mygraph.varsigma[i]=0;
			mygraph.state[i]=0;
			mygraph.Local_K_means_Objective[i]=0;
			mygraph.Local_Modularity[i]=0;
		}
		srand(GetTickCount());
		for (i=1;i<=mygraph.n;i++)
		{
			Rand(mygraph.Opinion[i], mygraph.d+1);
			mygraph.Opinion[i][0]=mygraph.d;
		}
	}
	
	cout<<"Number of opinion dimensions: "<<mygraph.d<<endl;
	



	if(mygraph.type_of_Topology_similarity==1)
	{
		cout<<"GK-means will use Jaccard Coefficient"<<endl;
	}
	else if (mygraph.type_of_Topology_similarity==2)
	{
		cout<<"GK-means will use Salton Index"<<endl;
	}
	else if (mygraph.type_of_Topology_similarity==3)
	{
		cout<<"GK-means will use Sorensen Index"<<endl;
	}
	else if (mygraph.type_of_Topology_similarity==4)
	{
		cout<<"GK-means will use Hub Promoted Index"<<endl;
	}
	else if (mygraph.type_of_Topology_similarity==5)
	{
		cout<<"GK-means will use Hub Depressed Index"<<endl;
	}
	else if (mygraph.type_of_Topology_similarity==6)
	{
		cout<<"GK-means will use Leicht-Holme-Newman Index"<<endl;
	}

	if (mygraph.type_of_divergence==1)
	{
		cout<<"GK-means will use Squared Euclidean Distance"<<endl;
	}
	else if (mygraph.type_of_divergence==2)
	{
		cout<<"GK-means will use KL-divergence"<<endl;
	}
	else if (mygraph.type_of_divergence==3)
	{
		cout<<"GK-means will use Cosine Distance"<<endl;
	}
	else if (mygraph.type_of_divergence==4)
	{
		cout<<"GK-means will use Normalized Cosine Distance"<<endl;
	}

	/*
	if (mygraph.typeofoutput==0)
	{
		cout<<"GK-means will product non-overlapping clusters"<<endl;
	}
	else
	{
		cout<<"GK-means will product overlapping clusters"<<endl;

	}
	

	cout<<"The decline parameter of opinion dynamics in Phase_1: "<<mygraph.rho<<endl;
	cout<<"The relative decline threshold of opinion dynamics in Phase_1: "<<mygraph.varepsilon<<endl;
	*/
}


float Neighborhood_based_similarities(Neighborhood* Node_1, Neighborhood* Node_2, int type)
{
	float size_a=Node_1[0].ID;
	float size_b=Node_2[0].ID;
	int i=1;
	int j=1;
	float joint_number=2;
	while(1)
	{
		if (i>Node_1[0].ID||j>Node_2[0].ID)
		{
			break;
		}
		else if (Node_1[i].ID>Node_2[j].ID)
		{
			j++;
		}
		else if (Node_1[i].ID<Node_2[j].ID)
		{
			i++;
		}
		else 
		{
			i++;
			j++;
			joint_number++;
		}
	}
	float union_number=size_a+size_b-joint_number+2;
	size_a++;
	size_b++;
	if (type==1)
	{
		return joint_number/union_number;
	}
	else if (type==2)
	{
		return joint_number/(sqrt(size_a*size_b));
	}
	else if (type==3)
	{
		return 2*joint_number/(size_a+size_b);
	}
	else if (type==4)
	{
		if (size_a<size_b)
		{
			return 2*joint_number/size_a;
		}
		else
		{
			return 2*joint_number/size_b;
		}
	}
	else if (type==5)
	{
		if (size_a<size_b)
		{
			return 2*joint_number/size_b;
		}
		else
		{
			return 2*joint_number/size_a;
		}
	}
	else if (type==6)
	{
		return 2*joint_number/size_a/size_b;
	}
	
}

float Bregman_divergence(float * Node_1, float* Node_2, int type)
{
	int i=1;
	int d=(int)Node_1[0];
	float divergence=0.0;
	if (type==1)
	{
		for (i=1;i<=d;i++)
		{
			divergence+=pow((Node_1[i]-Node_2[i]),2);
		}
		return divergence;
	}
	else if (type==2)
	{
		float basevalue=(float)1/Node_1[0];
		float sum_a=1.0;
		float sum_b=1.0;
		for (i=1;i<=d;i++)
		{
			sum_a+=Node_1[i];
			sum_b+=Node_2[i];
		}
		for (i=1;i<=d;i++)
		{
			divergence+=(Node_2[i]+basevalue)/sum_b*log(((Node_2[i]+basevalue)/sum_b)/((Node_1[i]+basevalue)/sum_a));
		}
		return divergence;
	}
	else if (type==3)
	{
		float abs_a=0.0;
		float abs_b=0.0;
		for (i=1;i<=d;i++)
		{
			abs_a+=pow(Node_1[i],2);
			abs_b+=pow(Node_2[i],2);
		}
		abs_a=sqrt(abs_a);
		abs_b=sqrt(abs_b);
		for (i=1;i<=d;i++)
		{
			divergence+=Node_1[i]*Node_2[i];
		}
		return abs_a-divergence/abs_b;
	}
	else if (type==4)
	{
		float abs_a=0.0;
		float abs_b=0.0;
		for (i=1;i<=d;i++)
		{
			abs_a+=pow(Node_1[i],2);
			abs_b+=pow(Node_2[i],2);
		}
		abs_a=sqrt(abs_a);
		abs_b=sqrt(abs_b);
		for (i=1;i<=d;i++)
		{
			divergence+=Node_1[i]*Node_2[i];
		}
		return 1-divergence/abs_a/abs_b;
	}

}




void* Thread_Phase_11(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	
	while(visited_ID<=mygraph.n)
	{
		pthread_mutex_lock(&mutex);
		i=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (i<=mygraph.n&&mygraph.Neighbor[i][0].ID>0)
		{
			for (j=1;j<=mygraph.Neighbor[i][0].ID;j++)
			{
				int x=i;
				int y=mygraph.Neighbor[i][j].ID;
				mygraph.Neighbor[i][j].lambda=Neighborhood_based_similarities(mygraph.Neighbor[x],mygraph.Neighbor[y],6);
			}

		}
		if(i>mygraph.n)
		{
			finish=1;
		}
	}
}








void* Thread_Phase_12(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	
	while(visited_ID<=mygraph.n)
	{
		pthread_mutex_lock(&mutex);
		i=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (i<=mygraph.n&&mygraph.Neighbor[i][0].ID>0)
		{
			for (j=1;j<=mygraph.Neighbor[i][0].ID;j++)
			{
				int x=i;
				int y=mygraph.Neighbor[i][j].ID;
				mygraph.Neighbor[i][j].varpi=Bregman_divergence(mygraph.Opinion[x],mygraph.Opinion[y],mygraph.type_of_divergence);
			}
			
		}
		if(i>mygraph.n)
		{
			finish=1;
		}
	}
}











void* Thread_Phase_13(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	
	while(visited_ID<=mygraph.n)
	{
		pthread_mutex_lock(&mutex);
		i=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (i<=mygraph.n&&mygraph.Neighbor[i][0].ID>0)
		{
			
			int nRand = rand();//随机生成0 - 0x7FFF(即0 -- RAND_MAX)的随机数
			float alpha = (float)nRand / RAND_MAX;//将随机数映射到-1 -- 1区间内
		//	float alpha=0.5;
			float sumsim=0.0;
			for (j=1;j<=mygraph.Neighbor[i][0].ID;j++)
			{
				if (mygraph.Neighbor[i][j].varpi<=mygraph.Believe_Threshold)
				{
					sumsim+=mygraph.Neighbor[i][j].lambda;
				}
			}
			
			if (sumsim!=0)
			{

				for (j=1;j<=mygraph.d;j++)
				{
					mygraph.FutureOpinion[i][j]=alpha*mygraph.Opinion[i][j];
				}
				for (j=1;j<=mygraph.Neighbor[i][0].ID;j++)
				{
					int y=mygraph.Neighbor[i][j].ID;
					if (mygraph.Neighbor[i][j].varpi<=mygraph.Believe_Threshold)
					{
						for (k=1;k<=mygraph.d;k++)
						{
							mygraph.FutureOpinion[i][k]+=(1-alpha)*mygraph.Neighbor[i][j].lambda/sumsim*mygraph.Opinion[y][k];
						}

					}
				}
			}
			else
			{
				for (j=1;j<=mygraph.d;j++)
				{
					mygraph.FutureOpinion[i][j]=mygraph.Opinion[i][j];
				}
			}


			float decline=0.0;
			float tempselfdifferece=Bregman_divergence(mygraph.Opinion[i],mygraph.FutureOpinion[i],mygraph.type_of_divergence);

		//	decline=tempselfdifferece/mygraph.selfdistance[i];
		//	mygraph.selfdistance[i]=tempselfdifferece;

		//	if (decline>mygraph.varepsilon)
		
			if (tempselfdifferece>=mygraph.d*mygraph.varepsilon)
			{
				pthread_mutex_lock(&mutex1);
				mygraph.opinionupdateingnumber=mygraph.opinionupdateingnumber+1;
				pthread_mutex_unlock(&mutex1);
			}

		}
		if(i>mygraph.n)
		{
			finish=1;
		}
	}
}






void Opinion_Dynamics()
{
	int NUMBEROFThread=32;
	pthread_t threads[NUMBEROFThread];
	int ThreadNUM=0;
	int rc;
	pthread_mutex_init(&mutex,NULL);
	pthread_mutex_init(&mutex1,NULL);
	pthread_mutex_init(&mutex2,NULL);
	int i=0;
	int j=0;



	float * preopinion=new float[mygraph.d+1];
	preopinion[0]=mygraph.d;
	for (i=1;i<=mygraph.d;i++)
	{
		preopinion[i]=0;
	}
	
	
	
	for (i=1;i<=mygraph.n;i++)
	{
		mygraph.selfdistance[i]=Bregman_divergence(preopinion,mygraph.Opinion[i],mygraph.type_of_divergence);
	}






	finish=0;		
	visited_ID=0;
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
		rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_11, NULL); 
	while(finish==0)	
		sleep(0.000001);
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);


	while(1)
	{
		finish=0;		
		visited_ID=0;
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
			rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_12, NULL); 
		while(finish==0)	
			sleep(0.000001);
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);

		mygraph.Believe_Threshold=mygraph.beta*pow(mygraph.rho,mygraph.time_1);
		mygraph.opinionupdateingnumber=0;

		srand(GetTickCount());

		finish=0;		
		visited_ID=0;
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
			rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_13, NULL); 
		while(finish==0)	
			sleep(0.000001);
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);


		for(i=1;i<=mygraph.n;i++)
		{
			for (j=1;j<=mygraph.d;j++)
			{
				mygraph.Opinion[i][j]=mygraph.FutureOpinion[i][j];
			}
		}

		cout<<mygraph.Believe_Threshold<<" "<<mygraph.opinionupdateingnumber<<endl;
		mygraph.time_1++;
		if (mygraph.opinionupdateingnumber==0||mygraph.time_1>=100)
		{
			break;
		}
	}
							
}



void* Thread_Phase_21(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	
	while(visited_ID<=mygraph.n)
	{
		pthread_mutex_lock(&mutex);
		i=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (i<=mygraph.n&&mygraph.Neighbor[i][0].ID>0)
		{
			mygraph.Neighbor[i][0].lambda=0;
			
			for (j=1;j<=mygraph.Neighbor[i][0].ID;j++)
			{
				int x=i;
				int y=mygraph.Neighbor[i][j].ID;
				mygraph.Neighbor[i][j].lambda=Neighborhood_based_similarities(mygraph.Neighbor[x],mygraph.Neighbor[y],mygraph.type_of_Topology_similarity);
				mygraph.Neighbor[i][j].lambda=mygraph.Neighbor[i][j].lambda*exp(-1*mygraph.Neighbor[i][j].varpi);
				mygraph.Neighbor[i][0].lambda+=mygraph.Neighbor[i][j].lambda;
			}
				
			mygraph.Reputation[i]=mygraph.Neighbor[i][0].lambda;
		}
		if(i>mygraph.n)
		{
			finish=1;
		}
	}
}


void* Thread_Phase_22(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	
	while(visited_ID<=mygraph.n)
	{
		pthread_mutex_lock(&mutex);
		i=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (i<=mygraph.n&&mygraph.Neighbor[i][0].ID>0)
		{
			mygraph.Neighbor[i][0].varpi=0;
			
			for (j=1;j<=mygraph.Neighbor[i][0].ID;j++)
			{
				int y=mygraph.Neighbor[i][j].ID;
				if (mygraph.Neighbor[i][0].lambda>=mygraph.Neighbor[y][0].lambda)
				{
					mygraph.Neighbor[i][0].varpi++;
				}
			}
			mygraph.Neighbor[i][0].varpi=mygraph.Neighbor[i][0].varpi/mygraph.Neighbor[i][0].ID;
			mygraph.varsigma[i]=mygraph.Neighbor[i][0].varpi;
		}
		if(i>mygraph.n)
		{
			finish=1;
		}
	}
}



void Initial_Cluster()
{
	int NUMBEROFThread=32;
	pthread_t threads[NUMBEROFThread];
	int ThreadNUM=0;
	int rc;
	pthread_mutex_init(&mutex,NULL);
	pthread_mutex_init(&mutex1,NULL);
	pthread_mutex_init(&mutex2,NULL);
	int i=0;
	int j=0;
		
	finish=0;		
	visited_ID=0;
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
		rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_21, NULL); 
	while(finish==0)	
		sleep(0.000001);
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);

	finish=0;		
	visited_ID=0;
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
		rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_22, NULL); 
	while(finish==0)	
		sleep(0.000001);
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);

	int p=1;
	int* visited=new int[mygraph.n+1];
	multimap<float,int> tempmap;
	multimap<float,int>::iterator it_map;

	for (i=1;i<=mygraph.n;i++)
	{
		visited[i]=0;
		tempmap.insert(multimap<float, int> :: value_type(-1*mygraph.Reputation[i], i));
	}



	for (it_map=tempmap.begin();it_map!=tempmap.end();it_map++)
	{
		int x=it_map->second;
		if (visited[x]==0)
		{
			visited[x]=1;
			mygraph.state[x]=p;

			for (j=1;j<=mygraph.Neighbor[x][0].ID;j++)
			{
				int y=mygraph.Neighbor[x][j].ID;
				if (visited[y]==0)
				{
					visited[y]=1;
	
				//	mygraph.state[y]=p;
				}
			}
			p++;
			
			if (p>mygraph.K)
			{
				break;
			}
			
		}
	}



	OutputGraphgml(mygraph);

	mygraph.K=p;
	

	mygraph.cluster=new int*[mygraph.K+1];
	mygraph.centroid=new float*[mygraph.K+1];
	mygraph.theta=new float[mygraph.K+1];


	
	for (p=1;p<=mygraph.K;p++)
	{
		mygraph.cluster[p]=new int[1];
		mygraph.centroid[p]=new float [mygraph.d+1];
		mygraph.theta[p]=0;
		for (j=1;j<=mygraph.d;j++)
		{
			mygraph.centroid[p][j]=0;
		}
	}
	p=1;
	for (i=1;i<=mygraph.n;i++)
	{
		int label=mygraph.state[i];
		if (label!=0)
		{
			for (j=1;j<=mygraph.d;j++)
			{
				mygraph.centroid[label][j]=mygraph.Opinion[i][j];
			}

		}
	}
}



void* Thread_Phase_31(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	int p=0;
	set<int>::iterator it_set;
	
	while(visited_ID<=mygraph.K)
	{
		pthread_mutex_lock(&mutex);
		p=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (p<=mygraph.K&&mygraph.cluster[p][0]>0)
		{
			float tempsize=mygraph.cluster[p][0];
			for (i=1;i<=mygraph.cluster[p][0];i++)
			{
				
				mygraph.theta[p]+=mygraph.Neighbor[mygraph.cluster[p][i]][0].ID;
				for(j=1;j<=mygraph.d;j++)
				{
					mygraph.centroid[p][j]+=mygraph.Opinion[mygraph.cluster[p][i]][j];
					
				}
				
			}
			mygraph.theta[p]/=2*mygraph.m;
			for(j=1;j<=mygraph.d;j++)
			{
				mygraph.centroid[p][j]/=tempsize;
			}

		}
		if(p>mygraph.K)
		{
			finish=1;
		}
	}
}






float Neighborhood_and_cluster(Neighborhood* Node_1, int* cluster)
{
	float size_a=Node_1[0].ID;
	float size_b=cluster[0];
	int i=1;
	int j=1;
	float joint_number=0;
	while(1)
	{
		if (i>Node_1[0].ID||j>cluster[0])
		{
			break;
		}
		else if (Node_1[i].ID>cluster[j])
		{
			j++;
		}
		else if (Node_1[i].ID<cluster[j])
		{
			i++;
		}
		else 
		{
			i++;
			j++;
			joint_number++;
		}
	}
	return joint_number;
}


void* Thread_Phase_32(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	set<int> feasiblelable;
	set<int>::iterator it_set;
	
	while(visited_ID<=mygraph.n)
	{
		pthread_mutex_lock(&mutex);
		i=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (i<=mygraph.n&&mygraph.Neighbor[i][0].ID>0)
		{
			int currentlabel=mygraph.state[i];
			for (j=1;j<=mygraph.Neighbor[i][0].ID;j++)
			{
				int y=mygraph.Neighbor[i][j].ID;
				int y_label=mygraph.state[y];
				if (y_label!=0)
				{
					feasiblelable.insert(y_label);
				}
			}
			mygraph.Feasible_Strategy[i].insert(currentlabel);
			float tempmodularity=0;
			if (currentlabel!=0)
			{
				float current_tauki=Neighborhood_and_cluster(mygraph.Neighbor[i], mygraph.cluster[currentlabel])/(float)mygraph.Neighbor[i][0].ID;
				mygraph.Local_Modularity[i]=(current_tauki-mygraph.theta[currentlabel])*(float)mygraph.Neighbor[i][0].ID/2/mygraph.m;
				tempmodularity=mygraph.Local_Modularity[i];
			}
			else
			{
				mygraph.Local_Modularity[i]=0;
				tempmodularity=-1;

			}
			
			

			
			for (it_set=feasiblelable.begin();it_set!=feasiblelable.end();it_set++)
			{
				int flabel=*it_set;
				float tauki=Neighborhood_and_cluster(mygraph.Neighbor[i], mygraph.cluster[flabel])/(float)mygraph.Neighbor[i][0].ID;
				float localmodularity=0;
				if (flabel!=currentlabel)
				{
					localmodularity=tauki-mygraph.theta[flabel]-(float)mygraph.Neighbor[i][0].ID/2/mygraph.m;
				}
				if (localmodularity>=tempmodularity)
				{
					mygraph.Feasible_Strategy[i].insert(flabel);
				}
			}
			feasiblelable.clear();

		}
		if(i>mygraph.n)
		{
			finish=1;
		}
	}
}



void* Thread_Phase_33(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	set<int> feasiblelable;
	set<int>::iterator it_set;
	
	while(visited_ID<=mygraph.n)
	{
		pthread_mutex_lock(&mutex);
		i=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (i<=mygraph.n&&mygraph.Neighbor[i][0].ID>0)
		{
			int label=0;
			float mindistance=mygraph.d;
			for (it_set=mygraph.Feasible_Strategy[i].begin();it_set!=mygraph.Feasible_Strategy[i].end();it_set++)
			{
				int templabel=*it_set;
				if (templabel!=0)
				{
					float tempdistance=Bregman_divergence(mygraph.Opinion[i],mygraph.centroid[templabel],mygraph.type_of_divergence);
					if (tempdistance<=mindistance)
					{
						mindistance=tempdistance;
						label=templabel;
					}
				}
	

			}
			
			if (label!=mygraph.state[i])
			{
				pthread_mutex_lock(&mutex1);
				mygraph.opinionupdateingnumber++;
				pthread_mutex_unlock(&mutex1);
			}
			
			if (label!=0)
			{
				mygraph.state[i]=label;
				mygraph.Local_K_means_Objective[i]=mindistance;
			}
		}
		if(i>mygraph.n)
		{
			finish=1;
		}
	}
}









void Initial()
{

	int i=1;
	int j=1;
	float Modularity=0.0;
	float K_means_objective=0.0;
	for (i=1;i<=mygraph.n;i++)
	{
		if (mygraph.state[i]==0)
		{
			float mindistrance=mygraph.d;
			int label=0;
			for (j=1;j<=mygraph.Neighbor[i][0].ID;j++)
			{
				int y=mygraph.Neighbor[i][j].ID;
				int z=mygraph.state[y];
				if (z!=0)
				{
					float tempdistance=Bregman_divergence(mygraph.Opinion[i],mygraph.centroid[z],mygraph.type_of_divergence);
					if (tempdistance<=mindistrance)
					{
						mindistrance=tempdistance;
						label=z;
					}

				}
			}
			mygraph.state[i]=label;
			if (label!=0)
			{
				K_means_objective+=mindistrance;
			}
			else
			{
				K_means_objective+=1;
			}
		}
	}
	mygraph.time_2++;
	
	OutputGraphgml(mygraph);

//	cout<<mygraph.time_2<<" "<<K_means_objective<<endl;

}
















void Dynamic_Initial()
{
	int i=0;
	int j=0;
	int p=0;
	mygraph.opinionupdateingnumber=0;
	for(p=1;p<=mygraph.K;p++)
	{
		delete [] mygraph.cluster[p];
		for (j=1;j<=mygraph.d;j++)
		{
			mygraph.centroid[p][j]=0;
		}
		mygraph.theta[p]=0;
	}

	
	
	int* clustersize=new int[mygraph.K+1];
	for (p=0;p<=mygraph.K;p++)
	{
		clustersize[p]=0;
	}
	for (i=1;i<=mygraph.n;i++)
	{
		mygraph.Local_K_means_Objective[i]=1;
		mygraph.Local_Modularity[i]=0;
		mygraph.Feasible_Strategy[i].clear();
		clustersize[mygraph.state[i]]++;
	}

	for (p=1;p<=mygraph.K;p++)
	{
		mygraph.cluster[p]=new int [clustersize[p]+1];
		mygraph.cluster[p][0]=0;
	}
	for (i=1;i<=mygraph.n;i++)
	{
		if (mygraph.state[i]!=0)
		{

			mygraph.cluster[mygraph.state[i]][++mygraph.cluster[mygraph.state[i]][0]]=i;
		}
	}
	delete [] clustersize;
}






void Dynamic_Game()
{
	int NUMBEROFThread=32;
	pthread_t threads[NUMBEROFThread];
	int ThreadNUM=0;
	int rc;
	pthread_mutex_init(&mutex,NULL);
	pthread_mutex_init(&mutex1,NULL);
	pthread_mutex_init(&mutex2,NULL);
	int i=0;
	int j=0;
	int p=0;

	float Modularity;
	float K_means_objective;
	while(1)
	{
		Dynamic_Initial();
		finish=0;		
		visited_ID=0;
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
			rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_31, NULL); 
		while(finish==0)	
			sleep(0.000001);
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);

	

		finish=0;		
		visited_ID=0;
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
			rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_32, NULL); 
		while(finish==0)	
			sleep(0.000001);
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);

	

		finish=0;		
		visited_ID=0;
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
			rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_33, NULL); 
		while(finish==0)	
			sleep(0.000001);
		for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);



		Modularity=0.0;
		K_means_objective=0.0;
		for (i=1;i<=mygraph.n;i++)
		{
			Modularity+=mygraph.Local_Modularity[i];
			K_means_objective+=mygraph.Local_K_means_Objective[i];
		}
		cout<<Modularity<<" "<<K_means_objective<<endl;
		mygraph.time_2++;
	//	OutputGraphgml(mygraph);

		if (mygraph.opinionupdateingnumber==0|| mygraph.time_2>=mygraph.maxiteration)
		{
			break;
		}
	}

}

void Writeclusters(char* head, GKmeans mygraph)
{
	ofstream fout;
	char* clustertail=".label";
	char* clusterfile=strcatre(head,clustertail);
	int i=0;
	int j=0;
	int p=0;
	int n=mygraph.n;
	set<int>::iterator it_set;
	int realnumbercluser=0;
	fout.open(clusterfile);
	for (p=1;p<=mygraph.K;p++)
	{
		if (mygraph.cluster[p][0]>=3)
		{
			realnumbercluser++;
			for (i=1;i<=mygraph.cluster[p][0];i++)
			{
				fout<<mygraph.cluster[p][i]<<" ";
			}
			fout<<endl;
		}
	}
	fout.close();
	cout<<"Real Detected Clusters: "<<realnumbercluser<<endl;
}



void ReWriteclusters(char* head, GKmeans mygraph)
{
	ofstream fout;
	char* clustertail=".label";
	char* clusterfile=strcatre(head,clustertail);
	int i=0;
	int j=0;
	int p=0;



	fout.open(clusterfile);
	set<int>* mycluster=new set<int>[mygraph.n+1];
	set<int>::iterator it_set;
	for (i=1;i<=mygraph.n;i++)
	{
		int label=mygraph.state[i];
		if (label!=0)
		{
			mycluster[i].insert(label);
			fout<<label<<" ";
			for (it_set=mygraph.Feasible_Strategy[i].begin();it_set!=mygraph.Feasible_Strategy[i].end();it_set++)
			{
				int relabel=*it_set;
				mycluster[i].insert(relabel);
				fout<<relabel<<" ";
			}
		}
		fout<<endl;

	}

	fout.close();




	/*
	set<int>* mycluster=new set<int>[mygraph.K+1];
	set<int>::iterator it_set;
	for (i=1;i<=mygraph.n;i++)
	{
		int label=mygraph.state[i];
		if (label!=0)
		{
			mycluster[label].insert(i);
			for (it_set=mygraph.Feasible_Strategy[i].begin();it_set!=mygraph.Feasible_Strategy[i].end();it_set++)
			{
				int relabel=*it_set;
				mycluster[relabel].insert(i);
			}
		}

	}

	int realnumbercluser=0;
	fout.open(clusterfile);
	for (p=1;p<=mygraph.K;p++)
	{
		if (mycluster[p].size()>0)
		{
			realnumbercluser++;
			for (it_set=mycluster[p].begin();it_set!=mycluster[p].end();it_set++)
			{
				fout<<*it_set<<" ";
			}
			fout<<endl;

		}
	}

	fout.close();

	cout<<"Real Detected Clusters: "<<realnumbercluser<<endl;

    */
}

















int** Readcluters(char* head)
{
	ifstream fin;
	char* clustertail=".label";
	char* clusterfile=strcatre(head,clustertail);
	string szLine;
	int i=0;
	int j=0;
	int K=0;
	set<int>::iterator it_set;
	fin.open(clusterfile);
    i=0;
	while(getline (fin,szLine))
	{
		i++;
	}
	fin.close();
	fin.clear();
	K=i;
	int ** clusters=new int *[K+1];
	clusters[0]=new int [1];
	clusters[0][0]=K;
	fin.open(clusterfile);
	int p=1;
	while(getline (fin,szLine))
	{
		vector<string> tData;
		istringstream iss(szLine);
		copy(istream_iterator<string>(iss),istream_iterator<string>(), back_inserter<vector<string> >(tData));
		set<int> tempset;
		for(vector<string>::iterator iter = tData.begin(); iter!=tData.end(); ++iter)
		{
			tempset.insert(atoi((*iter).c_str()));
		}
		int tempK=tempset.size();
		clusters[p]=new int [tempK+1];
		clusters[p][0]=tempK;
		j=1;
		for (it_set=tempset.begin();it_set!=tempset.end();it_set++)
		{
			clusters[p][j]=*it_set;
			j++;
		}
		p++;
		tempset.clear();
	}

	return clusters;

}




int** ReadGTcluters(char* head)
{
	ifstream fin;
	char* clustertail=".gt";
	char* clusterfile=strcatre(head,clustertail);
	string szLine;
	int i=0;
	int j=0;
	int K=0;
	set<int>::iterator it_set;
	fin.open(clusterfile);
    i=0;
	while(getline (fin,szLine))
	{
		i++;
	}
	fin.close();
	fin.clear();
	K=i;
	int ** clusters=new int *[K+1];
	clusters[0]=new int [1];
	clusters[0][0]=K;
	fin.open(clusterfile);
	int p=1;
	while(getline (fin,szLine))
	{
		vector<string> tData;
		istringstream iss(szLine);
		copy(istream_iterator<string>(iss),istream_iterator<string>(), back_inserter<vector<string> >(tData));
		set<int> tempset;
		for(vector<string>::iterator iter = tData.begin(); iter!=tData.end(); ++iter)
		{
			tempset.insert(atoi((*iter).c_str()));
		}
		int tempK=tempset.size();
		clusters[p]=new int [tempK+1];
		clusters[p][0]=tempK;
		j=1;
		for (it_set=tempset.begin();it_set!=tempset.end();it_set++)
		{
			clusters[p][j]=*it_set;
			mygraph.state[clusters[p][j]]=p;
			j++;
		}
		p++;
		tempset.clear();
	}
	mygraph.time_2=99;
	OutputGraphgml(mygraph);
	return clusters;
	
}

float CalculateF1(int* A, int* B)
{
	int K_A=A[0];
	int K_B=B[0];
	int i=1;
	int j=1;
	float joint=0.0;
	while(1)
	{
		if (i>K_A||j>K_B)
		{
			break;
		}
		else if (A[i]>B[j])
		{
			j++;
		}
		else if (A[i]<B[j])
		{
			i++;
		}
		else 
		{
			i++;
			j++;
			joint++;
		}
	}
	float precision=joint/K_A;
	float recall=joint/K_B;
	float f1=2*precision*recall/(precision+recall);
	return f1;

}



float CalculateMaxF1(int* A, int** targetset)
{
	int K_A=A[0];
	int Size_T=targetset[0][0];
	float maxf1=0.0;
	int q=1;
	for (q=1;q<=Size_T;q++)
	{
		float tempf1=CalculateF1(A,targetset[q]);
		if (tempf1>=maxf1)
		{
			maxf1=tempf1;
		}
	}
	return maxf1;

}


float CalculateAvgF1(int** Our, int** GT)
{
	int K_1=Our[0][0];
	int K_2=GT[0][0];
	float* MaxF1_1=new float[K_1+1];
	float* MaxF1_2=new float[K_2+1];
	int p=0;
	int q=0;
	float sumMAXF1_1=0.0;
	float sumMAXF1_2=0.0;
	for (p=1;p<=K_1;p++)
	{
		MaxF1_1[p]=CalculateMaxF1(Our[p],GT);
		sumMAXF1_1+=MaxF1_1[p];
	}
	for (q=1;q<=K_2;q++)
	{
		MaxF1_2[q]=CalculateMaxF1(GT[q],Our);
		sumMAXF1_2+=MaxF1_2[q];
	}	
	
	float AvgF1=sumMAXF1_1/2/K_1+sumMAXF1_2/2/K_2;
	return AvgF1;
	
}


struct Comparedata
{
	int** Data_1;
	int** Data_2;
	float* MaxF1_1;
	float* MaxF1_2;
	float sumMAXF1_1;
	float sumMAXF1_2;
	float** cap;
};

Comparedata mycompare_data;




void* Thread_Phase_4_1(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	int p=0;
	set<int> feasiblelable;
	set<int>::iterator it_set;
	
	while(visited_ID<=mycompare_data.Data_1[0][0])
	{
		pthread_mutex_lock(&mutex);
		p=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (p<=mycompare_data.Data_1[0][0])
		{
			mycompare_data.MaxF1_1[p]=CalculateMaxF1(mycompare_data.Data_1[p],mycompare_data.Data_2);
			pthread_mutex_lock(&mutex1);
			mycompare_data.sumMAXF1_1+=mycompare_data.MaxF1_1[p];
			pthread_mutex_unlock(&mutex1);
		}
		if(p>mycompare_data.Data_1[0][0])
		{
			finish=1;
		}
	}
}


void* Thread_Phase_4_2(void *argPointer)//The thread for Topic Dynamics with Decaying Confidence
{   
	int i=0;
	int j=0;
	int k=0;
	int p=0;
	set<int> feasiblelable;
	set<int>::iterator it_set;
	
	while(visited_ID<=mycompare_data.Data_2[0][0])
	{
		pthread_mutex_lock(&mutex);
		p=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (p<=mycompare_data.Data_2[0][0])
		{
			mycompare_data.MaxF1_2[p]=CalculateMaxF1(mycompare_data.Data_2[p],mycompare_data.Data_1);
			pthread_mutex_lock(&mutex1);
			mycompare_data.sumMAXF1_2+=mycompare_data.MaxF1_2[p];
			pthread_mutex_unlock(&mutex1);
		}
		if(p>mycompare_data.Data_2[0][0])
		{
			finish=1;
		}
	}
}



float Calculatecap(int* A, int* B)
{
	int K_A=A[0];
	int K_B=B[0];
	int i=1;
	int j=1;
	float joint=0.0;
	while(1)
	{
		if (i>K_A||j>K_B)
		{
			break;
		}
		else if (A[i]>B[j])
		{
			j++;
		}
		else if (A[i]<B[j])
		{
			i++;
		}
		else 
		{
			i++;
			j++;
			joint++;
		}
	}
	return joint;
	/*
	if (joint==0)
	{
		return 1;
	}
	else
	{
		return joint;
	}
	*/
}


void* Thread_Phase_4_3(void *argPointer)
{   
	int i=0;
	int j=0;
	int k=0;
	int p=0;
	
	while(visited_ID<=mycompare_data.Data_1[0][0])
	{
		
		pthread_mutex_lock(&mutex);
		p=++visited_ID;
		pthread_mutex_unlock(&mutex);
		if (p<=mycompare_data.Data_1[0][0])
		{
			for (j=1;j<=mycompare_data.Data_2[0][0];j++)
			{
				mycompare_data.cap[p][j]=Calculatecap(mycompare_data.Data_1[p],mycompare_data.Data_2[j]);
			}
		}
		if(p>mycompare_data.Data_1[0][0])
		{
			finish=1;
		}
	}
}










void ReOutputquality(char* head, float n)
{
	
	mycompare_data.Data_1=Readcluters(head);
	mycompare_data.Data_2=ReadGTcluters(head);
	int size_a=mycompare_data.Data_1[0][0];
	int size_b=mycompare_data.Data_2[0][0];
	mycompare_data.MaxF1_1=new float[size_a+1];
	mycompare_data.MaxF1_2=new float[size_b+1];
	mycompare_data.sumMAXF1_1=0.0;
	mycompare_data.sumMAXF1_2=0.0;


	mycompare_data.cap=new float*[size_a+1];
	int i=1;
	int j=1;
	for (i=1;i<=size_a;i++)
	{
		mycompare_data.cap[i]=new float[size_b+1];
	}









	int NUMBEROFThread=32;
	pthread_t threads[NUMBEROFThread];
	int ThreadNUM=0;
	int rc;
	pthread_mutex_init(&mutex,NULL);
	pthread_mutex_init(&mutex1,NULL);
	pthread_mutex_init(&mutex2,NULL);
	finish=0;		
	visited_ID=0;
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
		rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_4_1, NULL); 
	while(finish==0)	
		sleep(0.000001);
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);


	finish=0;		
	visited_ID=0;
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
		rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_4_2, NULL); 
	while(finish==0)	
		sleep(0.000001);
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);




	finish=0;		
	visited_ID=0;
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)	
		rc = pthread_create(&threads[ThreadNUM], NULL, Thread_Phase_4_3, NULL); 
	while(finish==0)	
		sleep(0.000001);
	for(ThreadNUM=0;ThreadNUM<NUMBEROFThread;ThreadNUM++)
		pthread_join( threads[ThreadNUM], NULL);






	



//	float AvgF1=mycompare_data.sumMAXF1_1/2/mycompare_data.Data_1[0][0]+mycompare_data.sumMAXF1_2/2/mycompare_data.Data_2[0][0];

	float AvgF1=mycompare_data.sumMAXF1_2/mycompare_data.Data_2[0][0];



	float NMI=0.0;
	float* NMI_A=new float[size_a+1];
	float* NMI_B=new float[size_b+1];
	for (i=1;i<=size_a;i++)
	{
		NMI_A[i]=0;
	}
	for (j=1;j<=size_b;j++)
	{
		NMI_B[j]=0;
	}
	for (i=1;i<=size_a;i++)
	{
		for (j=1;j<=size_b;j++)
		{
			NMI_A[i]+=mycompare_data.cap[i][j];
		}
	}


	for (j=1;j<=size_b;j++)
	{
		for (i=1;i<=size_a;i++)
		{
			NMI_B[j]+=mycompare_data.cap[i][j];
		}
	}

	for (i=1;i<=size_a;i++)
	{
		for (j=1;j<=size_b;j++)
		{
			if (mycompare_data.cap[i][j]!=0)
			{
				NMI+=mycompare_data.cap[i][j]*log(mycompare_data.cap[i][j]*n/NMI_A[i]/NMI_B[j])/log(2);
			}
			
		}
	}
	NMI=NMI*(-1*2);

	float sum_NMI_A=0.0;
	float sum_NMI_B=0.0;
	for(i=1;i<=size_a;i++)
	{
		if (NMI_A[i]!=0)
		{
			sum_NMI_A+=NMI_A[i]*log(NMI_A[i]/n)/log(2);
		}
		

	}
	for(j=1;j<=size_b;j++)
	{
		if(NMI_B[j]!=0)
		{
			sum_NMI_B+=NMI_B[j]*log(NMI_B[j]/n)/log(2);

		}
		
		
	}

	NMI=NMI/(sum_NMI_A+sum_NMI_B);


	cout<<"AvgF1 Score: "<<AvgF1<<endl;
		
	cout<<"NMI Score: "<<NMI<<endl;
}




























void Outputquality(char* head)
{
	int** OUR=Readcluters(head);
	int** GT=ReadGTcluters(head);
	cout<<"AvgF1 Score: "<<CalculateAvgF1(OUR, GT)<<endl;
}









int main(int argc, char **argv)
{
	struct timeval tod1, tod2,tod3,tod4,tod5,tod6, tod7;
	if (argc<=4)
    { 
		cout<< " Not enough arguments"<<endl;
		return -1;
    }
	char* head=argv[1];
	int type_of_Topology_similarity=atoi(argv[2]);
	int type_of_divergence=atoi(argv[3]);
	int K=atoi(argv[4]);



	/*
	int K=atoi(argv[2]);
	int d=atoi(argv[3]);
	int type_of_graph=atoi(argv[4]);
	int type_of_Topology_similarity=atoi(argv[5]);
	int type_of_divergence=atoi(argv[6]);
	float rho=atof(argv[7]);
	int maxiteration=atoi(argv[8]);
	int typeofoutput=atoi(argv[9]);
	*/

	cout<<"==========================================================="<<endl;
	gettimeofday(&tod1, NULL);
	Initialization(head,type_of_Topology_similarity,type_of_divergence,K);
	gettimeofday(&tod2, NULL);
	cout<<"==========================================================="<<endl;
	cout<<"Initializing Opinion Graph Time: "<<todiff(&tod2, &tod1) / 1000000.0<<"s"<<endl;

	cout<<"==========================================================="<<endl;
	Opinion_Dynamics();
	gettimeofday(&tod3, NULL);
	cout<<"Phase 1 : Opinion Dynamics: "<<todiff(&tod3, &tod2) / 1000000.0<<"s"<<endl;



	Initial_Cluster();
	gettimeofday(&tod4, NULL);
	cout<<"Phase 2 : Opinion Leader Identification: "<<todiff(&tod4, &tod3) / 1000000.0<<"s"<<endl;


	Dynamic_Game();

	gettimeofday(&tod5, NULL);
	cout<<"Phase 3 : Finding the Locally Pareto Optimality: "<<todiff(&tod5, &tod4) / 1000000.0<<"s"<<endl;
	cout<<"Total Time: "<<todiff(&tod5, &tod1) / 1000000.0<<"s"<<endl;
	cout<<"==========================================================="<<endl;
	OutputGraphgml(mygraph);

	if (mygraph.typeofoutput==0)
	{
		Writeclusters(head, mygraph);
	}
	else
	{
		ReWriteclusters(head, mygraph);

	}

	
//	ReOutputquality(head,mygraph.n);
	cout<<"==========================================================="<<endl;
	

	return 0;
}

