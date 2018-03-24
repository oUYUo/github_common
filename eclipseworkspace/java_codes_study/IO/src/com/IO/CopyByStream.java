package com.IO;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
public class CopyByStream {
	public static void main(String[] args)
	{
		try {
			FileInputStream fis = new FileInputStream("Welina038.jpg");
			FileOutputStream fos = new FileOutputStream("ani.jpg");
			byte input[] = new byte[50];
			while(fis.read(input)!=-1)
		
			{
				fos.write(input);
			}
			fos.close();
			
			fis.close();
			System.out.println("down");
		}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
