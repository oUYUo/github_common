import javax.swing.*;
import java.awt.*;
public class mainFrame extends JFrame {
	public mainFrame(String sTitle,int iWidth,int iHeight)
	{
		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon ii = new ImageIcom("");
		setTitle(sTitle);
		setIconImage(ii.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(iWidth,iHeight);
		int w = getSize().width;
		int h = getSize().height;
		System.out.println("hello");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
