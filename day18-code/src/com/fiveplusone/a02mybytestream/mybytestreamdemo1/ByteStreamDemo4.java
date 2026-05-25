package com.fiveplusone.a02mybytestream.mybytestreamdemo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("day18-code\\aaa\\test.docx");
        FileOutputStream fos = new FileOutputStream("day18-code\\aaa\\bbb\\test114514.docx");

        int b;
        while((b=fis.read())!=-1){
            fos.write(b);
        }

        fos.close();
        fis.close();
    }
}
