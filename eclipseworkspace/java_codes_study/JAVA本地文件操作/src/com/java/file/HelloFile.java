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
		// ../�ļ���һ��
		// ../../�ļ�������
		//�Ƿ����
		if(file.exists()){
			//�ļ��нṹ������ͬһ������
			File nameto=new File("new hello.txt");
			file.renameTo(nameto);
//			file.delete();
//			System.out.println("�ļ�ɾ���ɹ�");
////			//�ļ� 
//			System.out.println(file.isFile());
//			//·�����ļ��У�
//			System.out.println(file.isDirectory());
			
//		}else{
//			System.out.println("�ļ�������");
//			try {
//				file.createNewFile();
//				System.out.println("�ļ��Ѿ�������");
//			} catch (IOException e) {
//				System.out.println("�ļ��޷�������");
//			}
		}
		
		
	}

}
