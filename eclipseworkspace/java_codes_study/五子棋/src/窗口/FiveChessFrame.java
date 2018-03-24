package 窗口;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
public class FiveChessFrame extends JFrame implements MouseListener {
	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	int x = 0;
	int y = 0;
	int[][] allChess = new int[19][19];
	boolean isBlack= true;
	boolean canPlay = true;
	String message = "黑方先行";
	int maxTime=0;
	int blackTime=0;
	int whiteTime=0;
	
	String blackMessage="无限制";
	String whiteMeaaage="无限制";
	
	public FiveChessFrame() throws HeadlessException{
		this.setTitle("五子棋");
		this.setSize(500,500);
		this.setLocation((width-500)/2,(height-500)/2);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void mouseClicked(MouseEvent arg0){
		JOptionPane.showMessageDialog(this,"鼠标单击");
	}
	public void mouseEntered(MouseEvent arg0){
	//todo 自动生成方法存根
	}
	public void mouseExited(MouseEvent arg0){
		
	}
	public void mousePressed(MouseEvent arg0){
		
	}
	public void mouseReleased(MouseEvent arg0){
		
	}
}
