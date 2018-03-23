package com.chario;

import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo1_FileReader{
	public static void main(String[] args) throws IOException {
//		demo1();
		FileReader  rf  = new FileReader("xxx.txt");
		int c ;
		
		while((c=rf.read())!=-1)
		{
			System.out.print((char)c);
		}
		rf.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileReader  rf  = new FileReader("xxx.txt");
		int x =rf.read();
		char c = (char) x;
		System.out.println(c);
		rf.close();
	}

}
