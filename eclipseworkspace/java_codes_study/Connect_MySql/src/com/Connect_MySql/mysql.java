package com.Connect_MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://127.0.0.1:3306/test";
		String username ="root";
		String passward ="sz869993410";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,passward);
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
