/*
1��Button��һ��������ť���ࡣ
2��Button��̳��� Component��
3��Button�����������
	1���������ǩ�İ�ť��Button(String label)
	   ���÷�ʽ��Button but = new Button ( "��ť");

	2����Ӱ�ť�����¼���void addActionListener(ActionListener l)
	   ������ActionListener�ǽӿڣ�ֻ��һ��void actionPerformed(ActionEvent e)����
	   ���÷�ʽ��but.addActionListener( new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				});

	3���޸İ�ť��ǩ��void setLabel(String label)
	   ���÷�ʽ��but.setLabel( "��ť");

	4����ȡ��ť��ǩ��String getLabel()
	   ���÷�ʽ��String s = but.getLabel();

	5����Ӷ�����������void addActionListener(ActionListener l) 
	   ������ActionListener �ӿ�ֻ��һ��������void actionPerformed(ActionEvent e) 
	   ���÷�ʽ��but.addActionListener( new ActionListener(){  ʵ�ִ˽ӿڷ��� })
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
		but = new Button ( "��ť");

		init();
	}

	private void init()
	{		
		fra.setSize(500,400);	//���ô��ڳ���
		fra.setLocation(300,200);//���ô���λ��
		fra.setLayout(new FlowLayout());	//���ô��ڲ���
		fra.add( but);

		myEvent();

		fra.setVisible(true);	//���ڿ��ӡ�
	}

	private void myEvent()
	{
		fra.addWindowListener( new WindowAdapter()
		{
					//�رմ����¼�
			public void windowClosing(WindowEvent e)	
			{
				System.out.println("����");
				System.exit(0);	//�رոý��̡�
			}
		});

		but.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				System.out.println( "��ť�ɵ�");
				System.exit(0);
			}
		});	
	}

	public static void main(String[] args) 
	{
		new ButtonDome();
	}
}