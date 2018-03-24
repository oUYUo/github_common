package com.hlju.Tetris;
import java.awt.color.*;

import javax.management.timer.Timer;
import javax.swing.JPanel;
public class Tetris extends JPanel{
	private static final long serialVersionUID =-807909536278284335L;
	private static final int BlockSize =10;
	private static final int BlockWidth=16;
	private static final int BlockHeigh =26;
	private static final int TimeDelay =1000;
	
	private static final String[] AuthorInfo ={
			"³­Ï®ÈË:","zhuob"
	};
	private boolean[][] BlockMap=new boolean[BlockHeight][BlockHeight];
	
	private int Score =0;
	private boolean IsPause = false;
	static boolean[][] Shape = BlockV4.shape;
	
	private Point NowBlockPos;
	private boolean[][] NowBlockMap;
	private boolean[][] NextBlockMap;
	
	private int NextBlockState;
	private int NowBlockState;
	
	private Timer timer;
	
	public Tetris(){
		this.Initial();
		timer=new Timer(Tetris.TimeDelay,this.TimerListener);
		timer.start();
		this.addKeyListener(this.getKeyListeners());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
