package cn.itcast.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")//value属性可以不写
public class UserService {
//	
//	//得到dao对象
//	//1定义dao类型属性
//	//在dao的属性上面使用注解，完成对象注解
//	
//	@Autowired	//自动装配
//	private UserDao userDao;
//	//使用注解方式时候不需要set方法
//	
	
	//name属性值写的是创建dao的value值
	@Resource(name="userDao")
	private UserDao userDao;
	
	
	public void add(){
		System.out.println("service....");
		userDao.add();
	}
}
