package com.cjs.homeworkOJ.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinsheng
 * @date 2021年10月13日 10:54
 */
public class Demo12 {

    public static int[] maxProfit(int[] prices) {
        int[] memo = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diffValue = prices[i] - prices[j];
                if (j >= 2) {
                    if (diffValue > 0)
                        memo[i] = Math.max(memo[i], memo[j - 2] + diffValue);
                    else
                        memo[i] = Math.max(memo[i], memo[j]);
                } else {
                    if(diffValue >0)
                        memo[i] = Math.max(memo[i], diffValue);
                    else
                        memo[i] = Math.max(memo[i], memo[j]);
                }
            }
        }

        return memo;
    }

    public static int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int sum = 0;

        int leftMaxElement = height[0];
        for(int i=1;i<height.length;i++){
            leftMaxElement = Math.max(height[i],leftMaxElement);
            leftMax[i] = leftMaxElement;
        }

        int rightMaxElement = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightMaxElement = Math.max(height[i],rightMaxElement);
            rightMax[i] = rightMaxElement;
        }

        for(int i =0;i<height.length;i++){
            sum+= Math.min(leftMax[i],rightMax[i]) - height[i];
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] i = maxProfit(new int[]{1, 4, 2});
//
//        System.out.println(i);

        String chenjinsheng = "chenjinsheng";
        System.out.println(chenjinsheng.startsWith("chen"));
        System.out.println(chenjinsheng.length());


//        "aaaaaaa"
//        ["aaaa","aaa"]

//        boolean b = wordBreak("aaaaaaa", List.of("aaaa", "aaa"));

        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

        System.out.println(trap);

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length()+1];

        for(int i =0;i<s.length();i++){
            String subCompareStr = s.substring(i);
            for(String word : wordDict){
                if(subCompareStr.startsWith(word)&&i+word.length()<=s.length()){
                    if(i==0){
                        memo[i+word.length()] = true;
                    }else{
                        memo[i+word.length()] = memo[i]||memo[i+word.length()];
                    }
                }
            }
        }

        return memo[s.length()];
    }
}
