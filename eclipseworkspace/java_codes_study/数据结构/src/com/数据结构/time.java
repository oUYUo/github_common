package com.数据结构;

public class time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		int n=10000;
		int i;
		for(i=1;i<=n;i++){
			System.out.println(i+"\n");
		
		}
		long end = System.currentTimeMillis();
		long time=end-begin;
		System.out.println(time);
	}

}
