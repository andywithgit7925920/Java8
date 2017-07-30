package com.java8.date;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.security.jca.GetInstance;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * Created by ZhangYuZhong on 2017/7/30.
 */
public class Test1 {
    public static void main(String[] args) {
//        testInstant();
//        testLocalDate();
//        testLocalTime();
        testZoneId();
    }
    public static void run1(){
        for (int i=0;i<10000;i++){
            System.out.println(i);
        }
    }
    public static void run2(){
        for (int i=0;i<100000;i++){
            System.out.println(i);
        }
    }

    /**
     * Instant ，绝对时间
     */
    public static void testInstant(){
        Instant start = Instant.now();
        run1();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start,end);
        long millis1 = timeElapsed.toNanos();
        Instant start1 = Instant.now();
        run2();
        Instant end1 = Instant.now();
        Duration timeElapsed1 = Duration.between(start1,end1);
        long millis2 = timeElapsed1.toNanos();
        System.out.println("millis1->"+millis1);
        System.out.println("millis2->"+millis2);
        boolean result = timeElapsed.multipliedBy(10).minus(timeElapsed1).isNegative();
        System.out.println(result);
    }

    /**
     * LocalDate,本地时间
     */
    public static void testLocalDate(){
        LocalDate today = LocalDate.now();
        LocalDate andyBirthday = LocalDate.of(1991, Month.JANUARY,8);
        andyBirthday = LocalDate.of(1991,01,8);
        System.out.println(andyBirthday.getYear());
        LocalDate howold = andyBirthday.plusYears(26);
        System.out.println(howold);
        System.out.println(howold.until(andyBirthday));
        System.out.println(LocalDate.of(2017,01,31).plusMonths(1));
        System.out.println(LocalDate.of(2017,03,31).plusMonths(1));
        System.out.println(LocalDate.of(2017,07,30).getDayOfWeek().getValue());
        LocalDate firstTuesday = LocalDate.of(2017,07,1).with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println(firstTuesday);
        TemporalAdjuster temporalAdjuster = x->{
            LocalDate result = (LocalDate)x;
            do{
                result = result.plusDays(1);
            }while (result.getDayOfWeek().getValue()>=6);
            return result;
        };
        LocalDate backToWork = today.with(temporalAdjuster);
        System.out.println(backToWork);
    }

    public static void testLocalTime(){
        LocalTime rightNow = LocalTime.now();
        LocalTime bedTime = LocalTime.of(22,30);
        LocalTime wakeup = bedTime.plusHours(8);
        System.out.println(wakeup);
    }

    public static void testZoneId(){
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }


}
