package com.wyr.ecommercesys.core;

import com.wyr.ecommercesys.product.EditProduct;
import com.wyr.ecommercesys.product.ProductList;

// 全局信息
public class Global {
    private Global(){}
    public final static String SysName = "电子商务管理系统";
    public final static String SysVersion = "V1.0";
    public final static String author = "王煜冉";

    private static EditProduct currentEditProduct = null;
    private static ProductList currentProductList = null;

    public static String getTitle(){
        return SysName + " " + SysVersion + " by" + author;
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

}
