package com.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangYuZhong on 2017/7/30.
 */
public class LambdaTest4 {
    public void doWork1(){
        Runnable runnable = ()->{
            System.out.println(this.toString());
            System.out.println("i am do work function! thanks!");
        };
        new Thread(runnable).start();
    }

    public void doWork2(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.toString());
                System.out.println("i am do work function! thanks!");
            }
        };
        new Thread(runnable).start();
    }
    public void doWork2(List list){
        Runnable runnable = ()->{
            System.out.println(this.toString());
            System.out.println("i am do work function! thanks!");
        };
        new Thread(runnable).start();
    }
    public static void main(String[] args) {
        new LambdaTest4().doWork1();
        new LambdaTest4().doWork2();
    }
}
