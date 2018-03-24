/*
1��File��IO�����ļ����ļ��в����࣬�ֲ���IO�����ļ����ļ��в������㡣
2��File�ೣ��������
	1�����췽����
		A������·���ļ�����������File(String pathname)
		   ���÷�ʽ��File f1 = new File( "c:\\dome.txt");

		B������·���ļ�����������File(String parent, String child)
		   ������parent ·������ child �ļ�����
		   ���÷�ʽ��File f1 = new File( "c:\\", "dome.txt");

		C������·���ļ�����������File(File parent, String child)
		   ������parent File�����ȡ��·���� child �ļ�����
		   ���÷�ʽ��File f1 = new File( "c:\\dome.txt");
					 File f2 = new File( f1, "do.txt");

	2���ֶΣ�
		A����ƽ̨Ŀ¼�ָ�����static String separator  
		   ���÷�ʽ��File f1 = new File("c:" + File.separator + "Test.java");

	3��������
		A��ָ��λ�ô����ļ���������ļ��Ѿ����ڣ�����false��boolean createNewFile()
		   ���÷�ʽ������.createNewFile();

		B����ϵͳĬ����ʱ�ļ�Ŀ¼�д����ļ�:static File createTempFile(String prefix, String suffix)	����Ϊ�˽⡿
		   ������prefix - �ļ�����suffix - �ļ���׺����suffixΪ null����ʹ�ú�׺ ".tmp"
		   ���÷�ʽ��File.createTempFile( "dome",".txt");

		C����ָ��Ŀ¼�д����ļ���static File createTempFile(String prefix, String suffix, File directory)
		   ������prefix - �ļ�����suffix - �ļ���׺����directory - �ļ�·����
		   ���÷�ʽ��File f = new File( "c:\\dome.txt");
					 File.createTempFile( "dome", ".txt", f);

		D������һ���ļ��У�boolean mkdir()
		   ���÷�ʽ��File dir = new File("abc");
		             dir.mkdir();

		E�������༶�ļ��У�boolean mkdirs()
		   ���÷�ʽ��File dir = new File("abc\\kkk\\a\\a\\dd\\ee\\qq\\aaa");
		             dir.mkdirs();

	4��ɾ�������ļ���Ϊ��ʱ���Ż�ɾ��������ɾ��ʧ�ܡ�
		A��ɾ���ļ���boolean delete()
		   ����ֵ������ļ����ڱ�ʹ�ã���ɾ��ʧ�ܣ�����false��
		   ���÷�ʽ������.delete();

		B���ڳ����˳�ʱɾ��ָ���ļ���void deleteOnExit()
		   ���÷�ʽ������.deleteOnExit()

	5���жϣ�
		A���ļ��Ƿ���ڣ�boolean exists()
		   ���÷�ʽ�� boolean b = ����.exists();

		B���Ƿ����ļ���boolean isFile()
		   ���÷�ʽ��boolean b = ����.isFile();

		C���Ƿ����ļ��У�boolean isDirectory()
		   ���÷�ʽ��boolean b = ����.isDirectory();

		D���Ƿ��������ļ���boolean isHidden()
		   ���÷�ʽ��boolean b = ����.isHidden();

		E���Ƿ��Ǿ���·����boolean isAbsolute()
		   ���⣺�� Windows ϵͳ�ϣ�·����ǰ׺�Ǻ�� "\\" ���̷����� UNIX ϵͳ�ϣ����·������ǰ׺�� "/"�����Ǿ���·����
		   ���÷�ʽ��boolean b = ����.isAbsolute();

		F���ļ��Ƿ���ִ�У�boolean canExecute()
		   ���÷�ʽ��boolean b = ����.canExecute();

	6����ȡ��Ϣ��

		A��ȡ�ļ������ļ�������	String getName()
		   ���÷�ʽ��String s = ����.getName();

		B��ȡ���캯��String���ݣ�String getPath()
		   ����ֵ�������ص��� �����ڹ����������ص����ݡ�
		   ���÷�ʽ��String s = ����.getPath();   

		C��ȡ�ļ����·����String getParent()
		   ���⣺���δָ���ļ�·�����򷵻�null��
		   ���÷�ʽ��String s = ����.getParent();

		D��ȡ�ļ�·����String getAbsolutePath() 
		   ����ֵ���ļ�·��+�ļ���+��׺����
		   ���÷�ʽ��String s = ����.getAbsolutePath();

		E��ȡ���һ���޸�ʱ�䣺long lastModified() 
		   ���÷�ʽ��long l = ����.lastModified();

		F�������ļ���С��long length() 
		   ���÷�ʽ��long l = ����.length();

	7���޸ģ�

		A�����������ƶ����ļ���boolean renameTo(File dest) 
		   ���÷�ʽ��File f1 = new File( "d:\\dome1");
					 File f2 = new File( "c:\\dome2");
					 f1.renameTo( f2);
			���뽲�⣺�� dome1 �ļ����� dome2�����ƶ���c�̡�

	8���ļ��б�
		A��ȡ�����̷���static File[] listRoots()
		   ���÷�ʽ��File[] files = File.listRoots();

		B��ȡĿ¼�����ļ���String[] list()
		   ����ֵ�������ļ������ָ���쳣��
		   ���÷�ʽ��String[] s = new File( "abc").list();

		C��ȡָ����׺�ļ���String[] list(FilenameFilter filter)
		   ������FilenameFilter ��һ���ӿڣ�ͨ�������ڲ��ิд�˽ӿ� accept() ������
		   ���÷�ʽ��String[] s = files.list( new FilenameFilter()
		   {
				public boolean accept( File dir, String name)
				{
				    // dir ��ʾĿ¼�� name���ļ���	
				   //endsWith() ��String���з��������Դ��ַ����Ƿ���ָ���ĺ�׺������
				  //˼�룺 File �������������ļ� һ���� ���� accept�У�Ȼ�����accept����ֵ��
					return name.endsWith( ".java");
				}			
		   });

		D����Ŀ¼�����ļ���װ��File[] listFiles()
		   ����ֵ����Ŀ¼�����ļ�����һһ��װ�ɶ��󡣾���ʾ���ο���dome_8_listFiles��
		   ���÷�ʽ��File[] f = file.listFiles();
*/

import java.io.*;
class FileDemo 
{
	public static void main(String[] args) throws IOException
	{
		
	}

	public static void dome_1() throws IOException
	{
		File f1 = new File( "c:\\dome.txt");
	  //File f1 = new File( "c:\\", "dome.txt");
		File f2 = new File( f1, "do.txt");
	}

	public static void dome_2() throws IOException
	{
		File f1 = new File("c:" + File.separator + "Test.java");
	}

	public static void dome_3() throws IOException
	{
		File f1 = new File( "c:\\dome.txt");
		f1.createNewFile();

		File.createTempFile( "dome", ".txt", "c:\\")

		File dir1 = new File("abc");
		dir1.mkdir();

		File dir2 = new File("abc\\kkk\\a\\a\\dd\\ee\\qq\\aaa");
		dir2.mkdirs();
	}

	public static void dome_4()throws IOException
	{
		File f1 = new File( "c:\\dome.txt");
		sop( f1.delete());

		File f2 = new File( "c:\\dome.txt");
		f2.deleteOnExit();
	}

	public static void dome_5()throws IOException
	{
		File f1 = new File( "c:\\dome.txt");

		//�ļ��Ƿ����
		sop( f1.exists());

		//�Ƿ����ļ���
		sop( f1.isFile());

		//�Ƿ����ļ��У�
		sop( f1.isDirectory());

		//�Ƿ��������ļ���
		sop( f1.isHidden());

		//�Ƿ��Ǿ���·��
		 sop( f1.isAbsolute());

		//�ļ��Ƿ���ִ�У�
		sop( f1.canExecute());
	}

	public static void dome_6()throws IOException
	{
		File f1 = new File( "dome.txt");

		//ȡ�ļ������ļ�������	String getName()
		sop( f1.getName());

		//ȡ���캯��String���ݣ�
		sop( f1.getPath());		//�����dome.txt

		//ȡ�ļ����·����
		sop( f1.getParent());	//�����null

		//ȡ�ļ�·����
		sop( f1.getAbsolutePath());

		//ȡ���һ���޸�ʱ�䣺
		sop( f1.lastModified());

		//�����ļ���С�� 
		sop( f1.length());
	}

	public static void dome_7()throws IOException
	{
		//���������ƶ����ļ����� dome1 �ļ����� dome2�����ƶ���c�̡�
		File f1 = new File( "d:\\dome1");
		File f2 = new File( "c:\\dome2");
		f1.renameTo( f2);
	}

	public static void dome_8_list1()
	{
		//ȡ�����̷���
		File[] files = File.listRoots();

		for( File f : files)
		{
			String str = f.toString();	//���̷����� str ��
			System.out.println( " ----------------" + str + "-----------------");

			//ȡĿ¼�����ļ���
			String[] st = files.list();

			for( String s :st)
			{
				System.out.println(s);
			}
		}
	}

	public static void dome_8_list2()
	{
	/*
		FilenameFilter ��һ���ӿڣ����淽��ֻ�� accept
		accept( File dir, String name)
		dir  --- Ŀ¼
		name --- �ļ���
		endsWith ��String���з������ж��Ƿ���ָ����׺��������

		�⣺list()�����������������ļ������� accept�У�����һһ�жϡ�
			��������棬�������ļ���Ϣ������ɾ���ļ���Ϣ��
			����ͨ��endsWith()�����жϸ��ļ��Ƿ���ָ����׺��������
	*/
		File filete = new File( "c:\\");
		String[] name = filete.list( new FilenameFilter()
		{
			public boolean accept( File dir,  String name)
			{
				return name.endsWith( ".bmp");
			}	
		});

		for(String s : name)
		{
			System.out.println(s);
		}
	}

	public static void dome_8_listFiles()
	{
		File file = new File( "c:\\");
		//��ȡC��Ŀ¼�µ��ļ����ļ��У�������һһ��װ����
		File[] f = file.listFiles();

		for(File fi : f)
		{
			//getName ��ȡ�ļ�����
			System.out.println( fi.getName());
		}
	}

	public static void delete( File f)	// ��ʾɾ���������ݵ��ļ��С�
	{
		File[] fi = f.listFiles();

		for( int x = 0; x < fi.length; x++)
		{
			if( fi[x].isDirectory())
				delete( fi[x]);
			else
				fi[x].delete();
		}
		f.delete();
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
