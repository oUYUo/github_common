import java.io.*;
import java.util.*;
import java.util.zip.*;
//util��utiliy����д����Ϊ����;�ģ��������ʵİ�
//���������Ҫ����ˣ������ࣨ��Arraylist��HashMap�ȣ�������������࣬�����ļ���ȡ�࣬��ʱ������ࡣ
public class myZip {

	public void ZipFiles(String[] fs){
		try{
			String fileName = fs[0];
			FileOutputStream f =
					new FileOutputStream(fileName+".zip");
			//ʹ����������
			CheckedOutputStream cs = 
					new CheckedOutputStream(f,new Adler32());
			//�������zip��
			ZipOutStream out=
				new ZipOutStream(new BufferedOutputStream(cs))	;
			//дһ��ע��
			out.setComment("a test of java zipping");
			//�Զ��ļ�����ѹ��
			for(int i =1;i<fs.length;i++){
				System.out.print("Write file"+fs[i]);
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
