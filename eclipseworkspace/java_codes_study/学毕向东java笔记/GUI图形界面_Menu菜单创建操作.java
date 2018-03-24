/*
1��MenuBar -- �˵�����   Menu -- �˵� ��  MenuItem -- �˵���
2��������Ӳ˵������˵�������Ӳ˵����˵�������Ӳ˵��Ҳ����Ӳ˵���
3���̳й�ϵ��
	1��Menu �̳��� MenuItem
	2��MenuItem�̳��� MenuComponent
	3��MenuBar �̳��� MenuComponent
	4��MenuComponent����˵���صĳ��������ֱ࣬�Ӽ̳�obj


--------------------------------- MenuBar �˵��� ----------------------------------------------------

1��MenuBar �˵���������
	1������һ���˵�����MenuBar()

	2�����ָ���˵���Menu add(Menu m)
	   ����ֵ�������ؽ��ܡ���������ӵĲ˵�

	3���Ƴ��˵������void remove(MenuComponent m) 


--------------------------------- Menu �˵� ---------------------------------------------------

1��Menu �˵�������
	1������ձ�ǩ�˵���Menu()

	2��������б�ǩ�˵���Menu(String label) 

	3�����ָ���˵���˵��MenuItem add( mi)
	   ������MenuItem�� Menu�̳У����Լ�����Ӳ˵���ֿ���Ӳ˵���
	   ����ֵ�����ɲ��ؽ��ܡ���������ӵĲ˵���

	4����ӱ�ǩ���˵��public void add(String label)
	   ��⣺ָ���ָ�����

	5����ӷָ��ߵ���ǰλ�ã�void addSeparator()

	6��ָ��λ�ò���ָ��ߣ�void insertSeparator(int index) 

	7���Ƴ��˵��������void remove(MenuComponent item) 


-------------------------------- MenuItem�˵��� --------------------------------------------------

1��MenuItem �˵������
	1������ձ�ǩ�˵��MenuItem()

	2������ָ����ǩ�˵��MenuItem(String label)

	3������ָ����ǩ�ͼ��̿�ݼ��˵��MenuItem(String label, MenuShortcut s) 
	   ������MenuShortcut s -- ��鿴 ��MenuShortcut ��������������һ�㡣

	4����Ӷ�����������void addActionListener(ActionListener l)  
	   ������ActionListener -- �ӿڣ�ֻ��һ�����������临д���ɡ�

	5�������Ƿ��ѡ�в˵��void setEnabled(boolean b)

	6������Ƿ������˲˵�� boolean isEnabled() 


-------------------------------- MenuShortcut ��ݼ� ---------------------------------------------------

1��MenuShortcut ��ݼ�������
	1������ָ�������룺MenuShortcut(int key)

	2������ָ�������룬���Ƿ����� SHIFT ��ϼ���MenuShortcut(int key, boolean useShiftModifier) 

2��������ʾ����MenuShortcut ms = new MenuShortcut(KeyEvent.VK_A, false); 

3������SHIFT�Ƿ���������ϼ��� CTRL��������ã���ô����������ϼ���

*/
import java.awt.*;
import java.awt.event.*;
class MenuDome
{
	private Frame fra;
	private MenuBar mb;
	private Menu m, m2;
	private MenuItem mi, mi2;

	MenuDome()
	{
		fra = new Frame( "MenuDome");
		mb = new MenuBar();
		m = new Menu( "�˵�");
		mi = new MenuItem( "(�˳�)�˵���",  new MenuShortcut(KeyEvent.VK_A, false));

		m2 = new Menu( "�Ӳ˵�");
		mi2 = new MenuItem( "�Ӳ˵���");

		init();
	}

	private void init()
	{
		//���ò˵���ϵ
		mb.add( m);
		m.add( mi);
		m.add( m2);
		m2.add( mi2);

		//���ô���
		fra.setBounds( 400, 300, 500, 400);
		fra.setMenuBar( mb);

		myEvent();

		fra.setVisible( true);
	}

	private void myEvent()
	{
		mi.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}); 
	}

	public static void main(String[] args) 
	{
		new MenuDome();
	}
}