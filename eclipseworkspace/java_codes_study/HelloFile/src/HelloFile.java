import java.io.File;
import java.io.IOException;
public class HelloFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("hello.txt");
		//是否存在
		if(file.exists())
		{
//			file.delete();
//			//文件
//			System.out.println(file.isFile());
//		//路径（文件夹）
//			System.out.println(file.isDirectory());
//			System.out.println("文件删除成功");
			File nameto = new File("new Hello.txt");
			file.renameTo(nameto);
		}
		else
		{
			System.out.println("文件不存在");
			try{
				file.createNewFile();
				System.out.println("文件已经被创建");
			}catch(IOException e){
				System.out.println("文件无法被创建");
			}
		}
	}

}
