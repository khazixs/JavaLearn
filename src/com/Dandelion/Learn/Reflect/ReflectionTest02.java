package com.Dandelion.Learn.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        String path = "com.Dandelion.Learn.Bean.User";
        Class clazz = Class.forName(path);
        System.out.println(clazz.getName());//获得包名+类名
        System.out.println(clazz.getSimpleName());//获得类名
        //获得属性
        Field[] fields = clazz.getFields();//这个方法只能获得public修饰的
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field temp : fields2) {
            System.out.println(temp);
        }

        Method[] methods = clazz.getDeclaredMethods();
        Method m = clazz.getDeclaredMethod("getUname",null);
        Method m2 = clazz.getDeclaredMethod("setAge", int.class);
        //获得
    }
}
