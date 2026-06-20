package com.wyr.ecommercesys.console;

import com.wyr.ecommercesys.core.Global;
import com.wyr.ecommercesys.pages.Pages;
import com.wyr.ecommercesys.product.EditProduct;
import com.wyr.ecommercesys.product.Product;
import com.wyr.ecommercesys.product.ProductList;

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
            case 7:
                printProductQueryPage();
                break;
            case 8:
                printProductUpdatePage();
                break;
            case 9:
                printProductDeletePage();
                break;
        }
    }

    private static void printProductDeletePage() {
        if(Pages.getCurrentPageStatus() == 1){
            red("您即将删除的商品信息如下：\n");
            printEditProductInfo();
        }
    }

    private static void printProductUpdatePage() {
        if(Pages.getCurrentPageStatus() == 5){
            printEditProductInfo();
        }else if(Pages.getCurrentPageStatus() == 4){
            printEditProductInfo();
            ConsoleUI.printFunction("1.","修改商品名称");
            ConsoleUI.printFunction("2.","修改商品分类");
            ConsoleUI.printFunction("3.","修改商品单价");
            ConsoleUI.printFunction("4.","修改商品库存");
            ConsoleUI.printFunction("0.","退出修改并保存");
        }else if(Pages.getCurrentPageStatus() == 0){
            printEditProductInfo();
        }else if(Pages.getCurrentPageStatus() >0 && Pages.getCurrentPageStatus() <= 3){
            printEditProductInfo(); //原来漏了这个，导致编辑标签的时候无法显示对应的信息
            printCategoryEditUI(Pages.getCurrentPageStatus());
        }
    }

    private static void printProductQueryPage() {
        System.out.println("请根据提示选择查询方式");
        printDivider();
        if(Pages.getCurrentPageStatus() == 1){
            ConsoleUI.printFunction("1.按商品编号查询","按照商品编号精确查询");
            ConsoleUI.printFunction("2.按商品模糊查询","按照商品名称或分类模糊查询匹配");
            ConsoleUI.printFunction("3.按商品分类查询","根据分类进行查询");
            System.out.println();
            ConsoleUI.printFunction("0.退出查询","退出查询，返回到商品管理");
            printDivider();
        }else{
            switch (Pages.getCurrentPageStatus()){
                case 2:
                    yellow("按编号查询\n");
                    printDivider();
                    break;
                case 3:
                    yellow("按名称查询\n");
                    printDivider();
                    break;
                case 4:
                    yellow("按分类查询\n");
                    printDivider();
                    break;
            }
        }

    }

    private static void printProductAddPage() {
        System.out.println("请按照提示输入需要添加的商品信息");
        printDivider();
        printEditProductInfo();
        printCategoryEditUI(Pages.getCurrentPageStatus());
    }

    private static void printCategoryEditUI(int status) {
        if(status == 1){
            ConsoleUI.yellow("分类管理\n");
            ConsoleUI.printFunction("1.添加分类","为添加的商品添加一个分类");
            ConsoleUI.printFunction("2.删除分类","删除已添加的分类");
            ConsoleUI.printFunction("0.继续","继续完成下一步操作");
        }else if(status == 2){
            ConsoleUI.yellow("分类管理 - 添加分类\n");
        }else if(status == 3){
            ConsoleUI.yellow("分类管理 - 删除分类\n");
            printDivider();
            if(Global.getCurrentEditProduct()
                    .getCategoryList().getCategoryList().isEmpty()){
                ConsoleUI.red("暂无分类，请先去添加\n");
            }
            for (int i = 0; i < Global.getCurrentEditProduct()
                    .getCategoryList().getCategoryList().size(); i++) {
                ConsoleUI.printFunction((i+1)+"." ,Global.getCurrentEditProduct()
                        .getCategoryList().getCategoryList()
                        .get(i).getCategoryName());
            }
            ConsoleUI.printFunction("0.","取消删除");
            printDivider();
        }
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
        printUI(Pages.getCurrentPageId());
//        System.out.println();
        System.out.println(RESET + BOLD + "  是否确认" + YELLOW + action + RESET + BOLD + "?" + RESET);
//        System.out.println();
        printDivider();
//        System.out.println();
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
        if(editProduct!=null && !editProduct.isEmpty()){
            editProduct.getInfoShowMap().forEach((key,value)->{
                printFunction(key,value);
            });
            printDivider();
        }
    }
    public static void printEditProductInfo(){
        printEditProductInfo(Global.getCurrentEditProduct());
    }
//
//    public static void showProductList(ProductList productList){
//        ConsoleUI.yellow(padToTarget("商品编号",20)+
//                         padToTarget("商品名称",20)+
//                         padToTarget("所属类别",20)+
//                         padToTarget("单价",15)+
//                         padToTarget("库存",15)
//                );
//        printDivider();
//        for()
//    }

    public static void printProductList(ProductList productList){
        if(productList!=null && !productList.isEmpty()){
            yellow(
                    padToTarget("商品编号",20)+
                            padToTarget("商品名称",20)+
                            padToTarget("分类",20)+
                            padToTarget("单价",20)+
                            padToTarget("库存数量",20)+
                            "\n");
            for(Product product:productList.getProductList()){
                System.out.println(
                        padToTarget(product.getProductId(),20)+
                                padToTarget(product.getProductName(),20)+
                                padToTarget(product.getCategoryList().getSimpleDescription(),20)+
                                padToTarget(String.format("%.2f",product.getPrice()),20)+
                                padToTarget(product.getQuantity()+"",20)
                );
            }
        }else{
            yellow("未查询到商品信息！\n");
        }

    }
}
