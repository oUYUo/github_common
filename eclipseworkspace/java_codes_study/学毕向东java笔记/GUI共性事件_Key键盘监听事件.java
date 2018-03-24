/*
1，鼠标与键盘都属于共性事件，所以在 Component 超级类中。
2，Component类键盘监听方法：
	1，添加键盘监听器：void addKeyListener(KeyListener l)
	   参数：KeyListener是个接口。 KeyAdapter以“空方法”实现了它。
	   调用方式：对象.addKeyListener( new KeyAdapter(){ 事件代码 }); 请参考 myEvent() 代码。

3，KeyListener是个接口。 KeyAdapter以“空方法”实现了它：
	1，按下某个键时调用此方法：void keyPressed(KeyEvent e)   
	2，释放某个键时调用此方法：void keyReleased(KeyEvent e)      
	3，键入某个键时调用此方法：void keyTyped(KeyEvent e)

4，KeyEvent类，键盘事件对象：
	1，取按键关联的字符：char getKeyChar() 
	2，取按键关联的整数：int getKeyCode() 
	3，通过整数取对应的键符：static String getKeyText(int keyCode) 
	   特殊：取的都是大写字符，如果是括号，会以文字表现形式。
	   调用方式：KeyEvent.getKeyText( e.getKeyCode());

5，InputEvent类是KeyEvent的父类，它也是键盘事件。
	1，判断按下Alt键：boolean isAltDown()
	2，判断按下Ctrl键：boolean isControlDown()
	3，判断按下Shift键：boolean isShiftDown()
	4，停止产生事件：void consume()	例：文本框不准输入字母。

*/
import java.awt.*;
import java.awt.event.*;
class KeyDome
{
	private Frame fra;
	private Button but;
	private TextField tf;

	KeyDome()
	{
		fra = new Frame( "测试窗口");
		but = new Button( "按钮");
		tf = new TextField( 20);	//单行文本长度为10

		init();
	}

	private void init()
	{		
		fra.setSize(500,400);	//设置窗口长宽
		fra.setLocation(300,200);//设置窗口位置
		fra.setLayout(new FlowLayout());	//设置窗口布局
		fra.add( but);
		fra.add( tf);

		myEvent();

		fra.setVisible(true);	//窗口可视。
	}

	private void myEvent()
	{
		but.addKeyListener( new KeyAdapter()	//按钮键盘事件
		{
			int x = 0;
			//按下某个键时调用此方法。
			public void keyPressed(KeyEvent e) 
			{
				if( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
					System.out.println( "hlloe"+x++);
			}
		});

		tf.addKeyListener( new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int code = e.getKeyCode();
				if( !( code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)
				{
					System.out.println( "consume");	//停止输入框输入改字符事件
					e.consume();
				}
			}
		});
	}

	public static void main(String[] args) 
	{
		new KeyDome();
	}
}