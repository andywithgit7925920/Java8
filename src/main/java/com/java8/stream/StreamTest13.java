package com.java8.stream;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangYuZhong on 2017/8/20.
 * 并行流
 */
public class StreamTest13 {
    List<String> wordList;
    List<Integer> list;

    /**
     * 生成一亿条0-100之间的记录
     */
    @Before
    public void init() {
        wordList = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
                add("d");
                add("e");
                add("f");
                add("g");
            }
        };
        Random random = new Random();
        list = Stream.generate(() -> random.nextInt(100)).limit(100000000).collect(toList());
    }

    /**
     * tip
     */
    @org.junit.Test
    public void test1() {
        long begin1 = System.currentTimeMillis();
        list.stream().filter(x->(x > 10)).filter(x->x<80).count();
        long end1 = System.currentTimeMillis();
        System.out.println(end1-begin1);
        list.stream().parallel().filter(x->(x > 10)).filter(x->x<80).count();
        long end2 = System.currentTimeMillis();
        System.out.println(end2-end1);



        long begin1_ = System.currentTimeMillis();
        list.stream().filter(x->(x > 10)).filter(x->x<80).distinct().sorted().count();
        long end1_ = System.currentTimeMillis();
        System.out.println(end1-begin1);
        list.stream().parallel().filter(x->(x > 10)).filter(x->x<80).distinct().sorted().count();
        long end2_ = System.currentTimeMillis();
        System.out.println(end2_-end1_);

    }
    @org.junit.Test
    public void test1_() {
        long begin1 = System.currentTimeMillis();
        list.stream().filter(x->(x > 40)).filter(x->x<50).distinct().count();
        long end1 = System.currentTimeMillis();
        System.out.println(end1-begin1);
        list.stream().parallel().filter(x->(x > 40)).filter(x->x<50).distinct().count();
        long end2 = System.currentTimeMillis();
        System.out.println(end2-end1);
    }

    public void peek1(int x) {
        System.out.println(Thread.currentThread().getName() + ":->peek1->" + x);
    }

    public void peek2(int x) {
        System.out.println(Thread.currentThread().getName() + ":->peek2->" + x);
    }

    public void peek3(int x) {
        System.out.println(Thread.currentThread().getName() + ":->final result->" + x);
    }

    /**
     * peek，监控方法
     * 串行流和并行流的执行顺序
     */
    @org.junit.Test
    public void testPeek() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1).limit(10);
        stream.peek(this::peek1).filter(x -> x > 5)
                .peek(this::peek2).filter(x -> x < 8)
                .peek(this::peek3)
                .forEach(System.out::println);
    }

    @Test
    public void testPeekPal() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1).limit(10).parallel();
        stream.peek(this::peek1).filter(x -> x > 5)
                .peek(this::peek2).filter(x -> x < 8)
                .peek(this::peek3)
                .forEach(System.out::println);
    }

    /**
     * 延迟执行特性，在聚合操作之前都可以添加相应元素
     */
    @Test
    public void test() {
        Stream<String> words = wordList.stream();
        wordList.add("END");
        long n = words.distinct().count();
        System.out.println(n);
    }

    /**
     * 延迟执行特性，会产生干扰
     * nullPointException
     */
    @Test
    public void test2(){
        Stream<String> words1 = wordList.stream();
        words1.forEach(s -> {
            System.out.println("s->"+s);
            if (s.length() < 4) {
                System.out.println("select->"+s);
                wordList.remove(s);
                System.out.println(wordList);
            }
        });
    }
    @Test
    public void test3(){
        Stream<String> words1 = wordList.stream();
        words1.forEach(s -> {
            if (s.length() < 4) {
                System.out.println(s);
            }
        });
    }
}
