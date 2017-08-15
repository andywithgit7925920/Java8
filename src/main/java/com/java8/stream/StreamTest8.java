package com.java8.stream;

import com.java8.testcase1.DataUtil;
import com.java8.testcase1.Director;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ZhangYuZhong on 2017/8/1.
 * filter and distinct
 */
public class StreamTest8 {
    List<Director> directors;

    @Before
    public void init() {
        directors = DataUtil.getInstance().praseData();
    }

    /**
     * 筛选出所有以数字开头的字符串
     */
    @Test
    public void testStream1() {
        String[] arr = new String[]{"1a", "2b", "3c", "dfdf", "ddeeff"};
        Arrays.stream(arr).filter(x -> Character.isDigit(x.charAt(0))).forEach(System.out::println);
    }

    /**
     * 筛选出所有录入了三部以上电影的导演信息
     */
    @Test
    public void testStream2() {
        directors.stream().filter(x -> x.getMovies().size() >= 3).forEach(x -> System.out.println("导演名字：" + x.getName() + ",电影数：" + x.getMovies().size()));
    }

    @Test
    public void testStream3(){
        Director[] arr = new Director[]{
                new Director("andy","china"),
                new Director("jsonBoune","us"),
                new Director("andy","china")
        };
        Stream<Director> stream = Arrays.stream(arr);
        /**
         * distinct方法背后调用hashCode和equals方法
         * String默认实现了hashCode和equals方法
         */
        stream.distinct().forEach(System.out::println);
    }
}

