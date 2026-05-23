package com.fiveplusone.a01myfile.myfiledemo1;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        File f1 = new File("D:\\testfile\\1.txt");
        System.out.println(f1.exists() + " " +  f1.isFile() + " " + f1.isDirectory());

        File f2 = new File("D:\\testfile\\2.txt");
        System.out.println(f2.exists() + " " +  f2.isFile() + " " + f2.isDirectory());

        System.out.println(f1.length());
        System.out.println(f2.length());

        System.out.println(f1.getAbsolutePath());

        File f4 = new File("day18-code\\a.txt");

        System.out.println(f4.exists() + " " + f4.getAbsolutePath());
        System.out.println(f4.getName());
    }
}
