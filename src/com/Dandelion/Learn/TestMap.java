package com.Dandelion.Learn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> m1 = new HashMap<>();
        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");
        System.out.println(m1);
        System.out.println(m1.size());
        System.out.println(m1.get(1).hashCode());
        Map<Integer,String> treemap1 = new TreeMap<>();
        treemap1.put(20,"aa");
        treemap1.put(3,"bb");
        treemap1.put(6,"cc");

        //按照key递增的方式排序
        for(Integer key:treemap1.keySet()){
            System.out.println(key+"-----"+treemap1.get(key));
        }

    }
}
