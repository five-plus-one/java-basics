package com.fiveplusone.b02threadmethod.threaddemo2;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("测试1");
        t2.setName("测试2");

        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}
