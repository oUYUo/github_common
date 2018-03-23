package cn.itcast.bean;

public class Bean2Factory {
	//静态方法，返回bean2的对象
	public static Bean2 getBean2(){
		return new Bean2();
	}
}
