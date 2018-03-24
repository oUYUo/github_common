package FlowLayout;
import javax.swing.*;
import java.awt.*;
public class Panel1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Panel1 gui = new Panel1();
		gui.go();
	}
	public void go(){
		JFrame frame = new JFrame();
		JPanel panel =new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		JButton button = new JButton("click me ");
		Font bigFont=new Font("serif",Font.BOLD,28);
		button.setFont(bigFont);
		panel.add(button);
		
		JButton button2 = new JButton("click me ");
		Font bigFont2=new Font("serif",Font.BOLD,28);
		button2.setFont(bigFont2);
		panel.add(button2);
		
		
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
