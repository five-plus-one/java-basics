package com.wyr.ecommercesys.core;

import com.wyr.ecommercesys.product.EditProduct;

// 全局信息
public class Global {
    private Global(){}
    public final static String SysName = "电子商务管理系统";
    public final static String SysVersion = "V1.0";
    public final static String author = "王煜冉";

    private EditProduct currentEditProduct = null;

    public static String getTitle(){
        return SysName + " " + SysVersion + " by" + author;
    }

    public void setCurrentEditProduct(EditProduct currentEditProduct) {
        this.currentEditProduct = currentEditProduct;
    }

    public 


}
