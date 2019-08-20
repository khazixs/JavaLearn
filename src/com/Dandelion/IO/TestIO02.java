package com.Dandelion.IO;

import java.io.*;

public class TestIO02 {
    public static void main(String[] args) throws Exception {
        File file = new File("text.txt");
        Writer writer = new FileWriter(file,true);//在这里追加第二个参数就不会将原有内容覆盖掉
        writer.write("加油");
        writer.close();
        Reader reader = new FileReader(file);
        char[] flush = new char[1024];
        int len = -1;
        while((len=reader.read(flush))!=-1){
            String str = new String(flush,0,len);
            System.out.println(str);
        }
        reader.close();
    }
}
