package com.Dandelion.Learn;

public class StrongReference {
    public static void main(String[] args) {
        testStrongReference();
    }
    private static void testStrongReference() {
        // 当 new byte为 1M 时，程序运行正常
        //byte[] buff = new byte[1024 * 1024 * 1];
        // 当 new byte为 1M 时，程序堆溢出
        byte[] buff = new byte[1024 * 1024 * 3];
    }
}
