package com.Dandelion.Learn.Reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/*
 * 使用反射读取注解信息，模拟处理注解信息的流程
 * */
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class clazz = Class.forName("com.Dandelion.Learn.Reflect.Student01");
        //获得类的所有有效注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
        //获得类的指定的注解
        Table01 tb01 = (Table01) clazz.getAnnotation(Table01.class);
        System.out.println(tb01.value());

        //获得类的属性的注解
        Field f = clazz.getDeclaredField("studentName");
        Field01 field01 = f.getAnnotation(Field01.class);
        System.out.println(field01.columnName() + "--" + field01.type() + "--" + field01.length());
        //可以根据获得的表名、字段的信息，拼出DDL语句，使用JDBC执行这个SQL，在数据库中生成相关的表
    }
}
