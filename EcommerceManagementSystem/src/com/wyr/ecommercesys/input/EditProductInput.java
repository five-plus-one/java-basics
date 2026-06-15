package com.wyr.ecommercesys.input;

import com.wyr.ecommercesys.console.ConsoleUI;
import com.wyr.ecommercesys.core.Global;
import com.wyr.ecommercesys.pages.Pages;
import com.wyr.ecommercesys.product.EditProduct;
import com.wyr.ecommercesys.product.exception.ProducetQuantityIllegalException;
import com.wyr.ecommercesys.product.exception.ProductPriceIllegalException;

import java.util.Random;

// 工具类，用于统一输入
public class EditProductInput {
    private EditProductInput(){}
    public static EditProduct getEditProduct(){
        return Global.getCurrentEditProduct();
    }
    public static void inputProductId(){
        Pages.renderCurrentPage();
        String productOriginalId = InputTools.getStrWithGuide("商品编号");
        String productId = "";
        while(true){
            Random r = new Random();
            productId = "wyr-" + productOriginalId + "-" + r.nextInt(100,101);
            System.out.println("已自动添加姓名首字母为固定前缀，随机数后缀");
            System.out.print("新的商品编号为 " );
            Global.getCurrentEditProduct().setProductId(productId);
            ConsoleUI.yellow(productId + " ");
            if(Global.getCurrentProductList().isProductExist(productId)){
                Pages.renderCurrentPage();
                ConsoleUI.red("\n错误：商品编号" + productId + "已存在，请重新输入商品编号。");
                productOriginalId = InputTools.getStrWithGuide("商品编号");
            }else{
                break;
            }
        }
        Global.getCurrentEditProduct().setProductId(productId);
        System.out.print(" 。按下回车以继续");
        InputTools.waitForEnter();
    }
    public static void inputProductName(){
        Pages.renderCurrentPage();
        Global.getCurrentEditProduct().setProductName(
                InputTools.getStrWithGuide("商品名称")
        );
    }
    public static void inputProductPrice(){
        String message = "";
        Pages.renderCurrentPage();

        while(true){
            try {
                Global.getCurrentEditProduct().setPrice(
                    InputTools.getDoubleWithGuide("商品价格",message)
                );
                break;
            } catch (ProductPriceIllegalException e) {
                Pages.renderCurrentPage();

                System.out.print("发生错误：");
                ConsoleUI.red(e.getMessage() + "。");
                message = "请重新输入。\n";
            }

        }
    }
    public static void inputProductQuantity(){
        Pages.renderCurrentPage();
        while(true){
            try {
                Global.getCurrentEditProduct().setQuantity(
                        InputTools.getIntWithGuide("商品库存")
                );
                break;
            } catch (ProducetQuantityIllegalException e) {
                Pages.renderCurrentPage();

                System.out.print("发生错误：");
                ConsoleUI.red(e.getMessage() + "。请重新输入。\n");
            }
        }
    }
}
