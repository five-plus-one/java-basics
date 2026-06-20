package com.wyr.ecommercesys.order;


import com.wyr.ecommercesys.product.Product;
import com.wyr.ecommercesys.product.exception.ProductNotFoundException;
import com.wyr.ecommercesys.product.exception.ProductQuantityIllegalException;

import java.util.ArrayList;
import java.util.List;

//购物车类，用于正式下单前，用户可以自由编辑购物车内容
public class ShoppingCart {
    private List<OrderItem> cartItems;

    public ShoppingCart(){
        this.cartItems = new ArrayList<>();
    }

    public List<OrderItem> getCartItems(){
        return cartItems;
    }

    public void addItem(OrderItem item){
        cartItems.add(item);
    }

    public int getItemSerialNumByProductId(String productId){
        if(cartItems == null){
            return -1;
        }
        for(int i=0;i<cartItems.size();i++){
            if(cartItems.get(i).getProductSnapshot().getProductId().equals(productId)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public double getTotalPrice() {
        double total = 0;
        for(OrderItem item:cartItems){
            total += item.getSubTotal();
        }
        return total;
    }

    public OrderItemList convertToOrderItemList() {
        return new OrderItemList(this.cartItems);
    }
    public void clear(){
        cartItems.clear();
    }

    public void addItemOrMerge(Product realProduct,int addQuantity) throws ProductQuantityIllegalException {
        String targetId = realProduct.getProductId();
        int serialNum =  getItemSerialNumByProductId(targetId);
        if(serialNum == -1){
            cartItems.add(new OrderItem(realProduct,addQuantity));
        }else{
            int newTotalQuantity = cartItems.get(serialNum).getBuyQuantity() + addQuantity;
            cartItems.set(serialNum,
                    new OrderItem(realProduct,newTotalQuantity)
                    );
        }
    }

    // 修改数量的方法
    public void updateItemQuantity(String productId, int newQuantity)
            throws ProductNotFoundException, ProductQuantityIllegalException {
        int serialNum = getItemSerialNumByProductId(productId);
        if(serialNum == -1){
            throw new ProductNotFoundException("未找到编号为" + productId + "的项目");
        }
        if(newQuantity <=0){
            cartItems.remove(serialNum);
        } else{
            OrderItem oldItem = cartItems.get(serialNum);
            OrderItem newItem = new OrderItem(oldItem.getProductSnapshot(),newQuantity);
            cartItems.set(serialNum,newItem);
        }
    }
}
