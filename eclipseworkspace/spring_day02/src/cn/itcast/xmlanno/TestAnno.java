package cn.itcast.xmlanno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {

	@Test
	public void testSevice(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		BookService bookService = (BookService) context.getBean("bookService");
		bookService.add();
	}
}
