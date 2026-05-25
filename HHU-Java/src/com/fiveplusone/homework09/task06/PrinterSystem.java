package com.fiveplusone.homework09.task06;

public class PrinterSystem {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(()->{
            for(char ch = 'A';ch<= 'J';ch++){
                printer.printletter(ch,1);
            }
        },"线程1");
        Thread t2 = new Thread(()->{
            for(char ch = '0';ch<='9';ch++){
                printer.printletter(ch,2);
            }
        },"线程2");
        Thread t3 = new Thread(()->{
            for(char ch = 'a';ch<='j';ch++){
                printer.printletter(ch,3);
            }
        },"线程3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            System.out.println("打印完毕");
        }catch (InterruptedException e){
            System.out.println("出现异常：" +e.getMessage());
        }

    }
}

class Printer{
    private int status = 1; // 1-打印机1，2-打印机2，3-打印机3
    private final int MAXSTATUS = 3;
    private int currentstatus;

    public synchronized void printletter(char ch,int currentstatus){
        while (status!=currentstatus){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("出现异常" + e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + ch);
        status = currentstatus < MAXSTATUS ? currentstatus+1 : 1;
        notifyAll();
    }
}
