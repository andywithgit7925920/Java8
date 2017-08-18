package com.java8.stream;

/**
 * Created by ZhangYuZhong on 2017/8/14.
 */
public class Student implements Comparable<Student>{
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{"
                + "\"name\":\"" + name + "\""
                + ", \"score\":\"" + score + "\""
                + "}";
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
