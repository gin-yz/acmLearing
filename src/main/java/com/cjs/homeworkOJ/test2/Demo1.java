package com.cjs.homeworkOJ.test2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author jinsheng
 * @date 2021年11月19日 20:32
 */
public class Demo1 {

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int[] dp = new int[prices.length];
        int max = prices[prices.length-1];
        int[] dp2 = new int[prices.length];
        for(int i = 1;i<prices.length;i++){
            dp[i] = Math.max(dp[i-1],Math.max(prices[i]-min,0));
            min = Math.min(min,prices[i]);

            int k = prices.length-1-i;
            dp2[k] = Math.max(dp2[k+1],Math.max(max-prices[k],0));

            max = Math.max(max,prices[k]);
        }
        int maxValue = 0;

        for(int i = 0;i<prices.length;i++){
            maxValue = Math.max(dp[i]+dp2[i],maxValue);
        }

        return maxValue;
    }

    public static void main(String[] args) {
//        int i = maxProfit(new int[]{0,8,5,7,4,7});
//
//        System.out.println(i);

        int i1 = new Random().nextInt(2);

        System.out.println(i1);
    }
}
