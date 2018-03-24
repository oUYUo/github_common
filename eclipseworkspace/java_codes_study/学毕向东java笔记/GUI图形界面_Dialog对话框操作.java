/*
1，Dialog 对话框类，继承了 Window
2，Dialog类方法：
	1，构造方法：Dialog(Frame owner, String title, boolean modal) 
	   参数：owner -- 关联父窗口、title -- 标题、modal -- 打开对话框时，父窗口可否操作。

	2，是否可视：void setVisible(boolean b)

	3，设置标题：void setTitle(String title)

	4，获取标题：String getTitle()

	5，窗口可否调整大小：void setResizable(boolean resizable)
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
		but = new Button( "弹出对话框");

		init();
	}

	private void init()	//设置属性
	{
		fra.setBounds( 300, 200, 400, 600);
		fra.setLayout( new FlowLayout());
		fra.add( but);

		myEvent();

		fra.setVisible(true);
	}

	private void myEvent()
	{
		Dialog dia = new Dialog( fra, "提示", true);
		Label lb = new Label( "欢迎你使用标签功能");

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
