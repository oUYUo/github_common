package com.geek_泛型;

class Point<T>
{
	private T x;
	private T y;
	public String toString()
	{
		return "this is p";
	}
	public T getX()
	{
		return x;
	}
	public T getY()
	{
		return y;
	}
	public void setX(T x)
	{
		this.x=x;
	}
	public void setY(T y)
	{
		this.y = y;
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		Point<String> p = new Point<String>();
		p.setX("精度为十");
		System.out.println(p.getX());
		System.out.println(p);
		System.out.println(p.toString());
	}
}
