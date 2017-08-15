package com.java8.lambda;

/**
 * Created by ZhangYuZhong on 2017/8/10.
 */
public class LambdaTest6 {
    public void test1(int x, int y){
        new Thread(() ->{
            int z = 100;
            int total = z+x+y;
            System.out.println("total->"+total);
        }).start();
    }

    public static void main(String[] args) {
        new LambdaTest6().test1(1,2);
    }
}
