package com.how2java.springboot.proxy;

/**
 * Created by Administrator on 2018/9/5 0005.
 */
public class LiuDeHua implements Person {
    @Override
    public String sing(String name) {
        return ("liudehua sing " + name + " song");
    }

    @Override
    public String dance(String dance) {
        return ("liudehua dance " + dance);
    }
}
