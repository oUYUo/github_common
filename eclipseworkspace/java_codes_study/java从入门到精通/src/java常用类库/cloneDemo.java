package java常用类库;
class Employee implements Cloneable
{
	private String name;
	private int age;
	public Employee(String name,int age)
	{
		this.name =name;
		this.age = age;
	}
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	public String toString()
	{
		return "姓名："+this.name+"，年龄；"+this.age;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
}
public class cloneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("张三",21);
		Employee e2 = null;
		try{
			e2=(Employee)e1.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		e2.setName("李四");
		e2.setAge(30);
		System.out.println("两个对象的内存地址比较:"+(e1==e2));
		System.out.println(e1);
		System.out.println(e2);
	}

}
