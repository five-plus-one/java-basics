package com.fiveplusone.b02threadmethod.threaddemo1;

public class ThreadDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr,"test1");
        Thread t2 = new Thread(mr,"test2");

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(Thread.currentThread().getPriority());

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }
}
