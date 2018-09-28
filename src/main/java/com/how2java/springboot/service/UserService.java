package com.how2java.springboot.service;

import com.how2java.springboot.bean.User;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
public interface UserService {
    public User findById(int id);
    User save(User user);
    int delete(int id);

}
