/*
1��Dialog �Ի����࣬�̳��� Window
2��Dialog�෽����
	1�����췽����Dialog(Frame owner, String title, boolean modal) 
	   ������owner -- ���������ڡ�title -- ���⡢modal -- �򿪶Ի���ʱ�������ڿɷ������

	2���Ƿ���ӣ�void setVisible(boolean b)

	3�����ñ��⣺void setTitle(String title)

	4����ȡ���⣺String getTitle()

	5�����ڿɷ������С��void setResizable(boolean resizable)
*/
import java.awt.*;
import java.awt.event.*;
class DiaLab
{
	private Frame fra;
	private Button but;

	DiaLab()
	{
		fra = new Frame( "DiaLab");
		but = new Button( "�����Ի���");

		init();
	}

	private void init()	//��������
	{
		fra.setBounds( 300, 200, 400, 600);
		fra.setLayout( new FlowLayout());
		fra.add( but);

		myEvent();

		fra.setVisible(true);
	}

	private void myEvent()
	{
		Dialog dia = new Dialog( fra, "��ʾ", true);
		Label lb = new Label( "��ӭ��ʹ�ñ�ǩ����");

		but.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dia.setLayout( new FlowLayout());
				dia.setBounds( 350, 400, 200, 110);
				dia.add( lb);
				dia.setVisible(true);
			}
		});
		
		dia.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dia.setVisible(false);
			}
		});
	}

	public static void main(String[] args) 
	{
		new DiaLab();
	}
}
