import java.io.File;
import java.io.IOException;
public class HelloFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("hello.txt");
		//�Ƿ����
		if(file.exists())
		{
//			file.delete();
//			//�ļ�
//			System.out.println(file.isFile());
//		//·�����ļ��У�
//			System.out.println(file.isDirectory());
//			System.out.println("�ļ�ɾ���ɹ�");
			File nameto = new File("new Hello.txt");
			file.renameTo(nameto);
		}
		else
		{
			System.out.println("�ļ�������");
			try{
				file.createNewFile();
				System.out.println("�ļ��Ѿ�������");
			}catch(IOException e){
				System.out.println("�ļ��޷�������");
			}
		}
	}

}
