package com.cjs.acmLearing.testExample;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class TestDemo2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{7,1,5,3,6,4,4};
//        int num = removeDuplicates(numbers);
        int num = maxProfit(numbers);
        System.out.println(num);
        System.out.println(Arrays.toString(numbers));

        containsDuplicate(numbers);


    }


    //    public static int removeDuplicates(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        int i = 0;
//        int j = 1;
//        while(j<nums.length){
//            if(nums[i] == nums[j]) j++;
//            else {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return i+1;
//    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0,j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 ||prices.length == 1) return 0;

        int[] maxPrices = new int[prices.length];
        Arrays.fill(maxPrices,0);

        for (int i = 1;i<prices.length;i++){
            maxPrices[i] = maxPrices[i-1];
            for (int j = i-1;j>=0;j--){
                if (prices[i]>prices[j]) maxPrices[i] = Math.max(maxPrices[i],maxPrices[j]+prices[i]-prices[j]);
            }
        }

        return maxPrices[maxPrices.length-1];
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>();
//        boolean b = integers.addAll(Arrays.stream(nums).boxed().toL);

        System.out.println(integers);

        return true;
    }

}
