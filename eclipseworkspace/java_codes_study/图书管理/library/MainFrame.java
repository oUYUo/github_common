import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MainFrame implements ActionListener
{private  JMenuBar JMB;
 private  JMenu M1,M2,M3,M4,M5;
 private  JLabel Jlb;
 private  Toolkit tool;
 private  Dimension wndsize;
 private  JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;
 public   JMenuItem menuItem1,menuItem2,menuItem3,menuItem4,
 menuItem5,menuItem6,menuItem7,menuItem8,menuItem9,menuItem10,menuItem11,
 menuItem12,menuItem13,menuItem14,menuItem15,menuItem16,menuItem17;
 
	public MainFrame()
	{JFrame.setDefaultLookAndFeelDecorated(true);
	 JFrame frame=new JFrame();
	 frame.setTitle("主窗体");
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 Container content=frame.getContentPane();
	 content.setLayout(new BorderLayout());
	 tool=frame.getToolkit();
	 wndsize=tool.getScreenSize();
	 JMB=new JMenuBar();
	 M1=new JMenu("图书证管理");
	 M2=new JMenu("图书流通管理");
	 M3=new JMenu("统计查询");
	 M4=new JMenu("帮助");
	 M5=new JMenu("图书入库");
	 menuItem1=new JMenuItem("读者注册");
	 
	 menuItem2=new JMenuItem("图书证暂停");
	 menuItem3=new JMenuItem("挂失");
	 menuItem4=new JMenuItem("取消挂失");
	 menuItem5=new JMenuItem("注销管理");
	 M1.add(menuItem1);
	 M1.add(menuItem2);
	 M1.add(menuItem3);
	 M1.add(menuItem4);
	 M1.add(menuItem5);
	    
	 
	 menuItem6=new JMenuItem("读者借书");
	 menuItem7=new JMenuItem("还书");
	 menuItem8=new JMenuItem("图书预约");
	 menuItem15=new JMenuItem("续借");
	 M2.add(menuItem6);
	 M2.add(menuItem7);
	 M2.add(menuItem15);
	 M2.add(menuItem8);
	 
	 
	 menuItem9=new JMenuItem("图书查询");
	 menuItem10=new JMenuItem("读者查询");
	 menuItem11=new JMenuItem("借阅统计");
	 menuItem12=new JMenuItem("借阅查询");
	 menuItem13=new JMenuItem("罚款统计");
	 menuItem14=new JMenuItem("图书入库");
	 menuItem16=new JMenuItem("新书通报");
	 menuItem17=new JMenuItem("图书催还");
	 
	 M3.add(menuItem9);
	 M3.add(menuItem10);
	 M3.add(menuItem11);
	 M3.add(menuItem12);
	 M3.add(menuItem13);
	 M3.add(menuItem16);
	 M3.add(menuItem17);
	 
	 M5.add(menuItem14);
	 
	 menuItem1.addActionListener(this);
	 menuItem2.addActionListener(this);
	 menuItem3.addActionListener(this);
	 menuItem4.addActionListener(this);
	 menuItem5.addActionListener(this);
	 menuItem6.addActionListener(this);
	 menuItem7.addActionListener(this);
	 menuItem8.addActionListener(this);
	 menuItem9.addActionListener(this);
	 menuItem10.addActionListener(this);
	 menuItem11.addActionListener(this);
	 menuItem12.addActionListener(this);
	 menuItem13.addActionListener(this);
	 menuItem14.addActionListener(this);
	 menuItem15.addActionListener(this);
	 menuItem16.addActionListener(this);
	 menuItem17.addActionListener(this);
	 menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
	 ActionEvent.ALT_MASK));
	 menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
	 ActionEvent.ALT_MASK));
	 menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
	 ActionEvent.ALT_MASK));
	 menuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
	 ActionEvent.ALT_MASK));
	 menuItem6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
	 InputEvent.ALT_MASK));
	 menuItem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
	 InputEvent.ALT_MASK|InputEvent.CTRL_MASK));
	 menuItem9.setAccelerator(KeyStroke.getKeyStroke("control shift B"));
	 menuItem10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.ALT_MASK));
	 menuItem15.setAccelerator(KeyStroke.getKeyStroke('R'));
	 menuItem14.setAccelerator(KeyStroke.getKeyStroke('B'));
	 menuItem16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
	 InputEvent.ALT_MASK));
	 menuItem17.setAccelerator(KeyStroke.getKeyStroke("control alt C"));
	 menuItem12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,InputEvent.ALT_MASK));
	 
	 JMB.add(M5);
	 JMB.add(M1);
	 JMB.add(M2);
	 JMB.add(M3);
	 JMB.add(M4);
	 
	 
	
	 frame.setJMenuBar(JMB);
	 
	 
	 JToolBar JTB=new JToolBar();
	 btn1=new JButton("A");
	 btn1.setFont(new Font("楷体",Font.BOLD+Font.CENTER_BASELINE,16));
	 btn2=new JButton(new ImageIcon("images/register.gif"));
	 btn3=new JButton(new ImageIcon("images/new.gif"));
	 btn4=new JButton("C");
	 btn4.setFont(new Font("楷体",Font.BOLD+Font.CENTER_BASELINE,16));
	 btn5=new JButton(new ImageIcon("images/paste.gif"));
	 btn6=new JButton(new ImageIcon("images/right.gif"));
	 btn7=new JButton(new ImageIcon("images/middle.gif"));
	 btn8=new JButton(new ImageIcon("images/left.gif"));
	 btn9=new JButton(new ImageIcon("images/sound.gif"));
	 btn10=new JButton(new ImageIcon("images/underline.gif"));
	 
	 btn11=new JButton("L");
	 btn11.setFont(new Font("楷体",Font.BOLD+Font.CENTER_BASELINE,16));
	 btn1.setToolTipText("adfasdf");
	 btn1.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn2.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn3.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn4.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn5.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn6.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn7.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn8.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn9.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn10.setBorder(BorderFactory.createRaisedBevelBorder());
	 btn11.setBorder(BorderFactory.createRaisedBevelBorder());


	 JTB.add(btn1);
	 JTB.add(btn2);
	 JTB.add(btn3);
	 JTB.add(btn4);
	 JTB.add(btn5);
	 JTB.add(btn6);
	 JTB.add(btn7);
	 JTB.add(btn8);
	 JTB.add(btn9);
	 JTB.add(btn10);
	 JTB.add(btn11);
	
	 JTB.setBorder(BorderFactory.createLineBorder(Color.darkGray));
	 
	 Jlb=new JLabel(new ImageIcon("images/168.jpg"));
	 Jlb.setBorder(BorderFactory.createLoweredBevelBorder());
	 content.add(Jlb,BorderLayout.CENTER);
	 frame.setSize(wndsize);
	 content.add(JTB,BorderLayout.NORTH);
	 frame.setLocationRelativeTo(null);
	
	 frame.setVisible(true);
	 
	 
	}
	public void actionPerformed(ActionEvent e)
	{Object obj=e.getSource();
	 if(obj==menuItem1)
	 {new TransactCard();
	 }
	 else if(obj==menuItem14)
	 {new Book();
	 }
	 else if(obj==menuItem3|obj==menuItem4|obj==menuItem5)
	 {new CardManagement();
	 }
	 else if(obj==menuItem6)
	 {new Borrow();
	 }
	 else if(obj==menuItem7)
	 {new Return();
	 }
	 else if(obj==menuItem9)
	 {new BookInfo();
	 }
	 else if(obj==menuItem10)
	 {new UserQuery();
	 }
	 else if(obj==menuItem15)
	 {new Renew();
	 }
	 else if(obj==menuItem16)
	 {new NewBookReport();
	 }
	 else if(obj==menuItem17)
	 {new CallUpReturn();
	 }
	 else if(obj==menuItem12)
	 {new BorrowQuery();
	 }
	 
	}
	public static void main(String[]args)
	{
		new MainFrame();
	}
}