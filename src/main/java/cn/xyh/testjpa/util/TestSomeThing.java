package cn.xyh.testjpa.util;

import java.util.*;
import java.util.function.Predicate;

/**
 * Create by xyh on 2018/11/21
 */
public class TestSomeThing {


    public static void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
    }

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java","Python","scala","Shell","R");

        filterTest(languages, a -> a.contains("a"));

    }
}
