package com.java8.anoclass;

import org.junit.Test;

/**
 * Created by ZhangYuZhong on 2017/8/8.
 */
public class TestAno1 {
    @Test
    public void test1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
    @Test
    public void test2(){
//        Thread thread = new Thread(){
//            public void run(){
//                System.out.println("aaa");
//            }
//        };
//        thread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("11111111111");
                System.out.println("44444444444");
            }
        }){
            @Override
            public void run() {
                System.out.println("222222222222");
                System.out.println("333333333333");
            }
        }.start();

    }

    @Test
    public void test3(){
        AnomonyClass1 anomonyClass = new AnomonyClass1() {
            @Override
            public void test1() {
                System.out.println("test1");
            }

            @Override
            public void test2() {
                System.out.println("test2");
            }
        };
        anomonyClass.test1();
        anomonyClass.test2();
    }

    @Test
    public void test4(){
        AnomonyClass2 anomonyClass2 = new AnomonyClass2() {
            @Override
            public void test1() {
                System.out.println("1111111111111");
            }

            @Override
            public void test2() {
                System.out.println("222222222222222");
            }
        };
        anomonyClass2.test1();
        anomonyClass2.test2();
    }

    @Test
    public void test5(){
        AnomonyClass3 anomonyClass3 = new AnomonyClass3(){
            @Override
            public void test1() {
                System.out.println(3333);
            }

            @Override
            public void test2() {
                System.out.println(4444);
            }
        };
        anomonyClass3.test1();
        anomonyClass3.test2();
    }
    @Test
    public void test6(){
        AnomonyClass4 anomonyClass4 = new AnomonyClass4(){
            @Override
            public void test1() {
                System.out.println(1111);
            }
        };
    }

    @Test
    public void test7(){
        Father1 father1 = new Father1(){
            @Override
            public void test1() {
                System.out.println("2222");
            }
        };
        father1.test1();
        father1.test2();
//        Child1 child1 = new Child1(){
//            @Override
//            public void test1() {
//                System.out.println("33333");
//            }
//        };
//child1.test1();
    }
}

interface AnomonyClass1{
    public abstract void test1();
    public abstract void test2();
}
abstract class AnomonyClass2{
    public abstract void test1();
    public abstract void test2();
}
class AnomonyClass3 implements AnomonyClass1{

    @Override
    public void test1() {
        System.out.println(1111);
    }

    @Override
    public void test2() {
        System.out.println(2222);
    }
}
class AnomonyClass4{
    public void test1(){
        System.out.println(111);
    }
}
class Father1{
    public void test1(){
        System.out.println("1111");
    }
    public void test2(){
        System.out.println(3333);
    }
}
class Child1 extends Father1{

}