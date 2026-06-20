package com.wyr.ecommercesys.order;

import com.wyr.ecommercesys.order.exception.OrderNotFoundException;
import com.wyr.ecommercesys.product.Product;
import com.wyr.ecommercesys.product.ProductList;
import com.wyr.ecommercesys.product.exception.ProductNotFoundException;
import com.wyr.ecommercesys.product.exception.ProductQuantityIllegalException;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private List<Order> orderList;
    public OrderList(){
        this.orderList = new ArrayList<>();
    }
    public List<Order> getOrderList(){
        return orderList;
    }

    public Order getOrderById(String orderId) throws OrderNotFoundException {
        for(Order order: orderList){
            if(order.getOrderId().equals(orderId)){
                return order;
            }
        }
        throw new OrderNotFoundException("wyr-未查找到订单号为" + orderId + "的订单");
    }

    // 创建订单。其中会遇到一个问题，当其中的一个订单项库存不足（或者出现其他问题），整个订单应该直接取消
    // 所以采用预先检查的方法，先检查库存是否均充足，再下单
    public  Order createOrder(OrderItemList currentCart, ProductList globalProductList)
            throws ProductNotFoundException, ProductQuantityIllegalException {
        // 1.预检阶段
        for(OrderItem item : currentCart.getItemList()){
            String targetId  = item.getProductSnapshot().getProductId();
            Product realProduct = globalProductList.getProductById(targetId);
            int buyNum = item.getBuyQuantity();
            //检查库存是否充足
            if(realProduct.getQuantity() < buyNum){
                // 其中一项库存不足，直接抛出错误
                throw new ProductQuantityIllegalException(
                        "商品 [" + realProduct.getProductName() + "(编号:" + realProduct.getProductId() +
                        ")]当前仅剩" + realProduct.getQuantity() + "件，无法满足" +
                        buyNum + "件的购买需求"
                );
            }
        }

        //2.正式扣减商品数量并生成订单
        for(OrderItem item : currentCart.getItemList()){
            String targetId = item.getProductSnapshot().getProductId();
            Product realProduct = globalProductList.getProductById(targetId);
            int buyNum = item.getBuyQuantity();
            int remainingNum = realProduct.getQuantity() - buyNum;
            realProduct.setQuantity(remainingNum);
        }

        Order newOrder = new Order(currentCart);
        orderList.add(newOrder);
        return newOrder;
    }

    // 新增：用于将本地读取的历史订单直接塞入大盘
    public void addOrder(Order order) {
        orderList.add(order);
    }
}
