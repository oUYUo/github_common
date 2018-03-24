import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class TransactCard implements ActionListener
{private  JButton btn1,btn2,btn3,btn4;
 private  JTextField tfd1,tfd3,tfd4,tfd5;
 private  JComboBox jcb1,jcb2,jcb3;
 private  PreparedStatement pstmt;
 private  Connection con;
 private  JFrame frame;
 private static Statement stmt;
	public TransactCard()
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
	 frame=new JFrame("图书证办理");
		Container content=frame.getContentPane();
		
		frame.addWindowListener(new WindowAdapter()
		{ 
			public void windowCloing(WindowEvent e)
			{try{
			
				pstmt.close();
			    con.close();
			    stmt.close();
			    frame.dispose();
			    }
			    catch(SQLException sqle)
			    {
			    }
			}
			
		});
	
		content.setLayout(new BorderLayout());
		JPanel Jpl=new JPanel();
		JPanel Jpl2=new JPanel();
		Jpl.setLayout(new GridLayout(7,2,2,6));
		Jpl2.setLayout(new GridLayout(1,4,2,0));
		JLabel lb1=new JLabel("姓名:");
		JLabel lb2=new JLabel("性别:");
		JLabel lb3=new JLabel("身份:");
		JLabel lb4=new JLabel("单位:");
		JLabel lb5=new JLabel("证件号码:");
		JLabel lb6=new JLabel("注册日期:");
		JLabel lb7=new JLabel("有效日期:");
		
		btn1=new JButton("添加");
		btn2=new JButton("删除");
		btn3=new JButton("撤消");
		btn4=new JButton("退出");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		tfd1=new JTextField();
	
		tfd3=new JTextField();
		tfd4=new JTextField();
		tfd5=new JTextField();
		tfd4.addFocusListener(new FocusHandler());
		tfd5.addFocusListener(new FocusHandler());
		
		String[] str_sex={"男","女"};
		String[] str_office={"计算机系","电子系","商学系","机电系","外语系"};
		String[] str_status={"学生","教师"};
		
		jcb1=new JComboBox(str_sex);
		jcb2=new JComboBox(str_status);
		jcb3=new JComboBox(str_office);
		jcb2.setEditable(true);
		
		Jpl.add(lb1);
		Jpl.add(tfd1);
		Jpl.add(lb2);
		Jpl.add(jcb1);
		Jpl.add(lb3);
		Jpl.add(jcb2);
		Jpl.add(lb4);
		Jpl.add(jcb3);
		Jpl.add(lb5);
		Jpl.add(tfd3);
		Jpl.add(lb6);
		Jpl.add(tfd4);
		Jpl.add(lb7);
		Jpl.add(tfd5);
		Jpl.setBorder(BorderFactory.createTitledBorder("图书证注册"));
		Jpl2.add(btn1);
		Jpl2.add(btn2);
		Jpl2.add(btn3);
		Jpl2.add(btn4);
		Jpl2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		content.add(Jpl,BorderLayout.CENTER);
		content.add(Jpl2,BorderLayout.SOUTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(450,400);
		frame.setVisible(true);
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:library");
			String str;
			str="insert into user (user_name,user_sex,user_status,user_office,"+
			"user_cardnumber,user_registerdate,user_canceldate,user_state) values(?,?,?,?,?,?,?,'正常')";
			pstmt=con.prepareStatement(str,ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_UPDATABLE);
			stmt=con.createStatement();
		   }
		   catch(SQLException e)
		   {
		   	
		   }
		   catch(ClassNotFoundException cnfe)
		   {
		   }
		
	}
	class FocusHandler implements FocusListener
	{ java.util.Date today=new java.util.Date();
	  java.util.Date today2=new java.util.Date();
	  String formatted2;
	  DateFormat fmt=DateFormat.getDateInstance();
	  String formatted=fmt.format(today);
	 
	 
	 public void focusGained(FocusEvent e)
	 {Object obj=(JTextField)e.getSource();
	  if(obj==tfd4)
	  {tfd4.setText(formatted);
	  }
	  if(obj==tfd5)
	  {today2.setYear(today.getYear()+4);
	   formatted2=fmt.format(today2);
	   tfd5.setText(formatted2);
	  }
	 }
	 public void focusLost(FocusEvent e)
	 {
	 }
	}
	public void actionPerformed(ActionEvent e)
	{String str1,str2,str3,str4,str5,str6,str7;
	java.sql.Date today1,today2;
	 
	 str1=tfd1.getText().trim();
	 str2=jcb1.getSelectedItem().toString();
	 str3=jcb2.getSelectedItem().toString();
	 str4=jcb3.getSelectedItem().toString();
	 str5=tfd3.getText().trim();
	 str6=tfd4.getText().trim();
	 str7=tfd5.getText().trim();
	 
	 String sqlStr="delete from user where user_cardnumber="+"'"+str5+"'";
	 Object obj=(JButton)e.getSource();
	 try{
	 
	  if(obj==btn1)
	   {
	   	today1=java.sql.Date.valueOf(str6);
	    today2=java.sql.Date.valueOf(str7);
	  pstmt.setString(1,str1);
	  pstmt.setString(2,str2);
	  pstmt.setString(3,str3);
	  pstmt.setString(4,str4);
	  pstmt.setString(5,str5);
	  pstmt.setDate(6,today1);
	  pstmt.setDate(7,today2);
	  pstmt.executeUpdate();
	     
	   }
	 else if(obj==btn2)
	 {
	  stmt.executeUpdate(sqlStr);
	 }
	 else if(obj==btn3)
	 {tfd1.setText("");
	 
	  tfd3.setText("");
	  tfd4.setText("");
	  tfd5.setText("");
	 }
	 else if(obj==btn4)
	 {pstmt.close();
	  stmt.close();
	  con.close();
	  
	  frame.dispose();
	  
	 }
	 }
	  catch(SQLException sqle)
	      {System.err.println(sqle.getMessage());
	      }
	}
	public static void main(String[]args)
	{
		new TransactCard();
	}
}
