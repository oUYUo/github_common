/*
 * 抽象词汇数据类，存储抽象信息，点的词汇，对应TF，IDF值
 */
public class DataPoint {
	public DataPoint(String word,float TF,float IDF,int Rank){
		this.word=word;
		this.TF=TF;
		this.IDF=IDF;
		this.Rank=Rank;
	}
	public DataPoint(){
		
	}
	public void setWord(String aWord){
		this.word=aWord;
	}
	public String getWord(){
		return word;
	}
	public void setTF(float TF){
		this.TF=TF;
	}
	public float getTF(){
		return this.TF;
	}
	public void setIDF(float IDF){
		this.IDF=IDF;
	}
	public float getIDF(){
		return this.IDF;
	}
	public void setRank(int Rank){
		this.Rank=Rank;
	}
	public int getRank(){
		return this.Rank;
	}
	public float getLogRank(){
		return (float) Math.log10(this.Rank);
	}
	public float getTF_IDF(){
		return this.IDF*this.TF;
	}
private String word="";
private float TF;
private float IDF;
private int Rank;
}
