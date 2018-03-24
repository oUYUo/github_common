package BoxLayout;

import javax.swing.*;
import java.awt.*;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 gui = new Demo1();
		gui.go();
	}
	public void go(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JButton button = new JButton("shock me");
		JButton buttontwo =new JButton("bliss");
		panel.add(buttontwo);
		panel.add(button);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
