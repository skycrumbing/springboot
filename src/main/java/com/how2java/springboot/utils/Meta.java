package com.how2java.springboot.utils;

import lombok.Data;

/**
 * Created by Administrator on 2018/9/13 0013.
 * 请求元数据
 */
@Data
public class Meta {
    private boolean success;
    private String message;

    public Meta(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Meta() {
    }
}
