#include "head.h"


template <typename Type>
class AVL_Node{
    private:
		Type element;
		AVL_Node<Type>* left_tree;
		AVL_Node<Type>* right_tree;
    public:
		AVL_Node( Type const & obj);
		Type retrieve() const;
		AVL_Node<Type> *father(Type const & obj,AVL_Node *&);
		AVL_Node<Type> *left() const;
		AVL_Node<Type> *right() const;
		bool empty() const;
		bool is_leaf() const;
		int size() const;
		int height() const;
		Type front() const;
        Type back() const;
        bool find( Type const & obj) const;
				
		Type next( Type const &obj ) const; 
		Type previous( Type const &obj ) const;
		Type at( int k ) const;


		void clear();
        bool insert( Type const &, AVL_Node *&);
        AVL_Node<Type>* erase( Type const &, AVL_Node *&);
		void Print_First();
		void Print_Middle();
		void Print_Back();
		void DrawAVL(int root_height);
		
		AVL_Node<Type>* LL(AVL_Node *&);
		AVL_Node<Type>* LR(AVL_Node *&);
		AVL_Node<Type>* RL(AVL_Node *&);
		AVL_Node<Type>* RR(AVL_Node *&);
};

template <typename Type>
AVL_Node<Type>::AVL_Node( Type const &obj ):
element( obj ),
left_tree( NULL ),
right_tree( NULL ) {
    // Empty constructor
}

template <typename Type>
AVL_Node<Type> * AVL_Node<Type>::LL(AVL_Node *&A){//Ç®³Ì 
	AVL_Node* B =A->left();
	A->left_tree=B->right_tree;
	B->right_tree=A;
	return B;
}

template <typename Type>
AVL_Node<Type> * AVL_Node<Type>::LR(AVL_Node *&A){//ÁõÓÀ½Ü 
	A->left_tree=RR(A->left_tree);
	return LL(A);
}


template <typename Type>
AVL_Node<Type> * AVL_Node<Type>::RL(AVL_Node *&A){//Éòçù·² 
	A->right_tree=LL(A->right_tree);
	return RR(A);
}


template <typename Type>
AVL_Node<Type> * AVL_Node<Type>::RR(AVL_Node *&A){//Ëï×¿ 
	AVL_Node* B =A->right();
	A->right_tree=B->left_tree;
	B->left_tree=A;
	return B;
}
template <typename Type>
Type AVL_Node<Type>::retrieve() const {
    return element;
}

template <typename Type>
AVL_Node<Type> * AVL_Node<Type>::left() const {
    return left_tree;
}


template <typename Type>
AVL_Node<Type> * AVL_Node<Type>::right() const {
    return right_tree;
}

template <typename Type>
bool AVL_Node<Type>::empty() const {
    return this==0;
}


template <typename Type>
bool AVL_Node<Type>::is_leaf() const {
    return !empty() && left()->empty() && right()->empty();
}

template <typename Type>
int AVL_Node<Type>::size() const {
	return empty() ? 0 : 1 + left()->size() + right()->size();
}

template <typename Type>
int AVL_Node<Type>::height() const {
	return empty() ? -1 : 1 + __max( left()->height(), right()->height() );

}


template <typename Type>
Type AVL_Node<Type>::front() const {
	if ( empty() ) {
		cout<<"The tree is empty"<<endl;
	}
	return (  left()->empty() ) ? retrieve() : left()->front();
}


template <typename Type>
Type AVL_Node<Type>::back() const {

	if ( empty() ) {
		cout<<"The tree is empty"<<endl;
	}
	return ( right()->empty() ) ? retrieve() : right()->back();
}
template <typename Type>
AVL_Node<Type>* AVL_Node<Type>::father(Type const & obj,AVL_Node *&fath) {//Ëï×¿ 
	AVL_Node* tmp;
	tmp=this;
	if ( empty() ) {
		return false;
	} else if ( retrieve() == obj ) {
		return fath;
	}
	return ( obj < retrieve() ) ? left()->father( obj,tmp ) : right()->father( obj,tmp );
}


template <typename Type>
bool AVL_Node<Type>::find( Type const & obj ) const {
	if ( empty() ) {
		return false;
	} else if ( retrieve() == obj ) {
		return true;
	}
	return ( obj < retrieve() ) ? left()->find( obj ) : right()->find( obj );
}







template <typename Type>
Type AVL_Node<Type>::next( Type const &obj ) const {
            
	if ( empty() ) {
		return obj;
	} else if ( retrieve() == obj  ) {
		return ( right()->empty() ) ? obj : right()->front();
	} else if ( retrieve() > obj ) {
		Type tmp = left()->next( obj );
		
		return ( tmp == obj ) ? retrieve() : tmp;
	} else {
		return right()->next( obj );
	}

}


template <typename Type>
Type AVL_Node<Type>::previous( Type const &obj ) const {
	if ( empty() ) {
		return obj;
	} else if ( retrieve() == obj  ) {
		return ( left()->empty() ) ? obj : left()->front();
	} else if ( retrieve() < obj ) {
		Type tmp = right()->previous( obj );
		
		return ( tmp == obj ) ? retrieve() : tmp;
	} else {
		return left()->previous( obj );
	}
}


template <typename Type>
Type AVL_Node<Type>::at( int k ) const {
	if (k < 0 || k >= size() )
	{
		cout<<"Please the right parameter"<<endl;
		return 0;
	}

	if ( left()->size() == k ) {
		return retrieve();
	} else if ( left()->size() > k ) {
		return left()->at( k );
	} else {
		return right()->at(k-left()->size()-1);
	}
}










template <typename Type>
void AVL_Node<Type>::clear() {
	if ( empty() ) {
		return;
	}
	
	left()->clear();
	right()->clear();
	
	delete this;
}


template <typename Type>
bool AVL_Node<Type>::insert( Type const &obj, AVL_Node *&ptr_to_this ) {//Ëï×¿ 
		
	if(empty()){
		ptr_to_this=new AVL_Node<Type>(obj);
		return true;
	}
	else if(obj<retrieve()){
		left()->insert(obj,left_tree);
		if(ptr_to_this->left()->height()-ptr_to_this->right()->height()==2){
			if(obj<ptr_to_this->left()->element)
				ptr_to_this=LL(ptr_to_this);
			else
				ptr_to_this=LR(ptr_to_this);
		}
	}
	else if(obj>retrieve()){
		right()->insert(obj,right_tree);
		if(ptr_to_this->left()->height()-ptr_to_this->right()->height()==-2)
			if(obj>ptr_to_this->right()->element)
				ptr_to_this=RR(ptr_to_this);
			else
				ptr_to_this=RL(ptr_to_this);
	}
	return false;
	

	//rewrite your code here=============================
}
//

template <typename Type>
AVL_Node<Type>* AVL_Node<Type>::erase( Type const &obj, AVL_Node<Type> *&T ) {//Ëï×¿ 
	if(NULL==T)
		return T;
	if(!find(obj))
	{
		return T;
	}
	
	if(obj==T->element){
		if(!T->left()->empty()&&!T->right()->empty())
		{
			if(T->left()->height()>T->right()->height())
			{
				T->element=T->left()->back();
				T->left_tree=erase(T->element,T->left_tree);
			}
			else{
				T->element=T->right()->front();
				T->right_tree=erase(T->element,T->right_tree);
			}
		}
		else
		{
			AVL_Node* tmp=T;
			T=(T->left())?(T->left()):(T->right());
			delete tmp;
			tmp=NULL;
		}
	}
	else if(obj<T->element)
	{
		T->left_tree=erase(obj,T->left_tree);
		if(T->left()->height()-T->right()->height()<-1)
		{
			if(T->right()->left()-T->right()->right()>0)
			{
				T=RL(T);
			 } 
			 else
			 {
			 	T=RR(T);
			 }
		}
	}
	else
	{
		T->right_tree=erase(obj,T->right_tree);
		if(T->left()->height()-T->right()->height()>1)
		{
			if(T->left()->left()->height()-T->left()->right()->height()<0)
			{
				T=LR(T);
			}
			else
			{
				T=LL(T);
			}
		}
	}
	return T;
	//rewrite your code here=============================
}



template <typename Type>
void AVL_Node<Type>::Print_First() {

	if (empty())
	{
		;
	}
	else
	{
		cout<<retrieve()<<" ";
		left()->Print_First();
		right()->Print_First();
	}
}

template <typename Type>
void AVL_Node<Type>::Print_Middle() {
	if (empty())
	{
		;
	}
	else
	{
		left()->Print_Middle();
		cout<<retrieve()<<" ";
		right()->Print_Middle();
	}
}


template <typename Type>
void AVL_Node<Type>::Print_Back() {
	if (empty())
	{
		;
	}
	else
	{
		left()->Print_Back();
		right()->Print_Back();
		cout<<retrieve()<<" ";
	}
}


template <typename Type>
void AVL_Node<Type>::DrawAVL(int root_height) {
	if (empty())
	{
		;
	}
	else
	{
			
		
		
				
		left()->DrawAVL(root_height-1);
		int Depth=root_height;
		while (Depth-->0)
		{
			cout<<"¡ª";
		}
		cout<<retrieve()<<endl;
		
		right()->DrawAVL(root_height-1);
		
		
	}
}



template <typename Type>
class AVL {
    private:
        AVL_Node<Type> *root_node;
        
    public:
        AVL();
        ~AVL();
		AVL_Node<Type> *root();
        bool empty() const;
        int size() const;
        int height() const;
        Type front() const;
        Type back() const;
        bool find( Type const &obj ) const;
		Type next( Type const &obj ) const; 
		Type previous( Type const &obj ) const;
		Type at( int k ) const;

        void clear();
        bool insert( Type const &obj );
        bool erase( Type const &obj );
		void Print_First();
		void Print_Middle();
		void Print_Back();
		void DrawAVL();
};


template <typename Type>
AVL<Type>::AVL():
root_node( NULL ) {
	// does nothing
}

template <typename Type>
AVL<Type>::~AVL() {
	clear();
}

template <typename Type>
AVL_Node<Type> * AVL<Type>::root(){
	return root_node;
}


template <typename Type>
bool AVL<Type>::empty() const {
    return ( root()->empty() );
}


template <typename Type>
int AVL<Type>::size() const {
	return root_node->size();
}

template <typename Type>
int AVL<Type>::height() const {
	return root_node->height();
}



template <typename Type>
Type AVL<Type>::front() const {
	return root_node->front();
}


template <typename Type>
Type AVL<Type>::back() const {
	return root_node->back();
}

template <typename Type>
bool AVL<Type>::find( Type const & obj) const {
	return root()->find(obj);
}



template <typename Type>
Type AVL<Type>::next( Type const &obj ) const {
            

	return root_node->next(obj);

}


template <typename Type>
Type AVL<Type>::previous( Type const &obj ) const {
	return root_node->previous(obj);
}


template <typename Type>
Type AVL<Type>::at( int k ) const {
	if (k < 0 || k >= size() )
	{
		cout<<"Please input the right parameter"<<endl;
		return 0;
	}
	else
	{
		return root_node->at(k);
	}
}

template <typename Type>
void AVL<Type>::clear() {
	root_node->clear();
}


template <typename Type>
bool AVL<Type>::insert( Type const &obj ) {
	return root()->insert(obj,root_node);
}

template <typename Type>
bool AVL<Type>::erase( Type const &obj ) {
	return root()->erase(obj,root_node);
}


template <typename Type>
void AVL<Type>::Print_First() {
	root()->Print_First();
}

template <typename Type>
void AVL<Type>::Print_Middle() {
	root()->Print_Middle();
}


template <typename Type>
void AVL<Type>::Print_Back() {
	root()->Print_Back();
}

template <typename Type>
void AVL<Type>::DrawAVL() {
	int root_height=root_node->height();
	root()->DrawAVL(root_height);
}
