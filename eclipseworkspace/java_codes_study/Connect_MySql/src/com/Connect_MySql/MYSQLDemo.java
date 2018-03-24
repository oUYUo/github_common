package com.Connect_MySql;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MYSQLDemo {
	private static final String url="jdbc:mysql://127.0.0.1:3306/imooc";
	private static final String user = "root";
	private static final String passward="sz869993410";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得数据库的连接
		Connection conn=DriverManager.getConnection(url);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select user_name from imooc_goddess");
		while(rs.next())
		{
			System.out.println(re.getString("user_name"+re.getInt("age");));
		}
		
	}

}
