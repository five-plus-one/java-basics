package com.wyr.ecommercesys.product;

//商品快照类
// 为什么需要这个类？实际测试的时候发现，当创建订单后，如果只是关联product，当商品更新信息以后，已经创建订单的商品信息也会跟着改变！
// 这是非常不科学和不合理的，因此使用“商品快照”来保存商品买下时的状态
public class ProductSnapshot {
    private String productId;
    private String productName; //固定下单时候的名字
    private String categoryDesc; //固定下单的时候的分类名称
    private double price; //固定下单的时候的单价
    public ProductSnapshot(Product realProduct){
        this.productId = realProduct.getProductId();
        this.productName = realProduct.getProductName();
        this.categoryDesc = realProduct.getCategoryList().getSimpleDescription();
        this.price = realProduct.getPrice();
    }

    //因为是商品快照，快照绝对不能被修改，所以只提供getter，而没有setter

    public String getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public String getCategoryDesc(){
        return categoryDesc;
    }

    public double getPrice(){
        return price;
    }
}
