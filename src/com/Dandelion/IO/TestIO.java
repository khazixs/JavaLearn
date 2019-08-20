package com.Dandelion.IO;

import java.io.*;

public class TestIO {
    public static void main(String[] args) throws Exception {
        File src = new File("text.txt");
        OutputStream os = new FileOutputStream(src);
        String str = "asda  ada w2wda ";
        //编码
        byte[] txt = str.getBytes();
        os.write(txt);
        os.flush();
        os.close();
        InputStream is = new FileInputStream(src);
//        byte[] temp = new byte[1024];
//        int len = -1;
//        while ((len = is.read(temp)) != -1) {
//            //解码
//            System.out.println(new String(temp,0,len));
//        }
        int x = -1;
        while ((x = is.read()) != -1) {
            System.out.println((char) x);
        }
    }
}
