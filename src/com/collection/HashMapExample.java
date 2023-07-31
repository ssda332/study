package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);
        map.put("김영진", 50);
        map.put("백기선", 100);

        System.out.println(map.size());
        System.out.println("----------");


        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(map.get(next));
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator2 = entries.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Integer> next = iterator2.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }

    }
}
