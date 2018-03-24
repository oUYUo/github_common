import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class GameFrame {
	public static Image[] images = null;
	public static Toolkit tk = Toolkit.getDefaultToolkit();
	public static Map<String, Image> imgs = new HashMap<String, Image>();
	public static Image offScreenImage = null;
	public static final int Game_Weight = 500;
	public static final int Game_height = 500;

	static {

		// int i=JOptionPane.showConfirmDialog(null, "是否打印？","提示:",
		// JOptionPane.YES_NO_OPTION);
		images = new Image[] { tk.getImage(GameFrame.class.getClassLoader().getResource("images/frame.jpg")),
				tk.getImage(GameFrame.class.getClassLoader().getResource("images/00White.jpg")),
				tk.getImage(GameFrame.class.getClassLoader().getResource("images/01White.jpg")),
				tk.getImage(GameFrame.class.getClassLoader().getResource("images/00Black.jpg")),
				tk.getImage(GameFrame.class.getClassLoader().getResource("images/01Black.jpg")) };
		imgs.put("frame", images[0]);
		imgs.put("00White", images[1]);
		imgs.put("01White", images[2]);
		imgs.put("00Black", images[3]);
		imgs.put("01Black", images[4]);
	}

	public static void main(String[] args) {

		String[] possibleValues = { "双人模式", "单人执黑", "单人执白" };
		Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE,
				null, possibleValues, possibleValues[0]);
		Object choose = selectedValue;

		BlackWhiteChess bwc = new BlackWhiteChess();
		bwc.launch(choose);

	}

}

class BlackWhiteChess extends Frame {
	Font font1 = new Font("宋体", Font.BOLD, 40);
	public int testx = 0;
	public int testy = 0;
	public static int choose = 0;
	public boolean changpeople = false; // true代表下白棋子，false代表下黑棋

	public void launch(Object choose) {
		if (choose.equals("双人模式")) {
			this.choose = 0;
		} else if (choose.equals("单人执黑")) {
			this.choose = 1;
		} else if (choose.equals("单人执白")) {
			this.choose = 2;
		}
		Thread painttd = new Thread(new PaintThread());
		painttd.start();
		setLocation(200, 200);
		setSize(550, 550);
		setVisible(true);
		setTitle("BlackWhiteChess");
		new ChessBoard();
		init();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int last = 0;
				int max = 0;
				testx = e.getX();
				testy = e.getY();
				if (testx > 70 && testx < 450 && testy > 50 && testy < 450 && changpeople == true) {
					if (BlackWhiteChess.choose != 1) {
						for (int i = 0; i < 64; i++) {
							if (ChessBoard.cps.get(i).canpressed(1)) {
								if (max <= ChessBoard.cps.get(i).pressed(1)) {
									ChessBoard.cps.get(i).clear();
									max = ChessBoard.cps.get(i).pressed(1);
									last = i;
								}
								ChessBoard.cps.get(i).clear();
							}
						}
						if (max != 0) {
							int j = 1; // 表示要下白棋
							int i = (testx - 67) / 48 + (testy - 67) / 48 * 8;
							if (ChessBoard.cps.get(i).state == 0 && ChessBoard.cps.get(i).canpressed(j)) {
								ChessBoard.cps.get(i).pressed(j);
								ChessBoard.cps.get(i).state = 1;
								ChessBoard.cps.get(i).changeother();
								changpeople = !changpeople;
							}
						} else
							changpeople = !changpeople;
					} else {

						for (int i = 0; i < 64; i++) {

							if (ChessBoard.cps.get(i).canpressed(1)) {
								if (ChessBoard.cps.get(i).canpressed(1)) {
									if (max <= ChessBoard.cps.get(i).pressed(1)) {
										ChessBoard.cps.get(i).clear();
										max = ChessBoard.cps.get(i).pressed(1);
										last = i;
									}
									ChessBoard.cps.get(i).clear();
								}
							}
						}
						if (max != 0) {
							ChessBoard.cps.get(last).pressed(1);
							ChessBoard.cps.get(last).state = 1;
							ChessBoard.cps.get(last).changeother();
						}
						changpeople = !changpeople;
					}
				} else if (testx > 70 && testx < 450 && testy > 50 && testy < 450 && changpeople == false) {
					if (BlackWhiteChess.choose != 2) {
						for (int i = 0; i < 64; i++) {
							if (ChessBoard.cps.get(i).canpressed(2)) {
								if (max <= ChessBoard.cps.get(i).pressed(2)) {
									ChessBoard.cps.get(i).clear();
									max = ChessBoard.cps.get(i).pressed(2);
									last = i;
								}
								ChessBoard.cps.get(i).clear();
							}
						}
						if (max != 0) {
							int j = 2; // 表示要下黑棋
							int i = (testx - 67) / 48 + (testy - 67) / 48 * 8;
							if (ChessBoard.cps.get(i).state == 0 && ChessBoard.cps.get(i).canpressed(j)) {
								ChessBoard.cps.get(i).pressed(j);
								ChessBoard.cps.get(i).state = 2;
								ChessBoard.cps.get(i).changeother();
								changpeople = !changpeople;
							}
						} else
							changpeople = !changpeople;
					} else {
						for (int i = 0; i < 64; i++) {
							if (ChessBoard.cps.get(i).canpressed(2)) {
								if (max <= ChessBoard.cps.get(i).pressed(2)) {
									ChessBoard.cps.get(i).clear();
									max = ChessBoard.cps.get(i).pressed(2);
									last = i;
								}
								ChessBoard.cps.get(i).clear();
							}
						}
						if (max != 0) {
							System.out.println(max);
							ChessBoard.cps.get(last).pressed(2);
							ChessBoard.cps.get(last).state = 2;
							ChessBoard.cps.get(last).changeother();
						}

						changpeople = !changpeople;
					}

				}
			}

		});
	}

	@Override
	public void paint(Graphics g) {
		int whitecount = 0;
		int blackcount = 0;
		int max = 0;
		int last = 0;

		if (changpeople) {
			g.drawImage(GameFrame.imgs.get("00White"), 230, 490, null);
		} else {
			g.drawImage(GameFrame.imgs.get("00Black"), 230, 490, null);
		}

		g.drawImage(GameFrame.imgs.get("frame"), 50, 50, null);
		for (int i = 0; i < ChessBoard.cps.size(); i++)

			ChessBoard.cps.get(i).paint(g);
		
		for (int i = 0; i < 64; i++) {
			if (ChessBoard.cps.get(i).canpressed(2)) {
				if (max <= ChessBoard.cps.get(i).pressed(2)) {
					ChessBoard.cps.get(i).clear();
					max = ChessBoard.cps.get(i).pressed(2);
					last = i;
				}
				ChessBoard.cps.get(i).clear();
			}
		}
		for (int i = 0; i < 64; i++) {
			if (ChessBoard.cps.get(i).canpressed(1)) {
				if (max <= ChessBoard.cps.get(i).pressed(1)) {
					ChessBoard.cps.get(i).clear();
					max = ChessBoard.cps.get(i).pressed(1);
					last = i;
				}
				ChessBoard.cps.get(i).clear();
			}
		}
		// g.drawImage(GameFrame.imgs.get("frame"), 15, 30, null);
		for (int i = 0; i < 64; i++) {
			if (ChessBoard.cps.get(i).state == 1) {
				whitecount++;
			}
			if (ChessBoard.cps.get(i).state == 2) {
				blackcount++;
			}
		}
		if (blackcount + whitecount == 64) {
			g.setColor(Color.yellow);
			g.setFont(font1);
			if (blackcount > whitecount) {
				g.drawString(whitecount + "比" + blackcount +":黑方胜利!", 100, 200);
			}
			if (blackcount == whitecount) {
				g.drawString(whitecount + "比" + blackcount +":平局!", 100, 200);
			}
			if (blackcount < whitecount) {
				g.drawString(blackcount + "比" + whitecount +":白方胜利!", 100, 200);
			}
			
		}
		if (max == 0) {
			g.setColor(Color.yellow);
			g.setFont(font1);
			if (blackcount > whitecount) {
				g.drawString(whitecount + "比" + blackcount +":黑方胜利!", 100, 200);
			}
			if (blackcount == whitecount) {
				g.drawString(whitecount + "比" + blackcount +":平局!", 100, 200);
			}
			if (blackcount < whitecount) {
				g.drawString(blackcount + "比" + whitecount +":白方胜利!", 100, 200);
			}
			
		}
		// g.fillRect(testx, testy, 50, 50);
	}

	public void init() {
		ChessBoard.cps.get(27).state = 2;	
		ChessBoard.cps.get(28).state = 1;
		ChessBoard.cps.get(35).state = 1;
		ChessBoard.cps.get(36).state = 2;
	}

	/*
	 * @Override public void update(Graphics g) { if(GameFrame.offScreenImage ==
	 * null) { GameFrame.offScreenImage =
	 * this.createImage(GameFrame.Game_Weight, GameFrame.Game_height); }
	 * Graphics gOffScreen = GameFrame.offScreenImage.getGraphics();
	 * 
	 * paint(gOffScreen); g.drawImage(GameFrame.offScreenImage, 0, 0, null); }
	 */

	public class PaintThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}

}
