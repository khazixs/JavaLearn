package com.Dandelion.Learn.Reflect;

import com.Dandelion.Learn.Bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest03 {
    public static void main(String[] args) throws Exception{
        String path = "com.Dandelion.Learn.Bean.User";
        Class clazz = Class.forName(path);

        User u = (User) clazz.newInstance();//调用User的无参构造方法
        Constructor c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
        User u2 = (User) c.newInstance(1001, 18, "zdk");
        //通过反射API调用普通方法
        User u3 = (User) clazz.newInstance();
        Method method = clazz.getDeclaredMethod("setUname", String.class);
        method.invoke(u3,"zdk");//u3.setUname("zdk")
        //通过反射API操作属性
        User u4 = (User) clazz.newInstance();
        Field f = clazz.getDeclaredField("uname");
        f.setAccessible(true);
        f.set(u4,"zdk");
        System.out.println(u4.getUname());
        System.out.println(f.get(u4));
    }
}
