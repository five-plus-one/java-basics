package com.fiveplusone.a01myfile.myfiledemo1;

import java.io.File;

public class FileDemo4 {
    public static void main(String[] args) {
        File f1 = new File("day18-code\\aaa\\bbb\\ccc\\ddd\\eee\\fff");

        boolean b = f1.delete();
        System.out.println(b);
    }
}
