package com.javaFeaturesTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CollectionsUtilsTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        List<String> list = List.of("a", "b", "c", "d", "e");
        Collections.addAll(set, "a", "b", "c", "d", "e");
        Collections.shuffle(list);
        
    }
}
