/*
1��TextArea�����ı����������ı������̳���TextComponent�ࡣ
2��TextArea�෽����
	1�����췽����rows - ������ columns - ����
		1.1������ָ�������ı�����TextArea(int rows, int columns)
		1.2������ָ���ı��ı�����TextArea(String text)
		1.3������ָ�������ı��ı�����TextArea(String text, int rows, int columns)

	2�������ı����ݣ�void setText(String t)	��TextComponent��

	3������ı����ݣ�void append(String str)

	4��ȡ�ı����ݣ�String getText() ��TextComponent��
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

	private void init()	//��������
	{
		fra.setBounds( 300, 200, 700, 600);
		fra.setLayout( new FlowLayout());
		fra.add( but);
		fra.add( ta);

		myEvent();

		fra.setVisible(true);
	}

	private void myEvent()//�¼�
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