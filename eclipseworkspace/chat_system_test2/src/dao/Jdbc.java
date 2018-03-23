package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
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
		String sql="UPDATE chat SET word=\""+word+"\" WHERE USERNAME=\""+name+"\";";
		Statement stmt = con.createStatement();
		int rs = stmt.executeUpdate(sql);
		System.out.println(sql);
		if(rs!=-1)
		{
			System.out.println("更新成功。。。");
		}
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public boolean Login(String username,String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat?characterEncoding=utf-8","root", "sz869993410");
			String sql="INSERT	INTO chat (username,PASSWORD) VALUES(\""+username+"\",\""+password+"\")";
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(sql);
			if(rs!=-1)
			{
				
				if(stmt!=null)
				{
					try {
						stmt.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try {
						con.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return true;
			}
			else{
				
				if(stmt!=null)
				{
					try {
						stmt.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try {
						con.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return false;
	}
	public  String Search(String username){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat?characterEncoding=utf-8","root", "sz869993410");
			
			System.out.println("数据库连接成功。。。");
			String sql="SELECT word"+" FROM chat WHERE USERNAME=\""+username+"\";";
			System.out.println(sql);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			String result="null";
			if(rs.next())
			{
				result=rs.getString(1);
				System.out.println("数据库操作成功,查询数据为："+result);
				if(rs!=null)
				{
					try {
						rs.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(stmt!=null)
				{
					try {
						stmt.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try {
						con.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return result;
			}
			else{
				if(rs!=null)
				{
					try {
						rs.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(stmt!=null)
				{
					try {
						stmt.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try {
						con.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return "null";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "null";
		}
	public  String SearchPassword(String username){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat?characterEncoding=utf-8","root", "sz869993410");
			String sql="SELECT PASSWORD "+" FROM chat WHERE username=\""+username+"\";";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String result="";
			if(rs.next())
			{
				result=rs.getString(1);
				System.out.println("数据库操作成功,查询数据为："+result);
				if(rs!=null)
				{
					try {
						rs.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(stmt!=null)
				{
					try {
						stmt.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try {
						con.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return result;
			}
			else{
				if(rs!=null)
				{
					try {
						rs.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(stmt!=null)
				{
					try {
						stmt.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null)
				{
					try {
						con.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return "null";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "null";
		}
	public String getWord1() {
		return word1;
	}

	public void setWord1(String word1) {
		this.word1 = word1;
	}

	public static void main(String[] args){
		Jdbc DB = new Jdbc();
		DB.Update("zhuo", "nihaoma ");
	}
	
}
	
