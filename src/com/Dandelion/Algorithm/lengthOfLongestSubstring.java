package com.Dandelion.Algorithm;

import javax.xml.stream.events.Characters;
import java.util.*;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring01(str));
    }

    private static int lengthOfLongestSubstring01(String s) {
        Set<Character> set = new TreeSet<>(new MyComparator());
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
            System.out.println(set);
        }
        return ans;
    }
}
class MyComparator implements Comparator<Character>{
    @Override
    public int compare(Character o1, Character o2) {
        if (o1==o2){
            return 0;
        }
            return o1;
    }
}