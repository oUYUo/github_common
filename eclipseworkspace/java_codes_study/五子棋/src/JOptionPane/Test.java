package JOptionPane;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ����.FiveChessFrame;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiveChessFrame ff = new FiveChessFrame();
		JOptionPane.showMessageDialog(ff, "�ҵ���Ϣ");
		int result = JOptionPane.showConfirmDialog(ff, "�ҵ�ȷ����Ϣ��Ҫ���ڿ�ʼ��Ϸ��");
		if (result ==0)
		{
			JOptionPane.showMessageDialog(ff, "��Ϸ��ʼ");
		}
		if(result ==1 )
		{
			JOptionPane.showMessageDialog(ff, "��Ϸ����");
		}
		if(result==2)
		{
			JOptionPane.showMessageDialog(ff, "������ѡ��");
		}
		String username =JOptionPane.showInputDialog("�������������");
		if(username !=null)
		{
			System.out.println(username);
			JOptionPane.showMessageDialog(ff,"���������Ϊ��"+username);
		}else{
			JOptionPane.showMessageDialog(ff, "�����������������");
		}
	}

}
