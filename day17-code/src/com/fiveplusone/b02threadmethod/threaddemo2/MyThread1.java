package com.fiveplusone.b02threadmethod.threaddemo2;

public class MyThread1 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "@" + i);
        }
    }
}
