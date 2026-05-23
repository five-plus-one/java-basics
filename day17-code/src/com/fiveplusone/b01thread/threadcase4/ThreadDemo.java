package com.fiveplusone.b01thread.threadcase4;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("test1");
        MyThread t2 = new MyThread("test2");

        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println(name);
        System.out.println("1111");
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("2222");




    }
}
