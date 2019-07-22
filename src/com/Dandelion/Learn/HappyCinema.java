package com.Dandelion.Learn;
/*快乐影院*/
import java.util.*;
public class HappyCinema {
    public static void main(String[] args) {
        //影院可用位置
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(6);
        available.add(7);
        //顾客一需要位置
        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);
        //顾客二需要位置
        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(3);
        seats2.add(6);
        Cinema c= new Cinema(available,"happyCinema");
        new Thread(new Customer(c,seats1),"Jack").start();
        new Thread(new Customer(c,seats2),"Nick").start();
    }
}
class Customer implements Runnable{
    Cinema cinema;
    List<Integer> seats;

    public Customer(Cinema cinema,List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
//        并发，同步块
        synchronized (cinema){
            boolean flag = cinema.bookTickets(seats);
            if(flag){
                System.out.println("出票成功"+Thread.currentThread().getName()+"-<位置是："+seats);
            }else{
                System.out.println("出票失败"+Thread.currentThread().getName()+"-<票数不够");
            }
        }

    }
}
class Cinema{
    List<Integer> available;//可用位置
    String name;

    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }
    //购票
    public boolean bookTickets(List<Integer> seats){
        System.out.println("欢迎选购"+this.name+"可用位置为："+available);
        List<Integer>copy = new ArrayList<Integer>();
        copy.addAll(available);
        //相减
        copy.removeAll(seats);
        //判断大小
        if(available.size()-copy.size()!=seats.size()){
            return false;
        }
        //成功
        available = copy;
        return true;
    }
}