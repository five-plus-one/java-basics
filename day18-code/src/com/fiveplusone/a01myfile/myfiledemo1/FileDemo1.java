package com.fiveplusone.a01myfile.myfiledemo1;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        String str = "a.txt";
        File f1 = new File(str);
        System.out.println(f1);
    }
}
