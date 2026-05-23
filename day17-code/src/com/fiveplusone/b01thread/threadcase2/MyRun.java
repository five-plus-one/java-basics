package com.fiveplusone.b01thread.threadcase2;

public class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //获取到线程对象
            String name = Thread.currentThread().getName();
            System.out.println(name +  "Hello,Thread!");
        }
    }
}
