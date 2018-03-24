import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.math.*;

public class Book implements ActionListener
{private  JButton btn1,btn2,btn3,btn4;
 private JTextField jtfd1,jtfd2,jtfd3,jtfd5,jtfd6,
 jtfd7,jtfd8,jtfd9,jtfd10;
 private JComboBox jcbx;
 private  JTextArea jta;
 private  Connection con;
 private  PreparedStatement pstmt1,pstmt2;
 private  JFrame frame;

public Book()
{JFrame.setDefaultLookAndFeelDecorated(true);
 frame=new JFrame("图书入库");
 Container content=frame.getContentPane();
 Toolkit tool=frame.getToolkit();
 Dimension wndsize=tool.getScreenSize();
 
 JLabel lb1=new JLabel("书名:");
 JLabel lb2=new JLabel("条形码:");
 JLabel lb3=new JLabel("分类号:");
 JLabel lb4=new JLabel("分类名:");
 JLabel lb5=new JLabel("排架号:");
 JLabel lb6=new JLabel("出版社:");
 JLabel lb7=new JLabel("出版日期:");
 JLabel lb8=new JLabel("入库日期:");
 JLabel lb9=new JLabel("价格:");
 JLabel lb10=new JLabel("作者:");
 JLabel lb11=new JLabel("简介:");
 
  jtfd1=new JTextField();
  jtfd2=new JTextField();
  jtfd3=new JTextField();
  String[] kindname={"马克思列宁主义、毛泽东思想","综合性图书","哲学","社会科学总论",
	 "政治、法律","军事","经济","文化、科学、教育、体育","语言文字","文学","天文学、地球科学",
	 "生物科学","医药、卫生","农业科学","工业技术","艺术","历史、地理","数理化","自然科学总论",
	 "环境科学","航空航天","交通"};
 jcbx=new JComboBox(kindname);
  
  jtfd5=new JTextField();
  jtfd6=new JTextField();
  jtfd7=new JTextField();
  jtfd8=new JTextField();
  jtfd9=new JTextField();
  jtfd10=new JTextField();
  jtfd8.addFocusListener(new FocusHandler());
  
 
 jta=new JTextArea();
 jta.setLineWrap(true);
 btn1=new JButton("添加");
 btn2=new JButton("删除");
 btn3=new JButton("撤消");
 btn4=new JButton("退出");
 btn1.addActionListener(this);
 btn2.addActionListener(this);
 btn3.addActionListener(this);
 btn4.addActionListener(this);
 
 JPanel pl1=new JPanel();
 JPanel pl2=new JPanel();
 JPanel pl3=new JPanel();
 JPanel pl4=new JPanel();
 
 pl1.setLayout(new GridLayout(5,4,6,6));
 pl1.add(lb1);
 pl1.add(jtfd1);
 pl1.add(lb2);
 pl1.add(jtfd2);
 pl1.add(lb10);
 pl1.add(jtfd10);
 pl1.add(lb3);
 pl1.add(jtfd3);
 pl1.add(lb4);
 pl1.add(jcbx);
 pl1.add(lb5);
 pl1.add(jtfd5);
 pl1.add(lb6);
 pl1.add(jtfd6);
 pl1.add(lb7);
 pl1.add(jtfd7);
 pl1.add(lb8);
 pl1.add(jtfd8);
 pl1.add(lb9);
 pl1.add(jtfd9);
 
 
 
 GridBagLayout gridbag=new GridBagLayout();
 GridBagConstraints constraints=new GridBagConstraints();
 pl2.setLayout(gridbag);
 constraints.weightx=constraints.weighty=10.0;
 constraints.fill=constraints.BOTH;
 
 gridbag.setConstraints(lb11,constraints);
 constraints.weightx=1;
 constraints.gridwidth=1;
 pl2.add(lb11,constraints);
 gridbag.setConstraints(jta,constraints);
 constraints.weightx=9;
 constraints.gridheight=3;
 constraints.gridwidth=3;
 constraints.insets=new Insets(10,15,10,20);
 
 pl2.add(jta,constraints);
 
 GridBagLayout gridbag1=new GridBagLayout();
 GridBagConstraints constraints1=new GridBagConstraints();
 constraints1.weightx=1.0;
 constraints1.fill=constraints1.BOTH;
 pl3.setLayout(gridbag1);
 
 //gridbag1.setConstraints(pl1,constraints1);
 constraints1.weighty=0.8;
 constraints1.gridwidth=constraints1.REMAINDER;
 pl3.add(pl1,constraints1);
 
 //gridbag1.setConstraints(pl2,constraints1);
 constraints1.weighty=0.2;
 constraints1.gridheight=constraints.REMAINDER;
 pl3.add(pl2,constraints1);
 
 pl4.setLayout(new GridLayout(1,4,6,0));
 pl4.add(btn1);
 pl4.add(btn2);
 pl4.add(btn3);
 pl4.add(btn4);
 
 content.setLayout(new BorderLayout());
 content.add(pl3,BorderLayout.CENTER);
 content.add(pl4,BorderLayout.SOUTH);
 
 frame.setBounds(100,100,550,400);
 frame.setResizable(false);
 frame.setVisible(true);
 
 try
 {
 	
 	String sqlStr1,sqlStr2;
 	sqlStr1="insert into book (bookname,bannercode,kindnumber,kindname,"+
 	"positionnumber,publishingcompany,publishtime,putintime,price,"+
 	"state,introduction,author) values(?,?,?,?,?,?,?,?,?,'在架',?,?)";
 	sqlStr2="delete from book where bannercode=?";
 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 	con=DriverManager.getConnection("jdbc:odbc:library");
 	pstmt1=con.prepareStatement(sqlStr1);
 	pstmt2=con.prepareStatement(sqlStr2);
 	
 }
 catch(ClassNotFoundException e)
 {
 }
 catch(SQLException sqle)
 {
 }
 
 
}

class FocusHandler implements FocusListener
{ java.util.Date today=new java.util.Date();
  DateFormat format=DateFormat.getDateInstance();
  String formatted=format.format(today);
  
	
	public void focusGained(FocusEvent e)
	{Object obj=(JTextField)e.getSource();
	 if(obj==jtfd8)
	 {jtfd8.setText(formatted);
	 }
	 
	}
	public void focusLost(FocusEvent e)
	{
	}
}

 public void actionPerformed(ActionEvent e)
 {String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11;
  
  str1=jtfd1.getText().trim();
  str2=jtfd2.getText().trim();
  str3=jtfd3.getText().trim();
  str4=(String)jcbx.getSelectedItem();
  str5=jtfd5.getText().trim();
  str6=jtfd6.getText().trim();
  str7=jtfd7.getText().trim();
  str8=jtfd8.getText().trim();
  str9=jtfd9.getText().trim();
  str10=jtfd10.getText().trim();
  str11=jta.getText().trim();
  
  int result;

 try{	
  Object obj=(JButton)e.getSource();
  if(obj==btn1)
  {
   if(str1.equals("")|str2.equals("")|str3.equals("")|str4.equals("")|str5.equals(""))
   {JOptionPane.showMessageDialog(frame,"can't be null");
    return;
   }
   if(str6.equals("")|str7.equals("")|str8.equals("")|str9.equals("")|str10.equals(""))
   {JOptionPane.showMessageDialog(frame,"can't be null");
    return;
   }
   
   java.sql.Date today1,today2;
   BigDecimal money=new BigDecimal(str9);
   today1=java.sql.Date.valueOf(str7);
   today2=java.sql.Date.valueOf(str8);
   pstmt1.setString(1,str1);
   pstmt1.setString(2,str2);
   pstmt1.setString(3,str10);
   pstmt1.setString(4,str4);
   pstmt1.setString(5,str5);
   pstmt1.setString(6,str6);
   pstmt1.setDate(7,today1);
   pstmt1.setDate(8,today2);
   pstmt1.setBigDecimal(9,money);
 
   pstmt1.setString(10,str11);
   pstmt1.setString(11,str10);
   
   result=pstmt1.executeUpdate();
     
    if(result>0)
    {JOptionPane.showMessageDialog(frame,"add successfully!");
    }
  jtfd1.setText("");
  jtfd2.setText("");
  jtfd3.setText("");
  
  jtfd5.setText("");
  jtfd6.setText("");
  jtfd7.setText("");
  jtfd8.setText("");
  jtfd9.setText("");
  jtfd10.setText("");
  jta.setText("");
   
   }
  else if(obj==btn2)
  {if(str2.equals(""))
   {JOptionPane.showMessageDialog(frame,"bannercode can't be null");
    return;
   }
   
    pstmt2.setString(1,str2);
    result=pstmt2.executeUpdate();
    if(result>0)
    {JOptionPane.showMessageDialog(frame,"Delete successfully!");
    }
  
  }
  else if(obj==btn3)
  {jtfd1.setText("");
  jtfd2.setText("");
  jtfd3.setText("");
  
  jtfd5.setText("");
  jtfd6.setText("");
  jtfd7.setText("");
  jtfd8.setText("");
  jtfd9.setText("");
  jtfd10.setText("");
  jta.setText("");
   
  }
  else if(obj==btn4)
  {pstmt1.close();
   pstmt2.close();
   con.close();
   frame.dispose();
  }
  }
  catch(SQLException sqle)
  {System.err.println(sqle);
  }
 }
public static void main(String[]args)
{new Book();
}
	
}
