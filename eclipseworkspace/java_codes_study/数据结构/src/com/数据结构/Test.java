package com.���ݽṹ;

public class Test{
	long f(int n){
		if(n==1){
			return 1;
		}
		System.out.println(n);
		return f(n-1);
	}
}