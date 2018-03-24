/*
HashSet<E>��
1��HashSet���з�����Cloneable�ӿ��з���һ�¡�
2��HashSet�������ţ���ͨ����ϣֵ˳���ŵġ�
3��HashSet��������ظ�Ԫ�ء�
4�����Ԫ�ص�HashCodeֵ��ͬ���Ż��ж�equals�Ƿ�Ϊtrue��
5�����Ԫ�ص�hashcodeֵ��ͬ���������equals��
6����֤Ԫ��Ψһ����ͨ���ж�Ԫ�ص�hashCodeֵ�Ƿ���ͬ�������ͬ����������ж�Ԫ�ص�equals�������Ƿ�Ϊtrue��

HashSet�����б�
	1��boolean add(E e) 
       ����� set ����δ����ָ��Ԫ�أ������ָ��Ԫ�ء� 
	2��void clear() 
       �Ӵ� set ���Ƴ�����Ԫ�ء� 
	3��Object clone() 
       ���ش� HashSet ʵ����ǳ��������û�и�����ЩԪ�ر��� 
	4��boolean contains(Object o) 
       ����� set ����ָ��Ԫ�أ��򷵻� true�� 
	5��boolean isEmpty() 
       ����� set �������κ�Ԫ�أ��򷵻� true�� 
	6��Iterator<E> iterator() 
       ���ضԴ� set ��Ԫ�ؽ��е����ĵ������� 
	7��boolean remove(Object o) 
       ���ָ��Ԫ�ش����ڴ� set �У������Ƴ��� 
	8��int size() 
       ���ش� set �е�Ԫ�ص�������set ���������� 

-------------------------------------------------------------------------------------------------

HashSet��ϵ��Object�෽����  �洢ʱ�����Զ�����������������
	1���ж϶����Ƿ���ȣ�public boolean equals(Object obj);
	   ��ϵ����д�÷���������Լ���Ҫ�ıȽϷ�����

	2�����ظö���Ĺ�ϣֵ��public int hashCode();
	   ��ϵ����д�÷����������Լ������õĹ�ϣֵ����ôHashSet���÷���ʱ������������õĹ�ϣֵ���洢��
	   ��д��䣺return һ������;

*/
class HashSetTest 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		HashSet hs = new HashSet();

		hs.add(new Person("a1",11));
		hs.add(new Person("a2",12));
		hs.add(new Person("a3",13));

		Iterator it = hs.iterator();

		while(it.hasNext())
		{
			Person p = (Person)it.next();
			sop(p.getName()+"::"+p.getAge());
		}
	}
}
class Person
{
	public int hashCode() //**
	{
		return name.hashCode()+age*37;
	}

	public boolean equals(Object obj) //**
	{

		if(!(obj instanceof Person))
			return false;

		Person p = (Person)obj;

		return this.name.equals(p.name) && this.age == p.age;
	}

	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
}
