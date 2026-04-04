package com.fiveplusone.a03runtime;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("CPU线程数:"+Runtime.getRuntime().availableProcessors());
        System.out.println("最大内存:"+Runtime.getRuntime().maxMemory()/1024/1024+"MB");
        System.out.println("已获取:"+Runtime.getRuntime().totalMemory()/1024/1024+"MB");
        System.out.println("剩余："+Runtime.getRuntime().freeMemory()/1024/1024+"MB");

        Runtime.getRuntime().exec("shutdown -s -t 3600");

        runtime.exit(0);
    }
}
