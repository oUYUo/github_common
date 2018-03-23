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
int BST_Node<Type>::size() const {			//Ëï×¿ 
	int i=0;
	if(this){
		i++;
		i=i+this->left()->size();
		i=i+this->right()->size();
		return i;
	}
	else{
		return 0;
	}
	/*write your code here, and delete the next code*/

}

template <typename Type>
int BST_Node<Type>::height() const {  //Ëï×¿ 
	int HL,HR,MaxH;
	if(this)
	{
		HL=this->left()->height();
		HR=this->right()->height();
		MaxH=(HL>HR)?HL:HR;
		return (MaxH+1);
	}
	/*write your code here, and delete the next code*/
	else return 0;

}

template <typename Type>
Type BST_Node<Type>::front() const {   //Ëï×¿ 
	if(!this) return 0;
	else if(!this->left())
		return this->element;
	else{
		return this->left()->front();
	}
	
	/*write your code here, and delete the next code*/

}


template <typename Type>
Type BST_Node<Type>::back() const {   //Ëï×¿ 
	if(!this) return 0;
	else if(!this->right())
		return this->element;
	else{
		return this->right()->back();
	}
	/*write your code here, and delete the next code*/

}


template <typename Type>
bool BST_Node<Type>::find( Type const & obj) const {   //Ëï×¿ 
    if ( empty() ) {
	        return false;
	    } else if ( retrieve() == obj ) {
	        return true;
	    }

	    return ( obj < retrieve() ) ?
	        left()->find( obj ) : right()->find( obj );
	}

	






template <typename Type>
Type BST_Node<Type>::next( Type const &obj ) const {   //Ëï×¿ 
//	if(!this) return (Type)0;
//	else{
//		if(this->element>obj){
//			this->left()->next(obj);
//		}
//		else if(this->element<obj){
//			this->right()->next(obj);
//		}
//		else{
//			if(this->right()){
//				return this->right()->front();
//			}
//			else{
//				return this->element;
//			}
//		}
//	}
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
Type BST_Node<Type>::previous( Type const &obj ) const {   //Ëï×¿ 
//	if(!this) return (Type)0 ;
//	else{
//		if(this->element>obj){
//			this->left()->previous(obj);
//		}
//		else if(this->element<obj){
//			this->right()->previous(obj);
//		}
//		else{
//			if(this->left()){
//				return this->left()->back();
//			}
//			else{
//				return this->element;
//			}
//		}
//	}
	if ( empty() ) {
                return obj;
            } else if ( retrieve() == obj  ) {
                return ( left()->empty() ) ? obj : left()->back();
           } else if ( retrieve() < obj ) {
                Type tmp = right()->previous( obj );

                return ( tmp == obj ) ? retrieve() : tmp;
            } else {
                return left()->previous( obj );
            }

}


template <typename Type>
Type BST_Node<Type>::at( int k ) const {   //Ëï×¿ 
	if(this->left()->size()==k){
		return this->element;
	}
	else if(this->left()->size()>k){
		return this->left()->at(k);
	}
	else{
		return this->right()->at(k-this->left()->size()-1);
	}
	return 0;
}










template <typename Type>
void BST_Node<Type>::clear() {   //Ëï×¿ 
	if(!this){
		return;
	}
	else{
		this->left()->clear();
		this->right()->clear();
		*this=0;
		delete this;
	}
	    
}


template <typename Type>
bool BST_Node<Type>::insert( Type const &obj, BST_Node<Type> *&ptr_to_this ) {   //Ëï×¿ 
	if(ptr_to_this==NULL){	//¼ÙÈç½ÚµãÎª¿Õ 
		ptr_to_this=new BST_Node<Type>(obj);
		return true;
	}
	if(ptr_to_this!=NULL){  	//¼ÙÈç½Úµã²»Îª¿Õ 
		if(ptr_to_this->element==obj) 
		{
			cout<<"element==ptr";
			cout<<endl;
			return 0;
		}
		else if(ptr_to_this->element<obj){
			insert(obj,ptr_to_this->right_tree);
		} 
		else if(ptr_to_this->element>obj){
			insert(obj,ptr_to_this->left_tree);
		}
	}
	


}


template <typename Type>
bool BST_Node<Type>::erase( Type const &obj, BST_Node<Type> *&ptr_to_this ) {   //Ëï×¿ 
//	if(!this) {
//		return 0;
//	}
//	else
//	{
//		if(this->element<obj){
//			this->right()->erase(obj,this->right_tree);
//		}
//		else if(this->element>obj){
//			this->left()->erase(obj,this->left_tree);
//		}
//		else{
//			if(this->left_tree&&this->right_tree){
//				Type tmp;
//				tmp=this->right()->front();
//				this->element=tmp;
//				this->right()->erase(this->element,this->right_tree);
//			}
//			else{
//				BST_Node* tmp=this;
//				if((!this->left())&&this->right()){
//					*tmp=*tmp->right_tree;
//					delete(tmp->right_tree);
//				}
//				else if((!this->right())&&this->left()){
//					*tmp=*tmp->left_tree;
//					delete(tmp->left_tree);
//				}
//				else{
//					delete this;
//				}	
//				return true;
//			
//			}
//			 
//			}	
//	}	
	if ( empty() ) {
        return false;
    } else if ( obj == retrieve() ) {
        if ( is_leaf() ) {                                      // leaf node
            ptr_to_this = NULL;
            delete this;
        } else if ( !left()->empty() && !right()->empty() ) {   // full node
            element = right()->front();
            right()->erase( retrieve(), right_tree );
        } else {                                                // only one child
            ptr_to_this = ( !left()->empty() ) ? left() : right();
            delete this;
        }

        return true;
    } else if ( obj < retrieve() ) {
        return left()->erase( obj,  left_tree );} else {
        return right()->erase( obj, right_tree );}

}


template <typename Type>
void BST_Node<Type>::Print_First() {   //Ç®³Ì 
	if(this)
	{
		cout<<this->element<<" ";
	 	this->left()->Print_First();
		this->right()->Print_First();
	}
	/*write your code here*/
}

template <typename Type>
void BST_Node<Type>::Print_Middle()   //Éòçù·² 
{
	
	if(this)
	{
	 	this->left()->Print_Middle();
		cout<<this->element<<" ";
		this->right()->Print_Middle();
	}
	
	/*write your code here*/
}


template <typename Type>
void BST_Node<Type>::Print_Back() {  //ÁõÓÀ½Ü 
	if(this)
	{
	 	this->left()->Print_Back();
		this->right()->Print_Back();
		cout<<this->element<<" ";
	}
	/*write your code here*/
}




template <typename Type>
class BST {
    private:
        BST_Node<Type>* root_node;
        
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
root_node(NULL) {
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
	return root_node->find(obj);
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
