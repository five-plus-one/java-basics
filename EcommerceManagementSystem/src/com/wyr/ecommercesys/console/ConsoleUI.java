package com.wyr.ecommercesys.console;

import com.wyr.ecommercesys.core.Global;
import com.wyr.ecommercesys.pages.Pages;
import com.wyr.ecommercesys.product.EditProduct;

public class ConsoleUI extends ConsoleTools{
    private  ConsoleUI() {} //私有化构造方法，防止被创建
    public static void printTitle(String position){
        printDivider();
        System.out.print(CYAN + "  " + BOLD + padToTarget(Global.getTitle(),52,3) + CYAN + "  \n" + RESET);
        System.out.print(YELLOW + "  " + BOLD + padToTarget("当前位置:" + position,52,1)+ CYAN + "  \n" + RESET);
        printDivider();
    }

    public static void printUI(int currentPageId){
        clearScreen();
        printTitle(Pages.getPageName(currentPageId));
        switch (currentPageId){
            case 0:
                printHomePage();
                break;
            case 4:
                printExitPage();
                break;
            case 1:
                printProductManagePage();
                break;
            case 5:
                printProductAddPage();
                break;
        }
    }

    private static void printProductAddPage() {
        printEditProductInfo();
    }

    private static void printProductManagePage() {
        printFunction("1.商品添加","添加新的商品");
        printFunction("2.商品查询","按照多种方式查询商品");
        printFunction("3.商品修改","修改已有商品信息");
        printFunction("4.商品删除","删除已有商品");
        printFunction("5.所有商品","显示所有商品");
        System.out.println();
        printFunction("0.返回首页","退出当前菜单");
        System.out.println();
        printDivider();
    }

    private static void printExitPage() {
        System.out.println();
        System.out.println("感谢使用，再见！");
        System.out.println();

    }

    public static void printConfirm(String action,String otherwise,String message){
        clearScreen();
        printTitle(Pages.getPageName(Pages.getCurrentPageId()));
        System.out.println();
        System.out.println(RESET + BOLD + "  是否确认" + YELLOW + action + RESET + BOLD + "?" + RESET);
        System.out.println();
        printDivider();
        System.out.println();
        System.out.print(RESET  + message + "输入" + YELLOW + "Y/y" + RESET + "以" + YELLOW + action + RESET + ",输入" + YELLOW + "N/n" + RESET + "以" + YELLOW +  otherwise + RESET + ": ");
    }
    public static void printConfirm(String action,String otherwise){
        printConfirm(action,otherwise,"");
    }
    private static void printHomePage(){
        System.out.println(BOLD + "欢迎使用电子商务管理系统，系统功能如下：" + RESET);
        printDivider();
        printFunction("1.商品管理","添加、查询、修改、删除商品");
        printFunction("2.订单管理","创建、查询订单");
        printFunction("3.保存与读取","保存、读取文件");
        System.out.println();
        printFunction("0.退出系统","退出系统");
        printDivider();
    }
    public static void printEditProductInfo(EditProduct editProduct){
        if(editProduct!=null){
            editProduct.getInfoShowMap().forEach((key,value)->{
                printFunction(key,value);
            });
            printDivider();
        }
    }
    public static void printEditProductInfo(){
        printEditProductInfo(Global.getCurrentEditProduct());
    }
}
