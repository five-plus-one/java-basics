package com.fiveplusone.homework04.task04;

// 子类：转账
public class TransferTransaction extends Transaction{
    private double amount;
    TransferTransaction(double amount){
        this.amount = amount;
    }

    @Override
    public boolean checkRisk() {
        return amount > 10000;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
