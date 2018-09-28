package com.how2java.springboot.service.serviceImp;

import com.how2java.springboot.bean.Role;
import com.how2java.springboot.repository.RoleRepository;
import com.how2java.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
