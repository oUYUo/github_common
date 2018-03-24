package com.数据结构;

public class Test{
	long f(int n){
		if(n==1){
			return 1;
		}
		System.out.println(n);
		return f(n-1);
	}
}