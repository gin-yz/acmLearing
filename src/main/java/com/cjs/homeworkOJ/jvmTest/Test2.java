package com.cjs.homeworkOJ.jvmTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jinsheng
 * @date 2021年10月25日 16:57
 */
public class Test2 {
    public static int[] findDiagonalOrder(int[][] mat) {
        int len = mat.length;
        int[] res = new int[len*len];
        int index = 0;
        for(int num =0 ;num<len;num++){
            if(num%2==0){
                for(int i = num;i>=0;i--){
                    int j = num-i;
                    res[index] = mat[i][j];
                    index++;
                }
            }else{
                for(int i = 0;i<=num;i++){
                    int j = num-i;
                    res[index] = mat[i][j];
                    index++;
                }
            }
        }
        for(int num = len;num<=2*len-2;num++){
            if(num%2==0){
                for(int i = len-1;i>=0;i--){
                    int j = num-i;
                    if(j>len-1) break;
                    res[index] = mat[i][j];
                    index++;
                }
            }else{
                for(int j = len-1;j>=0;j--){
                    int i = num-j;
                    if(i>len-1) break;
                    res[index] = mat[i][j];
                    index++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        for (int i : findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})) {
//            System.out.println(i);
//        }
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        System.out.println(map.size());


        HashMap<Character,Integer> map = new HashMap<>();


    }
}
