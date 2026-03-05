package com.fiveplusone.twodimensionarr;

public class TwoDimensionDemo1 {
    static void main(String[] args) {
        // 1. 定义二维数组
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5, 6, 7, 8}};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6, 7, 8}};
        // 建议这样定义，把每个一维数组单独写一行
        // 注意：每一个一维数组其实是二维数组中的元素，所以每一个一维数组之间需要用逗号隔开，最后一个一维数组后面不需要加逗号
        int[][] arr3 = {
                {1, 2, 3},
                {4, 5, 6, 7, 8}
        };

        // 2.获取元素

        //arr3[0] 表示二维数组中的第一个一维数组
//        System.out.println(arr3[0][0]);


        //二维数组的遍历
        for (int i = 0; i < arr3.length; i++) {
            for (int i1 = 0; i1 < arr3[i].length; i1++) {
                System.out.print(arr3[i][i1] + " ");
            }
            System.out.println();
        }
    }
}
