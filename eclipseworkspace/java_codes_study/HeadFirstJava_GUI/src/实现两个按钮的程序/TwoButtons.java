package 实现两个按钮的程序;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MyDrawPanel extends JPanel{
	private int a=1;
	private int b=1;
	public void paintComponent(Graphics g){
		Graphics2D g2d =(Graphics2D) g;
		int red = (int)(Math.random()*255);
		int green =(int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		Color startColor = new Color(red,green,blue);
		
		red = (int)(Math.random()*255);
		green =(int)(Math.random()*255);
		blue = (int)(Math.random()*255);
		Color endColor = new Color(red,green,blue);
		
		
		GradientPaint gradient = new GradientPaint(70,70,startColor,150,150,endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(a, b, 100, 100);
		a+=1;
		b+=1;
	}
}


public class TwoButtons {
	JFrame frame;
	JLabel label;
	int i =1;
	int j=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoButtons gui = new TwoButtons();
		gui.go();
	}
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton labelButton = new JButton("change label");
		labelButton.addActionListener(new LabelListener());
		JButton colorButton = new JButton("change circle");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("i'm a label");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		
	}
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			label.setText("ouch"+i);
			i++;
		}
	}
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
//			for(int k=0;k<100;k++)
//			{
				frame.repaint();
				System.out.println("run"+j);
				j++;
//			}
			
		}
	}
}
