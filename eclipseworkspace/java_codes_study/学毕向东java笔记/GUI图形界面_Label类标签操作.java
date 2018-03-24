/*
1，Label标签类，继承了Component
2，Label标签字段：
	2.1，指示标签文本应居中：static int CENTER 
    2.2，指示标签文本应左对齐：static int LEFT  
    2.3，指示标签文本应右对齐：static int RIGHT

3，Label标签类方法：
	1，构造空内容标签：Label()

	2，构造指定内容标签：Label(String text)

	3，构造指定内容、指定对齐方式标签：Label(String text, int alignment) 

	4，取标签文本：String getText();

	5，设置标签对齐方式：void setAlignment(int alignment) 

	6，设置标签文本：void setText(String text)
*/

import java.awt.*;
import java.awt.event.*;
class LabelDome
{
	public static void main(String[] args) 
	{
		Frame fra = new Frame( "测试标签");
		Label lab = new Label( "您好标签");

		fra.setLayout( new FlowLayout());
		fra.setBounds( 300, 200, 400, 400);
		fra.add( lab);
		fra.setVisible( true);
	}
}