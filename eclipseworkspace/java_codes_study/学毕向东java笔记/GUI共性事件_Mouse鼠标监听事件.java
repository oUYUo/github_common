/*
1，鼠标与键盘都属于共性事件，所以在 Component 超级类中。
2，Component 类鼠标监听方法：
	1，添加鼠标监听事件：void addMouseListener(MouseListener l) 
	   参数：MouseListener接口， MouseAdapter类以“空方法”实现了它。
	   调用方式：对象.addMouseListener( new MouseAdapter() { 需要什么事件就覆盖，详细请看《第三项》 })
	
	2，添加鼠标移动事件：void addMouseMotionListener(MouseMotionListener l) 
	   参数：MouseMotionListener接口，MouseMotionAdapter类以“空方法”实现了它。
	   调用方式：对象.addMouseMotionListener( new MouseMotionAdapter(){ 覆盖需要方法，详细请看《第五项》 })
	
	3，添加鼠标滚轮事件：void addMouseWheelListener(MouseWheelListener l) 
	   参数：MouseWheelListener接口，它只有一个方法，请参考《第六项》
	   调用方式：对象.addMouseWheelListener( new MouseWheelListener(){ 覆盖方法，请详细查看《第六项》 }) 

3，MouseListener 鼠标事件接口：java.awt.event.*;
	1，鼠标按键在组件上单击（按下并释放）时调用：void mouseClicked(MouseEvent e) 		  
	2，鼠标进入到组件上时调用：void mouseEntered(MouseEvent e) 		   
	3，鼠标离开组件时调用：void mouseExited(MouseEvent e) 		  
	4，鼠标按键在组件上按下时调用：void mousePressed(MouseEvent e) 	   
	5.鼠标按钮在组件上释放时调用：void mouseReleased(MouseEvent e) 

4，MouseAdapter类以“空方法”实现了MouseListener接口。MouseAdapter类鼠标事件空方法类特有事件：java.awt.event.*;
	1，鼠标按键在组件上按下并拖动时调用：void mouseDragged(MouseEvent e)         
	2，鼠标光标移动到组件上但无按键按下时调用：void mouseMoved(MouseEvent e) 
	3，鼠标滚轮旋转时调用：void mouseWheelMoved(MouseWheelEvent e) 

5，MouseMotionAdapter鼠标移动事件类以“空方法”实现了MouseMotionListener鼠标移动事件接口：java.awt.event.*;
	1，鼠标按键在组件上按下并拖动时调用：void mouseDragged(MouseEvent e) 
	2，鼠标光标移动到组件上但无按键按下时调用：void mouseMoved(MouseEvent e) 

6，MouseWheelListener接口，鼠标滚轮事件：java.awt.event.*;
	1，鼠标滚轮旋转时调用：void mouseWheelMoved(MouseWheelEvent e) 

7，MouseEvent类鼠标详细事件：java.awt.event.*;
	1，取鼠标单击次数：int getClickCount()  
	   调用方式：请参考下面 《双击示例》代码。
*/
import java.awt.*;
import java.awt.event.*;
class Mouse
{
	private Frame fra;
	private Button but;
	Mouse()
	{
		fra = new Frame( "测试窗口");
		but = new Button( "按钮");

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
		but.addMouseListener( new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				System.out.println( "鼠标进入到组件上时调用。");
			}

			public void mouseClicked(MouseEvent e)	// 双击示例
			{
				if( e.getClickCount() == 2)
				{
					System.out.println( "双击拉");
				}
			}
		});
	}

	public static void main(String[] args) 
	{
		new Mouse();
	}
}