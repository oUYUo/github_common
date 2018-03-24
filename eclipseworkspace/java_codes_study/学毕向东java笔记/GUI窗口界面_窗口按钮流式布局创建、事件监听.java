/*
1，事件监听机制的特点：
	1，事件源：就是awt包或者swing包中的那些图形界面组件。
	2，事件：每一个事件源都有自己特有的对应事件和共性事件。
	3，监听器：将可以触发某一个事件的动作（不只一个动作）都已经封装到了监听器中。
	4，事件处理。

2，Window窗口类是Frame框架类的父类。
3，Frame基本方法演示：
	1，构造一个带有标题的窗体：Frame(String title)
	   调用方式：Frame frame = new Frame( "my awt");

	2，调整组件大小：void setSize( int width, int height)【window类方法】
	   参数：宽度为 width，高度为 height。
	   调用方式：对象.setSize( 500, 400);

	3，调整组件位置：void setLocation( int left, int top)【方法来源不明】
	   参数：left --- 左边， top ---顶边
	   调用方式：对象.setLocation(300,200);

	4，设置容器布局管理器：void setLayout(LayoutManager mgr)  【Container】
	   参数：LayoutManager是布局管理器接口 ---> FlowLayout 流式布局为示例
	   调用方式：对象.setLayout(new FlowLayout());

	5，添加组件至尾部：Component add(Component comp)  【Container】
	   调用方式：对象.add( new Button("我是一个按钮")); //添加了一个按钮。

	6，组件是否可视： void setVisible(boolean b)	 【window】
	   调用方式：对象.setVisible(true);  //为true可视，为false隐藏

	7，设置组件大小位置：void setBounds( int x, int y, int width, int height) 【Container】
	   参数：x -- 左边、y -- 顶边、width -- 宽度、height-- 高度

	8，添加窗口监听器：void addWindowListener(WindowListener l)  【window类方法】
	   参数：WindowListener类是接口类。WindowAdapter 类是抽象类，用“空方法”实现了WindowListener，方面于程序的覆盖。
	   调用方式：f.addWindowListener( new WindowAdapter()
				{
					//关闭窗口事件
					public void windowClosing(WindowEvent e)	
					{
						System.out.println("我关");
						System.exit(0);	//关闭该进程。
					}
					
					//激活窗口事件
					public void windowActivated(WindowEvent e)	
					{
						System.out.println("我活了。");

					}
					
					//启动窗口事件
					public void windowOpened(WindowEvent e)		
					{
						System.out.println("我被打开了,hahahhahah");
					}
				});

-------------------------------------------------------------------------------------
	
*/
import java.awt.*;
import java.awt.event.*;
class  AwtDemo
{
/*	创建图形化界面：
	1，创建frame窗体。
	2，对窗体进行基本设置。
		比如大小，位置，布局。
	3，定义组件。
	4，将组件通过窗体的add方法添加到窗体中。
	5，让窗体显示，通过setVisible(true)*/

	public static void main(String[] args) 
	{
		Frame f = new Frame("my awt");
		f.setSize(500,400);	//设置窗口长宽
		f.setLocation(300,200);//设置窗口位置
		f.setLayout(new FlowLayout());	//设置窗口布局


		Button b = new Button("我是一个按钮");	//新建按钮
		
		f.add(b);	//将按钮添加到窗体中。


		f.addWindowListener(new WindowAdapter()	//窗口监听事件
		{
			//关闭窗口事件
			public void windowClosing(WindowEvent e)
			{
				System.out.println("我关");
				System.exit(0);
			}

			//激活窗口事件
			public void windowActivated(WindowEvent e) 
			{
				System.out.println("我活了。");

			}
			
			//启动窗口事件
			public void windowOpened(WindowEvent e) 
			{
				System.out.println("我被打开了,hahahhahah");
			}

		});
		
		f.setVisible(true);	//窗口可视。
	}
}
/*
class MyWin implements WindowListener
{
	//覆盖7个方法。可以我只用到了关闭的动作。
	//其他动作都没有用到，可是却必须复写。

}

//因为WindowListener的子类WindowAdapter已经实现了WindowListener接口。
//并覆盖了其中的所有方法。那么我只要继承自Windowadapter覆盖我需要的方法即可。
class MyWin extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		//System.out.println("window closing---"+e.toString());
		System.exit(0);
	}
}

*/

//练习，定义一个窗体，在窗体中添加一个按钮具备关闭该窗体的功能。
