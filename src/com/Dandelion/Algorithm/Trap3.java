package com.Dandelion.Algorithm;

import java.util.Arrays;

public class Trap3 {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap3(height));
    }

    private static int trap3(int[] height) {
        int res = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            maxRight[height.length - i - 1] = Math.max(maxRight[height.length - i], height[height.length - i]);
        }
//        System.out.println("maxLeft:"+ Arrays.toString(maxLeft));
//        System.out.println("maxRight:"+ Arrays.toString(maxRight));
        for (int i = 1; i < height.length - 1; i++) {
            int temp = Math.min(maxLeft[i], maxRight[i]);
            if (temp > height[i]) {
                res += temp - height[i];
            }
        }
        return res;
    }
}

