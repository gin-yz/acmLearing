package com.cjs.homeworkOJ.test2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * @author jinsheng
 * @date 2021年12月15日 00:11
 */
public class Demo5 {
    public static final char[] STR1 = new char[]{'n','i','c','o'};
    public static final char[] STR2 = new char[]{'n','i','c','o','n','i'};
    public static final char[] STR3 = new char[]{'n','i','c','o','n','i','c','o','n','i'};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
        String[] split=line.split(" ");
        int nums=Integer.parseInt(split[0]);
        int score1=Integer.parseInt(split[1]);
        int score2=Integer.parseInt(split[2]);
        int score3=Integer.parseInt(split[3]);
        String str=sc.nextLine();
        char[] array = str.toCharArray();
        if(nums<STR1.length){
            System.out.println(0);
        }
        long[] dp = new long[nums];
        for(int i = STR1.length-1;i<nums;i++){
            dp[i] = dp[i-1];
            if((i>=3)&&(array[i]==STR1[3])&&(array[i-1]==STR1[2])&&(array[i-2]==STR1[1])&&(array[i-3]==STR1[0])){
                dp[i] = Math.max(dp[i],i-4>=0?dp[i-4]+score1:score1);
            }
            if((i>=5)&&(array[i]==STR2[5])&&(array[i-1]==STR2[4])&&(array[i-2]==STR2[3])&&(array[i-3]==STR2[2])&&(array[i-4]==STR2[1])&&(array[i-5]==STR2[0])){
                dp[i] = Math.max(dp[i],i-6>=0?dp[i-6]+score2:score2);
            }
            if((i>=9)&&(array[i]==STR3[9])&&(array[i-1]==STR3[8])&&(array[i-2]==STR3[7])&&(array[i-3]==STR3[6])&&(array[i-4]==STR3[5])&&(array[i-5]==STR3[4])&&(array[i-6]==STR3[3])&&(array[i-7]==STR3[2])&&(array[i-8]==STR3[1])&&(array[i-9]==STR3[0])){
                dp[i] = Math.max(dp[i],i-10>=0?dp[i-10]+score3:score3);
            }
        }

        System.out.println(dp[nums-1]);
    }
}
