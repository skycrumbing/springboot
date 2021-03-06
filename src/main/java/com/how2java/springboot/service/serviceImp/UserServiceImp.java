package com.how2java.springboot.service.serviceImp;

import com.how2java.springboot.bean.User;
import com.how2java.springboot.repository.UserRepository;
import com.how2java.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/9/4 0004.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    public User findById(int id) {
        return userRepository.findById(id);
    }
    public User save(User user) {
        return userRepository.save(user);
    }

    public int delete(int id) {
        return userRepository.deleteById(id);
    }

}
