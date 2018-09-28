package com.how2java.springboot.repository;


import com.how2java.springboot.bean.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
