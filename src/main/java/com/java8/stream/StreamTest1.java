package com.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ZhangYuZhong on 2017/7/30.
 * demo
 */
public class StreamTest1 {
    List<Student> stuList;
    Random random;

    @Before
    public void init() {
        random = new Random();
        stuList = new ArrayList<Student>() {
            {
                for (int i = 0; i < 100; i++) {
                    add(new Student("student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }

    //1列出班上超过85分的学生姓名，并按照分数降序输出用户名字
    @Test
    public void test1() {
        List<String> studentList = stuList.stream()
                .filter(x->x.getScore()>85)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(studentList);
    }

    @Test
    public void test1_(){
        List<Student> newList = new ArrayList<Student>();
        Iterator<Student> iterator = stuList.iterator();
        while (iterator.hasNext()){
            Student s = iterator.next();
            if (s.getScore()>85)
                newList.add(s);
        }
        Collections.sort(newList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getScore(),o1.getScore());
            }
        });
        for (Student s : newList)
            System.out.println(s.getName());
    }

    //2.统计出平均分数
    @Test
    public void test2() {
        stuList.stream()
                .mapToInt(Student::getScore)
                .average()
                .ifPresent(System.out::print);

    }
}