package com.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 * 延迟执行
 * Created by ZhangYuZhong on 2017/7/30.
 */
public class StreamTest2 {
    Student[] stuArr;
    Random random;

    @Before
    public void init() {
        random = new Random();
        stuArr = new Student[100];
        for (int i = 0; i < 100; i++) {
            stuArr[i] = new Student("student" + i, random.nextInt(50) + 50);
        }
    }

    public boolean filter(Student s) {
        System.out.println("begin compare");
        return s.getScore() > 85;
    }

    @Test
    public void test() {
        Stream<Student> stream = Stream.of(stuArr).filter(this::filter);
        System.out.println("split-------------------------------------");
        List<Student> studentList = stream.collect(toList());
    }

    @Test
    public void test1(){
        Stream<String> stream = Stream.generate(()->"user").limit(20);
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }
}
