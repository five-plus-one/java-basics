package com.fiveplusone.homework07.task03;

import java.io.*;

public class LibraryLogAnalyzer {
    public static void main(String[] args) {
        String inputPath = "D:\\testfile\\data\\borrow_log.txt";
        String outputPath = "D:\\testfile\\result\\summary.txt";

        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        if(!inputFile.exists()){
            System.out.println("日志文件不存在");
            return;
        }

        File targetDir = outputFile.getParentFile();
        if(targetDir != null && !targetDir.exists()){
            targetDir.mkdirs();
        }

        int totalLines = 0;
        int borrowCount = 0;
        int returnCount = 0;

        try(
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        ){
            String line;
            while((line = br.readLine()) != null){
                totalLines ++;
                String[] parts = line.split(",");
                if(parts.length >= 4){
                    String action = parts[3].trim();
                    if("borrow".equalsIgnoreCase(action)){
                        borrowCount++;
                    }else if("return".equalsIgnoreCase(action)){
                        returnCount++;
                    }
                }
            }

            bw.write("【图书馆借阅日志统计】");
            bw.newLine();

            bw.write("日志总条数：" + totalLines);
            bw.newLine();

            bw.write("借书次数：" + borrowCount);
            bw.newLine();

            bw.write("还书次数：" + returnCount);
            bw.newLine();

            System.out.println("日志分析完成，结果已生成至：" + outputPath);

        } catch (IOException e) {
            System.out.println("读取文件发生错误：" + e.getMessage());
        }
    }
}
