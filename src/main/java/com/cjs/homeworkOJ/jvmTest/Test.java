package com.cjs.homeworkOJ.jvmTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author jinsheng
 * @date 2021年10月25日 16:55
 */
public class Test {
    public static int lengthOfLongestSubstring(String s) {
        int[] aph = new int[26];
        char[] sArr = s.toCharArray();
        int left = 0;
        int right = 0;
        int len = 0;
        while(right<s.length()){
            int n = sArr[right] - 'a';
            aph[n]++;
            if(aph[n]==1){
                len = Math.max(len,right-left+1);
            }
            right++;
            while(aph[n]>1){
                int d = sArr[left] - 'a';
                aph[d]--;
                left++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int pwwkew = lengthOfLongestSubstring("pwwkew");

        System.out.println(pwwkew);
    }


}