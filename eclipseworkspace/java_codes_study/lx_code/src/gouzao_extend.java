/**
 * Created by lenovo on 2017/7/11.
 */
class grandpa{
    grandpa(){
        System.out.println("this is grandpa");
    }
    public void talk()
    {
        System.out.println("this is grandpa talk");
    }
}
public class gouzao_extend extends grandpa  {
//    gouzao_extend()
//    {
//        talk();
//        System.out.println("this is guozao");
//    }
//    public void talk()
//    {
//        System.out.println("this is guozao talk");
//    }
//    public void sing()
//    {
//        System.out.println("sing");
//    }
    public static void main(String[] args)
    {
        gouzao_extend ge = new gouzao_extend();
        System.out.println("this is main");
        grandpa gr = new grandpa();
        if(gr instanceof gouzao_extend)
        {
            gouzao_extend new_gr = new gouzao_extend();
            System.out.println("success");
        }
    }
}
