package com.cjs.homeworkOJ.test;

/**
 * @author jinsheng
 * @date 2021年10月16日 20:14
 */
public class Demo13 {


    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int start = 1;

        int[] memo = new int[s.length()];
        memo[0] = 1;
        if (s.length() >= 2 && (s.charAt(0) == '1' || s.charAt(0) == '2') && s.charAt(1) == '0') {
            memo[0] = 0;
            memo[1] = 1;
            start =2;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) != '1') == (s.charAt(i - 1) != '2'))
                return 0;
            if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2') && s.charAt(i + 1) == '0') {
                memo[i] = memo[i - 1];
                memo[i + 1] = memo[i - 1];
                i++;
                continue;
            }
            if (judgeTwo(s.charAt(i - 1), s.charAt(i))) {
                if (i < 2) {
                    memo[i] = memo[i - 1] + 1;
                } else {
                    memo[i] = memo[i - 1] + memo[i - 2];
                }
            } else
                memo[i] = memo[i - 1];
        }

        return memo[s.length() - 1];
    }


    public static boolean judgeTwo(int pre, int rear) {
        if (pre == 0) {
            return false;
        } else if (pre == '1') {
            return true;
        } else if (pre == '2') {
            return rear >= '0' && rear <= '6';
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int i = numDecodings("207");
        System.out.println(i);
    }
}
