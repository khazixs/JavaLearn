package com.Dandelion.Learn;

public class TestAnonymousInnerClass {
    public static void test01(AA a){
        a.aa();
    }

    public static void main(String[] args) {
        TestAnonymousInnerClass.test01(new AA(){
            @Override
            public void aa() {
                System.out.println("TestAnonymousInnerClass.main(...)");
            }
        });
    }
}

interface AA{
    void aa();
}