package com.db;
import java.sql.*;
public class DbConnect {
	private static String driverName="com.mysql.jdbc.Driver";
	private static String userName="root";
	private static String userPassword="sz869993410";
	private static String dbName="user";
	public static Connection getDBconnection(){
		String url1="jdbc:mysql://localhost/"+dbName;
		String url2="?characterEncoding=utf-8";
		String url=url1+url2;
		Connection con = null;
		try {
			Class.forName(driverName);
			con=DriverManager.getConnection(url,userName,userPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public static void closeDB(Connection con,PreparedStatement pstm,ResultSet rs)
	{
		try {
			if(rs!=null)
			{	
					rs.close();
			}
			if(pstm!=null)
			{
				pstm.close();
			}
			if(con!=null)
			{
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
