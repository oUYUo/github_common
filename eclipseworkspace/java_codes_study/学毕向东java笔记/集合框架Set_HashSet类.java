/*
HashSet<E>类
1，HashSet类中方法与Cloneable接口中方法一致。
2，HashSet是无序存放，是通过哈希值顺序存放的。
3，HashSet不会出现重复元素。
4，如果元素的HashCode值相同，才会判断equals是否为true。
5，如果元素的hashcode值不同，不会调用equals。
6，保证元素唯一性是通过判断元素的hashCode值是否相同。如果相同，还会继续判断元素的equals方法，是否为true。

HashSet方法列表：
	1，boolean add(E e) 
       如果此 set 中尚未包含指定元素，则添加指定元素。 
	2，void clear() 
       从此 set 中移除所有元素。 
	3，Object clone() 
       返回此 HashSet 实例的浅表副本：并没有复制这些元素本身。 
	4，boolean contains(Object o) 
       如果此 set 包含指定元素，则返回 true。 
	5，boolean isEmpty() 
       如果此 set 不包含任何元素，则返回 true。 
	6，Iterator<E> iterator() 
       返回对此 set 中元素进行迭代的迭代器。 
	7，boolean remove(Object o) 
       如果指定元素存在于此 set 中，则将其移除。 
	8，int size() 
       返回此 set 中的元素的数量（set 的容量）。 

-------------------------------------------------------------------------------------------------

HashSet关系的Object类方法：  存储时，会自动调用这两个方法。
	1，判断对象是否相等：public boolean equals(Object obj);
	   关系：复写该方法，设计自己需要的比较方法。

	2，返回该对象的哈希值：public int hashCode();
	   关系：复写该方法，返回自己所设置的哈希值，那么HashSet调用方法时，会根据你设置的哈希值来存储。
	   复写语句：return 一个整数;

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
