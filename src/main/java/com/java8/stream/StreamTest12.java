package com.java8.stream;

import org.junit.*;
import org.junit.Test;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ZhangYuZhong on 2017/8/20.
 * 原始类型流
 */
public class StreamTest12 {
    DoubleStream doubleStream;
    IntStream intStream;

    /**
     * 原始类型流的初始化
     */
    @Before
    public void testStream1(){

        doubleStream = DoubleStream.of(0.1,0.2,0.3,0.8);
        intStream = IntStream.of(1,3,5,7,9);
        IntStream stream1 = IntStream.rangeClosed(0,100);
        IntStream stream2 = IntStream.range(0,100);
    }

    /**
     * 流与原始类型流的转换
     */
    @Test
    public void testStream2(){
        Stream<Double> stream = doubleStream.boxed();
        doubleStream = stream.mapToDouble(Double::new);
    }
}
