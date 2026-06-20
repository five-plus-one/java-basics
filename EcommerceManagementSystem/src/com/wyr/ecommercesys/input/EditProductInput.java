package com.wyr.ecommercesys.input;

import com.wyr.ecommercesys.category.Category;
import com.wyr.ecommercesys.category.CategoryList;
import com.wyr.ecommercesys.console.ConsoleUI;
import com.wyr.ecommercesys.core.Global;
import com.wyr.ecommercesys.pages.Pages;
import com.wyr.ecommercesys.product.EditProduct;
import com.wyr.ecommercesys.product.exception.ProductQuantityIllegalException;
import com.wyr.ecommercesys.product.exception.ProductPriceIllegalException;

import java.util.Random;

// 工具类，用于统一输入
public class EditProductInput {
    private EditProductInput(){}
    public static EditProduct getEditProduct(){
        return Global.getCurrentEditProduct();
    }
    public static void inputProductId(){
        Pages.setCurrentPageStatus(0);
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
        Pages.setCurrentPageStatus(0);
        Pages.renderCurrentPage();
        Global.getCurrentEditProduct().setProductName(
                InputTools.getStrWithGuide("商品名称")
        );
    }
    public static void inputProductPrice(){
        Pages.setCurrentPageStatus(0);
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
        Pages.setCurrentPageStatus(0);
        Pages.renderCurrentPage();
        while(true){
            try {
                Global.getCurrentEditProduct().setQuantity(
                        InputTools.getIntWithGuide("商品库存")
                );
                break;
            } catch (ProductQuantityIllegalException e) {
                Pages.renderCurrentPage();

                System.out.print("发生错误：");
                ConsoleUI.red(e.getMessage() + "。请重新输入。\n");
            }
        }
    }

    public static void inputProductCategory(){
        if(!Global.getCurrentEditProduct().isSetCategoryList()){
            Global.getCurrentEditProduct().setCategoryList(
                    new CategoryList()
            );
        }
        CategoryList categoryList = Global.getCurrentEditProduct().getCategoryList();
        while(true){
            Pages.setCurrentPageStatus(1);
            Pages.renderCurrentPage();
            int choice = InputTools.getIntWithGuide("功能选择",0,2);
            if(choice == 0){
                break;
            }else if(choice == 1){
                Pages.setCurrentPageStatus(2);
                Pages.renderCurrentPage();
                String addCategory = InputTools.getStrWithGuide("添加的分类");
                Category category = Global.getCategoryPool().getCategoryByName(addCategory);
                //调试代码
//                System.out.println("---");
//                Global.getCategoryPool().test_printCategoryList();
//                System.out.println("---");

                if(categoryList.contains(category)){
                    ConsoleUI.red("该分类已存在。按下回车以继续\n");
                    InputTools.waitForEnter();
                }else{
                    categoryList.addCategory(category);
                    Pages.renderCurrentPage();
                    System.out.println("添加成功，按下回车以继续");
                    InputTools.waitForEnter();
                }
            }else if(choice == 2){
                Pages.setCurrentPageStatus(3);
                Pages.renderCurrentPage();
                int op = InputTools.getIntWithGuide("删除的标签编号",0,categoryList.getCategoryList().size());
                if(op > 0){
                    categoryList.removeCategory(op-1);
                    System.out.println("删除成功，按下回车键以继续");
                    InputTools.waitForEnter();
                }
            }
        }
        Pages.setCurrentPageStatus(0);
    }
}
