package com.fiveplusone.homework07.task01;

import java.io.File;
import java.util.Scanner;

public class FileCabineInspector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要巡检的文件夹路径：");
        String path = sc.nextLine();

        // 1.校验
        if(path == null || path.trim().isEmpty()){
            System.out.println("路径不能为空，请重新输入！");
            return;
        }
        File dir = new File(path);

        if(!dir.exists()){
            System.out.println("路径不存在。");
            return;
        }

        if(!dir.isDirectory()){
            System.out.println("请输入文件夹路径，而不是文件路径。");
        }

        if(!dir.canRead()){
            System.out.println("无访问权限。");
            return;
        }

        // 2. 获取一级文件列表
        File[] files = dir.listFiles();

        // 3.处理空目录情况
        if(files == null || files.length == 0){
            System.out.println("该目录为空");
            return;
        }

        // 4.输出详细信息
        System.out.println("===资料巡检结果===");
        int fileCount = 0, dirCount = 0;
        long totalSize = 0;
        for(File f : files){
            String name = f.getName();
            String type = f.isDirectory() ? "文件夹" : "文件";
            String sizeStr = f.isDirectory() ? "-" : f.length() + "字节";
            String absPath = f.getAbsolutePath();

            System.out.printf("%s | %s | %s | %s \n",name,type,sizeStr,absPath);

            //5. 统计
            if(f.isFile()){
                fileCount++;
                totalSize += f.length();
            }else{
                dirCount ++;
            }
        }

        //6. 输出汇总
        System.out.println("文件数量：" + fileCount);
        System.out.println("文件夹数量：" + dirCount);
        System.out.println("总文件大小：" + totalSize + "字节");
    }
}
