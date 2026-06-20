package com.wyr.ecommercesys.order;

import com.wyr.ecommercesys.core.Global;

import java.util.Random;

// 订单实体类
public class Order {
    private String orderId;
    private long createTime; //下单的时候的时间戳
    private OrderItemList orderItemList;
    private double finalPrice; //最终的总价

    public Order(OrderItemList orderItemList){
        this.orderId = generateUniqueOrderId();
        this.createTime = System.currentTimeMillis();
        this.orderItemList = orderItemList;
        this.finalPrice = orderItemList.getTotalPrice();
    }
    // 新增：专用于从本地文件恢复历史订单的构造方法
    public Order(String orderId, double finalPrice, OrderItemList orderItemList){
        this.orderId = orderId;
        this.createTime = System.currentTimeMillis(); // 也可以存时间戳，这里简化处理
        this.orderItemList = orderItemList;
        this.finalPrice = finalPrice;
    }
    //生成订单号，这里采用学号+时间戳+随机后缀
    private String generateUniqueOrderId() {
        long timestamp = System.currentTimeMillis();
        int randomNum = new Random().nextInt(
                Global.RandomNumOrigin,
                Global.RandomNumBound
        );
        return "2535010212" + String.valueOf(timestamp) +  String.valueOf(randomNum);
    }

    //订单一旦生成，不允许修改，全部采用get
    public String getOrderId() {
        return orderId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public OrderItemList getOrderItemList() {
        return orderItemList;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

}
