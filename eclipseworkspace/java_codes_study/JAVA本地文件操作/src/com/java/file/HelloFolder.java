package com.java.file;

import java.io.File;

public class HelloFolder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File folder = new File("my new folder/one/two/three/mian");
		
		if(folder.mkdirs())
			{//�����ļ���
				System.out.println("�ļ��д����ɹ�");
			}
		else{
			if(folder.exists())
			{
				System.out.println("�ļ����Ѿ����ڲ��ô���");
			}else{
				System.out.println("�ļ��д���ʧ��");
			}
		
			}
		File newfolder = new File("my new folder-new");
		folder.renameTo(newfolder);
	}
}
