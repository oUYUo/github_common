import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
import java.text.*;
public class CardManagement implements ActionListener
{ private  JTextField jtfd1,jtfd2,jtfd3,jtfd4;
  private  JButton btn1,btn2,btn3,btn4;
  private Statement stmt;
  private  PreparedStatement pstmt;
  private  Connection con;
  private  JFrame frame;
	
	public CardManagement()
	{JFrame.setDefaultLookAndFeelDecorated(true);
	 frame=new JFrame("借阅证管理");
	
	 Container content=frame.getContentPane();
	 JLabel lb1=new JLabel("借阅证号:");
	 JLabel lb2=new JLabel("按借阅证号:");
	 JLabel lb3=new JLabel("按有效期:");
	 JLabel lb4=new JLabel("借阅证号:");
	 jtfd1=new JTextField();
	 jtfd2=new JTextField();
	 jtfd3=new JTextField();
	 jtfd4=new JTextField();
	 jtfd3.addFocusListener(new FocusHandler());
	 btn1=new JButton("挂失");
	 btn2=new JButton("注销");
	 btn3=new JButton("注销");
	 btn4=new JButton("取消挂失");
	 btn3.addActionListener(this);
	 btn1.addActionListener(this);
	 btn2.addActionListener(this);
	 btn4.addActionListener(this);
	 JPanel pl1=new JPanel();
	 JPanel pl2=new JPanel();
	 JPanel pl3=new JPanel();
	 pl1.setBorder(BorderFactory.createTitledBorder("挂失"));
	 pl2.setBorder(BorderFactory.createTitledBorder("注销"));
	 pl3.setBorder(BorderFactory.createTitledBorder("取消挂失"));
	 GridBagLayout gbl=new GridBagLayout();
	 GridBagConstraints gbc=new GridBagConstraints();
	 gbc.fill=GridBagConstraints.BOTH;
	 gbc.weightx=gbc.weighty=10.0;
	 pl1.setLayout(gbl);
	 
	 gbc.gridwidth=1;
	 gbc.weightx=1.0;
	 gbl.setConstraints(lb1,gbc);
	 
	 pl1.add(lb1);
	 
	 
	 gbc.weightx=8.0;
	 gbc.gridheight=2;
	 gbc.gridwidth=2;
	 gbc.insets=new Insets(15,15,15,5);
	 gbl.setConstraints(jtfd1,gbc);
	 pl1.add(jtfd1);
	 
	 
	 gbc.insets=new Insets(19,0,19,5);
	 gbc.weightx=1.0;
	 gbc.gridheight=2;
	 gbc.gridwidth=3;
	 gbc.gridwidth=gbc.REMAINDER;
	 gbl.setConstraints(btn1,gbc);
	 pl1.add(btn1);
	 
	 GridBagLayout gbl2=new GridBagLayout();
	 GridBagConstraints gbc2=new GridBagConstraints();
	 gbc2.fill=GridBagConstraints.BOTH;
	 gbc2.weightx=gbc2.weighty=10;
	 pl2.setLayout(gbl2);
	 
	 gbc2.gridwidth=1;
	 gbc2.weightx=1;
	 gbl2.setConstraints(lb2,gbc2);
	 
	 pl2.add(lb2);
	
	 gbc2.gridwidth=2;
	 gbc2.insets=new Insets(0,0,0,5);
	 gbc2.weightx=8;
	 gbc2.gridheight=2;
	  gbl2.setConstraints(jtfd2,gbc2);
	 pl2.add(jtfd2);
	 
	 gbc2.gridwidth=gbc2.REMAINDER;
	 gbc2.insets=new Insets(5,0,5,5);
	 gbc2.weightx=1;
	 gbc2.gridwidth=2;
	 gbc2.gridheight=2;
	 gbl2.setConstraints(btn2,gbc2);
	 pl2.add(btn2);
	 
	
	 gbc2.gridx=0;
	 gbc2.insets=new Insets(5,0,0,0);
	 gbc2.gridwidth=1;
	 gbc2.weightx=1;
	 gbl2.setConstraints(lb3,gbc2);
	 pl2.add(lb3);
	 
	 gbc2.gridx=1;
	 gbc2.gridwidth=2;
	 gbc2.insets=new Insets(5,0,0,5);
	 gbc2.weightx=8;
	 gbl2.setConstraints(jtfd3,gbc2);
	 pl2.add(jtfd3);
	 gbc2.gridx=3;
	 gbc2.gridwidth=gbc2.REMAINDER;
	 gbc2.insets=new Insets(10,0,5,5);
	 gbc2.weightx=1;
	 gbl2.setConstraints(btn3,gbc2);
	 pl2.add(btn3);
	 
	 GridBagLayout gbl4=new GridBagLayout();
	GridBagConstraints gbc4=new GridBagConstraints();
	 gbc4.fill=GridBagConstraints.BOTH;
	 gbc4.weightx=gbc4.weighty=10.0;
	 pl3.setLayout(gbl4);
	 
	
	 gbc4.gridwidth=1;
	 gbc4.gridheight=1;
	 gbc4.weightx=1.0;
	 
	 gbl4.setConstraints(lb4,gbc4);
	 
	 pl3.add(lb4);
	 
	
	 gbc4.weightx=8;
	 gbc4.gridheight=2;
	 gbc4.gridwidth=2;
	 gbc4.insets=new Insets(15,15,15,5);
	 gbl4.setConstraints(jtfd4,gbc4);
	 pl3.add(jtfd4);
	 
     
	 gbc4.insets=new Insets(19,0,19,5);
	 gbc4.weightx=1.0;
	 gbc4.gridheight=2;
	
	 gbc4.gridwidth=gbc4.REMAINDER;
	 gbl4.setConstraints(btn4,gbc4);
	 pl3.add(btn4);
	 
	 
	 GridBagLayout gbl3=new GridBagLayout();
	 GridBagConstraints gbc3=new GridBagConstraints();
	 gbc3.fill=GridBagConstraints.BOTH;
	 gbc3.weightx=gbc3.weighty=10.0;
	 content.setLayout(gbl3);
	 
	 gbc3.weighty=2.5;
	 gbc3.insets=new Insets(10,10,0,10);
	 gbl3.setConstraints(pl1,gbc3);
     
	 content.add(pl1);
	 
	 gbc3.gridx=0;
	 gbc3.weighty=5;
	 gbc3.insets=new Insets(10,10,10,10);
	 gbl3.setConstraints(pl2,gbc3);
	 content.add(pl2);
	 
	 gbc3.gridx=0;
	 gbc3.weighty=2.5;
	 gbc3.insets=new Insets(0,10,10,10);
	 gbl3.setConstraints(pl3,gbc3);
	 content.add(pl3);

	 frame.setBounds(100,100,450,400);
	 frame.setResizable(true);
	 
	 try
	 {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  con=DriverManager.getConnection("jdbc:odbc:library");
	  stmt=con.createStatement();
	  pstmt=con.prepareStatement("select user_canceldate from user",
	  ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	  
	  
	 }
	 catch(ClassNotFoundException e)
	 {System.err.println(e);
	 }
	 catch(SQLException e)
	 {System.err.println(e);
	 }
	 frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{String str,sqlStr;
	 ResultSet result;
	 int res;
	 Object obj=(JButton)e.getSource();
	 
	 
	 try{
	 
	  if(obj==btn3)
	   {str=jtfd3.getText().trim();
	   	if(str.equals(""))
	    {return;
	    }
	    java.util.Date today=java.sql.Date.valueOf(str);
     
	      result=pstmt.executeQuery();
	    while(result.next())
	    {java.util.Date today1=result.getDate("user_canceldate");
	    
	     if(today.after(today1))
	     {  
	     	result.deleteRow();
	     
	     }
	    }
	    jtfd3.setText("");
	   }
	   if(obj==btn1)
	   {str=jtfd1.getText().trim();
	    sqlStr="update user set user_state='挂失' where user_cardnumber="+
	    "'"+str+"'";
	    if(str.equals(""))
	    {   JOptionPane.showMessageDialog(frame,"Text was null!");
	    	return;
	    }
	    res=stmt.executeUpdate(sqlStr);
	    if(res>0)
	    {JOptionPane.showMessageDialog(frame,"reportloss successfully!");
	     jtfd1.setText("");
	     return;
	    }
	    
	 	}
	 	if(obj==btn2)
	 	{str=jtfd2.getText().trim();
	 	 sqlStr="delete * from user where user_cardnumber="+"'"+str+"'";
	 	 if(str.equals(""))
	 	 {JOptionPane.showMessageDialog(frame,"Text was null!");
	 	  return;
	 	 }
	 	 res=stmt.executeUpdate(sqlStr);
	 	 if(res>0)
	 	 {JOptionPane.showMessageDialog(frame,"注销成功!");
	 	 }
	 	 jtfd2.setText("");
	 	}
	 	if(obj==btn4)
	 	{str=jtfd4.getText().trim();
	 	 sqlStr="update user set user_state='正常' where user_cardnumber="+
	 	 "'"+str+"'";
	 	 if(str.equals(""))
	 	 {JOptionPane.showMessageDialog(frame,"Text was null!");
	 	  return;
	 	 }
	 	 res=stmt.executeUpdate(sqlStr);
	 	 if(res>0)
	 	 {JOptionPane.showMessageDialog(frame,"update a record!");
	 	 }
	 	 jtfd4.setText("");
	 	}
	     }
	     catch(SQLException sqle)
	     {System.err.println(sqle.getMessage());
	     }
	}
	class FocusHandler implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{Object obj=(JTextField)e.getSource();
		 if(obj==jtfd3)
		 {java.util.Date today=new java.util.Date();
		  DateFormat format=DateFormat.getDateInstance();
		  String formatted=format.format(today);
		  jtfd3.setText(formatted);
		 }
		 
		}
		public void focusLost(FocusEvent e)
		{
		}
	}
	public static void main(String[]args)
	{
		new CardManagement();
	}
}