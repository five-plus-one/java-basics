package com.fiveplusone.b04waitandnotify;

public class Foodie extends Thread{
    @Override
    public void run(){
        while(true){
            synchronized (Desk.lock) {
                if(Desk.count == 0){
                    break;
                }else{
                    //先判断桌子上是否有面条,如果没有，等待，如果有，开吃，吃完以后，唤醒厨师继续做，吃的总数-1，修改桌子的状态
                    if(Desk.foodFlag == 0){
                        try {
                            Desk.lock.wait(); //让当前线程跟锁进行绑定
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        System.out.println("吃货在吃面条，还能再吃" + (Desk.count-1) + "碗");
                        Desk.lock.notifyAll();
                        Desk.count--;
                        Desk.foodFlag = 0;
                    }
                }
            }
        }
    }
}
