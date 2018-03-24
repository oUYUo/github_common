package com.IO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileInputStream fis=new FileInputStream("text.txt");
			byte input[] = new byte[21];//一个中文字可能占两个字节，如果设置读取数正好读了一个文字的半个字节，就会出现乱码情况
			fis.read(input);
			
			String inputString = new String(input,"GBK");
			System.out.println(inputString);
			fis.close();
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
