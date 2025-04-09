package com.javaFeaturesTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImmutableSet {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "first");
        map.put("2", "second");
        map.put("3", "third");
        map.put("4", "fourth");
        map.put("5", "fifth");
        map.put("6", "sixth");
        map.put("7", "seventh");
        map.put("8", "eighth");
        map.put("9", "ninth");
        map.put("10", "tenth");
        
       Set<Entry<String,String>> entrySet = map.entrySet();
       Entry<String, String>[] arr = entrySet.toArray(new Entry[entrySet.size()]);
       Map<String, String> res = Map.ofEntries(arr);

       Iterator<Entry<String, String>> it = res.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, String> pair = (Entry<String, String>)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
