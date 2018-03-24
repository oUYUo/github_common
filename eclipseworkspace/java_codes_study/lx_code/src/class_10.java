/**
 * Created by lenovo on 2017/7/11.
 */
//貌似instanceof 后面只能加正确的类型，不然就会报错，这样的话这个还有什么作用//instanceof判断父类是不是子类的实例
//getname tostring object类的方法
    //final定义的成员变量不可改变，用final static 定义的成员变量即使不要new类也可以使用
    //final定义方法不能被overriding
    //final定义类在class前面加final，所有的方法都默认成为final方法，但是成员变量可是final和非final的

    //内部类
    //在类中使用内部类可以直接存取其所在类的私有成员变量
    //调用内部类，需要先实例化外部类，然后用实例化的外部类a.new 内部类

    //静态内部类
    //创建静态内部类的对象，不需要其外部类的对象
    //不能从其静态内部类的对象访问非静态外部类的对象

public class class_10 extends abstract_class_test {
    final static int PI =3;
    public final int num=100;
    class apple{
        int num;
        apple()
        {
            this.num=class_10.this.num;
        }
    }
    static class banana{
        int num;
        static class bananas{
            int num;
            bananas()
            {
                this.num=banana.this.num;
            }
        }


    }
    public static int add(int i,int j)
    {
        return(i+j);
    }
    public int talk_()
    {
        return 1;
    }
    @Override
    public void talk() {
        System.out.println("lao zi jiu bu talk");
    }

    @Override
    public void sing() {
        System.out.println("sing");
    }

    public static void main(String[] args)
    {

        class_10 c10 = new class_10();
        class_10.apple a =c10.new apple();
        System.out.println(a.num);

//        System.out.println(c10.PI);
        System.out.println(PI);
        c10.talk();
        System.out.println(add(1,2));
        System.out.println(c10.getClass().toString());
//        System.out.println(c10 instanceof Math);
//        if(c10 instanceof Math)
//        {
//            pass;
//        }
//        else
//        {
//            System.out.println("false");
//        }

    }

}
