package com.cjs.acmLearing.GreedyLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CitySelectorDemo {
    public static void main(String[] args) {
        //存放所有的基站以及对应的城市
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> hashSet1 = new HashSet<>(Arrays.asList("上海", "北京", "天津"));
        HashSet<String> hashSet2 = new HashSet<>(Arrays.asList("广州", "北京", "深圳"));
        HashSet<String> hashSet3 = new HashSet<>(Arrays.asList("上海", "成都", "杭州"));
        HashSet<String> hashSet4 = new HashSet<>(Arrays.asList("上海", "天津"));
        HashSet<String> hashSet5 = new HashSet<>(Arrays.asList("杭州", "大连"));

        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("k3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);

        //未覆盖的地区
        HashSet<String> allAreas = new HashSet<String>() {
        };

        allAreas.addAll(hashSet1);
        allAreas.addAll(hashSet2);
        allAreas.addAll(hashSet3);
        allAreas.addAll(hashSet4);
        allAreas.addAll(hashSet5);

        HashSet<String> tempSet = new HashSet<>();

        //选择的基站
        HashSet<String> selectors = new HashSet<>();

        while (allAreas.size() != 0) {
            String maxKey = null;

            for (String key : broadcasts.keySet()) {
                //取出最大的set的值，并和未覆盖的地区取交集，得到一个基站未覆盖地区最大覆盖的数目
                HashSet<String> maxSet = new HashSet<>();
                if (broadcasts.get(maxKey) != null) {
                    maxSet.addAll(broadcasts.get(maxKey));
                    maxSet.retainAll(allAreas);
                }

                tempSet.clear();

                HashSet<String> areas = broadcasts.get(key);

                tempSet.addAll(areas);

                tempSet.retainAll(allAreas); //和未覆盖地区取交集

                if (tempSet.size() > 0 && tempSet.size() > maxSet.size()) maxKey = key;

            }

            if (maxKey != null) {
                selectors.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println("得到的选择结果是" + selectors);


    }
}
