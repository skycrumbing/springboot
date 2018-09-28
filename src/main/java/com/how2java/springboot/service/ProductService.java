package com.how2java.springboot.service;

import com.how2java.springboot.bean.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();
}
