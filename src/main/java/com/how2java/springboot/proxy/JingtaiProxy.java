package com.how2java.springboot.proxy;

/**
 * Created by Administrator on 2018/9/5 0005.
 */
public class JingtaiProxy implements Person{
    private Person person;
    public JingtaiProxy(Person person){
        this.person = person;
    }


    @Override
    public String sing(String name) {
        System.out.println("执行前");
        person.sing(name);
        System.out.println("执行后");
        return null;



    }

    @Override
    public String dance(String dance) {
        return null;
    }
}
