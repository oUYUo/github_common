package com.Connect_MySql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



//����jdbc��������  DriverManager��
//�������ݿ� 	connection�ӿ�
//����sql���	statement�ӿ� preparedstatement�ӿ� callablestatement�ӿ�
//��������	resultset�ӿ�
//�ر����ݿ�	�����������ιر�
public class new_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Statement stmt = null;//����sql�ӿ�
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
			
			
			//��̬��ѯ
//			String sql="select * from tb1 where username = ?";
//			PreparedStatement ps =con.prepareStatement(sql);
//			ps.setString(1, "Tom");
//			rs=ps.executeQuery();
			
			
			
			//��������
//			String sql1="insert into tb1(username) values('hhh')";
//			int result1 = stmt.executeUpdate(sql1);
//			System.out.println(result1+"���޸�");
		
			//�޸�����
//			String sql2 = "update tb1 set username = 'asf' where id =5";
//			int result2=stmt.executeUpdate(sql2);
//			System.out.println(result2+"���޸�");
			
			//ɾ������
//			String sql3 = "delete from tb1 where id =5";
//			int result3 = stmt.executeUpdate(sql3);
//			System.out.println(result3+"���޸�");
			
			rs = stmt.executeQuery("select * from tb1");
			while(rs.next()){
				int id =rs.getInt(1);
				String name=rs.getString(2);
				System.out.println("���="+id+"\t"+"����="+name);
			}
			//list_table[0][0]  list_table[1][0]
//			stmt=con.createStatement();
//			String sql1="insert into tb1(name) values('fuck')";
//			int result1= stmt.executeUpdate(sql1);
//			System.out.println("��"+result1+"�б��޸�");

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
