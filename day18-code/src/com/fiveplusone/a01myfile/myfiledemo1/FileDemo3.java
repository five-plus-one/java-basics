package com.fiveplusone.a01myfile.myfiledemo1;

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("day18-code\\b.txt");

        boolean b = f1.createNewFile();
        System.out.println(b);

        File f2 = new File("day18-code\\aaa\\bbb\\ccc\\ddd\\eee\\fff");
        boolean c = f2.mkdirs();
        System.out.println(c);
    }
}
