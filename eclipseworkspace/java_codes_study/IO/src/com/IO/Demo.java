package com.IO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileInputStream fis=new FileInputStream("text.txt");
			byte input[] = new byte[21];//һ�������ֿ���ռ�����ֽڣ�������ö�ȡ�����ö���һ�����ֵİ���ֽڣ��ͻ�����������
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
