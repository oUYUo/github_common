package com.java.file;

import java.io.File;
import java.io.IOException;

public class HelloFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("hello.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ../文件上一级
		// ../../文件上两级
		//是否存在
		if(file.exists()){
			//文件夹结构必须在同一个分区
			File nameto=new File("new hello.txt");
			file.renameTo(nameto);
//			file.delete();
//			System.out.println("文件删除成功");
////			//文件 
//			System.out.println(file.isFile());
//			//路径（文件夹）
//			System.out.println(file.isDirectory());
			
//		}else{
//			System.out.println("文件不存在");
//			try {
//				file.createNewFile();
//				System.out.println("文件已经被创立");
//			} catch (IOException e) {
//				System.out.println("文件无法被创建");
//			}
		}
		
		
	}

}
