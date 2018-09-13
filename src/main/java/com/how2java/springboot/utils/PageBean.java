package com.how2java.springboot.utils;

import lombok.Data;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/9/13 0013.
 * 自制page工具，注意如果Json要获得非属性的值，boolean用isXxx，其他类型用getXxx,Spring可能通过反射获得这些值
 */
@Data
@Resource
public class PageBean<T> {
    private List<T> content;
    private int start;
    private int size;
    private int total;

    public PageBean(List<T> content, int start, int size){
        this.content = content;
        this.start = start;
        this.size = size;
    }
    public PageBean(){};

    //得到页数
    public int getPageCount(){
        if(this.total % this.size == 0){
            return total / this.size;
        }else{
            return total / this.size + 1;
        }
    }

    //判断是不是首页
    public boolean isFist(){
        if(start == 1){
            return true;
        }else{
            return false;
        }
    }

    //判断是不是尾页
    public boolean isLast(){
        return(this.total == 0 || this.start == this.getPageCount());
    }

    //判断是否有下一页
    public boolean isHasNext() {
        return this.start < this.getPageCount();
    }

    //判断是否有上页
    public  boolean isHasPrev(){
        return this.start > 1;
    }

    //得到下一页
    public int getNext(){
        if(this.isLast()){
            return this.start;
        }else{
            return this.start + 1;
        }
    }

    //得到上页
    public int getPrev(){
        if(this.isFist()){
            return this.start;
        }else{
            return this.start - 1;
        }
    }







}
