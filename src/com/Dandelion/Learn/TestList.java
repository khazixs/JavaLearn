package com.Dandelion.Learn;

import com.sun.source.tree.InstanceOfTree;
import org.w3c.dom.TypeInfo;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/*测试Collection接口中的方法*/
public class TestList {
    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }

    public static void test01() {
        Collection<String> c = new ArrayList<>();
        c.add("aaaa");
        c.add("bbbb");
        c.remove("aaaa");//移出对象，对象还存在
        System.out.println(c);
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        System.out.println(c.contains("bbbb"));
        Object[] objs = c.toArray();
        System.out.println(objs);

        c.clear();
        System.out.println(c.isEmpty());
    }

    public static void test02() {
        List<String> list01 = new ArrayList<>();//Collection也是可使用的
        list01.add("a");
        list01.add("b");
        list01.add("c");
        list01.add("d");
        List<String> list02 = new ArrayList<>();
        list02.add("a");
        list02.add("f");
        list02.add("g");
        System.out.println("list01" + list01);
//        list01.removeAll(list02);//将list01中包含的list02中的所有元素全部移除，即删除相同元素[b,c,d]
        list01.retainAll(list02);//[a]取交集
        System.out.println("list01" + list01);
        System.out.println(list01.containsAll(list02));
        Set set;


    }

    public static void test03() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("B");
        System.out.println(list);
        list.add(2, "zdk");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.set(2, "wuliwu");
        System.out.println(list);
        System.out.println(list.indexOf("B"));
        System.out.println(list.lastIndexOf("B"));
        System.out.println(list.get(1));
        int a = 15;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a >> 1);
    }
}
