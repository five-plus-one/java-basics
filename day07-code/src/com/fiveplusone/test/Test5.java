package com.fiveplusone.test;

import java.util.Scanner;

public class Test5 {
    static void main(String[] args) {
        int[] scoresArr = getScores();
        int max = getMax(scoresArr);
        int min = getMin(scoresArr);
        int sum = getSum(scoresArr);
        double avg = (double) (sum - max - min) / (scoresArr.length - 2);
        System.out.println(avg);
    }

    public static int getSum(int[] scoresArr) {
        int sum = 0;
        for (int i = 0; i < scoresArr.length; i++) {
            sum += scoresArr[i];
        }
        return sum;
    }

    public static int getMax(int[] scoresArr) {
        int max = scoresArr[0];
        for (int i = 0; i < scoresArr.length; i++) {
            if (scoresArr[i] > max) {
                max = scoresArr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] scoresArr) {
        int min = scoresArr[0];
        for (int i = 0; i < scoresArr.length; i++) {
            if (scoresArr[i] < min) {
                min = scoresArr[i];
            }
        }
        return min;
    }

    public static int[] getScores() {
        int[] scores = new int[6];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; ) {
            System.out.println("请输入第" + (i + 1) + "位评委的打分");
            int score = sc.nextInt();
            if (score >= 0 && score <= 100) {
                scores[i] = score;
                i++;
            }
        }
        return scores;
    }
}
