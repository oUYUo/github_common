/*
import java.util.Date类;
Date类方法基本过时，被Calendar抽象类取代，部分方法演示：
	1，构造方法，对象返回看不懂时间字段：Date()
	   调用方式：Date d = new Date();

----------------------------------------------------------

import java.text.SimpleDateFormat类;
y  年				M  年中的月份		w  年中的周数				W  月份中的周数				D  年中的天数						d  月份中的天数
F  月份中的星期		E  星期中的天数		H  一天中的小时数（0-23）	k  一天中的小时数（1-24）	K  am/pm 中的小时数（0-11）			h  am/pm 中的小时数（1-12）		
m  小时中的分钟数	s  分钟中的秒数		S  毫秒数

SimpleDateFormat基本方法：
	1，日期模式构造函数：SimpleDateFormat(String pattern)
	   参数："yyyy年MM月dd日" 根据上面提供的表来描述日期格式。当需要取什么，我们就描述什么，例："yyyy年"，那么这个只返回年。
	   调用方式：SimpleDateFormat sf = new SimpleDateFormat( "yyyy年MM月dd日");
	
	2，格式化日期时间：StringBuffer format(Date date) 
	   参数：使用构造方法设置好日期格式，再传递 Date所返回的时间，Date将传递到参数里。
	   调用方式：String sb = 对象.format( data对象);

--------------------------------------------------------------------------------------------------
import java.util.Calendar类
Calendar抽象类日期字段表：YEAR年   MONTH月   DAY_OF_MONTH日   DAY_OF_WEEK星期   HOUR_OF_DAY小时   MINUTE分钟   MILLISECOND毫秒
1，计算机月份是从0月份开始的，0月也就是1月。
2，计算机星期是：星期日是星期一。
Calendar抽象类中方法：
    1，使用默认时区和语言环境获得一个日历：static Calendar getInstance()
	   作用：相当于创建日期对象。
	   调用方式：Calendar c = Calendar.getInstance();

	2，获取定日历字段的值：int get(int field)
	   调用方式：对象.get( Calendar.YEAR);  //获取了年。
	   解析：字段是静态的，通过类名调用。getInstance()方法创建一个日历，通过日历查找年份。

	3，设置年月日：void set(int year, int month, int date) 
	   调用方式：对象.set( 年, 月, 日);

	4，添加或减去指定的时间量：abstract void add(int field, int amount)
	   参数：field（日期字段），amount（偏移量）。
	   调用方式：对象.( Calendar.YEAR, -4); //将当前年数减去4年。

-------------------------------------------------------------------------------------------------

小练习：
1，获取任意年的2月有多少天。
2，获取昨天的现在时刻。

*/
import java.util.*;
class java
{
	public static void main(String args[])
	{
		Calendar c = Calendar.getInstance();
		//System.out.println(nian(c,2014));
		//System.out.println(shi(c));
	}

	static int nian(Calendar c, int n)
	{
		c.set( n, 2, 1); //某一年的3月1日   计算机从0月开始， 2月也就是3月
		c.add( Calendar.DAY_OF_MONTH, -1);  //将3月1日减1，那么就是2月的最后一天。

		return c.get( Calendar.DAY_OF_MONTH);
	}

	static String shi(Calendar c)
	{
		c.add( Calendar.DAY_OF_MONTH, -1);
		return c.get( Calendar.DAY_OF_MONTH ) + "日" +
		c.get( Calendar.HOUR_OF_DAY ) + "时" + 
		c.get( Calendar.MINUTE) + "分" +
		c.get( Calendar.MILLISECOND)+ "毫";
	}
}