package com.JavaFeaturesTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.classes.Person;
import java.util.stream.Stream;
import javax.xml.stream.util.StreamReaderDelegate;

public class JavaStreamPractise {
    public static void main(String[] args) {
        // 1
        solution1.solution();

        // 2
        solution2.solution();

        // 3
        solution3.solution();
    }

    private static class Actress extends com.classes.Person {
        public Actress(int age, String name) {
            super(age, name);
        }
    }

    private static class Actor extends com.classes.Person {
        public Actor(int age, String name) {
            super(age, name);
        }
    }
    static class solution1{
        private static void solution(){
            Set<Integer> set = new HashSet<>();
            for(int i = 1; i <= 100; i++) {
                set.add(i);
            }
            List<Integer> ls = set.stream()
                .filter(n-> n % 2 ==0)
                .collect(Collectors.toList());
                // .forEach(action -> System.out.println(action));
            System.out.println(ls.toArray());
        }
    }

    static class solution2{
        private static void solution(){
            List<String> ls2 = new ArrayList<>();
            ls2.add("zhangsan,23");
            ls2.add("lisi,24");
            ls2.add("wangwu,25");
            ls2.add("zhaoliu,26");
            ls2.add("tianqi,27");
            
            ls2.stream()
                .filter(s -> Integer.valueOf(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split(",")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.valueOf(s.split(",")[1]);
                    }
                }))
                .forEach((k, v) -> System.out.println(k + " " + v));
    
        }
    
    }
    
    static class solution3{
        private static void solution(){
            List<Actor> ls1 = new ArrayList<>();
            ls1.add(new Actor(23, "张国荣"));
            ls1.add(new Actor(24, "吴彦祖"));
            ls1.add(new Actor(55, "刘德华"));
            ls1.add(new Actor(25, "丁真"));

            List<Actress> ls2 = new ArrayList<>();
            ls2.add(new Actress(26, "范冰冰"));
            ls2.add(new Actress(27, "杨颖"));
            ls2.add(new Actress(28, "章若楠"));
            ls2.add(new Actress(29, "杨幂"));

            Stream<Actor> stream1 = ls1.stream()
                .filter(s -> s.getName().length() == 3)
                .limit(2);
            
            Stream<Actress> stream2 = ls2.stream()
                .filter(s -> s.getName().startsWith("杨"))
                .limit(1);
            
            Stream.concat(stream1, stream2)
                .forEach(action -> System.out.println(action.getName()));
        }
    }
}

