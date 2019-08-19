package com.Dandelion.Learn;

import java.util.*;

/*Collections辅助类的使用*/
public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0;i<10;i++){
            list.add("gao:"+i);
        }
        System.out.println(list);
        Collections.shuffle(list);//随机排列list中的元素
        System.out.println(list);
        Collections.reverse(list);//逆序排列
        System.out.println(list);
        Collections.sort(list);//按递增顺序排列。自定义类的使用：Comparable接口
        System.out.println(list);
        //二分法查找
        System.out.println(Collections.binarySearch(list,"gao:1"));
    }

}
