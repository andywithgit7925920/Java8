package com.java8.lambda;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ZhangYuZhong on 2017/7/30.
 */
public class LambdaTest2 {
    public static void main(String[] args) {
//        test1_();
        test2_();
    }
    public static void test1_(){

        List<String> strLst = new ArrayList<String>(){
            {
                add("adfkjsdkfjdskjfkds");
                add("asdfasdfafgfgf");
                add("public static void main");
            }
        };
        Collections.sort(strLst,String::compareToIgnoreCase);
        System.out.println(strLst);
    }
    public static void test2_(){
        new Child().greet();
    }
}
class Father{
    public void greet(){
        System.out.println("Hello, i am function in father!");
    }
}
class Child extends Father{
    @Override
    public void greet() {
        Runnable runnable = super::greet;
        new Thread(runnable).start();
    }
}