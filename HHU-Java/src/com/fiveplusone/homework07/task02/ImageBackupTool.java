package com.fiveplusone.homework07.task02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ImageBackupTool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要备份的源文件路径：");
        String sourcePath = sc.nextLine();

        if(sourcePath == null || sourcePath.trim().isEmpty()){
            System.out.println("源路径不能为空。");
            return;
        }

        System.out.println("请输入备份存放路径：");
        String targetPath = sc.nextLine();

        if(targetPath == null || targetPath.trim().isEmpty()){
            System.out.println("目标路径不能为空");
            return;
        }

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        if(!sourceFile.exists()){
            System.out.println("源文件不存在，请检查路径：" + sourcePath);
            return;
        }
        if(!sourceFile.isFile()){
            System.out.println("源路径不是一个有效的文件！");
            return;
        }

        File targetDir = targetFile.getParentFile();
        if(targetDir != null && !targetDir.exists()){
            boolean created = targetDir.mkdirs();
            if(created){
                System.out.println("备份目录不存在，已自动创建：" + targetDir.getAbsolutePath());
            }
        }
        System.out.println("正在备份...");
        try(
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(targetFile);
        ){
            byte[] buffer = new byte[1024];
            int len;

            while((len = fis.read(buffer)) !=-1){
                fos.write(buffer,0,len);
            }

            System.out.println("备份完成！");
            System.out.println("源文件大小：" + sourceFile.length() + "字节");
            System.out.println("目标文件大小：" + targetFile.length() + " 字节");

        } catch(IOException e){
            System.out.println("文件复制过程中发生错误：" + e.getMessage());
        }
    }
}
