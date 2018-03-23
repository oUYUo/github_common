//typedef int ElementType;
#include<stdio.h>
#include<iostream>
#include<stdlib.h>
#include<queue>

using namespace std;
typedef struct TNode* Position;
typedef  Position BinTree;
template <typename Type>
class Tree{
//	private:
		
	public:
		Type Data;
		Tree* left_tree;
		Tree* right_tree;
		Tree* root;
		
	    Tree(Type const &obj):Data(obj),left_tree(NULL),right_tree(NULL){root=this;}
		
		void insert(Type ,Type data,int way);
		Tree* findTNode(Tree* node,Type data);
		Type retrieve() const;
		void LevelOrderTraversal(Tree*);
		void PreOrderTraversal(Tree*);
		void InOrderTraversal(Tree*);
		void PostOrderTraversal(Tree*);
		Tree* Left() const;
		Tree* Right() const;
		
		bool empty() const;
		bool is_leaf(Tree* BT,Type data) const;
		int size() const;
		int height(Tree* BT) const;
		void clear();
		void leaf(Tree* BT);	
		
		
};
template <typename Type>
Tree<Type>* Tree<Type>::findTNode(Tree* node,Type data){
	Tree* temp;
	if(node==NULL){
		return NULL;
	}
	else{
		if(node->Data==data){
			return node;
		}
		else{
			if(temp=findTNode(node->left_tree,data))
			{
				return temp;
			}
			else if(temp=findTNode(node->right_tree,data)){
				return temp;
			}
		}
	}

}
template <typename Type>//	cout<<"输入0为左子树，输入1为右子树"<<endl; 
void Tree<Type>::insert(Type father_Data,Type data,int way){
	Tree* father=findTNode(root,father_Data);
	Tree* temp = new Tree(data);
	temp->Data=data;

	if(way==0){
		father->left_tree=temp;
	}
	if(way==1){
		father->right_tree=temp;
	}
		
}
template <typename Type>
void Tree<Type>::PreOrderTraversal(Tree* BT){
	if(BT){
		printf("%d",BT->Data);
		PreOrderTraversal(BT->left_tree);
		PreOrderTraversal(BT->right_tree);
	}
} 
template <typename Type>
void Tree<Type>::InOrderTraversal(Tree* BT){
	if(BT){
		InOrderTraversal(BT->left_tree);
		printf("%d",BT->Data);
		InOrderTraversal(BT->right_tree);
	}
} 
template <typename Type>
void Tree<Type>::PostOrderTraversal(Tree* BT){
	if(BT){
		PostOrderTraversal(BT->left_tree);
		PostOrderTraversal(BT->right_tree);
		printf("%d",BT->Data);
	}
} 
template <typename Type>
void Tree<Type>::LevelOrderTraversal(Tree* BT){
	int i=0;
	queue<Tree*> q;
	Tree* T;
	if(!BT) return;
	q.push(BT);
	while(!q.empty()){
		T=q.front();
		q.pop();
		printf("%d",T->Data);
		if(T->left_tree) q.push(T->left_tree);
		if(T->right_tree) q.push(T->right_tree);
		i++;
	}
	
}
template <typename Type>
int Tree<Type>::height(Tree* BT) const{
	int HL,HR,MaxH;
	if(BT){
		HL=height(BT->left_tree);
		HR=height(BT->right_tree);
		MaxH=(HL>HR)?HL:HR;
		return (MaxH+1); 
	} 
	else return 0;
} 
//template <typename Type>
//bool Tree<Type>::is_leaf(Tree* BT,Type data) const {
//	queue<Type> q; 
//	bool val;
//	if(BT){
//		if(!BT->left_tree&&!BT->right_tree)
//			q.push(BT->Data);
//		is_leaf(BT->left_tree,data);
//		is_leaf(BT->right_tree,data);
//	}
//	for(int i=0;i<q.size();i++){
//		if(q.front()==data) {
//			bool=1t
//		}
//		q.pop();
//	}
//    return false;
//	
//
//}

template <typename Type>
void Tree<Type>::leaf(Tree* BT){
	if(BT){
		if(!BT->left_tree&&!BT->right_tree){
			printf("%d",BT->Data);
		}
		leaf(BT->left_tree);
		leaf(BT->right_tree);
		
	}
}
int main()
{
	Tree<int> T(2);
//	cout<<T.Data; 
//	T.clear();
	T.insert(2,3,0);
	T.insert(2,4,1);
	T.insert(3,5,0);
	T.insert(5,6,0);
	T.insert(4,7,0);
	T.PreOrderTraversal(T.root);
//	T.PreOrderTraversal(T.root);
//	cout<<endl;
//	T.InOrderTraversal(T.root);
//	cout<<endl;
//	T.PostOrderTraversal(T.root);
//	T.LevelOrderTraversal(T.root);
//	
//	cout<<endl<<T.height(T.root);
//	cout<<endl<<T.is_leaf(T.root,7);
//	cout<<T.is_leaf(T.root,6);

//	T.leaf(T.root);
//	cout<<T.right_tree->Data<<endl;
//	cout<<T.left_tree->Data<<endl<<T.left_tree->left_tree->left_tree->Data<<endl;
//	cout<<T.right_tree->left_tree->Data;
//	T.insert(T.root,3,0);
//	printf("%p",T);
//	printf("%d",T.retrieve());
	
}




