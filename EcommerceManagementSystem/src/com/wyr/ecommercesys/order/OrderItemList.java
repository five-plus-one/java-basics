package com.wyr.ecommercesys.order;

import java.util.ArrayList;
import java.util.List;

public class OrderItemList {
    private List<OrderItem> itemList;
    public OrderItemList(){
        this.itemList = new ArrayList<>();
    }
    public OrderItemList(List<OrderItem> sourceList){
        // 创建一个新的集合，防止通过引用修改数据
        this.itemList = new ArrayList<>(sourceList);
    }
    public List<OrderItem> getItemList() {
        return itemList;
    }

    // 现在已经有了ShoppingCart，订单需要唯一，不再可变
//    public void addItem(OrderItem item){
//        itemList.add(item);
//    }

    public boolean isEmpty(){
        return itemList.isEmpty();
    }

    public double getTotalPrice(){
        double total = 0;
        for(OrderItem item:itemList){
            total += item.getSubTotal();
        }
        return total;
    }

    public String getSimpleDescription(){
        StringBuilder sb = new StringBuilder();
        for(OrderItem item : itemList){
            sb.append(item.getProductSnapshot().getProductName())
                    .append("*").append(item.getBuyQuantity()).append(";");
        }
        return sb.toString();
    }
}
