import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class NewBookReport implements ActionListener
{private JRadioButton rbtn1,rbtn2,rbtn3;
 private JComboBox jcbx;
 private JFrame frame;
 private String[]columnNames={"书名","作者","出版社","出版日期","价格"};
 private Object[][]rowData=new Object[1000][5];
 private JTable tableTest;
 private JButton btn;
 private Statement stmt;
 private Connection con;
	public NewBookReport()
	{JFrame.setDefaultLookAndFeelDecorated(true);
	 frame=new JFrame("新书通报");
	 Container content=frame.getContentPane();
	 rbtn1=new JRadioButton("近一周");
	 rbtn2=new JRadioButton("近一月");
	 rbtn3=new JRadioButton("近三个月");
	 rbtn1.setSelected(true);
	 ButtonGroup bgp=new ButtonGroup();
	 bgp.add(rbtn1);
	 bgp.add(rbtn2);
	 bgp.add(rbtn3);
	 
	 btn=new JButton("查询");
	 btn.addActionListener(this);
	 JLabel lb=new JLabel("新书分类:");
	 String[] kindname={"马克思列宁主义、毛泽东思想","综合性图书","哲学","社会科学总论",
	 "政治、法律","军事","经济","文化、科学、教育、体育","语言文字","文学","天文学、地球科学",
	 "生物科学","医药、卫生","农业科学","工业技术","艺术","历史、地理","数理化","自然科学总论",
	 "环境科学","航空航天","交通"};
	 jcbx=new JComboBox(kindname);
	 JPanel pl=new JPanel();
	 pl.setLayout(new GridLayout(2,3,10,10));
	 pl.add(rbtn1);
	 pl.add(rbtn2);
	 pl.add(rbtn3);
	 pl.add(lb);
	 pl.add(jcbx);
	 pl.add(btn);
	 content.add(pl,BorderLayout.NORTH);
	 tableTest=new JTable(rowData,columnNames);
	 tableTest.setRowHeight(30);
	 tableTest.setRequestFocusEnabled(false);
	 tableTest.setPreferredScrollableViewportSize(new Dimension(500,60));
	 JScrollPane scrollPane=new JScrollPane(tableTest);
	 content.add(scrollPane,BorderLayout.CENTER);
	 frame.pack();
	 frame.setVisible(true);
	 try
	 {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  con=DriverManager.getConnection("jdbc:odbc:library");
	  stmt=con.createStatement();
	 }
	 catch(ClassNotFoundException e)
	 {System.err.println(e);
	 }
	 catch(SQLException e)
	 {System.err.println(e);
	 }
	 
	 
		
	}
	public void actionPerformed(ActionEvent e)
	{Object obj=(JButton)e.getSource();
	 String kindname,sqlStr;
	 ResultSet result;
	 int i=0;
	 java.util.Date today=new java.util.Date();
	 java.util.Date day;

	 
	 try
	 {
	 	if(obj==btn)
	 	{ if(rbtn1.isSelected())
	 	  {
	 	   today.setDate(today.getDate()-7);
	 	  }
	 	  if(rbtn2.isSelected())
	 	  {
	 	  today.setDate(today.getDate()-30);
	 	  }
	 	  if(rbtn3.isSelected())
	 	  {today.setDate(today.getDate()-90);
	 	  }
	 	  for(int j=0;j<rowData.length;j++)
	 	  { for(int k=0;k<5;k++)
	 	    {rowData[j][k]=null;
	 	    }
	 	  }
	 	  kindname=(String)jcbx.getSelectedItem();
	 	  sqlStr="select bookname,author,publishingcompany,publishtime,"+
	 	  "price,putintime from book where kindname="+"'"+kindname+"'";
	 	  result=stmt.executeQuery(sqlStr);
	 	  while(result.next())
	 	  {day=result.getDate("putintime");
	 	   if(day.after(today))
	 	   { if(i<rowData.length)
	 	     {
	 	   	rowData[i][0]=result.getString("bookname");
	 	   	rowData[i][1]=result.getString("author");
	 	   	rowData[i][2]=result.getString("publishingcompany");
	 	   	rowData[i][3]=result.getDate("publishtime");
	 	   	rowData[i][4]=result.getBigDecimal("price",2);
	 	   	 }
	 	   	i++;
	 	   }
	 	  	 JOptionPane.showMessageDialog(frame,""+i);
	 	  }
	 	 
	 	  tableTest.repaint();
	 	  
	 		
	 	}
	 
	 }
	 catch(SQLException sqle)
	 {
	 	System.err.println(sqle);
	 }
		
	}
	public static void main(String[]args)
	{new NewBookReport();
	}
}