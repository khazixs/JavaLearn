package com.Dandelion.Learn;

public class LambdaTest {
    public static void main(String[] args) {
        //局部内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("I like Lambda3");
            }
        }
        ILike like = new Like();
        ILike like2 = new Like2();
        ILike like3 = new Like3();
        like.lambda();
        like2.lambda();
        like3.lambda();
        //方法内部类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like Lambda4");
            }
        };
        like4.lambda();
        //Lambda 方法：
        ILike like5 = () -> {
            System.out.println("I like Lambda5");
        };
        like5.lambda();
    }

    //静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like Lambda2");
        }
    }
}

interface ILike {
    void lambda();
}

//外部类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like Lambda");
    }
}