package JOptionPane;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import 窗口.FiveChessFrame;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiveChessFrame ff = new FiveChessFrame();
		JOptionPane.showMessageDialog(ff, "我的信息");
		int result = JOptionPane.showConfirmDialog(ff, "我的确认信息，要现在开始游戏吗");
		if (result ==0)
		{
			JOptionPane.showMessageDialog(ff, "游戏开始");
		}
		if(result ==1 )
		{
			JOptionPane.showMessageDialog(ff, "游戏结束");
		}
		if(result==2)
		{
			JOptionPane.showMessageDialog(ff, "请重新选择");
		}
		String username =JOptionPane.showInputDialog("请输入你的姓名");
		if(username !=null)
		{
			System.out.println(username);
			JOptionPane.showMessageDialog(ff,"输入的姓名为："+username);
		}else{
			JOptionPane.showMessageDialog(ff, "请重新输入你的姓名");
		}
	}

}
