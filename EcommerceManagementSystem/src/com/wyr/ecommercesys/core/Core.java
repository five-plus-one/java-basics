package com.wyr.ecommercesys.core;

import com.wyr.ecommercesys.input.InputTools;
import com.wyr.ecommercesys.pages.Pages;
import com.wyr.ecommercesys.product.EditProduct;

public class Core {
    private Core(){}
    public static void main(String[] args) {
        while(true){
            Pages.switchPage(0);
            int choice = InputTools.getIntWithGuide("功能编号",0,3);
            if(choice == 0){
                ExitPage();
                break;
            }else if(choice == 1){
                ProductManage();
            }
        }
    }

    private static void ExitPage() {
        Pages.switchPage(4);
        if(Pages.showConfirm("退出","返回")){
            Pages.switchPage(4);
            System.exit(0);
        }
    }

    private static void ProductManage() {
        Pages.switchPage(1);
        int choice = InputTools.getIntWithGuide("功能编号",0,5);
        switch (choice){
            case 0:
                return;
            case 1:
                ProductAdd();
                break;
        }
    }

    private static void ProductAdd() {
        Pages.switchPage(5);
        Global.setCurrentEditProduct(new EditProduct());


    }
}
