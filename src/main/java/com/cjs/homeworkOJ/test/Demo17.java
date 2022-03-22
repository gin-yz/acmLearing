package com.cjs.homeworkOJ.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jinsheng
 * @date 2021年10月18日 17:12
 */
public class Demo17 {

    //num 0,1,2,3
    private static String plusOne(String origin,int num){
        char[] array = origin.toCharArray();
        if(array[num]=='9'){
            array[num] = '0';
        }else{
            array[num] += 1;
        }

        return new String(array);
    }

    private static String minusOne(String origin,int num){
        char[] array = origin.toCharArray();
        if(array[num]=='0'){
            array[num] = '9';
        }else{
            array[num] -=1;
        }
        return new String(array);
    }

    public static int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>();
        for(String dead: deadends) deadSet.add(dead);
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> isVisited = new HashSet<>();
        queue.add("0000");
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                String node = queue.removeFirst();
                if(node.equals(target)) return depth;
                isVisited.add(node);
                for(int j = 0;j<4;j++){
                    String plusOneNode = plusOne(node,j);
                    String minusOneNode = minusOne(node,j);
                    if((!deadSet.contains(plusOneNode))&&(!isVisited.contains(plusOneNode))){
                        queue.addLast(plusOneNode);
                    }
                    if((!deadSet.contains(minusOneNode))&&(!isVisited.contains(minusOneNode))){
                        queue.addLast(minusOneNode);
                    }
                }
            }
            depth++;
        }
        return depth;
    }

//    ["0201","0101","0102","1212","2002"]
//            "0202"
    public static void main(String[] args) {
        int i = openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");

        System.out.println(i);
    }
}
