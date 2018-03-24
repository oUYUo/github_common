/*
1��java.io.ObjInputStream;
2��ObjectOutputStream �Ƕ�������л��࣬Ҳ���Ǵ�������ļ��ġ�
3���洢�Ķ������Ҫʵ�� Serializable �ӿڡ� ���ýӿڽ����뿴����ʼǡ�
4��ObjInputStream�����������
	1�����췽��������д��ָ���ļ���ObjectOutputStream(OutputStream out)
	   ���÷�ʽ��ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( "Person.Object"));

	2����������ļ��У�Object writeObject( Object obj);
	   ���⣺����������ʱ���������ô˷������ɡ�
	   ���÷�ʽ��oos.writeObject( new Person( "lisi", 20));

	3���ر���Դ��void close()
	   ���÷�ʽ��oos.close()

-------------------------- ObjectInputStream --------------------------

1��java.io.ObjectInputStream;
2,ObjectInputStream �Ƕ�ȡ�����ļ��ġ�
3�������ȡҪ��֤UID���к��Ƿ���ȷ�����Person���޸��ˣ��ٴζ�ȡ��UID��һ�������ᱨ��
4��ͨ�� Serializable �ӿڣ������Զ���UID���кţ������ٶ�ȡʱ�������ᱨ��
5��ObjectInputStream�����������
	1�����췽������������ָ���ļ���ObjectInputStream(InputStream in)
	   ���÷�ʽ��ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.Object"));

	2����ȡ����Object readObject();
	   ���⣺ȡ���������ʱ���������ô˷���������ȡ����
	   ���÷�ʽ��Person p = (Person)ois.readObject();

	3���ر���Դ��void close()
	   ���÷�ʽ��oos.close()
	
------------------ Serializable ---------------------------------------------

1��Serializable�Ǳ�ǽӿڣ����洢�Ķ�����Ҫʵ������
2��Serializable�ӿ�û���κη�����
3�����л�������static final long serialVersionUID = 42L; 42L��long�͵ģ��ɸ��κ�ֵ��
4��uid������ĸı���ı䣬����uidΨһ�Ծ��� ��ѡ��3����

--------------------- ���л��๲ͬҪ�� --------------------------------------

1����Person���Ա�� static��transient ����ʱ�������ᱻ���л���
   static�����������γ�Ա�Ĳ������ڴ档
		���󣺳����ڶ���ʱ��ֵ���ڲ����޷����и�ֵ��
			  �����ⲿ�������з������丳ֵ��

   teansient�����������εĳ�Ա�����ڴ��У������ᱻ���л���
		���󣺹��캯�����ڲ����޷����и�ֵ��
			  �����ⲿ�������з������丳ֵ��

2����ע�������һ���Ե���д��������country��̬����δ���ͷţ����Խ����kr

						���������У���һ������д������kr���ͷ��ˣ��ڶ��������� cn

						ԭ��country �Ǿ�̬�ģ����ᱻ���л���
*/

import java.io.*;
class ObjectIOS
{
	public static void main(String[] args) throws Exception
	{
		//ObjOutputStream();	
		ObjInputStream();

		/*
			�������ַ���ͬʱ���У�����������쳣 static
		*/
	}

	public static void ObjInputStream()throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.Object"));

		Person p = (Person)ois.readObject();

		System.out.println(p);
		ois.close();
	}

	public static void ObjOutputStream()throws IOException
	{
		ObjectOutputStream oos = 
			new ObjectOutputStream(new FileOutputStream("Person.Object"));

		oos.writeObject(new Person("lisi0",399,"kr"));

		oos.close();
	}
}

//-----------------------------------------------------------------------------------

class Person implements Serializable
{
	
	public static final long serialVersionUID = 42L;

	private String name;
	transient int age;
	static String country = "cn";
	Person(String name,int age,String country)
	{
		this.name = name;
		this.age = age;
		this.country = country;
	}
	public String toString()
	{
		return name+":"+age+":"+country;
	}
}