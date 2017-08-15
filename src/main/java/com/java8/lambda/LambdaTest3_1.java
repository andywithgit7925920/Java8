package com.java8.lambda;

import org.junit.Test;

import java.lang.*;

/**
 * Created by ZhangYuZhong on 2017/8/8.
 * classCreate
 * 构造器引用2
 */
public class LambdaTest3_1 {
    @Test
    public void test_() {
        test(Stretegy1::new, 5);
        test(Stretegy2::new, 3);
    }

    public void test(ClassCreator classCreator, int times) {
        for (int i = 0; i < times; i++) {
            classCreator.get().apply("this is a msg");
        }
    }
}

interface BaseStretegy {
    public void apply(String msg);
}

class Stretegy1 implements BaseStretegy {

    @Override
    public void apply(String msg) {
        System.out.println("stretegy1 apply.." + msg);
    }
}

class Stretegy2 implements BaseStretegy {

    @Override
    public void apply(String msg) {
        System.out.println("stretegy2 apply.." + msg);
    }
}

@FunctionalInterface
interface ClassCreator<T extends BaseStretegy> {
    T get();
}
