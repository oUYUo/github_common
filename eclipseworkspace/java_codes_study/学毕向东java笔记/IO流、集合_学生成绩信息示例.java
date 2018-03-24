/*
练习：有五个学生，每个学生有三门课的成绩。
从键盘输入以上数据
输入格式：张三，30，40，60 计算出总成绩，
并把学生的信息和计算出的总分数高低顺序存放在磁盘文件“stud.txt”中
*/
import java.io.*;
import java.util.*;
class The_Trans
{
	public static void main(String[] args) throws IOException
	{
		Comparator<Students> comp = Collections.reverseOrder();

		Save( input( comp));
		getSave();
	}

	public static TreeSet<Students> input( Comparator<Students> comp)throws IOException
	{		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Students> ts = null;

		if( comp == null)
			ts = new TreeSet<Students>();
		else
			ts = new TreeSet<Students>( comp);

		for( int x = 0; x < 2; x++)
		{	
			System.out.print( "请输入：姓名，成绩1，成绩2，成绩3：");
			String line = bufr.readLine();
			String[] s = line.split( ",");

			if( s.length != 4)
				return null;

			ts.add( new Students( s[0], Integer.valueOf( s[1]), Integer.valueOf( s[2]), Integer.valueOf( s[3])));
		}

		bufr.close();
		return ts;
	}

	public static void Save( TreeSet<Students> ts) throws IOException
	{
		BufferedWriter bw = new BufferedWriter( new FileWriter( "Student_information.txt"));

		Iterator<Students> it = ts.iterator();

		while( it.hasNext())
		{
			Students s = it.next();
			
			bw.write( "姓名：" + s.getName() + "\t成绩1：" + s.getresults1() + "\t成绩2：" + s.getresults2() + "\t成绩3：" + s.getresults3() + "\t总分：" + s.gethe());
		
			bw.newLine();
			bw.flush();
		}	

		bw.close();
	}

	public static void getSave()throws IOException
	{
		BufferedReader br = new BufferedReader( new FileReader( "Student_information.txt"));
		String s = null;
		while( ( s = br.readLine()) != null)
		{
			System.out.println( s);
		}

		br.close();
	}
}

class Students implements Comparable<Students>
{
	private String name;
	private int results1, results2, results3, he;

	Students( String name, int results1, int results2, int results3)
	{
		this.name = name;
		this.results1 = results1;
		this.results2 = results2;
		this.results3 = results3;
		this.he = results1 + results2 + results3;
	}

	public String getName()
	{
		return name;
	}

	public int getresults1()
	{
		return results1;
	}

	public int getresults2()
	{
		return results2;
	}

	public int getresults3()
	{
		return results3;
	}

	public int gethe()
	{
		return he;
	}

	public int hashCode()
	{
		return name.hashCode();
	}
	
	public boolean equals(Object o)  
	{
		if( !( o instanceof Students))
			throw new RuntimeException( "对象错误");

		Students s = (Students)o;

		return name.equals( s.getName()) && he == s.he;
	}
		
	public int compareTo( Students o)
	{
		int na = o.name.compareTo( name);

		int age = new Integer( he).compareTo( new Integer( o.he));
		
		if(na == 0 || age == 0)
			return na;

		return age;
	}
}

/*
class Comp implements Comparator<Students>
{
	public int compare(Students o1, Students o2)
	{
		int name = o1.getName().compareTo( o2.getName());
		int age = new Integer( o2.gethe()).compareTo( new Integer( o1.gethe()));
		
		if(name == 0)
			return name;
		else if( age == 0)
			return name;
		return age;
	}
}
*/