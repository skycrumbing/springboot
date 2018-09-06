package com.how2java.springboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/9/5 0005.
 */
public class LiuDeHuaProxy {
    ///设计一个类变量记住代理类要代理的目标对象
    private Person ldh = new LiuDeHua();
    //ClassLoader loader用来指明生成代理对象使用哪个类装载器，
    // Class<?>[] interfaces用来指明生成哪个对象的代理对象，通过接口指定，
    // InvocationHandler h用来指明产生的这个代理对象要做什么事情。所以我们只需要调用newProxyInstance方法就可以得到某一个对象的代理对象了。
    public Person getProxy(){
        return (Person)Proxy.newProxyInstance(LiuDeHua.class.getClassLoader(), ldh.getClass().getInterfaces(), new InvocationHandler() {
            @Override
                        /* 在invoke方法编码指定返回的代理对象干的工作
38                      * proxy : 把代理对象自己传递进来
39                      * method：把代理对象当前调用的方法传递进来
40                      * args:把方法参数传递进来*/
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //如果调用的是代理对象的sing方法
                if (method.getName().equals("sing")) {
                 System.out.println("我是他的经纪人，要找他唱歌得先给十万块钱！！");
                  //已经给钱了，经纪人自己不会唱歌，就只能找刘德华去唱歌！
                  return method.invoke(ldh, args); //代理对象调用真实目标对象的sing方法去处理用户请求
                }
                if (method.getName().equals("dance")) {
                  System.out.println("我是他的经纪人，要找他跳舞得先给二十万块钱！！");
                   //已经给钱了，经纪人自己不会唱歌，就只能找刘德华去跳舞！
                    return method.invoke(ldh, args);//代理对象调用真实目标对象的dance方法去处理用户请求
                }
                return null;
            }
        });
    }
}
