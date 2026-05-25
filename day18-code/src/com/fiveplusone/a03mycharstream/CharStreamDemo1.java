package com.fiveplusone.a03mycharstream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(new File("day18-code\\aaa\\333.txt"));
        int ch;
        while((ch = fr.read())!=-1){
            System.out.print((char)ch);
        }
        fr.close();
    }
}
