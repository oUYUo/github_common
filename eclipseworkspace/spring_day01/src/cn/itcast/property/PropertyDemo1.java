package cn.itcast.property;

public class PropertyDemo1 {
	private String username;

	public PropertyDemo1(String username) {
		this.username = username;
	}
	public void test1() {
		System.out.println("demo1---"+username);
	}
}
