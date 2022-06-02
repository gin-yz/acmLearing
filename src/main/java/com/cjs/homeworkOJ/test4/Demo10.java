package com.cjs.homeworkOJ.test4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author jinsheng
 * @date 2022年03月22日 10:10
 */
public class Demo10 {
    public static String longestCommonPrefix(String[] strs) {
        int len = strs[0].length();

        for(int i = 1;i<strs.length;i++){
            char[] array = strs[i].toCharArray();
            for(int j = 0;j<Math.min(array.length,len);j++){
                if(strs[0].charAt(j)!=array[j]){
                    len = j;
                    break;
                }
            }
            len = Math.min(len,array.length);
        }

        return strs[0].substring(0,len);
    }
    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"flower", "flow", "flight"});

        System.out.println(s);

        HashMap<String,String> map = new HashMap<>();

        map.remove("1");
        map.put("1","1");

    }
}


