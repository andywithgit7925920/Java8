package com.java8.stream;

import com.java8.testcase1.Actor;
import com.java8.testcase1.DataUtil;
import com.java8.testcase1.Director;
import com.java8.testcase1.Movie;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by ZhangYuZhong on 2017/8/1.
 * 改变元素
 */
public class StreamTest4 {
    /**
     * map把一种类型的流转换为另外一种类型的流
     * 将String数组中字母转换为大写
     */
    @Test
    public void testMap() {
        String[] arr = new String[]{"yes", "YES", "no", "NO"};
        Arrays.stream(arr).map(x -> x.toLowerCase()).forEach(System.out::println);
    }

    /**
     * flapMap：拆解流
     */
    @Test
    public void testFlapMap1() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).distinct().forEach(System.out::println);
    }

    /**
     * 2.找出票房在10亿以上的电影名称
     */
    @Test
    public void testFlapMap2() {
        List<Director> directors = DataUtil.getInstance().praseData();
        directors.stream().flatMap(x -> x.getMovies().stream()).filter(x -> BigDecimal.TEN.compareTo(x.getOfficeBox())<0).map(Movie::getMovieName).forEach(System.out::println);
    }

    /**
     * 3.列出参加过冯小刚电影的演员名单
     */
    @Test
    public void testFlapMap3() {
        List<Director> directors = DataUtil.getInstance().praseData();
        directors.stream().filter(x -> Objects.equals(x.getName(),"冯小刚")).flatMap(x -> x.getMovies().stream()).flatMap(x -> x.getDirectorList().stream()).map(Actor::getName).distinct().forEach(System.out::println);
    }
}
