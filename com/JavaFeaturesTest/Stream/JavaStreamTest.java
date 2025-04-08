package com.JavaFeaturesTest.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class JavaStreamTest {
    public static void main(String[] args) {
        // 单列集合获取Stream流
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        // Stream<String> stream1 = list.stream();
        // stream1.forEach(new Consumer<String>(){
        //     @Override
        //     public void accept(String s) {
        //         System.out.println(s);
        //     }
        // });
        list.stream().forEach(s -> System.out.println(s));
        // Stream<String> stream2 = list.stream();
        // stream2.forEach(s-> System.out.println(s));

        // 双列集合获取Stream流
        Map<String, String> map = new HashMap<>();
        map.put("张三-14", "男");
        map.put("李四-34", "男");
        map.put("王五-22", "男");
        map.put("赵六-30", "男");

        Set<String> keySet = map.keySet();
        Stream<String> stream2 = keySet.stream();
        stream2.forEach(s->System.out.println(s + " " + map.get(s)));

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream3 = entries.stream();
        stream3.forEach(entry->System.out.println(entry.getKey() + " " + entry.getValue()));

        map.keySet().stream()
            .filter(s-> !(s.startsWith("张")))
            .map(s -> Integer.valueOf(s.split("-")[1]))
            .forEach(action->System.out.println(action));
        // 数组获取Stream流
        int[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).forEach(s->System.out.println(s));
        Stream.of("1", 2).forEach(action->System.out.println(action.getClass().toString()));
    }
}
