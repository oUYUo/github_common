package com.java.file;

import java.io.File;

public class HelloFolder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File folder = new File("my new folder/one/two/three/mian");
		
		if(folder.mkdirs())
			{//创建文件夹
				System.out.println("文件夹创建成功");
			}
		else{
			if(folder.exists())
			{
				System.out.println("文件夹已经存在不用创建");
			}else{
				System.out.println("文件夹创建失败");
			}
		
			}
		File newfolder = new File("my new folder-new");
		folder.renameTo(newfolder);
	}
}
