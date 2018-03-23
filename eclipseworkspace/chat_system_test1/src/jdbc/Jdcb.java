package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdcb {
	private String word1;
	private String word2;
	private String user;
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getWord2() {
		return word2;
	}

	public void setWord2(String word2) {
		this.word2 = word2;
	}


	public  void Update(String name, String word){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat?characterEncoding=utf-8","root", "sz869993410");
		
		System.out.println("数据库连接成功。。。");
		String sql="UPDATE chat SET word=\""+word+"\" WHERE NAME=\""+name+"\";";
		Statement stmt = con.createStatement();
		int rs = stmt.executeUpdate(sql);
		System.out.println(sql);
		if(rs!=-1)
		{
			System.out.println("更新成功。。。");
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public  String Search(String name){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat?characterEncoding=utf-8","root", "sz869993410");
			
			System.out.println("数据库连接成功。。。");
			String sql="SELECT word"+" FROM chat WHERE NAME=\""+name+"\";";
//			System.out.println(sql);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			String result="";
			if(rs.next())
			{
				result=rs.getString(1);
				System.out.println("数据库操作成功,查询数据为："+result);
				return result;
			}
			else{
				return "";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		}
	
	public static void main(String[] args){
		Jdcb DB = new Jdcb();
		DB.Search("zhuo1");
	}

	public String getWord1() {
		return word1;
	}

	public void setWord1(String word1) {
		this.word1 = word1;
	}
}
