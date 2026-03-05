package com.fiveplusone.test;

import java.util.Random;
import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        //1. 生成中奖号码
        int[] arr = createNumber();
//        System.out.println("-----中奖号码为：-----");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println("-------------------");
        //2. 用户输入彩票号码（红球+蓝球）
        int[] userInputArr = userInputNumber();

        //3. 比较用户输入号码和中奖号码
        int redCount = 0;
        int blueCount = 0;

        for (int i = 0; i < userInputArr.length - 1; i++) {
            int redNumber = userInputArr[i];
            //判断红球号码是否在中奖号码中
            for(int j=0;j<arr.length-1;j++){
                if(redNumber==arr[j]){
                    redCount++;
                    break;
                }
            }
        }
        //判断蓝球号码是否在中奖号码中
        int blueNumber = userInputArr[6];
        if(blueNumber==arr[6]){
            blueCount++;
        }

        //4. 根据红球号码和蓝球号码判断中奖等级
        System.out.println("您中了" + redCount + "个红球，" + blueCount + "个蓝球");
        if(redCount == 6 && blueCount == 1){
            System.out.println("恭喜你，中奖1000万");
        }else if(redCount ==6 && blueCount == 1){
            System.out.println("恭喜你，中奖500万");
        }else if(redCount == 5 && blueCount == 1){
            System.out.println("恭喜你，中奖3000元");
        }else if((redCount == 5 && blueCount == 0)||(redCount == 4 && blueCount == 1)){
            System.out.println("恭喜你，中奖200元");
        }else if((redCount == 4 && blueCount == 0)||(redCount == 3 && blueCount == 1)){
            System.out.println("恭喜你，中奖10元");
        }else if((redCount == 2 && blueCount == 1)||(redCount == 1 && blueCount == 1)||(redCount == 0 && blueCount == 1)){
            System.out.println("恭喜你，中奖5元");
        }else{
            System.out.println("很遗憾，未中奖");
        }

    }


    public static int[] userInputNumber(){
        //1. 创建数组用于添加用户输入号码,6红1蓝
        int[] arr = new int[7];
        //2. 用户输入红球号码
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6;) {
            System.out.println("请输入第" + (i + 1) + "个红球号码(1-33之间的整数)：");
            int redNumber = sc.nextInt();
            //判断红球号码是否符合要求 在1-33 唯一不重复
            if(redNumber >= 1 && redNumber <= 33){
                //判断红球号码是否重复
                if(!contains(arr, redNumber)){
                    arr[i] = redNumber;
                    i++;
                }else{
                    System.out.println("红球号码重复，请重新输入！");
                }
            }else{
                System.out.println("红球号码输入错误，请重新输入！");
            }
        }
        //3. 用户输入蓝球号码
        System.out.println("请输入蓝球号码(1-16之间的整数)：");
        while (true) {
            int blueNumber = sc.nextInt();
            //判断蓝球号码是否符合要求 在1-16之间
            if(blueNumber >= 1 && blueNumber <= 16){
                arr[6] = blueNumber;
                break;
            }else{
                System.out.println("蓝球号码输入错误，请重新输入！");
            }
        }

        return arr;
    }

    public static int[] createNumber() {
        //1. 创建数组用于添加中奖号码,6红1蓝
        int[] arr = new int[7];

        //2. 随机生成号码并添加到数组中
        //红球：不能重复
        //篮球：可以和红球重复

        //生成红球号码并添加到数组中
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int redNumber = r.nextInt(33) + 1;
            //判断红球号码是否重复
            if (!contains(arr, redNumber)) {
                arr[i] = redNumber;
                i++;
            }
        }

        //生成蓝球号码并添加到数组中
        int blueNumber = r.nextInt(16) + 1;
        arr[6] = blueNumber;

        return arr;
    }

    public static boolean contains(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) return true;
        }
        return false;
    }
}
