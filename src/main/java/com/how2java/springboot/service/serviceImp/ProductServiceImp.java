package com.how2java.springboot.service.serviceImp;

import com.how2java.springboot.bean.Product;
import com.how2java.springboot.repository.ProductRepository;
import com.how2java.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Page<Product> findAll(Pageable pageable){
        return productRepository.findAll(pageable);
    }
    public List<Product> findAll(){ return productRepository.findAll();}
}
