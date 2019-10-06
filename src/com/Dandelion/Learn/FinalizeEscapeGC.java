package com.Dandelion.Learn;

public class FinalizeEscapeGC {
    private static FinalizeEscapeGC SAVE_HOOK = null;

    private void isAlive(){
        System.out.println("yes,i am alive :)");
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }


    public static void main(String[] args) throws InterruptedException {
        //对象第一次拯救自己
        SAVE_HOOK = null;
//        Runtime runtime = Runtime.getRuntime();
//        runtime.runFinalization();
        System.gc();//如今的gc函数已经不调用本对象的finalize函数了，依次调用的是Runtime下的native gc()方法
        //因为finalize方法优先级很低，所以暂停0.5秒以等待他
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead :(");
        }

        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待他
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead :(");
        }
    }
}
