package Demo_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SImpleGuiB implements ActionListener{
	JButton button;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SImpleGuiB gui = new SImpleGuiB();
		gui.go();
	}
	public void go()
	{
		JFrame frame = new JFrame();
		button = new JButton("click me");

		button.addActionListener(this);
		
		
		frame.getContentPane().add(BorderLayout.EAST, button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent event)
	{
		button.setText("i' ve been clicked!");
	}

}
