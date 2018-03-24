/*
1，TextArea类是文本区（多行文本），继承了TextComponent类。
2，TextArea类方法：
	1，构造方法：rows - 行数、 columns - 列数
		1.1，构造指定行列文本区：TextArea(int rows, int columns)
		1.2，构造指定文本文本区：TextArea(String text)
		1.3，构造指定行列文本文本区：TextArea(String text, int rows, int columns)

	2，设置文本内容：void setText(String t)	【TextComponent】

	3，添加文本内容：void append(String str)

	4，取文本内容：String getText() 【TextComponent】
*/

import java.awt.*;
import java.awt.event.*;

class TextAreaDome
{
	private Frame fra;
	private Button but;
	private TextArea ta;

	TextAreaDome()
	{
		fra = new Frame( "TextAreaDome");
		but = new Button( "Text");
		ta = new TextArea( 30, 90);

		init();
	}

	private void init()	//设置属性
	{
		fra.setBounds( 300, 200, 700, 600);
		fra.setLayout( new FlowLayout());
		fra.add( but);
		fra.add( ta);

		myEvent();

		fra.setVisible(true);
	}

	private void myEvent()//事件
	{
		but.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println( ta.getText());
			}
		});
	}

	public static void main(String[] args) 
	{
		new TextAreaDome();
	}
}