/**
 * Created by lenovo on 2017/7/11.
 */
//implement定义的变量都会变成常量，定义的方法必须是空方法，一个类可以继承多个接口，但只能继承一个抽象类
    //抽象类可以有非空方法
    //接口的方法必须要被重写
    //抽象类的abstract方法必须被重写
public class implements_test implements Interface_class_talk {
    @Override
    public void talk_() {
        System.out.println("talk");
    }


    public static void main(String[] args)
    {
        implements_test a = new implements_test();
        a.talk_();
        int b = a.num;
        System.out.println(a.num);
    }
}
