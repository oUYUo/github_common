/*
1，MenuBar -- 菜单栏、   Menu -- 菜单 、  MenuItem -- 菜单项
2，窗口添加菜单栏；菜单栏中添加菜单；菜单即可添加菜单项，也可添加菜单。
3，继承关系：
	1，Menu 继承了 MenuItem
	2，MenuItem继承了 MenuComponent
	3，MenuBar 继承了 MenuComponent
	4，MenuComponent：与菜单相关的超级抽象类，直接继承obj


--------------------------------- MenuBar 菜单栏 ----------------------------------------------------

1，MenuBar 菜单栏方法：
	1，构造一个菜单栏：MenuBar()

	2，添加指定菜单：Menu add(Menu m)
	   返回值：【不必接受】返回已添加的菜单

	3，移除菜单组件：void remove(MenuComponent m) 


--------------------------------- Menu 菜单 ---------------------------------------------------

1，Menu 菜单方法：
	1，构造空标签菜单：Menu()

	2，构造具有标签菜单：Menu(String label) 

	3，添加指定菜单或菜单项：MenuItem add( mi)
	   参数：MenuItem被 Menu继承，所以即可添加菜单项，又可添加菜单。
	   返回值：【可不必接受】返回已添加的菜单项

	4，添加标签到菜单项：public void add(String label)
	   详解：指定分隔符。

	5，添加分隔线到当前位置：void addSeparator()

	6，指定位置插入分隔线：void insertSeparator(int index) 

	7，移除菜单项组件：void remove(MenuComponent item) 


-------------------------------- MenuItem菜单项 --------------------------------------------------

1，MenuItem 菜单项方法：
	1，构造空标签菜单项：MenuItem()

	2，构造指定标签菜单项：MenuItem(String label)

	3，构造指定标签和键盘快捷键菜单项：MenuItem(String label, MenuShortcut s) 
	   参数：MenuShortcut s -- 请查看 《MenuShortcut 方法》，就在下一层。

	4，添加动作监听器：void addActionListener(ActionListener l)  
	   参数：ActionListener -- 接口，只有一个方法，将其复写即可。

	5，设置是否可选中菜单项：void setEnabled(boolean b)

	6，检查是否启动了菜单项： boolean isEnabled() 


-------------------------------- MenuShortcut 快捷键 ---------------------------------------------------

1，MenuShortcut 快捷键方法：
	1，构造指定键代码：MenuShortcut(int key)

	2，构造指定键代码，并是否启动 SHIFT 组合键：MenuShortcut(int key, boolean useShiftModifier) 

2，键代码示例：MenuShortcut ms = new MenuShortcut(KeyEvent.VK_A, false); 

3，不管SHIFT是否启动，组合键是 CTRL，如果启用，那么就是三个组合键。

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
		m = new Menu( "菜单");
		mi = new MenuItem( "(退出)菜单项",  new MenuShortcut(KeyEvent.VK_A, false));

		m2 = new Menu( "子菜单");
		mi2 = new MenuItem( "子菜单项");

		init();
	}

	private void init()
	{
		//设置菜单关系
		mb.add( m);
		m.add( mi);
		m.add( m2);
		m2.add( mi2);

		//设置窗口
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