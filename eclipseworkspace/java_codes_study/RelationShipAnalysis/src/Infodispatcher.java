import java.io.*;

import java.util.*;
import com.huaban.analysis.jieba.JiebaSegmenter;
/*
 * 这个类是对文档的信息处理类
 */
public class Infodispatcher{
	public Infodispatcher(File newFileDir){
		this.FileDir=newFileDir;
	}

	public void StartToDealing() throws IOException {
		if (this.FileDir.isDirectory()) {
			System.out.println(
					this.FileDir.getName() + "is a Dir , contains " + this.FileDir.listFiles().length + " Files");
			System.out.println("Starting to index!");
			for (File aFile : this.FileDir.listFiles())
				DispatcherInfo(aFile);
		}

	}
	private static String FileRead(File aFile)throws IOException{
		String Content="";
		String temp="";
		InputStreamReader in=new InputStreamReader(new FileInputStream(aFile),"GBK");
		BufferedReader buf=new BufferedReader(in);
		while((temp=buf.readLine())!=null)
			Content+=temp;
		return Content;
	}
	private static String[] Divide(String Content){//分词，调用分词算法
		String div="[ ,]";
        String temp=seg.sentenceProcess(Content).toString();
       temp=temp.replace("[", "").replace("]","").replaceAll("\\s*|\t|\r|\n", "");
        String[] step=temp.split(div);
        return step;
		}
	private void DispatcherInfo(File aFile)throws IOException{
		String Content=FileRead(aFile);
		String[] DWords=Divide(Content);
		String FileName=aFile.getName();
		for(String aWord:DWords)
			addWords(aWord,FileName);

	}
	private void addWords(String aWord,String BookName){//向项集中添加数据
		IndexWord temp=new IndexWord(aWord);
		if(this.indexterms.contains(temp))
				indexterms.get(this.indexterms.indexOf(temp)).addBook(BookName);
		else
			indexterms.add(new IndexWord(aWord,BookName));
	}
	public IndexWord[] getindexterms(){//返回词项集合数组
		IndexWord[] indexTerms=(IndexWord[]) this.indexterms.toArray(new IndexWord[0]);
		System.out.println("trans successful!");
		return indexTerms;
	}
	private ArrayList<IndexWord>  indexterms=new ArrayList<IndexWord>();
	public static JiebaSegmenter seg = new JiebaSegmenter();
	public File FileDir=null;
}