package com.Thread;
class Demo{

	@Override
	protected void finalize()  {
		System.out.println("垃圾被清扫了");
	}
	
}
public class Demo1 {
	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			new Demo();
		}
		for (int i = 0; i <100000; i++) {
			System.out.println("我是主线程");
		}
		
	}
}
