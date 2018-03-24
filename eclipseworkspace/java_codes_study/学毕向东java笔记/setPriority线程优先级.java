/*
setPriority(int newPriority) 方法：在Thread类中。
作用：更改线程的优先级，也就是获取CPU执行机率。
说明：优先级共10级，1-10
参数：优先级，Thread类提供了优先级常量值。
		static int MAX_PRIORITY   线程可以具有的最高优先级。 10级
		static int MIN_PRIORITY   线程可以具有的最低优先级。  1级
		static int NORM_PRIORITY  分配给线程的默认优先级。    5级
使用方法：线程对象.setPriority( Thread.MAX_PRIORITY);	//将该线程优先级改为10级。CPU执行该线程机率最大。
查看方法：线程对象.toString();返回该线程的字符串表示形式，包括线程名称、优先级和线程组。
*/