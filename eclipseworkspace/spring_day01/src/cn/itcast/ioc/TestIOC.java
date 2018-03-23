package cn.itcast.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.property.Person;

public class TestIOC {
	@Test
	public void testUser(){
		//1.加载spring配置文件，根据创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		//2.得到配置创建的对象
		Person user =(Person) context.getBean("person");
		System.out.println(user);		
		user.test1();
	}
}
