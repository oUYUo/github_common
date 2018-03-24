package Swing;
import java.awt.BorderLayout;

import javax.swing.*;
public class Demo_review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		
		JButton button = new JButton("click me");
		
		frame.getContentPane().add(BorderLayout.EAST, button);
		
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		panelB.add(new JButton("button 1"));
		panelB.add(new JButton("button 2"));
		panelB.add(new JButton("button 3"));
		panelA.add(panelB);
		
//		frame.getContentPane().add(BorderLayout.NORTH, panelB);
		frame.getContentPane().add(BorderLayout.SOUTH, panelA);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}

}
