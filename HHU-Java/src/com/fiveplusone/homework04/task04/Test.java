package com.fiveplusone.homework04.task04;

public class Test {
    public static void main(String[] args) {
        TransferTransaction transfer = new TransferTransaction(15000);
        WithdrawTransaction withdraw = new WithdrawTransaction(4000);
        if(transfer.checkRisk()){
            System.out.println("转账" + transfer.getAmount() + "元被风控拦截");
        }else{
            System.out.println("转账" + transfer.getAmount() + "元没有被风控拦截");
        }
        if(withdraw.checkRisk()){
            System.out.println("当日累计提现" + withdraw.getDailyTotal() + "元被风控拦截");
        }else{
            System.out.println("当日累计提现" + withdraw.getDailyTotal() + "元没有被风控拦截");
        }
    }
}
