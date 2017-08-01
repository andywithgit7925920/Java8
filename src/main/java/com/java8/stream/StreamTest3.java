package com.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ZhangYuZhong on 2017/7/31.
 * 创建stream
 */
public class StreamTest3 {
    /**
     * 通过数组创建流
     */
    @Test
    public void testArrayStream(){
        //1.通过Arrays.stream
        int[] arr = new int[]{1,2,34,5};
        IntStream intStream = Arrays.stream(arr);
        Student[] studentArr = new Student[]{new Student("s1",29),new Student("s2",27)};
        Stream<Student> studentStream = Arrays.stream(studentArr);
        //2.通过Stream.of
        Stream<Integer> stream1 = Stream.of(1,2,34,5,65);
        Stream<int[]> stream2 = Stream.of(arr,arr);
        stream2.forEach(System.out::println);
    }

    /**
     * 通过集合创建流
     */
    @Test
    public void testCollectionStream(){
        List<String> strs = Arrays.asList("11212","dfd","2323","dfhgf");
        //创建普通流
        Stream<String> stream  = strs.stream();
        //并行执行的stream
        Stream<String> stream1 = strs.parallelStream();
    }

    @Test
    public void testEmptyStream(){
        //创建一个空的stream
        Stream<Integer> stream  = Stream.empty();
    }

    /**
     * 如果可以在遍历Stream元素的时候才去生成要处理的下一个元素，
     * 就有可能创建一个无限大的Stream
     * 可能的原因：因为stream的操作是延迟操作，在处理一个元素的时候拿一个元素
     * 可以轻松创建大量的数据
     */
    @Test
    public void testUnlimitStream(){
        //创建无限流
        //Stream.generate(()->"number"+new Random().nextInt()).limit(100).forEach(System.out::println);
        Stream.generate(()->new Student("name",10)).limit(20).forEach(System.out::println);
    }

    /**
     * 产生规律的数据
     */
    @Test
    public void testUnlimitStream1(){
        Stream.iterate(0,x->x+1).limit(10).forEach(System.out::println);
        //Stream.iterate(0,x->x).limit(10).forEach(System.out::println);
        Stream.iterate(0, UnaryOperator.identity()).limit(10).forEach(System.out::println);
    }
}
