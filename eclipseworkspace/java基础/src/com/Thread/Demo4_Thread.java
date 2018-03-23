package com.Thread;

public class Demo4_Thread {
	public static void main(String[] args) {
		new Thread(){						//1.继承Thread类
			public void run() {				//2.重写run方法
											
				for(int i=0;i<1000;i++)		//3.将要执行的代码写在run方法中
				{
					System.out.println("aaaaaaaaaaaaa"); //4.开启线程
				}
				
			}
		}.start();
		
	
		new Thread(	new Runnable() {						//1.将runnable的子类对象传递给Thread的构造方法
			
			@Override
			public void run() {								//2.重写run方法
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++)		//3.将要执行的代码写在run方法中
				{
					System.out.println("bbbbbbbbbbb");
				}
			}
		}).start(); //4.开启线程
	}
}
