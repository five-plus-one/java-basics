package com.fiveplusone.a01myfile.myfiledemo1;

import java.io.File;
import java.util.ArrayList;

public class FileDemo5 {
    public static void main(String[] args) {
        File f1 = new File("day18-code\\aaa");
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
