package com.fiveplusone.homework09.task01;

public class HomeworkSubmissionSystem {
    public static void main(String[] args) {
        System.out.println("主线程：开始接受学生作业");
        HomeworkSubmission task1 = new HomeworkSubmission("张三","Java集合练习");
        HomeworkSubmission task2 = new HomeworkSubmission("李四","多线程预习报告");
        HomeworkSubmission task3 = new HomeworkSubmission("王五","异常处理实验");

        Thread t1 = new Thread(task1,"提交线程 - 张三");
        Thread t2 = new Thread(task2,"提交线程 - 李四");
        Thread t3 = new Thread(task3, "提交线程 - 王五");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("主线程：已发起全部提交任务");
    }
}


class HomeworkSubmission implements Runnable{
    private String studentName;
    private String homeworkName;

    public HomeworkSubmission(String studentName, String homeworkName){
        this.studentName = studentName;
        this.homeworkName = homeworkName;
    }

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + ":" + studentName + " 正在提交 " +homeworkName);

        int submitTime = (int)(Math.random() * 1000) + 500;
        try {
            Thread.sleep(submitTime); //模拟提交用时
        } catch (InterruptedException e) {
            System.out.println(threadName + ":提交被中断 " + e.getMessage());
        }

        System.out.println(threadName + ": " + studentName + " 提交完成");
    }
}