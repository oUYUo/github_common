import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
public class CallUpReturn 
{private Vector columnField=new Vector();
 private Vector column=new Vector();
 private Vector rowData=new Vector();
 private Connection con;
 private Statement stmt;
 private ResultSet result,result2,result3;
 private String sqlStr,cardnumber,bannercode,user_name,user_office,
 bookname,publisher;
 private java.util.Date day1,day2,today;
 private String[]columnNames={"借阅证","姓名","单位","图书条码","书名","作者",
 "借出时间","到期时间"};
 
 
	public CallUpReturn()
	{JFrame frame=new JFrame("催还通告");
	Container content=frame.getContentPane();
	
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 con=DriverManager.getConnection("jdbc:odbc:library");
		 stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		 ResultSet.CONCUR_READ_ONLY);
		 
		sqlStr="select borrow.user_cardnumber,borrow.bannercode,borrowdate,receivedate,"+
		"user_name,user_office,bookname,publishingcompany from borrow,book,user"+
		" where borrow.user_cardnumber=user.user_cardnumber and borrow.bannercode="+
		"book.bannercode";
	
		result=stmt.executeQuery(sqlStr);
	   today=new java.util.Date();
		int i=0;
		while(result.next())
		{	
		  columnField.clear();
		 day1=result.getDate("borrowdate");
		 day2=result.getDate("receivedate");
		 
		 if(day2.before(today))
		 {
		
		  cardnumber=result.getString("user_cardnumber");
		  bannercode=result.getString("bannercode");
		  
		  user_name=result.getString("user_name");
		  user_office=result.getString("user_office");
		  
		 
		  bookname=result.getString("bookname");
		  publisher=result.getString("publishingcompany");
		 
		  columnField.add(cardnumber);
		  columnField.add(user_name);
		  columnField.add(user_office);
		  columnField.add(bannercode);
		  columnField.add(bookname);
		  columnField.add(publisher);
		  columnField.add(day1);
		  columnField.add(day2);
		  rowData.add(columnField.clone());
		  
		 }
		
		 System.out.println(i);
		
		}
		
		stmt.close();
		con.close();
		
	}
	catch(ClassNotFoundException e)
	{System.err.println(e);
	}
	catch(SQLException e)
	{System.err.println(e.getCause());
	 System.err.println(e.getErrorCode());
	 System.err.println(e.getNextException());
	 System.err.println(e.getStackTrace());
	}
	
	for(int i=0;i<columnNames.length;i++)
	{
	 column.add(columnNames[i]);
	}
	
	JTable tableTest=new JTable(rowData,column);
	tableTest.setRowHeight(30);
	JScrollPane scrollPane=new JScrollPane(tableTest);
	scrollPane.setPreferredSize(new Dimension(500,80));
	content.add(scrollPane,BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);
	
	}
	public static void main(String[]args)
	{
		new CallUpReturn();
	}
	
}