package com.fiveplusone.b03threadsafe.threadsafedemo1;

public class MyThread extends Thread{

    //表示共享ticket数据
    static int ticket = 0;


    @Override
    public void run() {
         while(true){
             synchronized (MyThread.class){
                 if(ticket < 100){
                     try {
                         Thread.sleep(10);
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                     ticket++;
                     System.out.println(getName() + "正在卖第" + ticket + "张票!");
                 }else{
                     break;
                 }
             }
         }
     }
}
