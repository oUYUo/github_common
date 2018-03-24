/*
interface  用于定义接口，当抽象类全是抽象方法，可以以接口的形式去体现。
1，接口常见定义：常量，抽象方法
2，接口中的成员都有固定修饰符：
		常量：public static final
		方法：public abstract
	
3，接口中成员都是public
4，接口不可创建对象，因为有抽象方法，需要被子类实现，子类必须将接口抽象方法覆盖。
5，接口之间存在多继承： interface A extends B,C


implements 实现接口，用于类实现接口
1，格式： class类名 implements 接口名;
2，接口支持多实现  ----> class类名 implements 接口名a, 接口名b;
3，一个类在继承一个类，还可以去实现多接口。

注意事项：接口与接口之间，方法名相同，返回值不同，则不允许继承。

*/