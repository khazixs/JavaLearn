package com.Dandelion.Learn;

import java.text.SimpleDateFormat;
import java.util.*;

/**/
public class TimerTest01 {
    public static void main(String[] args) {
        Timer time = new Timer();
//        time.schedule(new MyTask(0),3000);
//        time.schedule(new MyTask(0),0,3000);//启动一个线程3000毫秒执行一次
        //Calendar cal = new GregorianCalendar(2019,7,23,10,30,0);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND,10);
        Date dt1 = cal.getTime();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println("开始时间是"+dateFormat.format(dt1));
        time.schedule(new MyTask(0),dt1,2000);
    }
}
class MyTask extends TimerTask{
    int count;
    public MyTask(int count){
        this.count = count;
    }
    @Override
    public void run() {
        count++;
        System.out.println(count+"---relax");
    }
}