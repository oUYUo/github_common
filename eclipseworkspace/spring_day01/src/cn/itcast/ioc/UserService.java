package cn.itcast.ioc;

public class UserService {
	//1.定义dao类型属性
	private UserDao userDao;
	//2.生成set方法
	public void add(){
		System.out.println("service-------");
		//在service里面得到dao类对象，才能调用dao里面的方法
//		dao.add();
//		UserDao dao = new UserDao();
		userDao.add();
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
