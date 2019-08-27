package com.Dandelion.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanNum {
    public static void main(String[] args) {
        System.out.println(romanToInt01("IVIIICMIXXLM"));
        System.out.println(romanToInt02("IVIIICMIXXLM"));
    }

    public static int romanToInt01(String s) {
        String[] roman = {"IV", "IX", "XL", "XC", "CD", "CM", "I", "V", "X", "L", "C", "D", "M"};
        int[] nums = {4, 9, 40, 90, 400, 900, 1, 5, 10, 50, 100, 500, 1000};
        int num = 0;
        while (s.length() > 0) {
            for (int i = 0; i < roman.length; i++) {
                if (s.startsWith(roman[i])) {
                    num += nums[i];
                    s = s.substring(roman[i].length());
                    break;
                }
            }
        }
        return num;
    }

    public static int romanToInt02(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int index = 0;
        int size = s.length();
        String temp = "";
        int sum = 0;
        System.out.println();
        for (index = 0; index < size; index++) {
            if (map.get(String.valueOf(s.charAt(index))) != null) {
                if ((index + 1) < size) {
                    if (map.get(String.valueOf(s.charAt(index + 1))) != null) {
                        temp = s.charAt(index) + String.valueOf(s.charAt(index + 1));
                        if (map.get(temp) != null) {
                            sum = sum + map.get(temp);
                            index++;
                            continue;
                        } else {
                            sum = sum + map.get(String.valueOf(s.charAt(index)));
                            continue;
                        }
                    }
                }
                sum = sum + map.get(String.valueOf(s.charAt(index)));
            }
        }
        return sum;
    }
}

