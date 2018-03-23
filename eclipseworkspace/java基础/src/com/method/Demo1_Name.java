package com.method;

public class Demo1_Name {
	public static void main(String[] args) {
//		demo1();
		new Thread(){
			public void run() {
				this.setName("张三");
				System.out.println(this.getName()+"-------------aaaaa");
				
			}
		}.start();
		new Thread(){
			public void run() {
				this.setName("李四");
				System.out.println(this.getName()+"-------------bbbb");
				
			}
		}.start();	
	}

	private static void demo1() {
		new Thread("A"){			//通过构造方法给name赋值
			public void run() {
				System.out.println(this.getName()+"aaaaaaaaaaaaa");
				
			}
		}.start();
		
		new Thread("B"){
			public void run() {
				System.out.println(this.getName()+"bbbbbbbbbbbbbb");
				
			}
		}.start();
	}
}
