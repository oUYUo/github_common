package com.syn;

public class Demo_Synchronized {
	/*
	 * 同步代码块
	 */
	public static void main(String[] args) {
		final Printer p = new Printer();
		new Thread(){
			public void run() {
				while (true) {
					p.print1();
				}
				
			}
		}.start();
		new Thread(){
			public void run() {
				while (true) {
					p.print2();
				}
				
			}
		}.start();
	}
}


class Printer {
	Integer demo = new Integer(1);
	public void print1() {
		synchronized (demo) {					//同步代码块，锁机制,锁对象可以是任意的
			System.out.print("1");
			System.out.print("2");
			System.out.print("3");
			System.out.print("\r\n");
		}
	
	}
	public void print2() {
		synchronized (demo) {
			System.out.print("a");
			System.out.print("b");
			System.out.print("c");
			System.out.print("\r\n");
		}
	}
	
}

class Demo{
	
}