package com.fiveplusone.b03threadsafe.threadsafedemo3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{

    //表示共享ticket数据
    static int ticket = 0;
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
         while(true){
             lock.lock();
             try {
                 if(ticket < 100){
                     Thread.sleep(80);
                     ticket++;
                     System.out.println(getName() + "正在卖第" + ticket + "张票!");
                 }else{
                     break;
                 }
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             } finally {
                 lock.unlock();
             }
         }
     }
}
