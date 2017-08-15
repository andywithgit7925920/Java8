package com.java8.others;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by ZhangYuZhong on 2017/8/8.
 */
public class OthersTest1 {
    /**
     * String的join方法
     */
    @Test
    public void test1() {
        List<String> list = new ArrayList<String>() {
            {
                add("a1");
                add("a2");
            }
        };
        String[] arr = list.stream().toArray(String[]::new);
        String name = "andy";
        String msg = String.join(",", "my", "name", "is");
        String msg1 = String.join(",", list);
        String msg2 = String.join("->", "name", name);
        String msg3 = String.join(",", arr);
        System.out.println(msg3);
    }

    /**
     * File相关
     * try with resource
     * Files.lines,产生的流需要显式close
     */
    @Test
    public void test2() throws IOException, URISyntaxException {

        Path path = Paths.get(this.getClass().getClassLoader().getResource("Movie.json").toURI());
        try (Stream<String> stream = Files.lines(path);) {
            stream.forEach(System.out::println);
            Optional<String> optional = stream.filter(lines -> lines.contains("葛优")).onClose(() -> System.out.println("file closed")).findFirst();
            optional.ifPresent(System.out::println);
        }


    }

    /**
     * File相关
     * 捕获多个异常
     */
    @Test
    public void test3() {

        Path path = null;
        try {
            path = Paths.get(this.getClass().getClassLoader().getResource("Movie.json").toURI());
            Stream<String> stream = null;
            stream = Files.lines(path);
            stream.forEach(System.out::println);
            Optional<String> optional = stream.filter(lines -> lines.contains("葛优")).onClose(() -> System.out.println("file closed")).findFirst();
            optional.ifPresent(System.out::println);
        } catch (URISyntaxException|IOException e) {
            e.printStackTrace();
        }




    }

    /**
     * Objects.equals
     *
     */
    @Test
    public void test4() {
        Integer a = 1;
        Integer b = 1;
//        System.out.println(Objects.equals(a,b));
//        System.out.println(Objects.hashCode(null));
        System.out.println(Objects.hash(null));
    }

    @Test
    public void test5(){
        OthersTest1 othersTest1 =null;
//                OthersTest1 othersTest1 = new OthersTest1();
        othersTest1 = Objects.requireNonNull(othersTest1);

    }

}
