package com.cjs.acmLearing.testExample;

import java.util.ArrayList;
import java.util.List;

public class FullSortDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6};
        List<Integer> tmpList = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        dfs(arr, 0, 3, tmpList, finalList);
        System.out.println(finalList);
    }


    public static void dfs(int[] arr, int start, int k, List<Integer> tmpList, List<List<Integer>> finalList) {
        if (k == tmpList.size()) {
            finalList.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            tmpList.add(arr[i]);

            dfs(arr, i + 1, k, tmpList, finalList);

            tmpList.remove((Object) arr[i]);
        }

    }
}
