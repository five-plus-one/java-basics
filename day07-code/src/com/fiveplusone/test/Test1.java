package com.fiveplusone.test;

import java.util.Scanner;

public class Test1 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入机票的原价: ");
        int ticket = sc.nextInt();
        System.out.print("请输入当前的月份: ");
        int month = sc.nextInt();
        System.out.print("请输入当前购买的仓位 0头等舱 1经济舱");
        int seat = sc.nextInt();
        if (month >= 5 && month <= 10) {
            ticket = getTicket(seat, ticket, 0.9, 0.85);
        } else if ((month >= 1 && month <= 4) || (month >= 11 && month <= 12)) {
            ticket = getTicket(seat, ticket, 0.7, 0.65);
        } else {
            System.out.println("输入的月份不合法");
        }
        System.out.println(ticket);
    }

    private static int getTicket(int seat, int ticket, double x, double x1) {
        if (seat == 0) {
            ticket = (int) (ticket * x);
        } else if (seat == 1) {
            ticket = (int) (ticket * x1);
        } else {
            System.out.println("没有这个仓位");
        }
        return ticket;
    }

//    public static int getPrice(int ticket, int seat, double v0, double v1) {
//        if (seat == 0) {
//            ticket = (int) (ticket * v0);
//        } else if (seat == 1) {
//            ticket = (int) (ticket * v1);
//        } else {
//            System.out.println("没有这个仓位");
//        }
//        return ticket;
//    }
}
