#include "head.h"


template <typename Type>
class BST_Node{
    private:
		Type element;
		BST_Node<Type>* left_tree;
		BST_Node<Type>* right_tree;
    public:
		BST_Node( Type const & obj);
		Type retrieve() const;
		BST_Node<Type> *left() const;
		BST_Node<Type> *right() const;
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
        bool insert( Type const &, BST_Node *&);
        bool erase( Type const &, BST_Node *&);
		void Print_First();
		void Print_Middle();
		void Print_Back();

};

template <typename Type>
BST_Node<Type>::BST_Node( Type const &obj ):
element( obj ),
left_tree( NULL ),
right_tree( NULL ) {
    // Empty constructor
}


template <typename Type>
Type BST_Node<Type>::retrieve() const {
    return element;
}

template <typename Type>
BST_Node<Type> * BST_Node<Type>::left() const {
    return left_tree;
}


template <typename Type>
BST_Node<Type> * BST_Node<Type>::right() const {
    return right_tree;
}

template <typename Type>
bool BST_Node<Type>::empty() const {
    return this==0;
}


template <typename Type>
bool BST_Node<Type>::is_leaf() const {
    return !empty() && left()->empty() && right()->empty();
}

template <typename Type>
int BST_Node<Type>::size() const {
	/*write your code here, and delete the next code*/
	return 0;
}

template <typename Type>
int BST_Node<Type>::height() const {
	/*write your code here, and delete the next code*/
	return 0;

}

template <typename Type>
Type BST_Node<Type>::front() const {
	/*write your code here, and delete the next code*/
	return 0;
}


template <typename Type>
Type BST_Node<Type>::back() const {

	/*write your code here, and delete the next code*/
	return 0;
}


template <typename Type>
bool BST_Node<Type>::find( Type const & ) const {
	/*write your code here, and delete the next code*/
	return 0;
}







template <typename Type>
Type BST_Node<Type>::next( Type const &obj ) const {
            
	/*write your code here, and delete the next code*/
	return 0;

}


template <typename Type>
Type BST_Node<Type>::previous( Type const &obj ) const {
	/*write your code here, and delete the next code*/
	return 0;
}


template <typename Type>
Type BST_Node<Type>::at( int k ) const {
	/*write your code here, and delete the next code*/
	return 0;
}










template <typename Type>
void BST_Node<Type>::clear() {
	/*write your code here*/
}


template <typename Type>
bool BST_Node<Type>::insert( Type const &obj, BST_Node *&ptr_to_this ) {

	/*write your code here, and delete the next code*/
	return 0;
}


template <typename Type>
bool BST_Node<Type>::erase( Type const &obj, BST_Node<Type> *&ptr_to_this ) {

	/*write your code here, and delete the next code*/
	return 0;
}


template <typename Type>
void BST_Node<Type>::Print_First() {
	/*write your code here*/
}

template <typename Type>
void BST_Node<Type>::Print_Middle() {
	/*write your code here*/
}


template <typename Type>
void BST_Node<Type>::Print_Back() {
	/*write your code here*/
}




template <typename Type>
class BST {
    private:
        BST_Node<Type> *root_node;
        
    public:
        BST();
        ~BST();
		BST_Node<Type> *root();
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
};


template <typename Type>
BST<Type>::BST():
root_node( NULL ) {
	// does nothing
}

template <typename Type>
BST<Type>::~BST() {
	clear();
}

template <typename Type>
BST_Node<Type> * BST<Type>::root(){
	return root_node;
}


template <typename Type>
bool BST<Type>::empty() const {
    return ( root()->empty() );
}


template <typename Type>
int BST<Type>::size() const {
	return root_node->size();
}

template <typename Type>
int BST<Type>::height() const {
	return root_node->height();
}



template <typename Type>
Type BST<Type>::front() const {
	return root_node->front();
}


template <typename Type>
Type BST<Type>::back() const {
	return root_node->back();
}

template <typename Type>
bool BST<Type>::find( Type const & obj) const {
	return root()->find(obj);
}



template <typename Type>
Type BST<Type>::next( Type const &obj ) const {
            

	return root_node->next(obj);

}


template <typename Type>
Type BST<Type>::previous( Type const &obj ) const {
	return root_node->previous(obj);
}


template <typename Type>
Type BST<Type>::at( int k ) const {
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
void BST<Type>::clear() {
	root_node->clear();
}


template <typename Type>
bool BST<Type>::insert( Type const &obj ) {
	return root()->insert(obj,root_node);
}

template <typename Type>
bool BST<Type>::erase( Type const &obj ) {
	return root()->erase(obj,root_node);
}


template <typename Type>
void BST<Type>::Print_First() {
	root()->Print_First();
}

template <typename Type>
void BST<Type>::Print_Middle() {
	root()->Print_Middle();
}


template <typename Type>
void BST<Type>::Print_Back() {
	root()->Print_Back();
}