package com.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ZhangYuZhong on 2017/7/25.
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        new LambdaTest1().testThread_();
    }


    @Test
    public void test1(){
        List<Student> studentList = new ArrayList<Student>(){
            {
                add(new Student("stu1",100.0));
                add(new Student("stu2",97.0));
                add(new Student("stu3",96.0));
                add(new Student("stu4",95.0));
            }
        };
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getScore(),o2.getScore());
            }
        });
        System.out.println(studentList);
    }

    /**
     * 多个参数
     * 可以不带参数类型
     */
    @Test
    public void test1_(){
        List<Student> studentList = new ArrayList<Student>(){
            {
                add(new Student("stu1",100.0));
                add(new Student("stu2",97.0));
                add(new Student("stu3",96.0));
                add(new Student("stu4",95.0));
            }
        };
        Collections.sort(studentList,(s1,s2)-> Double.compare(s1.getScore(),s2.getScore()));
        System.out.println(studentList);
    }

    @Test
    public void testThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello, i am thread!");
            }
        }).start();
    }

    /**
     * 无参
     */
    @Test
    public void testThread_(){
        new Thread(()-> {
            System.out.println("hello, i am thread!");
        }).start();
    }

    /**
     * 一个参数，可以省略参数的括号
     */
    @Test
    public void testOneParameter(){
        testOnePar(x-> System.out.println(x));
        testOnePar(System.out::print);
    }
    /**
     * 需要单个参数
     */
    public static void testOnePar(FunctionalInterface functionalInterface){
        functionalInterface.single("msg");
    }
}
class Student{
    private String name;
    private Double score;

    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{"
                + "\"name\":\"" + name + "\""
                + ", \"score\":\"" + score + "\""
                + "}";
    }
}