package com.cjs.homeworkOJ.finalAns;

public class Five {
    public static int catalan(int n){
        if (n<=3) return 1;
        int sum = 0;
        for (int i =2;i<n;i++){
            //卡特兰数递推
            sum += catalan(i)*catalan(n-i+1);
        }
        return sum;
    }
}
