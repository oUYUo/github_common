/**
 * Created by lenovo on 2017/7/11.
 */

import java.math.BigDecimal;

/**
bigDecimal和biginteger都能实现大数字的运算，不同的是bigdecimal加入了小数的概念。
一般的float型和double型数据只可以用来做科学计算或工程计算，但由于在商业计算中要求数字精度较高，
所以要用到java.math.BigDecimal类。
BigDecimal类支持任何精度的定点数，可以用他来精确计算货币值
*/
public class class_9
{
    static final int location =10;

    public BigDecimal add(double value1,double value2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.add(b2);
    }


    public static void main(String[] args)
    {
        class_9 a = new class_9();

        System.out.println(a.add(-7.5,8.9));
        double d1 = -7.5;
        double d2 = 8.9;
        System.out.println(d1+d2);
    }

}
