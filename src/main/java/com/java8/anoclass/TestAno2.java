package com.java8.anoclass;

import org.junit.Test;

/**
 * Created by ZhangYuZhong on 2017/8/9.
 */
public class TestAno2 {
    public void test1(String a ){
        C1 c1 = new C1(){
            @Override
            public void test2() {
                System.out.println("a->"+a);
                System.out.println("this is a modify test2");;
            };
            public void test1(){
                System.out.println("a->"+a);
                System.out.println("this is a modify test1");
            };
        };
        c1.test2();
        c1.test1();
    }
    @Test
    public void test2(){
        new TestAno2().test1("andy");
    }
}
abstract class F1{
    abstract void test1();
}
interface F2{
    abstract void test2();
}
class C1 extends F1 implements F2{

    @Override
    void test1() {
        System.out.println("test1...");
    }

    @Override
    public void test2() {
        System.out.println(String.join("->","C1","test2"));
    }
}