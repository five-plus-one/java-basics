package com.fiveplusone.homework09.task03;

public class TicketSellerSystem {
    public static void main(String[] args) {
        TicketSeller ts1 = new TicketSeller("窗口A");
        TicketSeller ts2 = new TicketSeller("窗口B");
        TicketSeller ts3 = new TicketSeller("窗口C");

        Thread t1 = new Thread(ts1);
        Thread t2 = new Thread(ts2);
        Thread t3 = new Thread(ts3);

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();t2.join();t3.join();
            System.out.println("所有电影票已售完");
        }catch (InterruptedException e){
            System.out.println("出现错误：" + e.getMessage());

        }
    }
}

class TicketSeller implements Runnable{
    private String SellerName;
    private static int tickets = 20;

    TicketSeller(String SellerName){
        this.SellerName = SellerName;
    }
    @Override
    public void run(){
        while(true){
            synchronized (TicketSeller.class){
                if(tickets > 0){
                    System.out.println(SellerName +" 卖出了第 " + tickets + " 张票");
                    try{
                        Thread.sleep((int)(Math.random()* 1000));
                        tickets--;
                    }catch (InterruptedException e){
                        System.out.println("出现异常");
                    }
                }else {
                    break;
                }
            }
        }
    }
}
