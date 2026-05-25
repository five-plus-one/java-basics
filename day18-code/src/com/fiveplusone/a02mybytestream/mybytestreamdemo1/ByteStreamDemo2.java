package com.fiveplusone.a02mybytestream.mybytestreamdemo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("day18-code\\aaa\\1.txt");
        int b;
        while((b=fis.read())!=-1){
            System.out.print((char)b);
        }
        fis.close();
    }
}
