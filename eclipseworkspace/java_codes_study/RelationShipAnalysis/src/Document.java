import java.io.*;
import java.util.*;
public class Document {
public Document(String FileName){
	this.Doc=new File(FileName);
}
public Document(String FileName,String DocContent){
	this.Doc=new File(FileName);
	this.setAttribute("Content", DocContent);
}
public Document(File newFile){
	this.Doc=newFile;
}
public Document(File newFile,String DocContent){
	this.Doc=newFile;
	this.setAttribute("Content", DocContent);
}
public File getDoc(){
	return this.Doc;
}
public String getAttribute(String Key){
	return this.Attribute.get(Key);
}
public void setAttribute(String Key,String Value){
	this.Attribute.put(Key, Value);
		
}
private File Doc=null;
private Map<String,String> Attribute=new HashMap<String,String>();

}
