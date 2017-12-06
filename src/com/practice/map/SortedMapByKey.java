package com.practice.map;

import java.util.*;

public class SortedMapByKey {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 122);
        map.put("bsh", 232);
        map.put("dsa", 12);
        map.put("aac", 192);


        System.out.println("未对 Key 进行排序：");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\"" + " : " + entry.getValue());
        }

        System.out.println("-----------------------------");

        System.out.println("使用 Collections.sort 对 Key 进行排序：");
        List<String> sortedKeys = new ArrayList(map.keySet());
        Collections.sort(sortedKeys);
        for (String key : sortedKeys){
            System.out.println("\"" + key + "\"" + " : " + map.get(key));
        }

        System.out.println("-----------------------------");

        System.out.println("使用 TreeMap 对 Key 进行排序：");
        Map<String, Integer> treeMap = new TreeMap<>(map);
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\"" + " : " + entry.getValue());
        }
    }

}
