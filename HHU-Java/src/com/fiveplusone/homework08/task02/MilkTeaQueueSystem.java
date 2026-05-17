package com.fiveplusone.homework08.task02;

import java.util.LinkedList;

public class MilkTeaQueueSystem {
    public static void main(String[] args) {
        // 1. 使用 LinkedList 保存订单队列，以便利用其首尾操作特性
        LinkedList<Order> queue = new LinkedList<>();

        // 2. 模拟订单入队操作
        Order order1 = new Order("A001", "林羽", "芋泥波波奶茶");
        queue.addLast(order1); // 普通订单加到队尾
        System.out.println("普通订单入队：" + order1);

        Order order2 = new Order("A002", "陈星", "柠檬茶");
        queue.addLast(order2);
        System.out.println("普通订单入队：" + order2);

        Order vipOrder = new Order("VIP001", "苏畅", "热可可");
        queue.addFirst(vipOrder); // 加急订单加到队首
        System.out.println("加急订单插队：" + vipOrder);

        Order order3 = new Order("A003", "王宇", "冰美式");
        queue.addLast(order3);
        System.out.println("普通订单入队：" + order3);
        System.out.println();

        // 3. 查看队首订单和队尾订单
        if (!queue.isEmpty()) {
            System.out.println("当前最早订单：" + queue.getFirst());
            System.out.println("当前最后订单：" + queue.getLast());
        }
        System.out.println();

        // 4. 开始取餐（连续完成2笔）
        System.out.println("【开始取餐】");
        for (int i = 0; i < 4; i++) {
            processNextOrder(queue);
        }
        System.out.println();

        // 5. 输出剩余订单
        System.out.println("【剩余订单】");
        if (queue.isEmpty()) {
            System.out.println("当前没有待取餐订单");
        } else {
            for (Order order : queue) {
                System.out.println(order);
            }
        }
    }


    private static void processNextOrder(LinkedList<Order> queue) {
        if (queue.isEmpty()) {
            System.out.println("当前没有待取餐订单");
        } else {
            // 从队首移除订单
            Order completedOrder = queue.removeFirst();
            System.out.println(completedOrder + " 已完成");
        }
    }
}