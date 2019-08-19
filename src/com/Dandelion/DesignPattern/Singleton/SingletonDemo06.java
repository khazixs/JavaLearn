package com.Dandelion.Designpattern.Singleton;

import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/*测试懒汉式单例模式（如何防止反射和反序列化漏洞）*/
public class SingletonDemo06 implements Serializable {
    private static SingletonDemo06 s;

    private SingletonDemo06() {
        if(s!=null){
            throw new RuntimeException();
        }
    }
    //判断是否为空，用的时候再加载，必须加同步，否则线程不安全，调用效率低
    public static synchronized SingletonDemo06 getInstance() {
        if (s == null) {
            s = new SingletonDemo06();
        }
        return s;
    }
    //反序列化时，如果定义了readResolve方法则直接返回此方法的指定对象，而不需要单独创建新对象
    private Object readResolve() throws ObjectStreamException {
        return s;
    }
}
