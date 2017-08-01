package com.java8.testcase1;

/**
 * Created by ZhangYuZhong on 2017/8/1.
 */
public class Actor {
    private String name;
    private Integer age;
    private String country;

    public Actor(String name, Integer age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return "{"
                + "\"name\":\"" + name + "\""
                + ", \"age\":\"" + age + "\""
                + ", \"country\":\"" + country + "\""
                + "}";
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
