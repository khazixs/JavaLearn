package com.Dandelion.Learn;

import com.sun.tools.javac.Main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("vv");
        set.add("aa");
        System.out.println(set);
        //用迭代器遍历set

        for(Iterator<String> iter = set.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
}
