package com.Dandelion.Designpattern.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/*测试懒汉式单例模式（如何防止反射和反序列化漏洞）*/
public class Client2 {
    public static void main(String[] args) throws Exception {
        SingletonDemo06 s1 = SingletonDemo06.getInstance();
        SingletonDemo06 s2 = SingletonDemo06.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        //反射破解单例及解决
//        Class<SingletonDemo06> clazz = (Class<SingletonDemo06>)Class.forName("com.Dandelion.Designpattern.Singleton.SingletonDemo06");
//        Constructor<SingletonDemo06> c = clazz.getDeclaredConstructor(null);
//        c.setAccessible(true);
//        SingletonDemo06 s3 = c.newInstance();
//        System.out.println(s3);
        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
        SingletonDemo06 s3 = (SingletonDemo06)ois.readObject();
        System.out.println(s3);
    }
}
