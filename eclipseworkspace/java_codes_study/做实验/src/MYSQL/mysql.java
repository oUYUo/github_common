package MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://127.0.0.1:3306/test";
		String username="root";
		String passward="sz869993410";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,passward);
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from tb");
			
			
			//插入数据
			String sql1=" INSERT INTO tb(username,ip_address,status_code,useful) values('http','193.108.0.0:808',200,1)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			int result1=stmt.executeUpdate(sql1);
//			int result2 = stmt.executeUpdate(sql1);
//			System.out.println(result1+"被修改");
//			System.out.println(result2+"被修改");
				
			//删除数据
			String sql2="delete from tb where id =2";
			int result1=stmt.executeUpdate(sql2);
			System.out.println(result1);
			
			
			
			
//			while(rs.next())
//			{
//				int id = rs.getInt(1);
//				String name=rs.getString(2);
//				String ip_address=rs.getString(3);
//				int status_code = rs.getShort(4);
//				int useful = rs.getInt(5);
//				System.out.println(id+"\t"+name+'\t'+ip_address+'\t'+status_code+'\t'+useful);
//			}
//			
			
			
			
			
			
			
			
			
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
