package cn.itcast.anno;

import org.springframework.stereotype.Component;

@Component(value="user")	//<bean id="user"	class=""/>
public class User {
	public void add()
	{
		System.out.println("add-----------");
	}
}
