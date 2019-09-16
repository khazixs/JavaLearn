package com.Dandelion.Algorithm;

public class EatPeach {
    public static void main(String[] args) {
        System.out.println(calculate(10,3));
    }

    private static int calculate(int value,int base){
        int total = 0;
        int leave = 0;
//        int n = (int) (Math.log(value)/Math.log(base));
        while(value>=3){
            total+=value;
            leave += value%3;
            total+=3;
            if(leave>=3){
                value += 1;
            }
        }
        return total;
    }
}

