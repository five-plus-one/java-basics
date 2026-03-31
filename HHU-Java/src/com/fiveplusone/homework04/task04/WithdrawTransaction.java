package com.fiveplusone.homework04.task04;

// 子类：提现
public class WithdrawTransaction extends Transaction{
    private double dailyTotal;
    WithdrawTransaction(double dailyTotal) {
        this.dailyTotal = dailyTotal;
    }
    @Override
    public boolean checkRisk() {
        return dailyTotal > 5000;
    }

    public double getDailyTotal() {
        return dailyTotal;
    }

    public void setDailyTotal(double dailyTotal) {
        this.dailyTotal = dailyTotal;
    }
}
