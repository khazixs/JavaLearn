package com.Dandelion.Algorithm;

        import java.math.BigInteger;
        import java.util.Arrays;


public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(reverse2(1534236469));
        System.out.println(reverse2(-4760));
    }

    public static int reverse(int val) {
        String str = String.valueOf(val);
        if(val == 0){
            return 0;
        }
        int flag1 = 0;
        if(str.contains("-")){
            flag1 = 1;
        }
        if(str.indexOf("0") == str.length()-1){
           str = str.substring(0,str.length()-1);
        }
        String[] strArr = str.split("");
        for (int start = flag1, end = str.length() - 1; start < end; start++, end--) {
            String temp = strArr[end];
            strArr[end] = strArr[start];
            strArr[start] = temp;
        }
        String str1 = "";
        for (String s : strArr) {
            str1 = str1.concat(s);
        }
        if(str1.length()>=10){
            long x = Long.parseLong(str1);
            long top =(long) Integer.MAX_VALUE;
            long foot = (long) Integer.MIN_VALUE;
            if(x<foot||x>top){
                return 0;
            }
        }
        return Integer.parseInt(str1);
    }
    public static int reverse2(int val){
        int rev = 0;
        while (val != 0) {
            int pop = val % 10;
            //System.out.println("pop"+pop);
            val /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
            //System.out.println("rev"+rev);
        }
        return rev;
    }
}


