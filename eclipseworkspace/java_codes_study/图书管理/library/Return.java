import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;

public class Return implements ActionListener
{private  JButton btn1,btn2;
 private  JTextField jtfd;
 private  Connection con;
 private  Statement stmt;
 private  JFrame frame;
	public Return()
	{
	
	JFrame.setDefaultLookAndFeelDecorated(true);
	frame=new JFrame("还书");
	Container content=frame.getContentPane();
	
	JLabel lb=new JLabel("条形码:");
	btn1=new JButton("确定");
	btn2=new JButton("退出");
	jtfd=new JTextField();
	btn1.addActionListener(this);
	btn2.addActionListener(this);
	GridBagLayout gbl=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	gbc.fill=GridBagConstraints.BOTH;
	gbc.weightx=gbc.weighty=10.0;
	content.setLayout(gbl);
	gbc.gridx=0;
	gbc.gridy=0;
	gbc.gridwidth=1;
	gbc.gridheight=1;
	gbc.weightx=4;
	gbc.insets=new Insets(10,10,0,0);
	gbl.setConstraints(lb,gbc);
	content.add(lb);
	gbc.gridx=1;
	gbc.gridy=0;
	
	gbc.weightx=6;
	gbc.insets=new Insets(10,10,0,10);
	gbl.setConstraints(jtfd,gbc);
	content.add(jtfd);
	gbc.gridx=0;
	gbc.gridy=1;
	
	gbc.weightx=5;
	gbc.insets=new Insets(30,20,20,20);
	gbl.setConstraints(btn1,gbc);
	content.add(btn1);
	gbc.gridx=1;
	gbc.gridy=1;
	gbc.weightx=5;
	gbc.insets=new Insets(30,35,20,35);
	gbl.setConstraints(btn2,gbc);
	content.add(btn2);
	frame.setBounds(100,100,420,160);
	frame.setResizable(true);
	frame.setVisible(true);
	try
	{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 con=DriverManager.getConnection("jdbc:odbc:library");
	 stmt=con.createStatement();
	}
	catch(ClassNotFoundException e)
	{System.err.println(e.getMessage());
	}
	catch(SQLException e)
	{System.err.println(e.getMessage());
	}
	}
	public void actionPerformed(ActionEvent e)
	{String str,sqlStr,cardnumber;
	 int day1,day2,res;
	 float money=0;
	 ResultSet result,result2;
	 Object obj=(JButton)e.getSource();
	 try{
	 
	 if(obj==btn1)
	 {str=jtfd.getText().trim();
	  sqlStr="select receivedate,user_cardnumber from borrow where bannercode="+
	  "'"+str+"'";
	  
	  if(str.equals(""))
	  {JOptionPane.showMessageDialog(frame,"Text was null!");
	   return;
	  }
	  result=stmt.executeQuery(sqlStr);
	  if(result.next())
	  {java.util.Date recdate=result.getDate("receivedate");
	   cardnumber=result.getString("user_cardnumber");
	   java.util.Date today=new java.util.Date();
	  
	    if(recdate.before(today))
	    {day1=today.getYear()*365+today.getMonth()*30+today.getDay();
	     day2=recdate.getYear()*365+recdate.getMonth()*30+recdate.getDate();
	     money=(float)((day1-day2)*0.1);
	     sqlStr="select * from punishment where user_cardnumber="+
	     "'"+cardnumber+"'";
	     result2=stmt.executeQuery(sqlStr);
	     if(!result2.next())
	     {
	      sqlStr="insert into punishment(user_cardnumber,sum_account)"+
	     "values("+"'"+cardnumber+"'"+","+money+")";
	      stmt.executeUpdate(sqlStr);
	      JOptionPane.showMessageDialog(frame,"insert a record!");
	     }
	     else
	     {sqlStr="update punishment set sum_account=sum_account+"+money+
	     " where user_cardnumber="+"'"+cardnumber+"'";
	      stmt.executeUpdate(sqlStr);
	      JOptionPane.showMessageDialog(frame,"update a record!");
	     }
	 
	    }
	      sqlStr="delete from borrow where bannercode="+"'"+str+"'";
	     
	      res=stmt.executeUpdate(sqlStr);
	      if(res>0)
	      {
	       sqlStr="update book set state='在架' where bannercode="+
	       "'"+str+"'";
	       stmt.executeUpdate(sqlStr);
	       JOptionPane.showMessageDialog(frame,"return successfully!");
	      }
	  }
	  jtfd.setText("");
	 }
	 if(obj==btn2)
	 {stmt.close();
	  con.close();
	  frame.dispose();
	 }
	 
	  
	 }
	 catch(SQLException sqle)
	 {System.err.println(sqle.getMessage());
	  
	 }
	}
	public static void main(String[]args)
	{new Return();
	}
 
}