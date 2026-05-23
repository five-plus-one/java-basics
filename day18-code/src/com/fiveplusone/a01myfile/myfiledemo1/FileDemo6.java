package com.fiveplusone.a01myfile.myfiledemo1;

import java.io.File;

public class FileDemo6 {
    public static void main(String[] args) {
        File f1 = new File("day18-code\\aaa");
        File[] files = f1.listFiles();
        for(File file : files){
            if(file.isFile() && file.getName().endsWith(".txt")){
                System.out.println(file.getName());
            }
        }
    }
}
