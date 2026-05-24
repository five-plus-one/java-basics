package com.fiveplusone.homework09.task04;

public class ExpressSystem {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(printer,"分拣员A");
        Thread t2 = new Thread(printer,"分拣员B");

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
            System.out.println("所有包裹编号打印完成");
        }catch(InterruptedException e){
            System.out.println("出现错误：" + e.getMessage());
        }
    }
}


class Printer implements Runnable{
    private static int currentnum = 0;
    private final int maxnum = 10;

    @Override
    public void run(){
        while (true){
            synchronized (this){
                if(currentnum == maxnum){
                    notifyAll();
                    break;
                }else{
                    currentnum++;
                    System.out.println(Thread.currentThread().getName() + " 打印编号： " + currentnum);
                    notify();
                    try{
                        wait();
                    }catch (InterruptedException e){
                        System.out.println("出现错误：" + e.getMessage());
                    }
                }
            }
        }
    }
}