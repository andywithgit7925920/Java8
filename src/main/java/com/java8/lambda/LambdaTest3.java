package com.java8.lambda;

import javafx.scene.control.Button;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ZhangYuZhong on 2017/7/30.
 * 构造器引用1
 */
public class LambdaTest3 {

    @Test
    public void test1_(){
        List<Integer> list = this.asList(ArrayList::new ,1,2,3,4,5);
        list.forEach(System.out::println);
    }

    @Test
    public void test2_(){
        List<String> labels = Arrays.asList("aaa","bbb","ccc","ddd");
        Stream<Button> buttonStream = labels.stream().map(Button::new);
        List<Button> buttons = buttonStream.collect(Collectors.toList());
        Button[] buttons1 = buttonStream.toArray(Button[]::new);
    }

    public  <T> List<T> asList(MyCrator<List<T>> creator,T... a){
        List<T> list =  creator.create();
        for (T t : a)
            list.add(t);
        return list;
    }
}
interface MyCrator<T extends List<?>>{
    T create();
}