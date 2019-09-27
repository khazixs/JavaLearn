package com.Dandelion.Algorithm;

public class EatPeach {
    public static void main(String[] args) {
        System.out.println(calculate(11, 3));
    }

    private static int calculate(int value, int base) {
        int total = value;
        int leave = 0;
        while (value >= 3) {
            total += value / base;
            System.out.println("total:" + total);
            leave += value % base;
            value = value / base + leave;
            leave = 0;
            System.out.println("now:" + value);

        }
        return total;
    }
}

