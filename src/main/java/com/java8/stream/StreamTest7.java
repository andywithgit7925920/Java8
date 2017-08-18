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
    /*Stream<Integer> stream = Stream.iterate(0, x -> x + 3).limit(100);
        HashSet<Integer> set = stream.collect(HashSet::new, HashSet::add, HashSet::addAll);
        HashSet<Integer> set1 = stream.collect(Collectors.toCollection(HashSet::new));
        set1.forEach(System.out::println);*/
    /*Optional<Integer> optional = Stream.of(1,2,3).filter(x->x>1).reduce((x,y)->x+y);
        System.out.println(optional.get());*/
    @Test
    public void testStream1() {
        Optional<Student> studentOptional = Optional.of(new Student("user1",21));
        Optional<String> optionalStr = studentOptional.map(Student::getName);
        System.out.println(optionalStr.get());
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

    /**
     * Optional的迭代
     */
    @Test
    public void testStream2() {
        double x = 4d;
        Optional<Double> result1 = inverse(x).flatMap(StreamTest7::squareRoot);
        result1.ifPresent(System.out::println);
        Optional<Double> result2 = Optional.of(4.0).flatMap(StreamTest7::inverse).flatMap(StreamTest7::squareRoot);
        result2.ifPresent(System.out::println);
    }

    /**
     * 常用操作
     */
    @Test
    public void testOptional() {
        List<String> list = new ArrayList<String>() {
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
    public void testOptional2() {
        Integer[] arr = new Integer[]{4,5,6,7,8,9};
        Integer result = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElse(-1);
        System.out.println(result);
        Integer result1 = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElseGet(()->-1);
        System.out.println(result1);
        Integer result2 = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElseThrow(RuntimeException::new);
        System.out.println(result2);
    }
}
