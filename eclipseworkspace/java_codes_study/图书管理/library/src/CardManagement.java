import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CardManagement
{ private static JTextField jtfd1,jtfd2,jtfd3;
  private static JButton btn1,btn2,btn3;
	
	public CardManagement()
	{JFrame.setDefaultLookAndFeelDecorated(true);
	 JFrame frame=new JFrame("借阅证管理");
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 Container content=frame.getContentPane();
	 JLabel lb1=new JLabel("借阅证号:");
	 JLabel lb2=new JLabel("按借阅证号:");
	 JLabel lb3=new JLabel("按有效期:");
	 jtfd1=new JTextField();
	 jtfd2=new JTextField();
	 jtfd3=new JTextField();
	 btn1=new JButton("");
	 btn2=new JButton("");
	 btn3=new JButton("");
	 JPanel pl1=new JPanel();
	 JPanel pl2=new JPanel();
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
	 gbc.gridwidth=5;
	 gbc.insets=new Insets(0,0,0,5);
	 gbl.setConstraints(jtfd1,gbc);
	 pl1.add(jtfd1);
	 
	 
	 gbc.insets=new Insets(0,0,0,5);
	 gbc.weightx=1.0;
	 gbc.gridheight=2;
	 gbc.gridwidth=2;
	 gbc.gridwidth=gbc.REMAINDER;
	 gbl.setConstraints(btn1,gbc);
	 pl1.add(btn1);
	 
	 GridBagLayout gbl2=new GridBagLayout();
	 GridBagConstraints gbc2=new GridBagConstraints();
	 gbc2.fill=GridBagConstraints.BOTH;
	 gbc2.weightx=gbc2.weighty=1.0;
	 pl2.setLayout(gbl2);
	 
	 
	 gbl2.setConstraints(lb2,gbc2);
	 
	 pl2.add(lb2);
	
	 gbc2.gridwidth=2;
	 gbc2.insets=new Insets(0,5,0,5);
	 gbc2.weightx=0.5;
	  gbl2.setConstraints(jtfd2,gbc2);
	 pl2.add(jtfd2);
	 
	 gbc2.gridwidth=gbc2.REMAINDER;
	 gbc2.insets=new Insets(0,0,0,5);
	 gbc2.weightx=0.2;
	 gbl2.setConstraints(btn2,gbc2);
	 pl2.add(btn2);
	 
	
	 
	 gbc2.insets=new Insets(5,0,0,0);
	 gbc2.gridwidth=1;
	 gbc2.weightx=0.3;
	 gbl2.setConstraints(lb3,gbc2);
	 pl2.add(lb3);
	 
	 gbc2.gridwidth=3;
	 gbc2.insets=new Insets(5,0,0,5);
	 gbc2.weightx=0.5;
	 gbl2.setConstraints(jtfd3,gbc2);
	 pl2.add(jtfd3);
	 
	 gbc2.gridwidth=gbc2.REMAINDER;
	 gbc2.insets=new Insets(5,0,0,5);
	 gbc2.weightx=0.2;
	 gbl2.setConstraints(btn3,gbc2);
	 pl2.add(btn3);
	 
	 
	 GridBagLayout gbl3=new GridBagLayout();
	 GridBagConstraints gbc3=new GridBagConstraints();
	 gbc3.fill=GridBagConstraints.BOTH;
	 gbc3.weightx=gbc3.weighty=1.0;
	 content.setLayout(gbl3);
	 
	 
	 gbl3.setConstraints(pl1,gbc3);
     
	 content.add(pl1);
	 
	 
	 
	 gbc3.gridx=0;
	
	 gbl3.setConstraints(pl2,gbc3);
	 content.add(pl2);
	/* content.setLayout(new GridLayout(2,1,10,10));
	 content.add(pl1);
	 content.add(pl2);*/
	 
	 frame.setBounds(100,100,400,400);
	 frame.setVisible(true);
	 
	 
	 
	}
	public static void main(String[]args)
	{
		new CardManagement();
	}
}