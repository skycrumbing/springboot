package com.how2java.springboot.java8.Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2018/9/13 0013.
 * Lambda表达式可以理解为简洁地表示可传递的匿名函数的一种方式：
 * 它没有名称，但它有参数列表、函数主体、返回类型，可能还有一个可以抛出的异常列表。
 * 匿名——我们说匿名，是因为它不像普通的方法那样有一个明确的名称：写得少而想得多！
 * 函数——我们说它是函数，是因为Lambda函数不像方法那样属于某个特定的类。但和方法一样， Lambda有参数列表、函数主体、返回类型，还可能有可以抛出的异常列表。
 * 传递——Lambda表达式可以作为参数传递给方法或存储在变量中。
 * 简洁——无需像匿名类那样写很多模板代码。
 *
 * Lambda表达式由参数、箭头、主体组成
 */
public class Lambda {
    public static void main(String args[]){
        String[] names = {"xiaoming", "xiaohuang", "xiaohei","sdfdasf"};
        List<String> list = Arrays.asList(names);
        //java8之前的for循环
        System.out.println("java8之前对list遍历");
        for (String name: list) {
            System.out.println(name);
        };
        //java8之后
        System.out.println("java8之后");
        list.forEach((name) -> System.out.println(name));

        //1.1,java8之前的使用runable匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm a thred in java7");
            }
        }).start();
        //1.2,java8之后
        new Thread(() -> System.out.println("I'm a thred in java8")).start();
        //2.1,java8之前的使用runable匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello java7");
            }
        };
        //2.2,java8之后
        Runnable race2 = () -> System.out.println("hello java8");
         race1.run();
         race2.run();

        //java8之前使用匿名内部类对数组根据name排序
        Arrays.sort(names, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
        System.out.println(Arrays.toString(names));
        //java8之后1
        Comparator<String> comparator = (String o1, String o2) ->o1.compareTo(o2);
        Arrays.sort(names,comparator);
        System.out.println(Arrays.toString(names));
        //java8之后2
        Arrays.sort(names,(String o1, String o2)->o1.compareTo(o2));
        System.out.println(Arrays.toString(names));












    }
}
