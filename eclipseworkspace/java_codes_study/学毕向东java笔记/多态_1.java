/*
多态概念：动物 D = new 猫();  ---> 猫是动物的一种，那么说动物也包括猫。
		  毕姥爷 B = new 毕老师();    --->  毕姥爷是毕老师的父亲，毕老师化妆成毕姥爷去讲课，但是毕老师只会讲java，那么都是讲课，但讲课内容不同。（向上转型）
		  回家后，毕老师朋友找毕老师看电影，毕姥爷却没有这个功能，那么毕老师就要卸妆，恢复身份，与朋友去看电影。（向下转型）
							向上转型： 毕姥爷 B = new 毕老师();
							向下转型： 毕老师 A = (毕老师)B;
			说明：多态自始自终都是子类对象在做着变化。
			instanceof

			

1，多态的体现
	父类引用指向子类对象。
	父类引用也可以接受子类对象。

2，多态的前提
	必须是类与类之间有关系，存在覆盖。要么继承，要么实现。

3，多态的好处
	多态的出现，大大提高了程序的扩展性。

4，多态的弊端
	提高了扩展性，但是只能使用父类引用访问父类中成员。

5，多态应用
*/

class 多态_1
{
	public static void main(String[] args) 
	{
		function( new Cat());	//Animal a = new Cat(); 类型提升，向上转型
		function( new Dog());
		//如果想要猫特有方法，强制将父类引用转成子类类型。向下转型
		
	}

	public static void  function( Animal a)
	{
		a.eat();
		//a.catchMouse();  错误，因为在动物类，未包含该方法，要想使用，必须向下转型
		//a instanceof Cat 判断a的引用是否为Cat，返回boolean类型。
		if (a instanceof Cat)
		{
			Cat b = (Cat)a;
			b.catchMouse();
		}
		else if (a instanceof Dog)
		{
			Dog b = (Dog)a;
			b.catchMouse();
		}


	}
}

abstract class Animal	//动物
{
	abstract void eat();
}

class Cat extends Animal	//猫
{
	void eat()
	{
		System.out.println("吃鱼");
	}

	void catchMouse()
	{
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal	//狗
{
	void eat()
	{
		System.out.println("吃骨头");
	}
	void kanjia()
	{
		System.out.println("看家");
	}
}