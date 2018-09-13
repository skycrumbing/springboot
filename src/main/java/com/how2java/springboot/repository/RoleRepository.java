package com.how2java.springboot.repository;

import com.how2java.springboot.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
}
