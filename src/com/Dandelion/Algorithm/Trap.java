package com.Dandelion.Algorithm;

import java.util.Arrays;

public class Trap {
    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int total = 0;
        while (true) {
            height = remove(height);
            if (discoverPositiveNumber(height)) {
                height = dig(height);
                for (int i = 0; i < height.length; i++) {
                    if (height[i] < 0) {
                        total++;
                        height[i]++;
                    }
                }
            } else {
                break;
            }
        }
        return total;
    }

    private static int[] remove(int[] height) {
        int start = 0;
        int end = 0;
        int[] heightCopy;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                start = i;
                break;
            }
        }
        for (int i = height.length - 1; i >= start; i--) {
            if (height[i] > 0) {
                end = i;
                break;
            }else{
                end = start;
            }
        }
        heightCopy = Arrays.copyOfRange(height, start, end+1);
        return heightCopy;
    }

    private static int[] dig(int[] height) {
        for (int i = 0; i < height.length; i++) {
            height[i]--;
        }
        return height;
    }

    private static boolean discoverPositiveNumber(int[] height) {
        if (height.length==1){
            return false;
        }
        for (int value : height) {
            if (value > 0) {
                return true;
            }
        }
        return false;
    }
}
