package com.fiveplusone.a02mybytestream.mybytestreamdemo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("day18-code\\aaa\\1.MP4");
        FileOutputStream fos = new FileOutputStream("day18-code\\aaa\\bbb\\test222.MP4");
        long start = System.currentTimeMillis();
        int len;
        byte[] bytes = new byte[1024 * 1024 * 5];
        while((len = fis.read(bytes))!= -1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
