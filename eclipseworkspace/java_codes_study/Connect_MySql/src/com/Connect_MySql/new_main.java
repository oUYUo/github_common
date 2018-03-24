package com.Connect_MySql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



//加载jdbc驱动程序  DriverManager类
//连接数据库 	connection接口
//发送sql语句	statement接口 preparedstatement接口 callablestatement接口
//处理结果集	resultset接口
//关闭数据库	从下往上依次关闭
public class new_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Statement stmt = null;//发送sql接口
		Connection con =null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			String url="jdbc:mysql://127.0.0.1:3306/test";
			String username="root";
			String passward="sz869993410";
			Class.forName("com.mysql.jdbc.Driver");
			
			
			con =DriverManager.getConnection(url,username,passward);
			stmt=con.createStatement();
			
			
			//动态查询
//			String sql="select * from tb1 where username = ?";
//			PreparedStatement ps =con.prepareStatement(sql);
//			ps.setString(1, "Tom");
//			rs=ps.executeQuery();
			
			
			
			//插入数据
//			String sql1="insert into tb1(username) values('hhh')";
//			int result1 = stmt.executeUpdate(sql1);
//			System.out.println(result1+"被修改");
		
			//修改数据
//			String sql2 = "update tb1 set username = 'asf' where id =5";
//			int result2=stmt.executeUpdate(sql2);
//			System.out.println(result2+"被修改");
			
			//删除数据
//			String sql3 = "delete from tb1 where id =5";
//			int result3 = stmt.executeUpdate(sql3);
//			System.out.println(result3+"被修改");
			
			rs = stmt.executeQuery("select * from tb1");
			while(rs.next()){
				int id =rs.getInt(1);
				String name=rs.getString(2);
				System.out.println("编号="+id+"\t"+"姓名="+name);
			}
			//list_table[0][0]  list_table[1][0]
//			stmt=con.createStatement();
//			String sql1="insert into tb1(name) values('fuck')";
//			int result1= stmt.executeUpdate(sql1);
//			System.out.println("有"+result1+"行被修改");

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

}
