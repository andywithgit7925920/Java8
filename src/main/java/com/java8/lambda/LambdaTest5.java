package com.java8.lambda;

/**
 * Created by ZhangYuZhong on 2017/7/30.
 */
public class LambdaTest5 implements myInterface1,myInterface2{
    @Override
    public void getName() {
        myInterface1.super.getName();
    }

    public static void main(String[] args) {
        new LambdaTest5().getName();
    }
}
interface myInterface1{
    default void getName(){
        System.out.println("myInterface1 getName");
    };
}
interface myInterface2{
    default void getName(){
        System.out.println("myInterface2 getName");
    }
}
