package com.how2java.springboot.proxy;

/**
 * Created by Administrator on 2018/9/5 0005.
 */
public class TestProxy {
    public static void main(String args[]){
        //动态代理
//        LiuDeHuaProxy liuDeHuaProxy = new LiuDeHuaProxy();
//        Person p = liuDeHuaProxy.getProxy();
//        System.out.println(p.sing("冰雨"));
//        System.out.println(p.dance("冰雨"));
        //静态代理
        Person ldh = new LiuDeHua();
        JingtaiProxy jingtaiProxy = new JingtaiProxy(ldh);
        jingtaiProxy.sing("hehe");


    }
}
