package com.cjs.homeworkOJ.test;

/**
 * @author jinsheng
 * @date 2021年10月11日 10:01
 */
public class demo10 {


    public static int jump(int[] nums) {
        if(nums.length==1) return 0;
        int[] memo = new int[nums.length];

        for(int i=nums.length-2;i>=0;i--){
            memo[i] = Integer.MAX_VALUE;
            int minStep = 1001;
            for(int j = i+1;j<=i+nums[i];j++){
                if(j>=nums.length-1){
                    minStep = 1;
                    break;
                }
                if(memo[j]+1<minStep){
                    minStep = memo[j]+1;
                }
            }

            memo[i] = minStep;
        }

        return memo[0];
    }

    public static void main(String[] args) {
        int jump = jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);

    }
}
