package com.how2java.springboot.web;

import com.how2java.springboot.bean.Role;
import com.how2java.springboot.service.RoleService;
import com.how2java.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/roleList")
    public PageBean<Role> roleList(){
        List<Role> roles = roleService.findAll();
        PageBean<Role> pageBean = new PageBean<Role>(roles,1,2);
        pageBean.setTotal(roles.size());
        return pageBean;
    }
}
