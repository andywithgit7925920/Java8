package com.java8.stream;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ZhangYuZhong on 2017/8/7.
 * Optional
 */
public class StreamTest7 {
    @Test
    public void testStream1() {
        Stream<Integer> stream = Stream.iterate(0, x -> x + 3).limit(100);
        HashSet<Integer> set = stream.collect(HashSet::new, HashSet::add, HashSet::addAll);
        HashSet<Integer> set1 = stream.collect(Collectors.toCollection(HashSet::new));
        set1.forEach(System.out::println);
//        set.forEach(System.out::println);
//        stream.forEach(System.out::println);
//        Optional<Integer> max = stream.max((x, y)->Integer.compare(x,y));
//        if (max.isPresent()){
//            System.out.println(max.get());
//        }
//        long size = stream.count();
//        System.out.println(size);
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

    @Test
    public void testStream2() {
        double x = 4d;
        Optional<Double> result1 = inverse(x).flatMap(StreamTest7::squareRoot);
        result1.ifPresent(System.out::println);
        Optional<Double> result2 = Optional.of(4.0).flatMap(StreamTest7::inverse).flatMap(StreamTest7::squareRoot);
        result2.ifPresent(System.out::println);
    }

    @Test
    public void testOptional(){
        List<String> list = new ArrayList<String>(){
            {
                add("user1");
                add("user2");
            }
        };
        Optional<String> opt = Optional.of("andy with u");
        opt.ifPresent(list::add);
        list.forEach(System.out::println);
    }

    @Test
    public void testOptional2(){
        Optional<String> result = Optional.of("andy with u");
        result = Optional.empty();
        String finalResult = result.orElse("1");
        System.out.println(finalResult);
        finalResult = result.orElseGet(()->System.getProperty("user.dir"));
        finalResult = result.orElseThrow(NoSuchElementException::new);
        System.out.println(finalResult);
    }
}
