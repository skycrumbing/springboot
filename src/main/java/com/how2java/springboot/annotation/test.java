package com.how2java.springboot.annotation;

/**
 * Created by Administrator on 2018/9/12 0012.
 */
public class test {
    public static void main(String args[]) throws ClassNotFoundException {
        Class<User> clazz = User.class;
        MyEntity myEntity = clazz.getAnnotation(MyEntity.class);
        if(myEntity != null){
            System.out.println("这是一个实体");
            Table table = clazz.getAnnotation(Table.class);
            System.out.println(table);
            if(table != null){
                System.out.println("实体对应表名是" + table.name());
            }
        }else{
            System.out.println("这不是一个实体");
        }



    }
}
