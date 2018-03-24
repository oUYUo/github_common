import java.util.HashMap;
import java.util.Map;
/*
 
 该类是存储基本词汇的类，这个类内存储了一些原始的信息，比如这个词在某本书中出现过多少次等
 
 */
public class IndexWord {
	public IndexWord(String word){
		this.word=word;
	}
public IndexWord(String Word,String BookName){
	this.word=Word;
	addBook(BookName);
}//之前为构造函数
public void addBook(String BookName){//添加书籍信息，判断之前关系集合中是否有某本书，如果没有则新建一个关系，如果有则计数+1
	if(this.Book_ATimes.containsKey(BookName))
		this.Book_ATimes.put(BookName,this.Book_ATimes.get(BookName).intValue()+1);
	else
		this.Book_ATimes.put(BookName,new Integer(1));
	TF++;
}
public int getIDF(){
	return Book_ATimes.size();
}
public int getTF(){
	return TF;
	
}
	public String getWord(){
		return word;
	}
	public void setWord(String word){
		this.word=word;
	}
	public void setRank(int newRank){
		this.Rank=newRank;
	}

	public int getRank() {
		return this.Rank;
	}
	public boolean equals(Object o){
		if(o instanceof IndexWord)
		{IndexWord u=(IndexWord)o;
		return this.word.equals(u.word);
		}

	return super.equals(word);
	}
	private String word=null;
	private Map<String,Integer> Book_ATimes=new HashMap<String,Integer>();//存储数据集合[书籍，该词汇在这本书中出现过多少次]
	private Integer A_Times=null;
	private int Rank=0;
	private int TF=0;
	
}
