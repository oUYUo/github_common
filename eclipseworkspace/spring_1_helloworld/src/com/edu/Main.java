package com.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("hellobean.xml");
		HelloBean student;
		student=(HelloBean) act.getBean("stu1");
		System.out.println("姓名："+student.getName()+"课程名："+student.getCourse()+"成绩："+student.getScore());
		student=(HelloBean) act.getBean("stu2");
		System.out.println("姓名："+student.getName()+"课程名："+student.getCourse()+"成绩："+student.getScore());
		student=(HelloBean) act.getBean("stu3");
		System.out.println("姓名："+student.getName()+"课程名："+student.getCourse()+"成绩："+student.getScore());
		
	}
}
