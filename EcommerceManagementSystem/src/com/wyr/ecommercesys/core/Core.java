package com.wyr.ecommercesys.core;

import com.wyr.ecommercesys.console.ConsoleTools;
import com.wyr.ecommercesys.console.ConsoleUI;
import com.wyr.ecommercesys.input.EditProductInput;
import com.wyr.ecommercesys.input.InputTools;
import com.wyr.ecommercesys.pages.Pages;
import com.wyr.ecommercesys.product.EditProduct;
import com.wyr.ecommercesys.product.exception.ProducetQuantityIllegalException;
import com.wyr.ecommercesys.product.exception.ProductPriceIllegalException;

import java.util.Random;

public class Core {
    private Core(){}
    public static void main(String[] args) {
        while(true){
            Pages.switchPage(0);
            int choice = InputTools.getIntWithGuide("功能编号",0,3);
            if(choice == 0){
                if(ExitPage()){
                    break;
                }
            }else if(choice == 1){
                ProductManage();
            }
        }
    }

    private static boolean ExitPage() {
        Pages.switchPage(4);
        if(Pages.showConfirm("退出","返回")){
            Pages.switchPage(4);
            return true;
        }else{
            return false;
        }
    }

    private static void ProductManage() {
        while (true){
            Pages.switchPage(1);
            int choice = InputTools.getIntWithGuide("功能编号",0,5);
            if(choice == 0){break;}
            switch (choice){
                case 1:
                    ProductAdd();
                    break;
                case 2:
            }
        }

    }

    private static void ProductAdd() {
        Pages.switchPage(5);
        Global.setCurrentEditProduct(new EditProduct());
        EditProductInput.inputProductId();
        EditProductInput.inputProductName();
        EditProductInput.inputProductPrice();
        EditProductInput.inputProductQuantity();
        EditProductInput.inputProductCategory();
        if(Pages.showConfirm("添加","取消添加")){
            try {
                Global.getCurrentProductList().addProduct(Global.getCurrentEditProduct().convertToProduct());
                ConsoleUI.green("添加成功。按下回车以继续");
                InputTools.waitForEnter();
            } catch (ProductPriceIllegalException |ProducetQuantityIllegalException e) {
                ConsoleUI.red("添加失败：" + e.getMessage() + " \n按下回车以继续");
                InputTools.waitForEnter();
            }
        }else{
            ConsoleUI.yellow("已取消添加，按下回车键回到首页");
            InputTools.waitForEnter();
        }
    }
}
