package com.fiveplusone.a02mybytestream.mybytestreamdemo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("day18-code\\b.txt");
        FileOutputStream fos = new FileOutputStream(f1);

        fos.write(97);
        fos.close();
    }
}
