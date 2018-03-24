import java.io.*;
import java.util.*;
import java.util.zip.*;
//util是utiliy的缩写，意为多用途的，工具性质的包
//这个包中主要存放了：集合类（如Arraylist，HashMap等），随机数产生类，属性文件读取类，定时器类等类。
public class myZip {

	public void ZipFiles(String[] fs){
		try{
			String fileName = fs[0];
			FileOutputStream f =
					new FileOutputStream(fileName+".zip");
			//使用输出流检查
			CheckedOutputStream cs = 
					new CheckedOutputStream(f,new Adler32());
			//声明输出zip流
			ZipOutStream out=
				new ZipOutStream(new BufferedOutputStream(cs))	;
			//写一个注释
			out.setComment("a test of java zipping");
			//对多文件进行压缩
			for(int i =1;i<fs.length;i++){
				System.out.print("Write file"+fs[i]);
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
