package com.wyr.ecommercesys.input;

import com.wyr.ecommercesys.pages.Pages;

import java.util.Scanner;

public class InputTools {
    private InputTools(){} //私有化构造方法
    private static int getIntWithGuide(String inputName, boolean restrictMin, int minnum, boolean restrictMax , int maxnum){
//        Pages.renderCurrentPage();
        System.out.print("请输入" +inputName);
        if(restrictMin && restrictMax){
            System.out.print("(" + minnum + "-" + maxnum + "): ");
        }else if(restrictMax){
            System.out.print("(≤" + maxnum + "): ");
        }else if(restrictMin){
            System.out.print("(≥" + minnum + "): ");
        }else{
            System.out.print(": ");
        }
        boolean flag = true;
        int num = -1;
        while(flag){
            try{
                num = Integer.parseInt(getInput().trim());
                if((num<minnum && restrictMin)|| (num>maxnum) && restrictMax){
                    Pages.renderCurrentPage();
                    if(restrictMax && restrictMin){
//                        ConsoleTools.clearPreviousLine(); IDEA中的控制台并不支持这种格式控制
                        System.out.print(inputName + "必须为" + minnum + "-" + maxnum + "之间的整数，请重新输入：");
                    }else if(restrictMax){
                        System.out.print(inputName + "不能超过" + maxnum + "，请重新输入：");
                    }else{
                        System.out.print(inputName + "不能低于" + minnum + "，请重新输入：");
                    }
                }else{
                    flag = false;
                }
            }catch (NumberFormatException e){
//                ConsoleTools.clearPreviousLine();
                Pages.renderCurrentPage();
                System.out.print(inputName + "必须为整数，请重新输入：");
            }
        }
        return num;
    }
    public static double getDoubleWithGuide(String inputName){
        return getDoubleWithGuide(inputName,"");
    }
    public static double getDoubleWithGuide(String inputName,String message){
//        Pages.renderCurrentPage();
        System.out.print(message + "请输入" +inputName + ": ");
        double num = -1;
        while(true){
            try{
                num = Double.parseDouble(getInput().trim());
                break;
            }catch (NumberFormatException e){
                Pages.renderCurrentPage();
                System.out.println(inputName + "输入格式有误，请重新输入：");
            }
        }
        return num;
    }
    public static int getIntWithGuide(String InputName, int minnum, int maxnum){
        return getIntWithGuide(InputName,true,minnum,true,maxnum);
    }
    public static int getIntWithGuide(String InputName, int minnum){
        return getIntWithGuide(InputName,true,minnum,false,0);
    }
    public static int getIntWithGuide(String InputName){
        return getIntWithGuide(InputName,false,0,false,0);
    }
    public static String getStr(){
        return getInput().trim();
    }
    private static String getInput(){
//        Scanner sc = new Scanner(System.in);
//        StringBuffer sb = new StringBuffer();
//        while(sc.hasNextLine()){
//            sb.append(sc.nextLine());
//        }
//        return sb.toString();
        //这里原来写的代码有问题，因为sc.hasNextLine() 在读取 System.in时，具有阻塞特性。
        //当输入一行文字并按下回车后，sc.nextLine() 会读取这行文字并拼接到 StringBuffer 中。
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String getStrWithGuide(String InputName,boolean NotEmptyRestrict){
//        Pages.renderCurrentPage();
        System.out.print("请输入" + InputName + ": ");
        String str = "";
        while(true){
            str = getInput().trim();
            if(!(NotEmptyRestrict && str.isEmpty())){
                break;
            }
            Pages.renderCurrentPage();
            System.out.print(InputName + "不能为空，请重新输入" + InputName + ": ");
        }
        return str;
    }



    public static String getStrWithGuide(String InputName){
        return getStrWithGuide(InputName,true);
    }

    public static void waitForEnter(){
        getInput();
        return;
    }
}
