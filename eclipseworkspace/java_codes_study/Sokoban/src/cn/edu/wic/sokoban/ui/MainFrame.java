package cn.edu.wic.sokoban.ui;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements KeyListener {

	private JLabel[][] sheeps = new JLabel[12][16];
	// 代表人物横向坐标
	private int wx;
	// 代表人物纵向坐标
	private int wy;

	private int num = 0;

	private int total = 3;
	// 全局变量名
	private JLabel lab_wolf;
	// 场景数据的模拟，使用二维数组模拟
	// 1代表障碍，0代表空地
	// 4代表箱子
	// 8代表目标
	// 12代表箱子在目标中
	private int[][] datas = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public MainFrame() {

		// 目标初始化
		targetInit();
		// 灰太狼人物初始化
		wolfInit();
		// 小羊人物初始化
		sheepInit();
		// 树木初始化
		treeInit();

		// 设置背景图片
		backgroundInit();// 主意这行代码要在setMainFrameUI的前面否者不会出现图片
		// 设置主窗体界面显示效果
		setMainFrameUI();

		// 添加键盘监听
		this.addKeyListener(this);
	}

	private void targetInit() {
		Icon i = new ImageIcon("target.png");

		JLabel lab_target1 = new JLabel(i);
		JLabel lab_target2 = new JLabel(i);
		JLabel lab_target3 = new JLabel(i);

		lab_target1.setBounds(700, 200, 50, 50);
		lab_target2.setBounds(700, 250, 50, 50);
		lab_target3.setBounds(700, 300, 50, 50);

		datas[4][14] = 8;
		datas[5][14] = 8;
		datas[6][14] = 8;

		this.add(lab_target1);
		this.add(lab_target2);
		this.add(lab_target3);

	}

	// 树木的初始化
	private void treeInit() {
		// 创建图片
		Icon ic = new ImageIcon("tree.png");

		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if (datas[i][j] == 1) {
					JLabel lab_tree = new JLabel(ic);
					lab_tree.setBounds(50 * j, 50 * i, 50, 50);
					this.add(lab_tree);
				}
			}
		}
	}

	// 制作羊
	private void sheepInit() {

		Icon i = new ImageIcon("sheep-no.png");
		JLabel lab_sheep1 = new JLabel(i);
		lab_sheep1.setBounds(300, 200, 50, 50);
		datas[4][6] = 4;

		JLabel lab_sheep2 = new JLabel(i);
		lab_sheep2.setBounds(300, 300, 50, 50);
		datas[6][6] = 4;

		JLabel lab_sheep3 = new JLabel(i);
		lab_sheep3.setBounds(300, 400, 50, 50);
		datas[8][6] = 4;
		
		sheeps[4][6] = lab_sheep1;
		sheeps[6][6] = lab_sheep2;
		sheeps[8][6] = lab_sheep3;

		// 添加到窗口中
		this.add(lab_sheep1);
		this.add(lab_sheep2);
		this.add(lab_sheep3);
	}

	// 推箱子人物初始化
	private void wolfInit() {
		// 人物初始位置
		wx = 4;
		wy = 5;

		// 使用一张图片模拟
		Icon i = new ImageIcon("wolf-zm.png");
		lab_wolf = new JLabel(i);
		lab_wolf.setBounds(50 * wx, 50 * wy, 50, 50);
		this.add(lab_wolf);

	}

	// 背景初始化
	private void backgroundInit() {
		// 创建一个图片
		Icon i = new ImageIcon("bg.png");
		// 使用JLable制作背景
		JLabel lab_bg = new JLabel(i);
		// 设置添加的组件位置
		lab_bg.setBounds(6, 6, 800, 600);
		// 添加到窗口里面
		this.add(lab_bg);
	}

	private void setMainFrameUI() {
		// 设置整个窗体的布局模式为自由布局
		this.setLayout(null);
		// 设置窗口的标题
		this.setTitle("推箱子游戏-制作者:涂志鹏");
		// 设置窗口不可以扩展
		this.setResizable(false);
		// 设置窗口的大小
		this.setSize(818, 640);
		// 设置窗口的位置
		// this.setLocation(110, 30);
		this.setLocationRelativeTo(null);
		// 设置默认关闭窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口可见
		this.setVisible(true);
	}

	private void victory() {
		if (num == total) {
			JOptionPane.showMessageDialog(MainFrame.this, "胜利啦!");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 松开按键时发生。
		// 38 ,40 , 37,39上下左右
		int code = e.getKeyCode();
		// 向上走
		if (code == 38) {

			if (datas[wy - 1][wx] == 0) {
				wy = wy - 1;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y - 50);
				Icon i = new ImageIcon("wolf-sm.png");
				lab_wolf.setIcon(i);
				return;
			}

			if (datas[wy - 1][wx] == 1) {
				return;
			}
			if (datas[wy - 1][wx] == 4 && datas[wy - 2][wx] == 1) {
				return;
			}
			if (datas[wy - 1][wx] == 4 && datas[wy - 2][wx] == 4) {
				return;
			}
			if (datas[wy - 1][wx] == 4 && datas[wy - 2][wx] == 12) {
				return;
			}
			if (datas[wy - 1][wx] == 12 && datas[wy - 2][wx] == 1) {
				return;
			}
			if (datas[wy - 1][wx] == 12 && datas[wy - 2][wx] == 4) {
				return;
			}
			if (datas[wy - 1][wx] == 12 && datas[wy - 2][wx] == 12) {
				return;
			}

			if (datas[wy - 1][wx] == 8) {
				wy = wy - 1;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y - 50);
				Icon i = new ImageIcon("wolf-sm.png");
				lab_wolf.setIcon(i);
				return;
			}

			if (datas[wy - 1][wx] == 4 && datas[wy - 2][wx] == 0) {
				datas[wy - 1][wx] = 0;
				datas[wy - 2][wx] = 4;
			}

			if (datas[wy - 1][wx] == 4 && datas[wy - 2][wx] == 8) {
				datas[wy - 1][wx] = 0;
				datas[wy - 2][wx] = 12;
				num++;
			}
			if (datas[wy - 1][wx] == 12 && datas[wy - 2][wx] == 0) {
				datas[wy - 1][wx] = 8;
				datas[wy - 2][wx] = 4;
				num--;
			}
			if (datas[wy - 1][wx] == 12 && datas[wy - 2][wx] == 8) {
				datas[wy - 1][wx] = 8;
				datas[wy - 2][wx] = 12;
			}
			sheeps[wy - 1][wx].setLocation( wx * 50,  wy * 50 - 100);
			sheeps[wy - 2][wx] = sheeps[wy - 1][wx];
			sheeps[wy - 1][wx] = null;
			wy = wy - 1;
			int x = (int) lab_wolf.getLocation().getX();
			int y = (int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x, y - 50);
			Icon i = new ImageIcon("wolf-sm.png");
			lab_wolf.setIcon(i);
			victory();
			return;

		}
		if (code == 40) {// 向下走

			if (datas[wy + 1][wx] == 0) {
				wy = wy + 1;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y + 50);
				Icon i = new ImageIcon("wolf-zm.png");
				lab_wolf.setIcon(i);
				return;
			}

			if (datas[wy + 1][wx] == 1) {
				return;
			}
			if (datas[wy + 1][wx] == 4 && datas[wy + 2][wx] == 1) {
				return;
			}
			if (datas[wy + 1][wx] == 4 && datas[wy + 2][wx] == 4) {
				return;
			}
			if (datas[wy + 1][wx] == 4 && datas[wy + 2][wx] == 12) {
				return;
			}
			if (datas[wy + 1][wx] == 12 && datas[wy + 2][wx] == 1) {
				return;
			}
			if (datas[wy + 1][wx] == 12 && datas[wy + 2][wx] == 4) {
				return;
			}
			if (datas[wy + 1][wx] == 12 && datas[wy + 2][wx] == 12) {
				return;
			}

			if (datas[wy + 1][wx] == 8) {
				wy = wy + 1;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x, y + 50);
				Icon i = new ImageIcon("wolf-zm.png");
				lab_wolf.setIcon(i);
				return;
			}

			if (datas[wy + 1][wx] == 4 && datas[wy + 2][wx] == 0) {
				datas[wy + 1][wx] = 0;
				datas[wy + 2][wx] = 4;
			}

			if (datas[wy + 1][wx] == 4 && datas[wy + 2][wx] == 8) {
				datas[wy + 1][wx] = 0;
				datas[wy + 2][wx] = 12;
				num++;
			}
			if (datas[wy + 1][wx] == 12 && datas[wy + 2][wx] == 0) {
				datas[wy + 1][wx] = 8;
				datas[wy + 2][wx] = 4;
				num--;
			}
			if (datas[wy + 1][wx] == 12 && datas[wy + 2][wx] == 8) {
				datas[wy + 1][wx] = 8;
				datas[wy + 2][wx] = 12;
			}
			sheeps[wy + 1][wx].setLocation( wx * 50,  wy * 50 + 100);
			sheeps[wy + 2][wx] = sheeps[wy + 1][wx];
			sheeps[wy + 1][wx] = null;
			wy = wy + 1;
			int x = (int) lab_wolf.getLocation().getX();
			int y = (int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x, y + 50);
			Icon i = new ImageIcon("wolf-zm.png");
			lab_wolf.setIcon(i);
			victory();
			return;

		}
		if (code == 37) {// 向左走

			if (datas[wy][wx - 1] == 0) {
				wx = wx - 1;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x - 50, y);
				Icon i = new ImageIcon("wolf-zb.png");
				lab_wolf.setIcon(i);
				return;
			}

			if (datas[wy][wx - 1] == 1) {
				return;
			}
			if (datas[wy][wx - 1] == 4 && datas[wy][wx - 2] == 1) {
				return;
			}
			if (datas[wy][wx - 1] == 4 && datas[wy][wx - 2] == 4) {
				return;
			}
			if (datas[wy][wx - 1] == 4 && datas[wy][wx - 2] == 12) {
				return;
			}
			if (datas[wy][wx - 1] == 12 && datas[wy][wx - 2] == 1) {
				return;
			}
			if (datas[wy][wx - 1] == 12 && datas[wy][wx - 2] == 4) {
				return;
			}
			if (datas[wy][wx - 1] == 12 && datas[wy][wx - 2] == 12) {
				return;
			}

			if (datas[wy][wx - 1] == 8) {
				wx = wx - 1;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x - 50, y);
				Icon i = new ImageIcon("wolf-zb.png");
				lab_wolf.setIcon(i);
				return;
			}

			if (datas[wy][wx - 1] == 4 && datas[wy][wx - 2] == 0) {
				datas[wy][wx - 1] = 0;
				datas[wy][wx - 2] = 4;
			}

			if (datas[wy][wx - 1] == 4 && datas[wy][wx - 2] == 8) {
				datas[wy][wx - 1] = 0;
				datas[wy][wx - 2] = 12;
				num++;
			}
			if (datas[wy][wx - 1] == 12 && datas[wy][wx - 2] == 0) {
				datas[wy][wx - 1] = 8;
				datas[wy][wx - 2] = 4;
				num--;
			}
			if (datas[wy][wx - 1] == 12 && datas[wy][wx - 2] == 8) {
				datas[wy][wx - 1] = 8;
				datas[wy][wx - 2] = 12;
			}
			sheeps[wy][wx - 1].setLocation( wx * 50 - 100,  wy * 50);
			sheeps[wy][wx - 2] = sheeps[wy][wx - 1];
			sheeps[wy][wx - 1] = null;
			wx = wx - 1;
			int x = (int) lab_wolf.getLocation().getX();
			int y = (int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x - 50, y);
			Icon i = new ImageIcon("wolf-zb.png");
			lab_wolf.setIcon(i);
			victory();
			return;

		}
		if (code == 39) {// 向右走

			// 让人物向右移动
			// 方向上第一位的坐标是 wy wx+1
			// 方向上第二位的坐标是 wy wx+2
			if (datas[wy][wx + 1] == 0) {
				wx = wx + 1;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x + 50, y);
				Icon i = new ImageIcon("wolf-ym.png");
				lab_wolf.setIcon(i);
				return;
			}

			// 1代表障碍，0代表空地
			// 4代表箱子
			// 8代表目标
			// 12代表箱子在目标中
			if (datas[wy][wx + 1] == 1) {
				return;
			}
			if (datas[wy][wx + 1] == 4 && datas[wy][wx + 2] == 1) {
				return;
			}
			if (datas[wy][wx + 1] == 4 && datas[wy][wx + 2] == 4) {
				return;
			}
			if (datas[wy][wx + 1] == 4 && datas[wy][wx + 2] == 12) {
				return;
			}
			if (datas[wy][wx + 1] == 12 && datas[wy][wx + 2] == 1) {
				return;
			}
			if (datas[wy][wx + 1] == 12 && datas[wy][wx + 2] == 4) {
				return;
			}
			if (datas[wy][wx + 1] == 12 && datas[wy][wx + 2] == 12) {
				return;
			}

			if (datas[wy][wx + 1] == 8) {
				wx = wx + 1;
				int x = (int) lab_wolf.getLocation().getX();
				int y = (int) lab_wolf.getLocation().getY();
				lab_wolf.setLocation(x + 50, y);
				Icon i = new ImageIcon("wolf-ym.png");
				lab_wolf.setIcon(i);
				return;
			}

			if (datas[wy][wx + 1] == 4 && datas[wy][wx + 2] == 0) {
				datas[wy][wx + 1] = 0;
				datas[wy][wx + 2] = 4;
			}

			if (datas[wy][wx + 1] == 4 && datas[wy][wx + 2] == 8) {
				datas[wy][wx + 1] = 0;
				datas[wy][wx + 2] = 12;
				num++;
			}
			if (datas[wy][wx + 1] == 12 && datas[wy][wx + 2] == 0) {
				datas[wy][wx + 1] = 8;
				datas[wy][wx + 2] = 4;
				num--;
			}
			if (datas[wy][wx + 1] == 12 && datas[wy][wx + 2] == 8) {
				datas[wy][wx + 1] = 8;
				datas[wy][wx + 2] = 12;
			}
			sheeps[wy][wx + 1].setLocation( wx * 50 + 100 , wy * 50);
			sheeps[wy][wx + 2] = sheeps[wy][wx + 1];
			sheeps[wy][wx + 1] = null;
			wx = wx + 1;
			int x = (int) lab_wolf.getLocation().getX();
			int y = (int) lab_wolf.getLocation().getY();
			lab_wolf.setLocation(x + 50, y);
			Icon i = new ImageIcon("wolf-ym.png");
			lab_wolf.setIcon(i);
			// 判断胜利
			victory();
			return;

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 敲击键盘，发生在按键按下后，按键放开前

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 按下按键时发生。
	}

}
