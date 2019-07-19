package com.Dandelion.Learn;

public class TestGeneric {
    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<String>();
        MyCollection<Boolean> mb = new MyCollection<Boolean>();
        mc.set("lalal",0);
        mb.set(true,1);
        String b = mc.get(0);
        System.out.println(b);
        System.out.println(mb.get(1));
    }
}
class MyCollection<E>{
    Object[] obj = new Object[5];
    public void set(E e,int index){
        obj[index] = e;
    }

    public E get (int index){
        return (E)obj[index];
    }
}