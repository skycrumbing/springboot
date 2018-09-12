package com.how2java.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2018/9/12 0012.
 */
//元注解，用于定义自定义注解的注解
//@Target 表示这个注解能放在什么位置上,ElementType.TYPE表示可以放在类、接口或枚举类型
@Target(ElementType.TYPE)
//@Retention表示注解的声明周期，RetentionPolicy.RUNTIME表示注解运行时依然存在，可以通过反射获取
@Retention(RetentionPolicy.RUNTIME)
public @interface MyEntity {
}
