package com.fiveplusone.homework06.task03;

// 1.自定义异常类
class InsufficientFundsException extends Exception {
    private double shortfall;

    public InsufficientFundsException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public double getShortfall() {
        return shortfall;
    }
}

// 2.交易指令实体类
class Transaction {
    private String tradeName;
    private double amount;
    private double balance;

    public Transaction(String tradeName, double amount, double balance) {
        this.tradeName = tradeName;
        this.amount = amount;
        this.balance = balance;
    }

    public void execute() throws InsufficientFundsException {
        if (amount > balance) {
            double gap = amount - balance;
            throw new InsufficientFundsException("余额不足", gap);
        }
        System.out.println("交易成功");
    }
}

// 3.核心交易引擎
class TradeEngine {
    public void executeBatch(Transaction[] tasks) {
        for (Transaction task : tasks) {
            try {
                task.execute();
            } catch (NullPointerException e) {
                System.out.println("检测到空指令，已跳过。捕获异常" + e);
            } catch (Exception e){
                //捕获业务级异常
                if(e instanceof InsufficientFundsException) {
                    InsufficientFundsException ife = (InsufficientFundsException) e;
                    System.out.println("交易拦截！" + ife.getMessage() + "。捕获自定义异常，金额缺口为:" + ife.getShortfall() + "元");
                }else {
                    System.out.println("发生未知异常" + e.getMessage());
                }
            }
        }
        System.out.println("--------");
        System.out.println("批处理结束");
    }
}

// 4.主程序
public class VirtualStockSystem {
    public static void main(String[] args) {
        Transaction[] tasks ={
                new Transaction("测试交易1",2000,5000),
                null,
                new Transaction("测试交易2",8000,3000)
        };

        TradeEngine engine = new TradeEngine();
        engine.executeBatch(tasks);
    }
}
