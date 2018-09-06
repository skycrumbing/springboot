package com.how2java.springboot.web;

/**
 * Created by Administrator on 2018/9/4 0004.
 */

import com.how2java.springboot.bean.User;
import com.how2java.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/query/{id}")
    public Object query(@PathVariable int id) {
        return userService.findById(id);
    }

    @RequestMapping("/save")
    public Object save(@ModelAttribute User user) {
        return userService.save(user);
    }

    @RequestMapping("/delete/{id}")
    public Object delete(@PathVariable int id) {
        return userService.delete(id);
    }

    @RequestMapping("/queryPage")
    public Object query(String name, int pageNum, int count) {
        //根据weight倒序分页查询
//        Pageable pageable = new PageRequest(pageNum, count, Sort.Direction.DESC, "weight");
//        return userRepository.findByName(name, pageable);
        return null;
    }
}
