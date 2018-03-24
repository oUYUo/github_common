/*
1，Button是一个创建按钮的类。
2，Button类继承了 Component类
3，Button类基本方法：
	1，构造带标签的按钮：Button(String label)
	   调用方式：Button but = new Button ( "按钮");

	2，添加按钮监听事件：void addActionListener(ActionListener l)
	   参数：ActionListener是接口，只有一个void actionPerformed(ActionEvent e)方法
	   调用方式：but.addActionListener( new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				});

	3，修改按钮标签：void setLabel(String label)
	   调用方式：but.setLabel( "按钮");

	4，获取按钮标签：String getLabel()
	   调用方式：String s = but.getLabel();

	5，添加动作侦听器：void addActionListener(ActionListener l) 
	   参数：ActionListener 接口只有一个方法：void actionPerformed(ActionEvent e) 
	   调用方式：but.addActionListener( new ActionListener(){  实现此接口方法 })
*/
import java.awt.*;
import java.awt.event.*;
class ButtonDome
{
	private Frame fra;
	private Button but;

	ButtonDome()
	{
		fra = new Frame("my awt");
		but = new Button ( "按钮");

		init();
	}

	private void init()
	{		
		fra.setSize(500,400);	//设置窗口长宽
		fra.setLocation(300,200);//设置窗口位置
		fra.setLayout(new FlowLayout());	//设置窗口布局
		fra.add( but);

		myEvent();

		fra.setVisible(true);	//窗口可视。
	}

	private void myEvent()
	{
		fra.addWindowListener( new WindowAdapter()
		{
					//关闭窗口事件
			public void windowClosing(WindowEvent e)	
			{
				System.out.println("窗体");
				System.exit(0);	//关闭该进程。
			}
		});

		but.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				System.out.println( "按钮干的");
				System.exit(0);
			}
		});	
	}

	public static void main(String[] args) 
	{
		new ButtonDome();
	}
}