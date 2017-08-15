package com.java8.stream;

import com.java8.testcase1.DataUtil;
import com.java8.testcase1.Director;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * sorted
 * Created by ZhangYuZhong on 2017/8/2.
 */
public class StreamTest6 {
    List<Director> directorList;
    Integer[] arr;
    @Before
    public void init(){
        arr = new Integer[]{8,9,51,43,10};
        directorList = DataUtil.getInstance().praseData();
    }
    /**
     * sorted：无参的排序方法，要能够使用sorted方法进行排序
     * 要求流的数据必须是实现了Comparable接口的
     * 默认是按照自然排序的
     */
    @Test
    public void testSorted(){
        Stream.of(arr).sorted(Comparator.naturalOrder()).sorted(Comparator.reverseOrder()).forEach(x-> System.out.print(x+","));
        System.out.println("\n");
        Stream.of(arr).sorted((x,y)->Integer.compare(y,x)).forEach(x-> System.out.print(x+","));
    }

    @Test
    /**
     * 根据导演执导的电影的总票房排序，从高到低
     *
     */
    public void testSorted1(){
        directorList.stream().sorted((x,y)-> y.getTotalBoxOffice().compareTo(x.getTotalBoxOffice())).forEach(x-> System.out.println(x.getName()+"->"+x.getTotalBoxOffice()));
        System.out.println("========split========");
        directorList.stream().sorted(Comparator.comparing(Director::getTotalBoxOffice).reversed()).forEach(x-> System.out.println(x.getName()+"->"+x.getTotalBoxOffice()));
    }

    /**
     * 根据导演执导电影总数量从多到少排序，如果数量相同，再按照票房从高到低排序
     */
    @Test
    public void testSorted2(){
        //java8泛型推导的问题，所以如果comparing里面是非方法引用的lambda表达式就没办法直接使用reversed()
        //directorList.stream().sorted(Comparator.comparing(x->x.getMovies().size()).reversed())
        //不能执行，Comparator.reverseOrder()要求Director实现comparable
//        directorList.stream().sorted(Comparator.comparing(x->x.getMovies().size())).sorted(Comparator.reverseOrder())
        directorList.stream().sorted(Comparator.comparing(Director::getMovieSize).reversed().thenComparing(Comparator.comparing(Director::getTotalBoxOffice).reversed())).forEach(x-> System.out.println(x.getName()+"->"+x.getMovieSize()+"->"+x.getTotalBoxOffice()));
    }
    /**
     * reversed()
     * Comparator.reverseOrder():也是用于翻转顺序，用于比较对象（Stream里面的类型必须是可比较的）
     * Comparator. naturalOrder()：返回一个自然排序比较器，用于比较对象（Stream里面的类型必须是可比较的）
     */
    @Test
    public void testSotred3(){
        directorList.stream().parallel().sorted(Comparator.comparing(Director::getTotalBoxOffice)).forEach(x-> System.out.println(x.getName()+"->"+x.getTotalBoxOffice()));
        System.out.println("========split========");
        directorList.stream().parallel().sorted(Comparator.comparing(Director::getTotalBoxOffice)).forEachOrdered(x-> System.out.println(x.getName()+"->"+x.getTotalBoxOffice()));
    }
    //sorted()distinct()是一个元素相关的方法，和整体的数据是有关系的
    //map，filter等方法和已经通过的元素是不相关的
    //不需要知道流里面有哪些元素
    //并行执行和sorted会不会产生冲突？
    //结论：
    // 1.并行流和排序是不冲突的，
    // 2.一个流是否是有序的，对于一些api可能会提高执行效率，对于另一些api可能会降低执行效率
}   // 3.如果想要输出的结果是有序的，对于并行的流需要使用forEachOrdered(forEach的输出效率更高)

