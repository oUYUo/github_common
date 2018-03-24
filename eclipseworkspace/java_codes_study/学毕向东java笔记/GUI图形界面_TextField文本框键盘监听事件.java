/*
1，TextField类是单行文本框，它父类是TextComponent。
2，TextField类方法：
	1，构造一个单行文本框：TextField()
	2，构造指定列数单行文本框：TextField(int columns)
	3，构造指定内容单行文本框：TextField(String text)
	4，构造指定列数及内容单行文本框：TextField(String text, int columns)
	5，添加键盘监听器：void addKeyListener(KeyListener l) 【Component类】
	   参数：详细查看《GUI共性事件_Key键盘监听事件》
	   调用方式：tex.addKeyListener( new KeyAdapter() { 事件代码 });
*/
import java.awt.*;
import java.awt.event.*;
class TextFie
{
	private Frame fra;
	private TextField tex;
	TextFie()
	{
		fra = new Frame( "测试文本框");//创建窗口
		tex = new TextField( 20);//创建文本框

		init();
		myEvent();
	}

	private void init()	//设置属性
	{
		fra.setBounds( 400, 300, 500, 400);
		fra.setLayout( new FlowLayout());
		fra.add( tex);
		fra.setVisible(true);
	}

	private void myEvent()//事件
	{
		tex.addKeyListener( new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int code = e.getKeyCode();

				if( !( code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9))
					e.consume();
			}
		});
	}

	public static void main( String[] args)
	{
		new TextFie();
	}
}