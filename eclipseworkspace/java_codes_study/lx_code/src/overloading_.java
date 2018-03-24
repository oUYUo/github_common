/**
 * Created by lenovo on 2017/7/11.
 */
//overloading指的是一个方法带有不同的参数成为不同的方法
    //overriding 指的是重写父类方法
public class overloading_ {
    public void talk(String a)
    {
        System.out.println(a);
    }
    public void talk(String a ,String b)
    {
        System.out.println(a);
        System.out.println(b);
    }
    public static void main(String[] args)
    {
        overloading_ a = new overloading_();
        a.talk("hhh");
        a.talk("hhh","www");

    }
}
