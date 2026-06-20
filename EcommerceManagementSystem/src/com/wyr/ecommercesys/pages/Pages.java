package com.wyr.ecommercesys.pages;

import com.wyr.ecommercesys.console.ConsoleUI;
import com.wyr.ecommercesys.input.InputTools;


public class Pages {
    private static int currentPageId;
    private static int currentPageStatus;
    private static final String[] pageName = new String[]{
            "首页","商品管理","订单管理","保存与读取","退出系统","添加商品","显示全部商品","商品查询","商品修改","商品删除"
            // 0     1          2          3         4       5            6         7         8        9
    };

    private Pages(){}
    public static int getCurrentPageStatus() {
        return currentPageStatus;
    }
    public static void setCurrentPageStatus(int currentPageStatus){
        Pages.currentPageStatus = currentPageStatus;
    }
    public static int getCurrentPageId() {
        return currentPageId;
    }
    private static void setCurrentPageId(int currentPageId) {
        Pages.currentPageId = currentPageId;
    }
    public static void renderCurrentPage(){
        ConsoleUI.printUI(currentPageId);
    }
    public static void switchPage(int currentPageId){
        setCurrentPageStatus(0);
        setCurrentPageId(currentPageId);
        renderCurrentPage();
    }
    public static String getPageName(int currentPageId){
        if(currentPageId < pageName.length && currentPageId >= 0){
            return pageName[currentPageId];
        } else {
            throw new IllegalPageIdException("wyr-不合法的页面id");
        }
    }
    public static boolean showConfirm(String action,String otherwise){
        String message = "";
        while(true){
            ConsoleUI.printConfirm(action,otherwise,message);
            String input = InputTools.getStr();

            if(input.equalsIgnoreCase("y")){
                return true;
            }else if(input.equalsIgnoreCase("n")){
                return false;
            }
            message = "输入不合法，请重新输入。";
        }
    }

}
