/*
��̬������� D = new è();  ---> è�Ƕ����һ�֣���ô˵����Ҳ����è��
		  ����ү B = new ����ʦ();    --->  ����ү�Ǳ���ʦ�ĸ��ף�����ʦ��ױ�ɱ���үȥ���Σ����Ǳ���ʦֻ�ὲjava����ô���ǽ��Σ����������ݲ�ͬ��������ת�ͣ�
		  �ؼҺ󣬱���ʦ�����ұ���ʦ����Ӱ������үȴû��������ܣ���ô����ʦ��Ҫжױ���ָ���ݣ�������ȥ����Ӱ��������ת�ͣ�
							����ת�ͣ� ����ү B = new ����ʦ();
							����ת�ͣ� ����ʦ A = (����ʦ)B;
			˵������̬��ʼ���ն���������������ű仯��
			instanceof

			

1����̬������
	��������ָ���������
	��������Ҳ���Խ����������

2����̬��ǰ��
	������������֮���й�ϵ�����ڸ��ǡ�Ҫô�̳У�Ҫôʵ�֡�

3����̬�ĺô�
	��̬�ĳ��֣��������˳������չ�ԡ�

4����̬�ı׶�
	�������չ�ԣ�����ֻ��ʹ�ø������÷��ʸ����г�Ա��

5����̬Ӧ��
*/

class ��̬_1
{
	public static void main(String[] args) 
	{
		function( new Cat());	//Animal a = new Cat(); ��������������ת��
		function( new Dog());
		//�����Ҫè���з�����ǿ�ƽ���������ת���������͡�����ת��
		
	}

	public static void  function( Animal a)
	{
		a.eat();
		//a.catchMouse();  ������Ϊ�ڶ����࣬δ�����÷�����Ҫ��ʹ�ã���������ת��
		//a instanceof Cat �ж�a�������Ƿ�ΪCat������boolean���͡�
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

abstract class Animal	//����
{
	abstract void eat();
}

class Cat extends Animal	//è
{
	void eat()
	{
		System.out.println("����");
	}

	void catchMouse()
	{
		System.out.println("ץ����");
	}
}

class Dog extends Animal	//��
{
	void eat()
	{
		System.out.println("�Թ�ͷ");
	}
	void kanjia()
	{
		System.out.println("����");
	}
}