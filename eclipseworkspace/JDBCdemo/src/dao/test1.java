package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user="root";
		String password="sz869993410";
		String url ="jdbc:mysql://localhost:3306/shopping";
		String sql = "INSERT INTO items(NAME,city,price,number,picture) VALUES('hhsunzhuo1','昆山',199,600,'006.page')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			int result=stmt.executeUpdate(sql);
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			CallableStatement cstmt = con.prepareCall(sql);
			ResultSet rs = stmt.executeQuery("SELECT * FROM items");
			   while(rs.next()){   
			         String name = rs.getString(2); 
//			    String pass = rs.getString(1) ; // 此方法比较高效   
			         System.out.println(name);
			     }   
			System.out.println(result);
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
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
