import java.util.HashMap;
import java.util.Map;
/*
 
 �����Ǵ洢�����ʻ���࣬������ڴ洢��һЩԭʼ����Ϣ�������������ĳ�����г��ֹ����ٴε�
 
 */
public class IndexWord {
	public IndexWord(String word){
		this.word=word;
	}
public IndexWord(String Word,String BookName){
	this.word=Word;
	addBook(BookName);
}//֮ǰΪ���캯��
public void addBook(String BookName){//����鼮��Ϣ���ж�֮ǰ��ϵ�������Ƿ���ĳ���飬���û�����½�һ����ϵ������������+1
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
	private Map<String,Integer> Book_ATimes=new HashMap<String,Integer>();//�洢���ݼ���[�鼮���ôʻ����Ȿ���г��ֹ����ٴ�]
	private Integer A_Times=null;
	private int Rank=0;
	private int TF=0;
	
}
