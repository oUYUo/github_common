/*
import java.util.*;
1��System�඼�Ǿ�̬������
System���з�����
	1����ȡ��ǰϵͳ���ԣ�static Properties getProperties()
	   ����ֵ��Properties ��Hashtable���࣬Ҳ����Map����������󡣿���ͨ��prop.keySey()ȡ��
	   ���÷�ʽ��Properties prop = System.getProperties();

	2������ָ����ָʾ��ϵͳ���ԣ�static String setProperty(String key, String value)
	   ����ֵ�������ؽ��ܡ�����ϵͳ������ǰ��ֵ�����û����ǰ��ֵ���򷵻� null��
	   ���÷�ʽ��System.setProperty( ��, ֵ)

    3�����ݼ���ȡϵͳ��Ϣ��static String getProperty(String key)
	   ���÷�ʽ��System.getProperty( ��);  �磺"os.name"  �˼���ȡ����ϵͳ��
	
	4�����·��䡰��׼����������static void setIn(InputStream in)
	   ʵ�����ο� dome_2(); ���롣
	   ���÷�ʽ��System.setIn( new FileInputStream( "dome.txt"));


	5�����·��䡰��׼���������static void setOut(PrintStream out) 
	   ʵ�����ο� dome_2(); ���롣
	   ���÷�ʽ��System.setOut( new PrintStream( "zzz.txt"));

-----------------------------------------------------------------------------------------------------------

2��System�����ֶΣ�
	1������׼����������static InputStream in 
	   ˵�������ڴ��������������
	   ���÷�ʽ��InputStream in = System.in;

	2������׼���������static PrintStream out 
	   ˵�������ڴ��������������
	   ���÷�ʽ��OutputStream out = System.out;
           


----------------------------------------------------------------------------------------------------------

System֪ʶ�㣺
1���ⲿ����ϵͳ���ԣ�cmd --> java -D��=ֵ �ļ�����	// ������ֵ��
*/
class  
{
	public static void main(String[] args)throws IOException
	{
		/*
		dome_1();
		dome_2();
		*/
	}

	public static void dome_1()
	{
		Properties prop = System.getProperties(); //���ص�ǰϵͳ���ԡ�
		//Properties ��Hashtable���࣬Ҳ����Map����������󡣿���ͨ��prop.keySey()ȡ��.
		//��ȡϵͳ������Ϣ��
		for(Object obj : prop.keySey()) 
	    }
			String valus = (String)prop.get(obj);
			System.out.println(obj+"::"+value);
		}


		//����ָ����ָʾϵͳ����
		System.setProperty( "01", "qwe");


		//��ȡָ����ϵͳ��Ϣ
		System.getProperty( "01");  //���� ��qwe����
	}

	public static void dome_2()throws IOException
	{
		System.setIn( new FileInputStream( "dome.txt")); //�ı���������
		System.setOut( new PrintStream( "zzz.txt"));	//�ı��������
		/*
			System.in  ---> Ĭ���ǿ���̨��������
			System.out  ----> Ĭ���� ��ӡ����

			����ͨ�� SetIn��setOut  ���������ı�Ĭ�ϵ�������
		*/

		BufferedReader bufr = new BufferedReader( new InputStreamReader( System.in));
		BufferedWriter bufw = new BufferedWriter( new OutputStreamWriter( System.out));

		String line = null;

		while( ( line = bufr.readLine()) != null)
		{
			if( "over".equals(line))
				break;

			bufw.write( line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		
		bufr.close();
	}
}