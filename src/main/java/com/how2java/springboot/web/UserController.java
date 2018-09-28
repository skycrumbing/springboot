package com.how2java.springboot.web;

/**
 * Created by Administrator on 2018/9/4 0004.
 */

import com.how2java.springboot.bean.User;
import com.how2java.springboot.service.UserService;
import com.how2java.springboot.utils.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 使用@Controller 注解，在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面 若返回json等内容到页面，则需要加@ResponseBody注解
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 * RestController不能解析return 的jsp,html页面
 *
 * @RequestBody能将前端传来的Json对象转化为Java对象
 *
 * 　REST风格：从MVC到前后端完全分离
 * 首先从浏览器发送AJAX请求，然后服务端接受该请求并返回JSON数据返回给浏览器，最后在浏览器中进行界面渲染
 * 服务端将内部资源发布REST服务，客户端通过URL来定位这些资源并通过HTTP协议来访问它们
 * @
*/

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping("/query/{id}") //@PathVariable 是从一个URI模板里面来填充
    public Object query(@PathVariable int id) {
        logger.debug("查找用户id:" + id);
        User user = userService.findById(id);
        return (new Response().success(user));
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
