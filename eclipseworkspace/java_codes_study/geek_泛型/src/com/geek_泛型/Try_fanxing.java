package com.geek_·ºÐÍ;
class Person<T>
{
	private T x;
	public void setx(T x)
	{
		this.x=x;
	}
	public T talk()
	{
		return x;
	}
}
public class Try_fanxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person<String> tt = new Person<String>();
		tt.setx("fuck");
		String a= tt.talk();
		System.out.println(a);
	}

}
