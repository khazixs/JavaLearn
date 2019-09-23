package com.Dandelion.Learn.Reflect;

public class ReflectionTest01 {
    public static void main(String[] args) throws ClassNotFoundException {
        String path = "com.Dandelion.Learn.Bean.User";
        Class clazz = Class.forName(path);
        //对象时表示或者封装一些数据。一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息会放到对应的Class对象中，这个Class对象就像一面镜子一样，通过这面镜子我们可以看到类的全部信息
        System.out.println(clazz);
        System.out.println(clazz.hashCode());

        Class strClazz = String.class;
        Class strClazz2 = path.getClass();
        System.out.println(strClazz == strClazz2);

        Class intClazz = int.class;

        int[] arr01 = new int[10];
        int[] arr02 = new int[10];
        int[][] arr03 = new int[30][3];

        System.out.println(arr01.getClass().hashCode());
        System.out.println(arr02.getClass().hashCode());
        System.out.println(arr03.getClass().hashCode());
        System.out.println(arr03.getClass());
    }
}
