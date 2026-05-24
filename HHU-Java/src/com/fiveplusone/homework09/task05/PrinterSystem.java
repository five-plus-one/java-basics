package com.fiveplusone.homework09.task05;

public class PrinterSystem {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(()->{
            for(int i=1;i<=10;i++){
                printer.printnum(i);
            }
        },"数字线程");
        Thread t2 = new Thread(()->{
            for(char ch = 'A';ch<= 'J';ch++){
                printer.printletter(ch);
            }
        },"字母线程");
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
            System.out.println("数字和字母交替打印完成");
        }catch (InterruptedException e){
            System.out.println("出现错误：" + e.getMessage());
        }
    }
}


class Printer{
    int status = 0; //0 数字，1字母

    public synchronized void printnum(int num){
        if(status == 1){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println("出现错误：" +e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + num);
        status = 1-status;
        notify();
    }

    public synchronized void printletter(char letter){
        if(status == 0){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("出现错误：" +e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + letter);
        status = 1-status;
        notify();
    }
}