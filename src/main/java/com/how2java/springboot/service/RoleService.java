package com.how2java.springboot.service;

import com.how2java.springboot.bean.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Service
public interface RoleService {
    public List<Role> findAll();

}
