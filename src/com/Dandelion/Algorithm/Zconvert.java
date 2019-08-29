package com.Dandelion.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Zconvert {
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
//        String s="1234567890";
//        System.out.println(s.substring(3));
    }

    public static String convert(String s, int numRows) {
        List<char[]> totalList = new ArrayList<>();
        int T = 2 * numRows - 2;
        int len = 0;
        int pc = 0;
        String str = "";
        for (int i = 0; i < numRows; i++) {
            totalList.add(new char[s.length() / T + 1]);
        }
        while (s.length() != 0) {
            if (s.length() < T) {
                len = s.length();
            } else {
                len = T;
            }
            for (int i = 0; i < len; i++) {
                if (i < numRows) {
                    Character char1 = s.charAt(i);
                    totalList.get(i)[pc] = char1;
                } else {
                    Character char2 = s.charAt(i);
                    totalList.get(2 * numRows - 1 - i)[pc] = char2;
                }
            }
            pc++;
            s = s.substring(len);
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < pc; j++) {
                if ((int) totalList.get(i)[j] != 0) {
                    str = str + totalList.get(i)[j];
                }
            }
        }
        return str;
    }
}
