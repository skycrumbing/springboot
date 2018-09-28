package com.how2java.springboot.utils;

import lombok.Data;

/**
 * Created by Administrator on 2018/9/13 0013.
 * 在rest风格框架中映射Json结构
 */
@Data
public class Response {
    public static final String OK = "ok";
    public static final String ERROR = "error";

    private Meta meta; //元数据
    private Object date; //具体数据

    public Response success(){
        this.meta = new Meta(true,OK);
        return this;
    }
    //重载
    public Response success(Object obj){
        this.meta = new Meta(true,OK);
        this.date = obj;
        return this;
    }
    public Response failure(){
        this.meta = new Meta(false,ERROR);
        return  this;
    }
    //重载
    public Response failure(Object obj){
        this.meta = new Meta(false,ERROR);
        this.date = obj;
        return  this;
    }






}
