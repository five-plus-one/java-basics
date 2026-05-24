package com.fiveplusone.homework09.task02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class BankInterestSystem{
    public static void main(String[] args) {
        InterestCalculator calcA = new InterestCalculator("账号A",10000,0.03,5);
        InterestCalculator calcB = new InterestCalculator("账号B",20000,0.025,3);

        FutureTask<Double> futureA = new FutureTask<>(calcA);
        FutureTask<Double> futureB = new FutureTask<>(calcB);

        Thread t1 = new Thread(futureA,"账户A计算线程");
        Thread t2 = new Thread(futureB,"账户B计算线程");

        t1.start();
        t2.start();

        try {
            double resultA = futureA.get();
            double resultB = futureB.get();

            System.out.println("账户A 到期总额：" + resultA);
            System.out.println("账户B 到期总额：" + resultB);

            System.out.println("全部账户利息计算完成");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("计算过程中发生异常：" + e.getMessage());
        }
    }
}



class InterestCalculator implements Callable<Double> {
    private String accountName;
    private double principal;
    private double rate;
    private int years;

    public InterestCalculator(String acoountName,double principal,double rate,int years){
        this.accountName = acoountName;
        this.principal = principal;
        this.rate = rate;
        this.years = years;
    }

    @Override
    public Double call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ":开始计算");

        Thread.sleep(500); //模拟计算耗时

        return principal + principal *rate * years;
    }
}
