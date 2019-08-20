package com.Dandelion.IO;

import java.io.*;

public class TestIO03 {
    public static void main(String[] args) throws IOException {
        byte[] datas = fileToByteArray("流程图.png");
        System.out.println(datas.length);
        byteArrayToFile(datas,"p-byte.png");
    }

    //图片转字节数组
    //1.图片到程序
//    2.程序到字节数组
    private static byte[] fileToByteArray(String filePath) throws IOException {
        File src = new File(filePath);
        InputStream is = new FileInputStream(src);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] flush = new byte[1024 * 10];
        int len = -1;

        while ((len = is.read(flush)) != -1) {//inputStream流读取内容，然后用ByteArrayOutputStream写到内存缓冲区
            baos.write(flush, 0, len);
        }
        baos.flush();
        return baos.toByteArray();
    }

    //字节数组转图片
//    1.字节数组到程序
//    2.程序到文件
    private static void byteArrayToFile(byte[] src, String filePath) throws IOException {
        InputStream is = new ByteArrayInputStream(src);
        OutputStream os = new FileOutputStream(filePath);
        byte[] flush = new byte[5];
        int len = -1;
        while ((len = is.read(flush))!=-1){
            os.write(flush,0,len);
        }
        os.flush();
        os.close();
    }
}
