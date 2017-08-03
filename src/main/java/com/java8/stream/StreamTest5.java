package com.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by ZhangYuZhong on 2017/8/2.
 * 流的拆分和合并
 */
public class StreamTest5 {
    String[] arr1 ;
    String[] arr2 ;
    String[] arr3;
    @Before
    public void init(){
        arr1 = new String[]{"a","b","c","d"};
        arr2 = new String[]{"d","e","f","g"};
        arr3 = new String[]{"i","j","k","l"};
    }
    /**
     * limit，限制从流中获得前n个数据
     */
    @Test
    public void testLimit(){
        Stream.iterate(1,x->x+2).limit(10).forEach(System.out::println);
    }

    /**
     * skip，跳过前n个数据
     */
    @Test
    public void testSkip(){
        Stream.of(arr1).skip(2).limit(1).forEach(System.out::println);
        Stream.iterate(1,x->x+2).skip(1).limit(5).forEach(System.out::println);
    }

    /**
     * 可以把两个stream合并成一个stream（合并的stream类型必须相同）
     * 只能两两合并
     */
    @Test
    public void testConcat(){
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        Stream.concat(stream1,stream2).distinct().forEach(System.out::println);
     }

     public void peek1(int x){
         System.out.println(Thread.currentThread().getName()+"->peek1->"+x);
     }
    public void peek2(int x){
        System.out.println(Thread.currentThread().getName()+"->peek2->"+x);
    }
    public void peek3(int x){
        System.out.println(Thread.currentThread().getName()+"->final result->"+x);
    }
    /**
     * peek，监控方法
     */
    @Test
    public void testPeek(){
        Stream<Integer> stream = Stream.iterate(1,x->x+1).limit(10);
        stream.peek(this::peek1).filter(x->x>5)
                .peek(this::peek2).filter(x->x<8)
//                .peek(this::peek3);
                .forEach(System.out::println);
    }

    @Test
    public void testPeekPal(){
        Stream<Integer> stream = Stream.iterate(1,x->x+1).limit(10).parallel();
        stream.peek(this::peek1).filter(x->x>5)
                .peek(this::peek2).filter(x->x<8)
//                .peek(this::peek3);
                .forEach(System.out::println);
    }
}
