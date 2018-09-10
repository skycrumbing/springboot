package com.how2java.springboot.web;

import com.how2java.springboot.bean.Product;
import com.how2java.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/productList")
    public String productList(Model m, @RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="size",defaultValue = "3") int size){
        start = start > 0 ? start:0;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size, sort);
        Page<Product> page = productService.findAll(pageable);
        System.out.println(page.getContent());
        m.addAttribute("page",page);
        return "productList";


    }
}
