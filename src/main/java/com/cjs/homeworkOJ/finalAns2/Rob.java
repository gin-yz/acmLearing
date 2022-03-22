package com.cjs.homeworkOJ.finalAns2;

public class Rob {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        boolean[] isVisited = new boolean[nums.length];
        int[] maxMoney=new int[nums.length];
        maxMoney[0]=nums[0];
        maxMoney[1]=Math.max(nums[0],nums[1]);
        for(int i=2; i<nums.length; i++){
            if (isVisited[i]) continue;
            maxMoney[i]=Math.max(nums[i]+maxMoney[i-2], maxMoney[i-1]);
            if (nums[i]+maxMoney[i-2]> maxMoney[i-1]) isVisited[i] = true;
        }
        return maxMoney[nums.length-1];
    }
}
