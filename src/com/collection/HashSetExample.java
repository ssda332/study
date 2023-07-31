package com.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");
        set.add("iBATIS");

        int size = set.size();
        System.out.println("size = " + size);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("JDBC")) {
                System.out.println(next);
                iterator.remove();
            }
        }

        System.out.println(set.size());
    }
}
