package com.Dandelion.Chat3;

import java.io.Closeable;

//工具类
public class MyUtils3 {
    /*释放资源*/
    public static void close(Closeable... targets) {
        for (Closeable target : targets) {
            try {
                if (null != target) {
                    target.close();
                }
            } catch (Exception e) {
                    e.printStackTrace();
            }
        }
    }
}
