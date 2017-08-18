package com.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 聚合操作
 * Created by ZhangYuZhong on 2017/8/16.
 */
public class StreamTest9 {
    String[] arr;
    @Before
    public void init(){
        arr = new String[]{"b","ab","abc","abcd","abcde"};
    }

    /**
     * max、min
     * 最大最小值
     */
    @Test
    public void testMaxAndMin(){
        Stream.of(arr).max(Comparator.comparing(String::length)).ifPresent(System.out::println);
        Stream.of(arr).min(Comparator.comparing(String::length)).ifPresent(System.out::println);
    }

    /**
     * count
     * 计算数量
     */
    @Test
    public void testCount(){
        long count = Stream.of(arr).count();
        System.out.println(count);
    }

    /**
     * findFirst
     * 查找第一个
     */
    @Test
    public void testFindFirst(){
        String str =  Stream.of(arr).parallel().filter(x->x.length()>3).findFirst().orElse("noghing");
        System.out.println(str);
    }

    /**
     * findAny
     * 找到所有匹配的元素
     * 对并行流十分有效
     * 只要在任何片段发现了第一个匹配元素就会结束整个运算
     */
    @Test
    public void testFindAny(){
        Optional<String> optional = Stream.of(arr).parallel().filter(x->x.length()>3).findAny();
        optional.ifPresent(System.out::println);
    }

    /**
     * anyMatch
     * 是否含有匹配元素
     */
    @Test
    public void testAnyMatch(){
        Boolean aBoolean = Stream.of(arr).anyMatch(x->x.startsWith("a"));
        System.out.println(aBoolean);
    }
}
