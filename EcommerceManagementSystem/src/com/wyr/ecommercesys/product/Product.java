package com.wyr.ecommercesys.product;

import com.wyr.ecommercesys.category.CategoryList;
import com.wyr.ecommercesys.product.exception.ProductQuantityIllegalException;
import com.wyr.ecommercesys.product.exception.ProductPriceIllegalException;

// 商品的核心类
public class Product {
    private String productId;
    private String productName;
//    private String category;
    // ↑一开始写的是category作为字符串，但是觉得不够好，因为我考虑到一个商品可能属于多个分类，所以可以考虑构造出来一个专门的类，然后传入一个list
    private CategoryList categoryList;
    private double price;
    private int quantity;
    public Product(String productId, String productName, CategoryList categoryList, double price, int quantity) throws ProductQuantityIllegalException, ProductPriceIllegalException {
//        this.productId = productId;
//        this.productName = productName;
//        this.categoryList = categoryList;
//        this.setPrice(price);
//        this.setQuantity(quantity);

//        Product(productId,productName,categoryList,price,quantity,false);
        //这么写构造方法会报错，应该用this
        this.productId = productId;
        this.productName = productName;
        this.categoryList = categoryList;
        this.setPrice(price);
        this.setQuantity(quantity);
    }
    public Product(String productId, String productName, CategoryList categoryList, double price, int quantity,boolean ignore) {
        try{
            this.productId = productId;
            this.productName = productName;
            this.categoryList = categoryList;
            this.setPrice(price);
            this.setQuantity(quantity);
        } catch (ProductPriceIllegalException | ProductQuantityIllegalException e) {
            if(!ignore){
                throw new RuntimeException(e);
            }
        }
    }


    //get和set方法
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public CategoryList getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(CategoryList categoryList) {
        this.categoryList = categoryList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws ProductPriceIllegalException {
        if(price<0){
            throw new ProductPriceIllegalException("wyr-商品错误：商品价格" + price + "不能为负数");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws ProductQuantityIllegalException {
        if(quantity<0){
            throw new ProductQuantityIllegalException("wyr-商品错误：商品数量" + quantity + "不能为负数");
        }
        this.quantity = quantity;
    }

}
