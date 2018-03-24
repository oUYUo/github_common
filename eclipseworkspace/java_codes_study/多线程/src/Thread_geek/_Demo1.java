//线程与进程
//线程的实现
//线程的状态
//线程的常用方法
//线程的优先级
//线程的生命周期
//继承Thread类 必须重写run（）方法
//实现runnable接口
//
package Thread_geek;

public class _Demo1 {

	public static void main(String[] args) {
//		long nowTime = System.currentTimeMillis();
//		System.out.println(nowTime);
//		// TODO Auto-generated method stub
//		myThread t1 = new myThread("fuck");
//		myThread t2 = new myThread("u");
//		t1.start();
//		t2.start();
//		long stopTime = System.currentTimeMillis();
//		long x = stopTime - nowTime;
//		t1.stop();
//		t2.stop();
//		System.out.println(x);
		myRunable r1= new myRunable("a");
		Thread t1=new Thread(r1);
		t1.start();
		
	}

}
//getName()
//currentThread()
//isAlive()
//join()
//sleep()