package com.Dandelion.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ZConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入目标字符串：");
        String str = sc.nextLine();
        System.out.println("请输入排列行数：");
        int rows = sc.nextInt();
//        System.out.println(convert01(str, rows));
        System.out.println(convert02(str, rows));
    }

    private static String convert01(String s, int numRows) {
        ArrayList<ArrayList<Character>> totalList = new ArrayList<>();
        int T = 2 * numRows - 2;
        int len;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Character> charList = new ArrayList<>();
            totalList.add(charList);
        }
        while (s.length() != 0) {
            len = Math.min(s.length(), T);
            System.out.println(s);
            for (int i = 0; i < len; i++) {
                if (i < numRows) {
                    Character char1 = s.charAt(i);
                    totalList.get(i).add(char1);
                } else {
                    Character char2 = s.charAt(i);
                    totalList.get(2 * numRows - 2 - i).add(char2);
                }
            }
            s = s.substring(len);
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < totalList.get(i).size(); j++) {
                if ((int) totalList.get(i).get(j) != 0) {
                    str.append(totalList.get(i).get(j));
                }
            }
        }
        return str.toString();
    }

    private static String convert02(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> totalList = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            totalList.add(new StringBuilder());
        }
        int curRow = 0;
        boolean changeDirection = false;
        for (char c : s.toCharArray()) {
            totalList.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                changeDirection = !changeDirection;
            }
            curRow += changeDirection ? 1 : -1;
        }
        StringBuilder str = new StringBuilder();
        for (StringBuilder row : totalList) {
            str.append(row);
        }
        return str.toString();
    }
}
