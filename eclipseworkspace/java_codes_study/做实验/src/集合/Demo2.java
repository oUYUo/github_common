package ¼¯ºÏ;

import java.util.ArrayList;
class Book{
	int id;
	String name;
	public Book(int id ,String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString(){
		return "(±àºÅ£º"+this.id+";Ãû×Ö"+this.name+")";
	}
	@Override
	public boolean equals(Object obj){
		Book book =(Book)obj;
		return this.id == book.id;
	}
	@Override
	public int hasCode(){
		return  super.hashCode();
	}
}
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add(new Book(1,"java1"));
		list.add(new Book(2,"java2"));
		list.add(new Book(3,"java3"));
		list.add(new Book(4,"java4"));
		System.out.println(list);
	}
	public static ArrayList clearRepeat(ArrayList list){
		
	}

}
