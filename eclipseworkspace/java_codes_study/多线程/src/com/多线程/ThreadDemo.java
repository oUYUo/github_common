package com.多线程;

/**
 * Created by lenovo on 2017/5/16.
 */
public class ThreadDemo {
    public static void main(String[] args){
        TestThread t =new TestThread();
        new Thread(t).setName("f").start();
        new Thread(t).setName("u").start();
        new Thread(t).setName("c").start();
        new Thread(t).setName("k").start();
    }
}
class TestThread implements Runn
{
    private int tickets = 20;
    public void run()
    {
        while(true)
        {
            if (tickets>0)
            {
                System.out.println(Thread.currentThread().getName()+"出售票"+tickets--);
            }
        }
    }
}