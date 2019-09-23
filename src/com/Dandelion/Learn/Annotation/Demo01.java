package com.Dandelion.Learn.Annotation;

import com.Dandelion.Learn.TestObject;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class Demo01 {

    @Override
    public String toString(){
        return "";
    }
    @Deprecated
    public static void test001(){
        System.out.println("test001");
    }


    public static void test002(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test001();
    }
}
