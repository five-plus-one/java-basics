package com.wyr.ecommercesys.core;

import com.wyr.ecommercesys.category.CategoryPool;
import com.wyr.ecommercesys.order.Order;
import com.wyr.ecommercesys.order.OrderList;
import com.wyr.ecommercesys.order.ShoppingCart;
import com.wyr.ecommercesys.product.EditProduct;
import com.wyr.ecommercesys.product.Product;
import com.wyr.ecommercesys.product.ProductList;

// 全局信息
public class Global {
    private Global(){}
    public final static String SysName = "电子商务管理系统";
    public final static String SysVersion = "V1.0";
    public final static String Author = "王煜冉";
    public final static String AuthorID = "2535010212";
    public final static int RandomNumOrigin = 100;
    public final static int RandomNumBound = 101;

    private static EditProduct currentEditProduct = null;
    private static ProductList currentProductList = null;
    private static CategoryPool categoryPool = null;
    private static OrderList currentOrderList = null;
    private static ShoppingCart currentShoppingCart = null;
    // 用于订单模块 UI 渲染的数据通道
    private static Product currentOrderOperateProduct = null;
    private static Order currentGeneratedOrder = null;

    public static String getTitle(){
        return SysName + " " + SysVersion + " by" + Author;
    }

    public static void setCurrentEditProduct(EditProduct currentEditProduct) {
        Global.currentEditProduct = currentEditProduct;
    }

    public static EditProduct getCurrentEditProduct() {
        if(currentEditProduct == null){
            currentEditProduct = new EditProduct();
        }
        return currentEditProduct;
    }


    public static void setCurrentProductList(ProductList currentProductList) {
        Global.currentProductList = currentProductList;
    }

    public static ProductList getCurrentProductList() {
        if(currentProductList == null){
            currentProductList = new ProductList();
        }
        return currentProductList;
    }
    public static CategoryPool getCategoryPool() {
        if(categoryPool == null){
            categoryPool = new CategoryPool();
        }
        return categoryPool;
    }

    public static void setCurrentOrderList(OrderList currentOrderList) {
        Global.currentOrderList = currentOrderList;
    }
    public static OrderList getCurrentOrderList() {
        if(currentOrderList == null){
            currentOrderList = new OrderList();
        }
        return currentOrderList;
    }


    public static void setCurrentShoppingCart(ShoppingCart currentShoppingCart) {
        Global.currentShoppingCart = currentShoppingCart;
    }

    public static ShoppingCart getCurrentShoppingCart() {
        if(currentShoppingCart == null){
            currentShoppingCart = new ShoppingCart();
        }
        return currentShoppingCart;
    }



    public static Product getCurrentOrderOperateProduct() { return currentOrderOperateProduct; }
    public static void setCurrentOrderOperateProduct(Product p) { currentOrderOperateProduct = p; }

    public static Order getCurrentGeneratedOrder() { return currentGeneratedOrder; }
    public static void setCurrentGeneratedOrder(Order o) { currentGeneratedOrder = o; }
}
