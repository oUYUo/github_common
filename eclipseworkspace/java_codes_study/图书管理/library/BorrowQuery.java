import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class BorrowQuery implements ActionListener
{ private JFrame frame;
  private JButton btn1,btn2;
  private JTextField jtfd1,jtfd2;
  private JTable tableTest;
  private String[]columnNames={"借阅证号","图书条码","借书日期","应还日期"};
  
  private Object[][] rowData=new Object[4][4];
  private Statement stmt;
  private Connection con;
	public BorrowQuery()
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame=new JFrame("借阅查询");
		Container content=frame.getContentPane();
		content.setLayout(new BorderLayout());
		
		JLabel lb1=new JLabel("借阅证号:");
		JLabel lb2=new JLabel("姓名:");
		btn1=new JButton("查询");
		btn2=new JButton("退出");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		jtfd1=new JTextField();
		jtfd2=new JTextField();
		JPanel pl=new JPanel();
		pl.setLayout(new GridLayout(2,3,10,10));
		pl.add(lb1);
		pl.add(jtfd1);
		pl.add(btn1);
		pl.add(lb2);
		pl.add(jtfd2);
		pl.add(btn2);
		
		tableTest=new JTable(rowData,columnNames);
		tableTest.setRowHeight(30);
	 
		tableTest.setPreferredScrollableViewportSize(new Dimension(500,60));
		JScrollPane scrollPane=new JScrollPane(tableTest);
		
		content.add(pl,BorderLayout.NORTH);
		content.add(scrollPane,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:library");
			stmt=con.createStatement();
		}
		catch(ClassNotFoundException e)
		{
		}
		catch(SQLException e)
		{System.err.println(e);
		}
		
		
	}
	public void actionPerformed(ActionEvent e)
	{String sqlStr,cardnumber,user_name,str1,str2,bannercode;
	 ResultSet result;
	 java.util.Date day1,day2;
	 Object obj=(JButton)e.getSource();
	 str1=jtfd1.getText().trim();
	 str2=jtfd2.getText().trim();
	 try
	 {if(obj==btn1)
	  {if(str1.equals("")|str2.equals(""))
	   {JOptionPane.showMessageDialog(frame,"Text can't be null!");
	    return;
	   }
	   
	   sqlStr="select borrow.user_cardnumber,user_name,bannercode,borrowdate,receivedate"+
	   " from borrow,user where borrow.user_cardnumber=user.user_cardnumber and"+
	   " borrow.user_cardnumber="+"'"+str1+"'";
	   result=stmt.executeQuery(sqlStr);
	   
	   for(int j=0;j<rowData.length;j++)
	   { for(int k=0;k<4;k++)
	   	 rowData[j][k]=null;
	   }
	  tableTest.repaint();
	  int i=0;
	   while(result.next())
	   {
	   
	   	cardnumber=result.getString("user_cardnumber");
	   	user_name=result.getString("user_name");
	   	if(str2.equals(user_name))
	   	{
	   	 	day1=result.getDate("borrowdate");
	   	 	day2=result.getDate("receivedate");
	   	 	bannercode=result.getString("bannercode");
	   	 	
	   	 	rowData[i][0]=cardnumber;
	   	 	rowData[i][1]=bannercode;
	   	 	rowData[i][2]=day1;
	   	 	rowData[i][3]=day2;
	   	 	i++;
	   	}
	   }
	   
	   jtfd1.setText("");
	   jtfd2.setText("");
	  }
	  if(obj==btn2)
	  {stmt.close();
	   con.close();
	   frame.dispose();
	  }
	 }
	 catch(SQLException sqle)
	 {System.err.println(sqle);
	 }
	}
	public static void main(String[]args)
	{new BorrowQuery();
	}
}